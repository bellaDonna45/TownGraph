package towngraphpackage;

import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph = new Graph();

    public boolean addRoad(String town1, String town2, int degree, String roadName) {
        return graph.addEdge(new Town(town1), new Town(town2), degree, roadName) != null;
    }

    public String getRoad(String town1, String town2) {
        Road road = graph.getEdge(new Town(town1), new Town(town2));
        return (road != null) ? road.getName() : null;
    }

    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    public Town getTown(String name) {
        for (Town town : graph.vertexSet()) {
            if (town.getName().equals(name)) return town;
        }
        return null;
    }

    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    public ArrayList<String> allRoads() {
        ArrayList<String> list = new ArrayList<>();
        for (Road road : graph.edgeSet()) {
            list.add(road.getName());
        }
        Collections.sort(list);
        return list;
    }

    public boolean deleteRoadConnection(String town1, String town2, String road) {
        return graph.removeEdge(new Town(town1), new Town(town2), -1, road) != null;
    }

    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    public ArrayList<String> allTowns() {
        ArrayList<String> list = new ArrayList<>();
        for (Town town : graph.vertexSet()) {
            list.add(town.getName());
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }
}

