// Developer: Alberth Matos
// Project Name: Project1
// Class CMSC 215
// Date 23  March 2024
// Description: The program consists of three classes: Project1, Height, and Player.
//
//              The Player class has private instance variables name, height, and age, a constructor that takes
//              three arguments, name, height, and age, and initializes the instance variables, and methods getName,
//              getHeight, getAge, and toString that return the name, height, age, and a string representation of the
//              player, respectively.

package project1;

public class Player {
    private final String name;
    private final Height height;
    private final int age;

    public Player(String name, Height height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Height getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        // Return the player's name, height, and age as a string, formatted to be nicely human-readable.
        return "Name: " + name + ", project1.Height: " + height.toString() + ", Age: " + age;
    }
}
