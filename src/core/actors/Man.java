package core.actors;

import utility.Human;
import utility.WrongInstanceException;
import utility.WrongNameException;

import java.util.Objects;

public class Man extends Human {
    private String name;

    @Override
    public void setName(String name) throws WrongNameException {
        if (name == "Dunno") {
            this.name = name;
            joinStory();
        } else {
            throw new WrongNameException("Wrong name of man");
        }
    }
    @Override
    public String getName() {
        return name;
    }
    
    public Man(){
        super();
    }

    private void joinStory() {
        System.out.println(name + " join in story");
    }
    
    public void getAttention(Human someone) throws WrongInstanceException{
        if (someone instanceof Astronomer) {
            attention(someone);
        } else {
            throw new WrongInstanceException("Only talk with Steklyaskin");
        }
    }
    private void attention(Human someone) {
        System.out.println("Listen "+ someone.getName()+"!");
    } // SOLID :v :v 



    public void talkSomeone(Object obj) throws WrongInstanceException{
        if (obj instanceof Astronomer) {
            System.out.println("You understand what story came out: a piece came off the sun and hit me on the head.");
        } else {
            throw new WrongInstanceException("Only talk with Steklyaskin");
        }
    }
    public void goHome(){
        System.out.println(name + " went home");
    }

    // Use checked 
    public void meet(Object obj) throws WrongInstanceException{
        if (obj instanceof Astronomer) {
            System.out.println(name + " meet " + ((Astronomer) obj).getName());
        } else {
            throw new WrongInstanceException("Dunno should meet Steklyaskin");
        }
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Man man = (Man) object;
        return Objects.equals(name, man.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
