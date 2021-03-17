// Breadth First Search Algorithm (Part 4 Extension)
import java.util.*;
import java.util.LinkedList;

public class Main {
    //Setting global variables to use when making the matrix
    public static int pathCount;
    public static int x1;
    public static int y1;
    public static int x2;
    public static int y2;

    public static void main(String[] args) {
        Scanner Introduction = new Scanner(System.in); // introducing a scanner
        System.out.println("Do you want normal gameplay or gameplay with cheats?"); // printing out the question
        String response = Introduction.nextLine(); //output
        
        try{
            if(response.equalsIgnoreCase("normal")){
                MazeRunner myRunner = new MazeRunner();
                Scanner input = new Scanner(System.in); // created a new scanner
                myRunner.intro();//called on introduction method from MazeRunner
                myRunner.game(input); // calling on "input" from created scanner
                System.out.println("You're out alive!");
            } elseif(response.equalsIgnoreCase("Cheats")) {

            } catch (Exception e) {
                System.out.println("Be sure to input correct information!");
            }
        }

// Basic grid outline and following approach - my prospective plan
// x values go horizontal directions and y values go vertical directions (like a normal coordinate plane)
// Both x and y start from the origin (0,0)
    /* {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
       {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
       {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
       {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
       {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
       {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
       and more
*/

// The updated coordinates are x1,y1 = "x" and x2,y2 = "x"

// Since matrix is organized into different structures, a Cell would be a good implementation as a place carrying all
// the characters of x

// I would then reitterate the normal and cheat gameplay Strings and print out Starting Point and Ending Point
// for the x value to go to (like maximum and minimum)

// The Breadth Search Algorithm comes into play when for making the grid modeled by the matrix
        // 1. start by putting all the variables together in parenthesis (character, grid, integer, start, end)
        // 2. organize start and end by 0 to 1 in coordinates
        // 3. classify that a cell includes grid length plus additonal length per additional move
        // 4. use an if statement to show how it works

        // 5. then use your Linkedlist imported statement