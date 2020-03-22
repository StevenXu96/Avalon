package Character;

import java.util.ArrayList;

public class Merlin extends Character{

    private String name;
    private ArrayList<String> badguys;

    public Merlin(String name, ArrayList<String> badguys){
        super(name);
        this.badguys = badguys;
    }

    public String skill(){
        return "you are Merlin, the bad guys are: " + this.badguys;
    }

    public boolean check(){
        return true;
    }
}
