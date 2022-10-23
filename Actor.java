import java.util.ArrayList;
/**
 * This class holds the name of each actor, as well as an arrayList of all their movies and roles.
 * Also has getter/setter methods for actorname, as well as adding movies and roles to the arrayLists.
 */
public class Actor {
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
    public int getRoleSize(){
        return roleName.size();
    }
}



