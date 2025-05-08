package towngraphpackage;

import java.util.*;

public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns = new HashSet<>();
    private Set<Road> roads = new HashSet<>();
    private Map<Town, List<Road>> adjacencyMap = new HashMap<>();
    private Map<Town, Integer> distances = new HashMap<>();
    private Map<Town, Town> previous = new HashMap<>();

    public Road getEdge(Town source, Town destination) {
        if (source == null || destination == null || !containsVertex(source) || !containsVertex(destination))
            return null;

        for (Road road : roads) {
            if (road.contains(source) && road.contains(destination)) {
                return road;
            }
        }
        return null;
    }

    public Road addEdge(Town source, Town destination, int degree, String description) {
    	  if (source == null || destination == null)
    	        throw new NullPointerException();
    	    if (!containsVertex(source) || !containsVertex(destination))
    	        throw new IllegalArgumentException();

    	    Road road = new Road(source, destination, degree, description);
    	    if (roads.contains(road)) return null;

    	    roads.add(road);
    	    adjacencyMap.get(source).add(road);
    	    adjacencyMap.get(destination).add(road);
    	    return road;
    }

    public boolean addVertex(Town v) {
        if (v == null) throw new NullPointerException();
        if (towns.contains(v)) return false;
        towns.add(v);
        adjacencyMap.put(v, new ArrayList<>());
        return true;
    }

    public boolean containsEdge(Town source, Town destination) {
        return getEdge(source, destination) != null;
    }

    public boolean containsVertex(Town v) {
        return v != null && towns.contains(v);
    }

    public Set<Road> edgeSet() {
        return new HashSet<>(roads);
    }

    public Set<Road> edgesOf(Town vertex) {
        if (vertex == null) throw new NullPointerException();
        if (!containsVertex(vertex)) throw new IllegalArgumentException();
        return new HashSet<>(adjacencyMap.get(vertex));
    }

    public Road removeEdge(Town sourceVertex, Town destinationVertex, int degree, String description) {
    	Road existing = getEdge(sourceVertex, destinationVertex);
        if (existing != null && existing.getName().equals(description)) {
            roads.remove(existing);
          
        }
        return existing;
    }

    public boolean removeVertex(Town v) {
        if (!containsVertex(v)) return false;
        for (Road road : new ArrayList<>(edgesOf(v))) {
            removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());
        }
        adjacencyMap.remove(v);
        towns.remove(v);
        return true;
    }

    public Set<Town> vertexSet() {
        return new HashSet<>(towns);
    }

    public void dijkstraShortestPath(Town source) {
        distances.clear();
        previous.clear();
        for (Town town : towns) {
            distances.put(town, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        pq.add(source);

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            for (Road road : adjacencyMap.get(current)) {
                Town neighbor = road.getSource().equals(current) ? road.getDestination() : road.getSource();
                int alt = distances.get(current) + road.getWeight();
                if (alt < distances.get(neighbor)) {
                    distances.put(neighbor, alt);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    public ArrayList<String> shortestPath(Town source, Town destination) {
        dijkstraShortestPath(source);
        ArrayList<String> path = new ArrayList<>();
        if (!previous.containsKey(destination)) return path;

        Town current = destination;
        while (!current.equals(source)) {
            Town prev = previous.get(current);
            Road road = getEdge(prev, current);
            path.add(0, prev + " via " + road.getName() + " to " + current + " " + road.getWeight() + " mi");
            current = prev;
        }
        return path;
    }
}

