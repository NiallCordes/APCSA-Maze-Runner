import java.util.*;



public class MazeRunner{
    public static Maze myMap = new Maze();
    public static int userSteps = 0;
    public static void main(String[] args){
        /**Part 1*/
        intro();
        while (myMap.didIWin() == false){ //Wall ting
            
            String userDirection = userMove();
            
            if (userDirection.equals("R") || userDirection.equals("L") || userDirection.equals("U") || userDirection.equals("D"))
                navigatePit(userDirection);
        }
            if (myMap.didIWin() == true){
                System.out.print("Rooby Rooby Roo! You made it out of the maze. Time for a Scooby Snack!");
                System.out.println("You've won with" + MazeRunner.userSteps + " moves.");
        }
    }
    public static void intro(){
        System.out.println("Looks like we've got another mystery on our hands! A maze has appeared.");
        System.out.println("Your current position:");
        myMap.printMap();
    }

    public static void movesMessage(int moves){
        switch (moves){
            case 50:
                    System.out.println("Jeepers! You've made 50 moves, you have 50 remaining before the maze exit closes");
                break;
            case 75:
                    System.out.println("Jeepers! You've made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                    System.out.println("We better hurry! You've made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                    System.out.println("Rip! You've failed to escape, no scooby snacks for you.[");
                break;
            default:
                break;
        }
    }

    public static String userMove(){
        Scanner input = new Scanner(System.in);
        String direction = "";
        do{
            if(MazeRunner.userSteps != 101)
           {   System.out.print("Where would you like to move? (R, L, U, D)");
               direction = input.next();
        }

            if(direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D")){
                
                movesMessage(++MazeRunner.userSteps);

                if (myMap.canIMoveRight() == true && direction.equals("R")){
                    myMap.moveRight();
                }
                else if (myMap.canIMoveLeft() == true && direction.equals("L")){
                         myMap.moveLeft();
                }
                else if (myMap.canIMoveUp() == true && direction.equals("U")){
                         myMap.moveUp();
                }
                else if (myMap.canIMoveDown() == true && direction.equals("D")){
                         myMap.moveDown();
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
        if(myMap.isThereAPit(userDirection) == true){
       
            System.out.print("Jeepers! There's a pit ahead. Would you like to jump over it?  ");
            String jump = input.next();
            if(jump.equalsIgnoreCase("yes"))
               myMap.jumpOverPit(userDirection);
            else{
           
            System.out.println("You fell into the pit. R.I.P.");
            System.exit(0);
            }
    }
            else{
            System.out.println("Yikes, you've hit a wall.");
        }
    }
}
