package sample;

import java.util.ArrayList;
import java.util.Vector;

public class School {

    private String name;
    private double totalPointsMen = 0;
    private double totalPointsWomen = 0;
    private ArrayList<Athlete> MaleAthletes = new ArrayList<Athlete>();
    private ArrayList<Athlete> FemaleAthletes = new ArrayList<Athlete>();

    public School(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getTotalPointsWomen() {
        return totalPointsWomen;
    }

    public void setTotalPointsWomen(double totalPointsWomen) {
        this.totalPointsWomen = totalPointsWomen;
    }

    public double getTotalPointsMen() {
        return totalPointsMen;
    }

    public void setTotalPointsMen(double totalPointsMen) {
        this.totalPointsMen = totalPointsMen;
    }

    public void addMaleAthlete(Athlete ath){
        MaleAthletes.add(ath);
    }

    public void addFemaleAthlete(Athlete ath){
        FemaleAthletes.add(ath);
    }
}
