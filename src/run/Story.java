package run;

import core.actors.Astronomer;
import core.actors.Man;
import core.actors.Astronomer.Make;
import utility.WrongInstanceException;
import utility.WrongNameException;

public class Story {
    public static void main(String[] args) {

        Man man = new Man();
        try {
            man.setName("Dunno");
        } catch (WrongNameException e) {
            e.printStackTrace();
        }

        man.goHome();

        Astronomer astronomer = new Astronomer();

        try {
            astronomer.setName("Steklyashkin");
        } catch (WrongNameException e) {
            e.printStackTrace();
        }

        try {
            man.meet(astronomer);
        } catch (WrongInstanceException e) {
            e.printStackTrace();
        }

        System.out.println(astronomer.toString());

        astronomer.lookThroughBrokenBottles();//;try catch , design exception here
        // need to declare inner class of Astronomer
        Make make = astronomer.new Make();

        make.makeMagnifying(astronomer.getName());

        astronomer.lookThroughMagnifying();

        make.makeTelescope(astronomer.getName());

        astronomer.lookThroughTelescope();
        astronomer.becomeAstronomer();

        try {
            man.getAttention(astronomer);
        } catch (WrongInstanceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            man.talkSomeone(astronomer);
        } catch (WrongInstanceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
