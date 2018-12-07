package test.testbeanpostprocessor;

/**
 * @author chuanshi - 2018-12-07 13:48
 */
public class FootballPlayer {

    String name;
    String team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void shoot() {
        System.out.println(this.getName() + " shoot");
    }

    public void pass() {
        System.out.println(this.getName() + " pass");
    }
}
