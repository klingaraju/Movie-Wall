import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;


public class DisplayWall extends MovieData{


    public static void main (String args[])  {
        boolean checkagain = true;
        String file = args[0];
        Scanner userinput = new Scanner(System.in);
        System.out.println("Welcome to the Movie Wall!");
        while (checkagain==true){
            System.out.println("Enter the name of an actor (or 'EXIT' to quit )");
            String actorname = userinput.nextLine();
            //
            if (actorname.equals("EXIT")){
                checkagain=false;
            }else{
                MovieData output = new MovieData();
                output.readFile(file);
            }
        }
        System.out.println("Thanks for using the Movie Wall!");
    }
}
