package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Conference Championship Standings");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();


    }

    public static ArrayList<School> createSchools(){
        //create a vector of schools
        ArrayList<School> schools = new ArrayList<School>();
        //create all schools in the NWC
        School WHIT = new School("Whitworth");
        School GFU = new School("George Fox");
        School PLU = new School("Pacific Lutheran");
        School LC = new School("Lewis & Clark");
        School LIN = new School("Linfield");
        School PU = new School("Pacific (Ore.)");
        School PSU = new School("Puget Sound");
        School WU = new School("Willamette");
        //add all schools to a vector
        schools.add(WHIT);
        schools.add(GFU);
        schools.add(PLU);
        schools.add(LC);
        schools.add(LIN);
        schools.add(PU);
        schools.add(PSU);
        schools.add(WU);
        //return schools
        return schools;
    }


    public static void main(String[] args) {
        //generate all of the schools in the northwest conference and add them to an arrayList
        ArrayList<School> nwcSchools = createSchools();

        //create NWC conference object using newly created arrayList of schools
        Conference NWC = new Conference("Northwest Conference",nwcSchools);
        //System.out.println(NWC.toString());


        //create a data parser to take rankings from tfrrs website and transfer information to custom data structures
        DataParser dataParser = new DataParser("https://www.tfrrs.org/lists/2595.html");

        ArrayList<String[]> maleAthleteData = dataParser.getMaleAthleteDatabase();
        for (int i=0; i < maleAthleteData.size();i++){
            School school = NWC.getSchool((maleAthleteData.get(i))[4],(maleAthleteData.get(i))[1]);
            System.out.println(school.getName());
            //TODO create athlete objects based on their data
            //NWC.getSchool((maleAthleteData.get(i))[4],(maleAthleteData.get(i))[1]).addMaleAthlete(new Athlete(// constructor parameters));
        }

        launch(args);
    }


}
