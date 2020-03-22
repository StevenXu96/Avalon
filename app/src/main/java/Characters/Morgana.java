package Characters;

import java.util.ArrayList;

public class Morgana extends Character{

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