// Breadth First Search Algorithm (Part 4 Extension)
import java.util.*;

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
            }
        }