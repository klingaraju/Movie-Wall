import java.util.ArrayList;

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

    public String getMovie(){
        return movieName.toString();
    }
    public String getActor(){
        return actorname;
    }

    public String getRole(){
        return roleName.toString();
    }
}
