package towngraphpackage;

import java.util.Objects;

public class Road implements Comparable<Road> {
    private Town source;
    private Town destination;
    private int degrees;
    private String name;

    public Road(Town source, Town destination, int degrees, String name) {
        this.source = source;
        this.destination = destination;
        this.degrees = degrees;
        this.name = name;
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return degrees;
    }

    public boolean contains(Town town) {
        return source.equals(town) || destination.equals(town);
    }

    @Override
    public int compareTo(Road other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
    	 if (!(obj instanceof Road)) return false;
    	    Road other = (Road) obj;
    	    return (this.source.equals(other.source) && this.destination.equals(other.destination) ||
    	            this.source.equals(other.destination) && this.destination.equals(other.source)) &&
    	           this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
    	return source.hashCode() + destination.hashCode() + name.hashCode();
    }

    public String toString() {
        return name + ", " + degrees + " mi; " + source + "; " + destination;
    }
}

