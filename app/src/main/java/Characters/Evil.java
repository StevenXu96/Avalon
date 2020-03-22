package Characters;

import java.util.ArrayList;

public class Evil extends Character{

    private String name;
    private ArrayList<String> teammates;

    public Evil(String name, ArrayList<String> teammates){
        super(name);
        this.teammates = teammates;
    }

    public String skill(){
        return "you are just a bad guy! Your teammates are " + this.teammates;
    }

    public boolean check(){
        return false;
    }
}