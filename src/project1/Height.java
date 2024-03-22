// Developer: Alberth Matos
// Project Name: Project1
// Class CMSC 215
// Date 23  March 2024
// Description: The program consists of three classes: Project1, Height, and Player.
//
//              The Height class has private instance variables feet and inches, a constructor that takes two arguments,
//              feet and inches, and initializes the instance variables, a method toInches that returns the height in
//              inches, and a method toString that returns the height in feet and inches as a string.

package project1;

public class Height {
    private int feet;
    private int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    public int toInches() {
        // Convert height to inches:  Multiply feet by 12 and add inches.
        return (feet * 12) + inches;
    }

    public String toString() {
        // If inches is greater than or equal to 12, convert to feet and inches.
        // This is in case the user decides to enter 5 feet 12 inches instead of 6 feet.
        if (inches >= 12) {
            feet += inches / 12;
            // Using modulo 12, since we only care about the remainder.
            inches = inches % 12;
        }
        return feet + "' " + inches + "\"";
    }
}
