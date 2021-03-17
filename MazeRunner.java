import java.util.*; //import statement

public class MazeRunner{ // the constructor that sets the variable
    public static Maze myMap = new Maze();
    public static int userSteps = 0; // set the number of moves to 0
    public static void main(String[] args){ // the main method
        // Part 1 - Let the User solve the Maze
        intro();

        // Returns true if the mentioned space is free, false if there is a wall
        while (myMap.didIWin() == false){ // Wall
            // Part 2 - Move Limit
            String userDirection = userMove();
            // Part 3 - Watch out for Pits
            if (userDirection.equals("R") || userDirection.equals("L") || userDirection.equals("U") || userDirection.equals("D"))
                navigatePit(userDirection); // calls the navigate pit method
        }
            if (myMap.didIWin() == true){
                System.out.print("Rooby Rooby Roo! You made it out of the maze. Time for a Scooby Snack!"); // prints a congratulating message
                System.out.println("You've won with" + MazeRunner.userSteps + " moves.");
        }
    }
    
    // The introduction
    public static void intro(){
        System.out.println("Looks like we've got another mystery on our hands! A maze has appeared."); // welcome message
        System.out.println("Your current position:"); // prints your current place in the map
        myMap.printMap();
    } // Welcome the user into the program and print map

    public static void movesMessage(int moves){
        switch (moves){
            case 50:
                    System.out.println("Warning! You've made 50 moves, you have 50 remaining before the maze exit closes");
                break;
            case 75:
                    System.out.println("Warning! You've made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                    System.out.println("We better hurry! You've made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                    System.out.println("Rip! You've failed to escape, no scooby snacks for you.[");
                break;
            default:
                break;

            // Prints message after a certain number of moves
            // then counts moves
        }
    }

    // takes a direction to move to, and then checks if the direction is possible or a valid move
    public static String userMove(){
        Scanner input = new Scanner(System.in); // prints out current move the user made
        String direction = ""; // gets the mover's choice
        do{
            if(MazeRunner.userSteps != 101)
           {   System.out.print("Where would you like to move? (R, L, U, D)"); //laying out the possible move options
               direction = input.next();
        }

            if(direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D")){
                
                movesMessage(++MazeRunner.userSteps);

                if (myMap.canIMoveRight() == true && direction.equals("R")){ // ensures the mover can move right
                    myMap.moveRight(); // moves right
                }
                else if (myMap.canIMoveLeft() == true && direction.equals("L")){
                         myMap.moveLeft(); // moves left
                }
                else if (myMap.canIMoveUp() == true && direction.equals("U")){
                         myMap.moveUp(); // moves up
                }
                else if (myMap.canIMoveDown() == true && direction.equals("D")){
                         myMap.moveDown(); // moves down
                }
                else{ //Part 2: Move Limit
                    if (MazeRunner.userSteps != 101){
                        System.out.println("Jinkies! You've hit a wall.");
                        System.out.print("Which direction would you like to move? (R, L, U, D)");
                        direction = input.next();
                        movesMessage(++MazeRunner.userSteps);
                    }
                    }
                        myMap.printMap();
                        break;}
            
                    }   while(direction.matches("[RLUD]") == false);

                        return direction;
    }

    public static void navigatePit(String userDirection){
        Scanner input = new Scanner(System.in);
        // Takes in the direction String the user entered in and returns if there is a pit ahead
        if(myMap.isThereAPit(userDirection) == true){
       
            System.out.print("Warning! There's a pit ahead. Would you like to jump over it? (yes or no)  ");
            String jump = input.next();
            if(jump.equalsIgnoreCase("yes"))
               myMap.jumpOverPit(userDirection);
            else{ // Returning true
           
            System.out.println("You fell into the pit. R.I.P.");
            System.exit(0); // Returning false
            }
    }
            else{
            System.out.println("Yikes, you've hit a wall."); // game over
        }
    }
}