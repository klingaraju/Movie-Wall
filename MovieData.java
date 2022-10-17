import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;



public class MovieData extends Actor {
    ArrayList<Actor> actorList = new ArrayList<>();

//implement sorting method for actorList
// implement binary search method for actorList

    public void readFile(String filename){
        try {
            ArrayList<Actor> actorArrayList = new ArrayList<>();
            FileReader csvFile = new FileReader(filename);
            BufferedReader br = new BufferedReader(csvFile);
            String line = br.readLine();
            String actorMovie = new String();
            String actorRole= new String();
            int i = 0;
            //System.out.println("Hello");
            while (line != null){
                //System.out.println("Hello Kitty");
            //for (int i = 0; i < 1 ; i++) {
                line = br.readLine();
                if(line == null){
                    break;
                }
                String[] fields = line.split("]");
                String[] movieDetails= fields[0].split("}");
                for (int j = 0; j < movieDetails.length; j++) {
                    System.out.println(movieDetails[j]);
                    String[] castDetails=movieDetails[j].split(",");
                    if (j==0){
                        actorMovie=castDetails[1];
                        //System.out.println(actorMovie);
                    }
                    for (int k = 1; k < castDetails.length; k++) {
                        //System.out.println(castDetails[k]);
                        if(castDetails[k].contains("character")){
                            actorRole=castDetails[k].substring(18, castDetails[k].length()-2);
                            //System.out.println(actorRole);
                        } if(castDetails[k].contains("name")){
                            String actorName=castDetails[k].substring(13, castDetails[k].length()-2);
                            for (int l = 0; l < actorArrayList.size(); l++) {
                                if(actorArrayList.get(i).actorname==actorName){
                                    actorArrayList.get(i).setMovie(actorMovie);
                                    actorArrayList.get(i).setRole(actorRole);
                                }
                            }
                            Actor actor = new Actor();

                            //System.out.println(actorName);
                            actor.setActor(actorName);
                            actor.setMovie(actorMovie);
                            actor.setRole(actorRole);
                            actorArrayList.add(actor);
                        }
                        //System.out.println(castDetails[k]);
                    }

                }

                i++;
            }
            for (int k = 0; k < actorArrayList.size(); k++) {
                System.out.println(actorArrayList.get(k).getMovie(0).toString());
                System.out.println(actorArrayList.get(k).getRole(0).toString());
                System.out.println(actorArrayList.get(k).getActor());
                System.out.println(" ");

            }



        } catch (IOException f) {
            System.out.println(f);

        }

    }
}

//