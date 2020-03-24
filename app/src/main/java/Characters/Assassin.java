package Characters;

import java.io.Serializable;
import java.util.ArrayList;

public class Assassin extends Character implements Serializable {

    private String name;
    private ArrayList<String> teammates;

    public Assassin(String name, ArrayList<String> teammates){
        super(name);
        this.teammates = teammates;
    }

    public String skill(){
        return "you are an Assassin! Your teammates are: " + this.teammates;
    }

    public boolean check(){
        return false;
    }

    public boolean merlin(){
        return false;
    }
}
