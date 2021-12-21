package core.sources;

import utility.Objects;
import utility.Visionable;

public class Telescope implements Visionable {
    @Override
    public void lookThrough(String name) {
        System.out.println(name + "through large telescope could look at the "+ Objects.MOON+ " and at the "+Objects.STARS);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
