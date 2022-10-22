import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Actor {
    //Actor class with variables for name, and arraylists of movies and role the actor has played in/as.
    // Also contains a actorArrayList variable, so arraylist of actors can be sorted/searched.
    // Contains getter and setter methods for all variables, as well as a getSize function for arraylist.
    //Sort uses comparable interface, which allows for use of a comparator and collections.sort.
    //Search method uses binary search to search through sorted list of actor objects.
    String actorname;
    ArrayList<String> movieName = new ArrayList<>();
    ArrayList<String> roleName = new ArrayList<>();

    public void setActor(String actor) {
        actorname = actor;
    }
    public void setMovie(String movie) {
        movieName.add(movie);
    }

    public void setRole(String role) {
        roleName.add(role);
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

    public int getMovieSize(){
        return movieName.size();
    }
    public int getRoleSize(){
        return roleName.size();
    }

}



