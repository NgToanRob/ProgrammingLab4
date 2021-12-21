<p align="center">
  <img src="doc/Picture1.png" />
</p>
<p align="center" style ="font-size: 24px"><em>Факультет мехатроники и робототехники</em></p>

<p align="center" style ="font-size: 24px"><strong>Лабораторная работа №1 </br>
По дисциплине : «Программирование»</br>
Вариант 215521</strong>
</p>
<p align="left">Преподаватель: <strong>Райла Мартин</strong></br>
Выполнил: <strong>Нгуен Тоан</strong></br>
Группа: <strong>R3137</strong>
</p>

# Лабораторная работа #3

## 1. Текст задания.
### Story
Он пошел домой и встретил знакомого, которого звали Стекляшкин. Этот Стекляшкин был знаменитый астроном. Он умел делать из осколков битых бутылок увеличительные стекла. Когда он смотрел в увеличительные стекла на разные предметы, то предметы казались больше. Из нескольких таких увеличительных стекол Стекляшкин сделал большую подзорную трубу, в которую можно было смотреть на Луну и на звезды. Таким образом он сделался астрономом.
— Слушай, Стекляшкин, — сказал ему Незнайка. — Ты пони­маешь, какая история вышла: от солнца оторвался кусок и ударил меня по голове.

He went home and met an acquaintance named Steklyashkin. This Steklyashkin was a famous astronomer. He knew how to make magnifying glasses from fragments of broken bottles. When he looked through magnifying glasses at different objects, the objects seemed larger. From several such magnifying glasses, Steklyashkin made a large telescope through which one could look at the moon and at the stars. Thus he became an astronomer.
“Listen, Steklyashkin,” Dunno told him. - You understand what story came out: a piece came off the sun and hit me on the head.

### Class diagram
![class diagram](doc/src.png)

## 2. Sources
### 2.1. Run Package
#### Story.java
```java
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
```

### 2.2. Core package

#### 2.2.1. core.source
##### BrokenBottles.java
        
```java
package core.sources;

import utility.Visionable;

public class BrokenBottles implements Visionable {
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
        System.out.println(name + " can be look through broken bottles");
    }
}
```

##### Magnifying.java
```java
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
```

##### Telescope.java
```java
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
```

#### 2.2.2. core.actors

##### Man.java
```java
package core.actors;

import utility.Human;

import java.util.Objects;

public class Man extends Human {
    private String name;

    public Man(String name) {
        this.name = name;
        joinStory();
    }

    private void joinStory() {
        System.out.println(name + " join in story");
    }

    @Override
    public String getName() {
        return name;
    }

    public void goHome(){
        System.out.println(name + " went home");
    }
    public void meet(Astronomer astronomer){
        System.out.println(name + " meet " + astronomer.getName());
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
```

##### Astronomer.java
```java
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

```
### 2.3. utility package

#### Makable.java
```java
package utility;

public interface Makable {
    void make(String name);
}
```
#### Visionable.java
```java
package utility;

public interface Visionable {
    void lookThrough(String name);
}
```

#### Objects.java
```java
package utility;

public enum Objects {
    MOON,
    STARS;
}
```

#### Human.java
```java
package utility;

public abstract class Human {
    public abstract String getName();
    public abstract void setName(String name) throws WrongNameException;
}
```

#### WrongInstanceException.java
```java
package utility;

public class WrongInstanceException extends Exception {
    // Custom checked exception
    public WrongInstanceException(String message) {
        super(message);
    }
}
```

#### WrongNameException.java
```java
package utility;

public class WrongNameException extends RuntimeException{
    //Custom unchecked exception

    public WrongNameException(String message){
        super(message);
    }

}

```

## 3. Results
```java
Dunno join in story
Dunno went home 
Steklyashkin join in story 
Dunno meet Steklyashkin
Steklyashkin was a famous astronomer
Steklyashkin can be look through broken bottles
Steklyashkin knew how to make magnifying glasses from fragments of broken bottles
Steklyashkin looked through magnifying glasses at different objects, the objects seemed larger 
From several such magnifying glasses, Steklyashkin made a large telescope
Steklyashkin through large telescope could look at the MOON and at the STARS 
Steklyashkin became an astronomer
Listen Steklyashkin!
You understand what story came out: a piece came off the sun and hit me on the head.

```

## 4. Conclusion

В этой лабораторной работе я научился применять принципы SOLID на практике, применять соглашения об именах Java, более 
внимательно изучать интерфейсы, абстрактные классы и перечисления. Узнал, как использовать систему сборки Gradle. Не выспался :(

In this lab, I learned how to put the principles of SOLID in practice, apply Java naming conventions, take a closer look at interfaces, abstract classes, and enumerations. Learned how to use the Gradle build system. Not getting enough sleep.