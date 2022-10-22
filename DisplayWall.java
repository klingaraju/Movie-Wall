import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Collections;


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
                HashMap<String, Actor> driverHashMap = output.readFile(file);
                Set<String> keySet=driverHashMap.keySet();
                ArrayList<String> actorKeys= new ArrayList<String>(keySet);
                Collections.sort(actorKeys); // replace with MergeSort
                String foundActor = searchActorKey(actorKeys, driverActorName);
                if(driverActorName.compareTo(foundActor)==0){
                    System.out.println("Actor: " + foundActor);
                    for (int i = 0; i < driverHashMap.get(foundActor).getRoleSize(); i++) {
                        System.out.println("* Movie: " + driverHashMap.get(foundActor).getIndividualMovie(i)+" as "+ driverHashMap.get(foundActor).getIndividualRole(i));
                    }
                } else {
                    System.out.println("No such actor found. Did you mean " + foundActor);
                    String YesOrNo = userinput.nextLine();
                    if (YesOrNo.equals("Y")){
                    System.out.println("Actor: "+ foundActor);
                        for (int i = 0; i < driverHashMap.get(foundActor).getRoleSize(); i++) {
                            System.out.println("* Movie: " + driverHashMap.get(foundActor).getIndividualMovie(i)+" as "+ driverHashMap.get(foundActor).getIndividualRole(i));
                        }
                    } else if (YesOrNo.equals("N")) {
                        checkagain = true;
                    }
                }
            }
        }
            System.out.println("Thanks for using the Movie Wall!");
    }

    public static String searchKey(ArrayList<String> searchArrayList, String targetActor, int low, int high) {
        int mid = (low+high)/2;
        int greaterOrLess = targetActor.compareTo(searchArrayList.get(mid));
        if (low>high){
            return searchArrayList.get(mid);
        }
        if (greaterOrLess==0){
            return searchArrayList.get(mid);
        }
        else if (greaterOrLess<0){
            return searchKey (searchArrayList, targetActor, low, mid-1);
        }
        else if (greaterOrLess>0){
            return searchKey (searchArrayList, targetActor, mid+1,high);
        }
        return searchArrayList.get(low);
    }
    public static String searchActorKey(ArrayList<String> searchArrayList, String targetActor){
        return searchKey(searchArrayList, targetActor, 0, searchArrayList.size()-1);
    }
}



