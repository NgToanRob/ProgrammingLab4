package core.actors;

import core.sources.BrokenBottles;
import core.sources.Magnifying;
import core.sources.Telescope;
import utility.Human;
import utility.Makable;
import utility.WrongNameException;


public class Astronomer extends Human {
    private  String name;
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) throws WrongNameException {
        if (name == "Steklyashkin") {
            this.name = name;
            joinStory();
       } else {
           throw new WrongNameException("Wrong name of astronomer");
       }
    }

    public Astronomer() {
        super();
    }

    private void joinStory() {
        System.out.println(name + " join in story");
    }

    public void becomeAstronomer(){
        System.out.println(name + " became an astronomer");
    }

    // non-static class (inner classes)
    public class Make {
        public void makeMagnifying(String name){
            // Declare local class --  Anonymous
            Makable action = new Makable() {
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
                public void make(String name) {
                    System.out.println(name + " knew how to make magnifying glasses from fragments of broken bottles");
                }
            };
            action.make(name);
        }

        public void makeTelescope(String name){
            // Declare local class --  Anonymous
            Makable action = new Makable() {
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
                public void make(String name) {
                    System.out.println("From several such magnifying glasses, " + name + " made a large telescope");
                }
            };
            action.make(name);
        }

    }
    
    // static inner class
    static class Vision {
        // Edit the code beautifully here
        private static void lookThroughBrokenBottles(String name){
            BrokenBottles brokenBottles = new BrokenBottles();
            brokenBottles.lookThrough(name);
        }

        private static void lookThroughMagnifying(String name){
            Magnifying magnifying = new Magnifying();
            magnifying.lookThrough(name);
        }

        private static void lookThroughTelescope(String name){
            Telescope telescope = new Telescope();
            telescope.lookThrough(name);
        }
    }
    
    // Using static classes
    public void lookThroughBrokenBottles(){
        Vision.lookThroughBrokenBottles(name);
    }

    public void lookThroughMagnifying(){
        Vision.lookThroughMagnifying(name);
    }
    
    public void lookThroughTelescope(){
        Vision.lookThroughTelescope(name);
    }




    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    public String toString() {
        return name +" was a famous astronomer";
    }
    
}
