package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Conference {
    private String name;
    private ArrayList<School> Schools = new ArrayList<School>();

    public Conference(String name) {
        this.name = name;
    }

    public Conference(String n, ArrayList<School> schoolVector) {
        name = n;
        //Collections.copy(Schools,schoolVector);
        for (int i =0; i < schoolVector.size(); i++){
            Schools.add(schoolVector.get(i));
        }
    }

    public String toString(){
        StringBuilder schoolNames = new StringBuilder();
        for (int i =0; i <Schools.size(); i++){
            schoolNames.append(Schools.get(i).getName() + " ");
        }
        return schoolNames.toString();
    }

    public void addSchool(School school){
        Schools.add(school);
    }

    public School getSchool(String sch,String sch2){
        for (int i = 0; i <Schools.size();i++){
            if (Schools.get(i).getName().contains(sch) || Schools.get(i).getName().contains(sch2))
                return Schools.get(i);
        }
        return new School("Sky High");
    }
}
