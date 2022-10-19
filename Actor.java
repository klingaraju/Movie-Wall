import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Actor implements Comparable<Actor> {
    //Actor class with variables for name, and arraylists of movies and role the actor has played in/as.
    // Also contains a actorArrayList variable, so arraylist of actors can be sorted/searched.
    // Contains getter and setter methods for all variables, as well as a getSize function for arraylist.
    //Sort uses comparable interface, which allows for use of a comparator and collections.sort.
    //Search method uses binary search to search through sorted list of actor objects.
    String actorname;
    ArrayList<String> movieName = new ArrayList<>();
    ArrayList<String> roleName = new ArrayList<>();

    ArrayList<Actor> actorArrayList = new ArrayList<>();

    public void setActorArrayList(ArrayList<Actor> arrayListToSort){
        actorArrayList=arrayListToSort;
    }
    public ArrayList<Actor> getActorArrayList(){
        return  actorArrayList;
    }
    public void setActor(String actor) {
        actorname = actor;
    }


    public void setMovie(String movie) {
        movieName.add(movie);
    }

    public void setRole(String role) {
        roleName.add(role);
    }

    public String getMovie(){
        return movieName.toString();
    }
    public String getActor(){
        return actorname;
    }



    public String getIndividualRole(int index) {
        return roleName.get(index);
    }

    public String getIndividualMovie (int index){
        return movieName.get(index);
    }

    public String getRole(){
        return roleName.toString();
    }

    @Override
    //compare to function to use in comparator.
    public int compareTo(Actor actor) {
            if (this.actorname.charAt(0) != actor.actorname.charAt(0)) {
                return Character.compare(this.actorname.charAt(0), actor.actorname.charAt(0));
            } else {
                int index = 1;
                while (this.actorname.charAt(index)==actor.actorname.charAt(index)){
                    index++;
                }
                return Character.compare(this.actorname.charAt(index), actor.actorname.charAt(index));
            }
        }

    public int getSize(){
        return actorArrayList.size();
    }

    public int getMovieRoleSize(){
        return movieName.size();
    }
    //comparator to use in sortActorArrayList
    public static Comparator<Actor> ActorNameComparator = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            String ActorName1 = a1.getActor().toUpperCase();
            String ActorName2 = a2.getActor().toUpperCase();

            return ActorName1.compareTo(ActorName2);
        }
    };
    public void sortActorArrayList(){
        Collections.sort(actorArrayList, Actor.ActorNameComparator);
    }
    public Actor search(ArrayList<Actor> searchArrayList, String targetActor, int low, int high) {
        int mid = (low+high)/2;
        int greaterOrLess = targetActor.compareTo(searchArrayList.get(mid).getActor());
        if (low>high){
            return searchArrayList.get(mid);
        }
        if (greaterOrLess==0){
            return searchArrayList.get(mid);
        }
        else if (greaterOrLess<0){
            return search (searchArrayList, targetActor, low, mid-1);
        }
        else if (greaterOrLess>0){
            return search (searchArrayList, targetActor, mid+1,high);
        }
        return searchArrayList.get(low);
    }
    public Actor searchActor(ArrayList<Actor> searchArrayList, String targetActor){
        return search(searchArrayList, targetActor, 0, searchArrayList.size()-1);
    }
    }



