import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This MovieData class takes in the file of movies to be read, and parses it to find the actors, roles, and movies.
 * It adds this info to a hashmap of Actor objects.
 */
public class MovieData extends Actor {
    HashMap<String, Actor> actorHashMap;
    public MovieData() {
        this.actorHashMap  = new HashMap<String, Actor>();
    }
    /**
     * readFile is the method used to read and parse the movie csv file, and adds Actor objects accordingly to a hashmap.
     * @param filename - File to be read.
     */
    public void readFile(String filename) {
        ArrayList<String> keyList = new ArrayList();
;        try {
            FileReader csvFile = new FileReader(filename);
            BufferedReader br = new BufferedReader(csvFile);
            String line = br.readLine();
            String actorMovie = "";
            String workingActorRole = "";
            String workingActorName = "";
            while(line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                //These arrays hold all the raw name and role data for each line of the csv file.
                String[] parseNames = line.split("name\"\": \"\"");
                String[] parseRoles = line.split(", \"\"character\"\": \"\"");
                //This logic finds the movie name for each line of the csv file.
                if (line.contains("[") && line.contains("{")) {
                    actorMovie = line.substring(line.indexOf(",") + 1, line.indexOf(123) - 3);
                    if (actorMovie.contains("[]")) {
                        actorMovie = line.substring(line.indexOf(",") + 1, line.indexOf("{") - 6);
                    }
                } else if (line.contains("[")) {
                    actorMovie = line.substring(line.indexOf(",") + 1, line.indexOf("[") - 1);
                }
                if (actorMovie.contains("\"")) {
                    actorMovie = actorMovie.substring(1, actorMovie.length() - 1);
                }
                //This for loop cleans up each actor's name and role in the movie. It also checks to see if the actor is already in the hashmap.
                //If they are, it adds the movie and role to the arraylist of movies and roles in the actor object.
                //If they aren't, it creates a new actor object for that actor and adds the movie and role to the arraylist of movies and roles within the actor object.
                for(int i = 1; i < parseNames.length && i < parseRoles.length; i++) {
                    if (parseNames[i].contains("\"")) {
                        workingActorName = parseNames[i].substring(0, parseNames[i].indexOf("\"\""));
                        workingActorRole = parseRoles[i].substring(0, parseRoles[i].indexOf("\""));
                        if(workingActorName.contains(" ")){
                            workingActorName=workingActorName.trim();
                        }
                    }
                    if(actorHashMap.containsKey(workingActorName)){
                        actorHashMap.get(workingActorName).setMovie(actorMovie);
                        actorHashMap.get(workingActorName).setRole(workingActorRole);
                    } else {
                        Actor newActor = new Actor();
                        newActor.setActor(workingActorName);
                        newActor.setMovie(actorMovie);
                        newActor.setRole(workingActorRole);
                        keyList.add(workingActorName);
                        actorHashMap.put(workingActorName, newActor);
                    }
                }
            }
        } catch (IOException var16) {
            System.out.println(var16);
        }
    }
}
