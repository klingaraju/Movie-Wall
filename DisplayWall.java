import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;


public class DisplayWall extends MovieData {
    //this class is used to display output to the user and take input from the user.
    public static void main(String args[]) {
        boolean checkagain = true;
        String file = args[0];
        Scanner userinput = new Scanner(System.in);
        System.out.println("Welcome to the Movie Wall!");
        while (checkagain == true) {
            System.out.println("Enter the name of an actor (or 'EXIT' to quit )");
            String driverActorName = userinput.nextLine();
            if (driverActorName.equals("EXIT")) {
                checkagain = false;
            } else {
                MovieData output = new MovieData();
                ArrayList<Actor> driverActorList = output.readFile(file);
//                //here, the parent actor object is created to store an arraylist of actor objects.
//                Actor parent = new Actor();
//                parent.setActorArrayList(driverActorList);
//                parent.sortActorArrayList();
//                int y =0;
//                Actor displayactor = parent.searchActor(parent.getActorArrayList(), driverActorName);
//                if (driverActorName.compareTo(displayactor.getActor())==0) {
//                    //code to display all movies and roles of actor
//                    System.out.println("Actor: " + displayactor.getActor());
//                    for (int i = 0; i < displayactor.getMovieRoleSize(); i++) {
//                        System.out.println("* Movie: " + displayactor.getIndividualMovie(i)+" as "+ displayactor.getIndividualRole(i));
//                    }
//
//                } else {
//                    System.out.println("No such actor. Did you mean " + displayactor.getActor()+"?");
//                    String yesOrNo = userinput.nextLine();
//                    if (yesOrNo.equals("Y")){
//                        //code to display all movies and roles of actor
//                        System.out.println("Actor: "+ displayactor.getActor());
//                        for (int i = 0; i < displayactor.getMovieRoleSize(); i++) {
//                            System.out.println("* Movie: " + displayactor.getIndividualMovie(i)+" as "+ displayactor.getIndividualRole(i));
//                        }
//                    } else if (yesOrNo.equals("N")){
//                        checkagain=true;
//                    }
//                }
            }
            }
            System.out.println("Thanks for using the Movie Wall!");
        }
    }

