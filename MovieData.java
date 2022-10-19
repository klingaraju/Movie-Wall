import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;



public class MovieData extends Actor {
    //this class is used to parse through the data file and add actor objects to the arraylist of actors.
    public ArrayList<Actor> readFile(String filename){
        //this is the function that parses through the data file containing all of the actors' info.
        ArrayList<Actor> actorArrayList = new ArrayList<>();
        try {
            FileReader csvFile = new FileReader(filename);
            BufferedReader br = new BufferedReader(csvFile);
            String line = br.readLine();
            String actorMovie = new String();
            String actorRole= new String();
            int i = 0;
            while (line != null){
                line = br.readLine();
                if(line == null){
                    break;
                }
                //Here, the movie name is obtained getting the first element, which will always be the movie.
                //The array is then split on ] to remove crew members, and creates fields.
                //Fields is then split on } to seperate each actor's attributes into an individual array, giving movieDetails.
                actorMovie = line.split(",")[1];
                String[] fields = line.split("]");
                String[] movieDetails= fields[0].split("}");
                //System.out.println(actorMovie);
                for (int j = 0; j < movieDetails.length; j++) {
                    //Each movie's actor is split on , to seperate all the different attributes of the actor.
                    String[] castDetails=movieDetails[j].split(",");
                    for (int k = 1; k < castDetails.length; k++) {
                        //this boolean is to check if an actor in a movie already has an entry in the arraylist of actors.
                        boolean alreadyVisited = false;
                        //here, based on the contents of each attribute, we assign the actor's role and name.
                        if(castDetails[k].contains("character")){
                            actorRole=castDetails[k].substring(18, castDetails[k].length()-2);
                        } if(castDetails[k].contains("name")){
                            String actorName=castDetails[k].substring(13, castDetails[k].length()-2);
                            if(actorName.contains(" ")){
                                actorName=actorName.trim();
                            }
                            if(actorName.contains("\"\"")){
                                actorName=actorName.trim();
                            }
                            //Here, we are checking to see if the actorname already has an entry in the actorarraylist.
                            // If it does, we just add the movie and role to the actor object's arraylist of movies and roles.
                            for (int l = 0; l < actorArrayList.size(); l++) {
                                if(actorArrayList.get(l).getActor().equals(actorName)){
                                    actorArrayList.get(l).setMovie(actorMovie);
                                    actorArrayList.get(l).setRole(actorRole);
                                    alreadyVisited=true;
                                }
                                // Here, if the actorname isn't in the arraylist of actors, we add them to the list.
                            } if (alreadyVisited==false) {
                                Actor actor = new Actor();
                                actor.setActor(actorName);
                                actor.setMovie(actorMovie);
                                actor.setRole(actorRole);
                                actorArrayList.add(actor);
                            }
                        }
                    }

                }
                i++;
            }
        } catch (IOException f) {
            System.out.println(f);
        }
        return actorArrayList;
    }
}
