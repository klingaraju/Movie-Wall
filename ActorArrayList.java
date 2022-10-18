import java.util.ArrayList;

public class ActorArrayList extends Actor {
    ArrayList<Actor> actorArrayList = new ArrayList<>();

    public void setActorArrayList(ArrayList<Actor> classArrayList){
        actorArrayList=classArrayList;
    }
    public ArrayList getActorArrayList(){
        return actorArrayList;
    }
    public void sortActorArrayList(){

    }

    public Actor searchActor(ArrayList<Actor> searchArrayList, String actorname){
        Actor targetActor = new Actor();
        return targetActor;
    }

}
