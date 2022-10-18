import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;



public class MovieData extends Actor {
//implement sorting method for actorList
// implement binary search method for actorList

    public ArrayList<Actor> readFile(String filename){
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
                String[] fields = line.split("]");
                String[] movieDetails= fields[0].split("}");
                for (int j = 0; j < movieDetails.length; j++) {
                    //System.out.println(movieDetails[j]);
                    String[] castDetails=movieDetails[j].split(",");
                    if (j==0){
                        actorMovie=castDetails[1];
                        //System.out.println(actorMovie);
                    }
                    for (int k = 1; k < castDetails.length; k++) {
                        boolean alreadyVisited = false;
                        //System.out.println(castDetails[k]);
                        if(castDetails[k].contains("character")){
                            actorRole=castDetails[k].substring(18, castDetails[k].length()-2);
                            //System.out.println(actorRole);
                        } if(castDetails[k].contains("name")){
                            String actorName=castDetails[k].substring(13, castDetails[k].length()-2);
                            if(actorName.contains(" ")){
                                actorName=actorName.trim();
                            }
                            for (int l = 0; l < actorArrayList.size(); l++) {
                                if(actorArrayList.get(l).getActor().equals(actorName)){
                                    actorArrayList.get(l).setMovie(actorMovie);
                                    actorArrayList.get(l).setRole(actorRole);
                                    alreadyVisited=true;
                                }
                            } if (alreadyVisited==false) {
                                Actor actor = new Actor();
                                actor.setActor(actorName);
                                actor.setMovie(actorMovie);
                                actor.setRole(actorRole);
                                actorArrayList.add(actor);
                            }
                        }
                        //System.out.println(castDetails[k]);
                    }

                }

                i++;
            }
//            for (int j = 0; j < actorArrayList.size(); j++) {
//                System.out.println(actorArrayList.get(j).getActor());
//                System.out.println(actorArrayList.get(j).getMovie());
//                System.out.println(actorArrayList.get(j).getRole());
//            }

        } catch (IOException f) {
            System.out.println(f);
        }
        return actorArrayList;
    }
}
