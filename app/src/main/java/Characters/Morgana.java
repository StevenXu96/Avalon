package Characters;

import java.io.Serializable;
import java.util.ArrayList;

public class Morgana extends Character implements Serializable {

    private String name;
    private ArrayList<String> teammates;

    public Morgana(String name, ArrayList<String> teammates){
        super(name);
        this.teammates = teammates;
    }

    public String skill(){
        return "you are Morgana! Your teammates are: " + this.teammates;
    }

    public boolean check(){
        return false;
    }
}