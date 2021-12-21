package core.sources;

import utility.Visionable;

public class Magnifying implements Visionable {
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

    @Override
    public void lookThrough(String name) {
        System.out.println(name + " looked through magnifying glasses at different objects, the objects seemed larger");
    }
}
