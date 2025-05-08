package towngraphpackage;

import java.util.Objects;

public class Town implements Comparable<Town> {
    private String name;

    public Town(String name) {
        this.name = name;
    }

    public Town(Town templateTown) {
        this.name = templateTown.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Town o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Town) {
            Town other = (Town) obj;
            return this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name;
    }
}

