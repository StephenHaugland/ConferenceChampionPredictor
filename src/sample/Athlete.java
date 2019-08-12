package sample;

public class Athlete {

    private int points = 0;
    private String name;
    private String year;
    private String school;
    private char sex;

    public Athlete(int p, String n,char s){
        name = n;
        sex = s;
        CalculatePoints(p);
    }

    public void CalculatePoints(int Place){
        if (Place == 1){
            points += 10;
        }
        else if (Place == 2){
            points += 8;
        }
        else
            points += (9-Place);
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString(){
        return name + " " + year + " " + school;
    }
}
