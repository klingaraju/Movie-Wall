import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * This is the driver class that takes in user input of what actor to search for and displays the actor's movies and roles. It also contains search and sort functions to sort through the keys of the hashmap.
 */
public class DisplayWall extends MovieData {
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
                output.readFile(file); //reads file and creates hashmap of actor objects.
                Set<String> keySet=output.actorHashMap.keySet(); //creates Set of all keys (actor names) of hashmap.
                ArrayList<String> actorKeys= new ArrayList<String>(keySet); //creates ArrayList of Set of all keys of hashmap.
                sortArray(actorKeys); //merge sorts ArrayList of keys of actor object hashmap.
                String foundActor = searchActorKey(actorKeys, driverActorName);
                if(driverActorName.compareTo(foundActor)==0){
                    System.out.println("Actor: " + foundActor);
                    for (int i = 0; i < output.actorHashMap.get(foundActor).getRoleSize(); i++) { // if user input matches a key in the ArrayList, gets the actor's roles and movies.
                        System.out.println("* Movie: " + output.actorHashMap.get(foundActor).getIndividualMovie(i)+" as "+ output.actorHashMap.get(foundActor).getIndividualRole(i));
                    }
                } else {
                    System.out.println("No such actor found. Did you mean " + foundActor);
                    // if user input doesn't match, asks if suggested name is what they were looking for.
                    // if user enters "Y", shows suggested actor's movies and roles. If "N", asks for another input.
                    String YesOrNo = userinput.nextLine();
                    if (YesOrNo.equals("Y")){
                    System.out.println("Actor: "+ foundActor);
                        for (int i = 0; i < output.actorHashMap.get(foundActor).getRoleSize(); i++) {
                            System.out.println("* Movie: " + output.actorHashMap.get(foundActor).getIndividualMovie(i)+" as "+ output.actorHashMap.get(foundActor).getIndividualRole(i));
                        }
                    } else if (YesOrNo.equals("N")) {
                        checkagain = true;
                    }
                }
            }
        }
            System.out.println("Thanks for using the Movie Wall!");
    }

    /**
     * Performing Binary Search of the ArrayList of objects keys in the hashmap. Keys are the actors.
     * @param searchArrayList - ArrayList of keys (actor names) of hashmap.
     * @param targetActor - User's input on which actor they would like to search for.
     * @param low - Start index of ArrayList of keys.
     * @param high - End index of ArrayList of keys.
     * @return - returns found value of actor key.
     */
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

    /**
     * Calls searchKey function
     * @param searchArrayList - ArrayList of keys of objects in hashmap.
     * @param targetActor - User input of desired actor to be found.
     * @return - Result of searchKey
     */
    public static String searchActorKey(ArrayList<String> searchArrayList, String targetActor){
        return searchKey(searchArrayList, targetActor, 0, searchArrayList.size()-1);
    }

    /**
     * Calls divideArray
     * @param keyList - arrayList of keys of hashmap of actor objects.
     */
    public static void sortArray(ArrayList<String> keyList){
        divideArray(0, keyList.size()-1, keyList);
    }

    /**
     * Repeatedly divide unsorted arrayList until there is one element per array, and then calls mergeArray to merge these individual arrays.
     * @param start - first index of arrayList of keys of hashmap.
     * @param end - last index of arrayList of keys of hashmap.
     * @param keyList - arrayList of keys of hashmap.
     */
    public static void divideArray(int start,int end, ArrayList<String> keyList){
        if(start<end && (end-start)>=1){
            int mid = (end + start)/2;
            divideArray(start, mid, keyList);
            divideArray(mid+1, end, keyList);
            mergeArray(start,mid,end, keyList);
        }
    }

    /**
     * Merges unsorted, divided arrayList entries.
     * @param start - first index of arrayList of keys of hashmap.
     * @param mid - middle index of arrayList of keys of hashmap.
     * @param end - last index of arrayList of keys of hashmap.
     * @param keyList - arrayList of keys of hashmap.
     */
    public static void mergeArray(int start,int mid,int end, ArrayList<String> keyList){
        ArrayList<String> mergedSortedArray = new ArrayList<String>();
        int left = start;
        int right = mid+1;
        while(left<=mid && right<=end){
            if(keyList.get(left).compareTo(keyList.get(right)) <=0){
                mergedSortedArray.add(keyList.get(left));
                left++;
            }else{
                mergedSortedArray.add(keyList.get(right));
                right++;
            }
        }
        while(left<=mid){
            mergedSortedArray.add(keyList.get(left));
            left++;
        }
        while(right<=end){
            mergedSortedArray.add(keyList.get(right));
            right++;
        }
        int i = 0;
        int j = start;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            keyList.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}



