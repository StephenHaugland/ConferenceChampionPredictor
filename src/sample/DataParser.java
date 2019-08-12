package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Array;
import java.util.*;

/**
 * this class contains everything needed to retrieve data from the tfrrs website
 */
public class DataParser {

    private String url;
    private ArrayList<String[]> MaleAthleteDatabase = new ArrayList<String[]>();
    private ArrayList<String[]> FemaleAthleteDatabase = new ArrayList<String[]>();



    /**
     * this constructs a DataParser with a given url as a starting point
     * @param URL is a url of type String that gives a starting website
     */
    DataParser(String URL){
        try {
            this.url = URL;
            getContent();
        }
        catch(Exception e){
            System.out.println("Could not create object");
        }
    }

    /**
     * this sets the starting url
     * @param url of type String
     */
    public void setURL(String url){
        this.url = url;
    }



    public void addToDatabase(char sex, String[] ath){
        if (sex == 'm'){
            MaleAthleteDatabase.add(ath);
        }
        if (sex == 'f'){
            FemaleAthleteDatabase.add(ath);
        }
    }
    /**
     * this reads in all of the data from the website and appends it to contents
     */
    public void getContent(){
        try {
            //connect to the specified URL and parse its data
            Document doc = Jsoup.connect(this.url).get();
            // Access the main element where results will be found
            Element table = doc.getElementsByClass("panel-body").first();
            // Put all of the events into an array of elements by searching for them by class name
            Elements events = table.getElementsByAttributeValueStarting("class","row");


            char gender = ' ';
            char relayFlag = 'n';
            for (Element event : events){
                Elements eventnames = event.getElementsByClass("font-weight-500");
                System.out.print(eventnames.get(0).text() + "\n");
                if (eventnames.get(0).text().contains("Women")){
                    gender = 'f';
                }
                else if(eventnames.get(0).text().contains("Men")){
                    gender = 'm';
                }

                if (eventnames.get(0).text().contains("Relay")){
                    relayFlag = 'y';
                }

//TODO make it so relay events go to their own database
                Elements Athletes = event.getElementsByTag("tr");
                for (int i =1; i < 9; i++){
                    Element athlete = Athletes.get(i);
                    System.out.println(athlete.text());
                    String athleteInfo = athlete.text();
                    String[] AthleteInfo = athleteInfo.split(" ");
                    addToDatabase(gender,AthleteInfo);
                    System.out.println("Individual Athlete info: " + Arrays.toString(AthleteInfo));
                }
                System.out.println("\n");

            }



            /*
            for (Element event : events){
                System.out.println(event.getElementsByClass("font-weight-500").text());
                Elements Athletes = event.getElementsByTag("tr");
                for (Element athlete : Athletes){

                    System.out.println(athlete.text());
                }
            }
*/


        }
        catch (Exception ex){
            System.out.printf("Oops: %s", ex.getMessage());
        }

    }


    public ArrayList<String[]> getFemaleAthleteDatabase() {
        return FemaleAthleteDatabase;
    }

    public ArrayList<String[]> getMaleAthleteDatabase() {
        return MaleAthleteDatabase;
    }

    // main test function
    public static void main(String[] args){
        System.out.println("\nFetching Data:");
        DataParser dataParser = new DataParser("https://www.tfrrs.org/lists/2595.html");
        System.out.println("hi");
        //dataParser.displayContents();
    }


}
