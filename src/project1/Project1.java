// Developer: Alberth Matos
// Project Name: Project1
// Class CMSC 215
// Date 23  March 2024
// Description: The program consists of three classes: Project1, Height, and Player.
//
//              The Project1 class has an ArrayList of Player objects, an instance variable averageAge, and a main
//              method. The main method creates an instance of the Project1 class, initializes the ArrayList of Player
//              objects, prompts the user to enter players, calculates the average age of the players, and prints it
//              to the console. The main method then finds the tallest player among the players whose age is greater
//              than or equal to the average age and prints the player's name and height to the console.

package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
    private ArrayList<Player> players;
    private int averageAge;

    public static void main(String[] args) {
        Project1 project = new Project1();
        project.players = new ArrayList<>();
        Scanner getInput = new Scanner(System.in);

        // Add some players to the list of players.
        /*
        project.players.add(new Player("Aa Bb", new Height(5, 11), 16));
        project.players.add(new Player("Cc Dd", new Height(6, 0), 22));
        project.players.add(new Player("Ee Ff", new Height(6, 8), 14));
        project.players.add(new Player("Gg Hh", new Height(5, 5), 33));
        project.players.add(new Player("Ii Jj", new Height(5, 13), 24));
        */

        System.out.println("Please enter the players' information in response to the prompt.");
        while (true) {
            // Prompt the user to enter the player's name.
            System.out.print("Enter the player's name (or 'done' if you have entered all players): ");
            String name = getInput.nextLine();
            // If the user enters 'done', break out of the loop.
            if (name.equals("done")) {
                break;
            }

            // Prompt the user to enter the player's height in feet and inches.
            System.out.print("Enter the player's height in feet and inches (e.g., 5 10): ");
            String[] height = getInput.nextLine().split(" ");
            // If the user enters less than two values, print an error message and prompt the user to re-enter the
            // player's information.
            if (height.length < 2) {
                System.out.println("Please enter the height in feet and inches.");
                continue;
            }
            // Parse the height values as integers.
            int feet = Integer.parseInt(height[0]);
            int inches = Integer.parseInt(height[1]);

            // Prompt the user to enter the player's age.
            System.out.print("Enter the player's age: ");
            int age = Integer.parseInt(getInput.nextLine());

            // Add the player to the list of players.
            project.players.add(new Player(name, new Height(feet, inches), age));
        }

        int counter = 0;
        int averageAge = 0;
        // Iterate through the players and calculate their total age plus the number of players.
        for (Player player : project.players) {
            averageAge += player.getAge();
            counter++;
        }

        // Calculate the average age of the players.
        // If there are players, calculate the average age by dividing the total age by the number of players.
        // If there aren't any players, print an error message and exit the program, lest we divide by zero.
        if (counter > 0) {
            project.averageAge = averageAge / counter;
            System.out.println("Average age: " + project.averageAge);
        } else {
            System.out.println("No players to calculate average age.");
            System.exit(-1);
        }

        // Find the tallest player among the players whose age is greater than or equal to the average age.
        // To do this, we need to check if each player's age is greater than or equal to the average age, by iterating
        // through the players. IF the current player's age is, we then compare the current player's height to the
        // tallest height found so far.  If the current player's height is taller, we update the tallest height,
        // the tallest player's name, and the tallest height as a string.

        // Set the initial tallest height to 0, and set the tallest player's name and height as empty strings.
        int tallestHeight = 0;
        String tallestPlayerName = "";
        String tallestHeightAsString = "";
        boolean multipleTallestPlayers = false;
        // Iterate through the players.
        for (Player player : project.players) {
            // Check if the player's age is greater than or equal to the average age, which was calculated above.
            if (player.getAge() >= project.averageAge) {
                // If the player's height is greater than or equal to the tallest height found so far, update the
                // tallest height, the tallest player's name, and the tallest height as a string.
                // If two (or more) players have the same height, list both names and set a flag.
                if (player.getHeight().toInches() >= tallestHeight) {
                    if (player.getHeight().toInches() == tallestHeight) {
                        tallestPlayerName += ", " + player.getName();
                        multipleTallestPlayers = true;
                    } else {
                        tallestPlayerName = player.getName();
                    }
                    tallestHeight = player.getHeight().toInches();
                    tallestHeightAsString = player.getHeight().toString();
                }
            }
        }

        // Print the tallest player's name and height.
        if (multipleTallestPlayers) {
            System.out.println("Multiple players found with the same height: " + tallestPlayerName
                    + " with a height of " + tallestHeight + " inches (" + tallestHeightAsString + ")");
        } else {
            System.out.println("Tallest player: " + tallestPlayerName + " with a height of " + tallestHeight
                    + " inches (" + tallestHeightAsString + ")");
        }
    }
}
