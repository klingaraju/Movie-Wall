import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MovieData extends Actor {
    public MovieData() {
    }

    public ArrayList<Actor> readFile(String filename) {
        ArrayList<Actor> actorArrayList = new ArrayList();

        try {
            FileReader csvFile = new FileReader(filename);
            BufferedReader br = new BufferedReader(csvFile);
            String line = br.readLine();
            String actorMovie = "";
            String workingActorRole = "";
            String workingActorName = "";
            Actor newActor = new Actor();

            while(line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                String[] parseNames = line.split("name\"\": \"\"");
                String[] parseRoles = line.split(", \"\"character\"\": \"\"");
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

                for(int i = 1; i < parseNames.length && i < parseRoles.length; ++i) {
                    if (parseNames[i].contains("\"")) {
                        workingActorName = parseNames[i].substring(0, parseNames[i].indexOf("\"\""));
                        workingActorRole = parseRoles[i].substring(0, parseRoles[i].indexOf("\""));
                    }

                    if (actorArrayList.size() == 0) {
                        newActor.setActor(workingActorName);
                        newActor.setMovie(actorMovie);
                        newActor.setRole(workingActorRole);
                        actorArrayList.add(newActor);
                    }

                    boolean actorInList = false;

                    for(int j = 0; j < actorArrayList.size(); j++) {
                        if (((Actor)actorArrayList.get(j)).getActor().equals(workingActorName)) {
                            ((Actor)actorArrayList.get(j)).setRole(workingActorRole);
                            ((Actor)actorArrayList.get(j)).setMovie(actorMovie);
                            actorInList = true;
                        } else if (!actorInList) {
                            newActor.setActor(workingActorName);
                            newActor.setMovie(actorMovie);
                            newActor.setRole(workingActorRole);
                            actorArrayList.add(newActor);
                        }
                    }
                }

                System.out.println(actorArrayList.size());
            }
        } catch (IOException var16) {
            System.out.println(var16);
        }

        return actorArrayList;
    }
}






























/*
OLD CLASS -------------------------------------------
 */
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//
//
//public class MovieData extends Actor {
//    //this class is used to parse through the data file and add actor objects to the arraylist of actors.
//    public ArrayList<Actor> readFile(String filename){
//        //this is the function that parses through the data file containing all of the actors' info.
//        ArrayList<Actor> actorArrayList = new ArrayList<>();
//        try {
//            FileReader csvFile = new FileReader(filename);
//            BufferedReader br = new BufferedReader(csvFile);
//            String line = br.readLine();
//            String actorMovie = "";
//            String workingActorRole="";
//            String workingActorName= "";
//            Actor newActor = new Actor();
//
//            //int i = 0;
//            while (line != null){
//                line = br.readLine();
//                if(line == null){
//                    break;
//                }
//                String[] parseNames=line.split("name\"\": \"\"");
//                String[] parseRoles= line.split(", \"\"character\"\": \"\"");
//                String parseMovie=line;
//
//                if (parseMovie.contains("[") && parseMovie.contains("{")){
//                    actorMovie=parseMovie.substring(parseMovie.indexOf(",")+1 , parseMovie.indexOf('{')-3);
//                    if (actorMovie.contains("[]")){
//                        actorMovie=parseMovie.substring(parseMovie.indexOf(",")+1, parseMovie.indexOf("{")-6);
//                    }
//                } else if (parseMovie.contains("[")) {
//                    actorMovie=parseMovie.substring(parseMovie.indexOf(",")+1,parseMovie.indexOf("[")-1);
//                }
//                if(actorMovie.contains("\"")){
//                    actorMovie=actorMovie.substring(1, actorMovie.length()-1);
//                }
//                //System.out.println(parseNames[1].toString());
//                for (int i = 1; i < parseNames.length && i < parseRoles.length;  i++) {
//                    if (parseNames[i].contains("\"")){
//                        workingActorName=parseNames[i].substring(0, parseNames[i].indexOf("\"\""));
//                        workingActorRole=parseRoles[i].substring(0, parseRoles[i].indexOf("\""));
//                    }
////                    System.out.println(workingActorRole);
////                    System.out.println(workingActorName);
////
////
//                    if(actorArrayList.size()==0){
//                        newActor.setActor(workingActorName);
//                        newActor.setMovie(actorMovie);
//                        newActor.setRole(workingActorRole);
//                        actorArrayList.add(newActor);
//                    }
//                    boolean actorInList = false;
//                    for (int j = 0; j < actorArrayList.size(); j++) {
//                        if (actorArrayList.get(j).getActor().equals(workingActorName)){
//                            actorArrayList.get(j).setRole(workingActorRole);
//                            actorArrayList.get(j).setMovie(actorMovie);
//                            actorInList=true;
//                        } else if (actorInList==false) {
//                            newActor.setActor(workingActorName);
//                            newActor.setMovie(actorMovie);
//                            newActor.setRole(workingActorRole);
//                            actorArrayList.add(newActor);
//                        }
//                    }
//                }
//                System.out.println(actorArrayList.size());
//
//
//                //i++;
//                //Here, the movie name is obtained getting the first element, which will always be the movie.
//                //The array is then split on ] to remove crew members, and creates fields.
//                //Fields is then split on } to seperate each actor's attributes into an individual array, giving movieDetails.
//
////                String[] movieDetails= fields[0].split("}");
////                //System.out.println(actorMovie);
////                for (int j = 0; j < movieDetails.length; j++) {
////                    //Each movie's actor is split on , to seperate all the different attributes of the actor.
////                    String[] castDetails=movieDetails[j].split(",");
////                    for (int k = 1; k < castDetails.length; k++) {
////                        //this boolean is to check if an actor in a movie already has an entry in the arraylist of actors.
////                        boolean alreadyVisited = false;
////                        //here, based on the contents of each attribute, we assign the actor's role and name.
////                        if(castDetails[k].contains("character")){
////                            actorRole=castDetails[k].substring(18, castDetails[k].length()-2);
////                        } if(castDetails[k].contains("name")){
////                            String actorName=castDetails[k].substring(13, castDetails[k].length()-2);
////                            if(actorName.contains(" ")){
////                                actorName=actorName.trim();
////                            }
////                            if(actorName.contains("\"\"")){
////                                actorName=actorName.trim();
////                            }
////                            //Here, we are checking to see if the actorname already has an entry in the actorarraylist.
////                            // If it does, we just add the movie and role to the actor object's arraylist of movies and roles.
////                            for (int l = 0; l < actorArrayList.size(); l++) {
////                                if(actorArrayList.get(l).getActor().equals(actorName)){
////                                    actorArrayList.get(l).setMovie(actorMovie);
////                                    actorArrayList.get(l).setRole(actorRole);
////                                    alreadyVisited=true;
////                                }
////                                // Here, if the actorname isn't in the arraylist of actors, we add them to the list.
////                            } if (alreadyVisited==false) {
////                                Actor actor = new Actor();
////                                actor.setActor(actorName);
////                                actor.setMovie(actorMovie);
////                                actor.setRole(actorRole);
////                                actorArrayList.add(actor);
////                            }
////                        }
////                    }
////
////                }
////                i++;
//            }
//        } catch (IOException f) {
//            System.out.println(f);
//        }
//        return actorArrayList;
//    }
//}
