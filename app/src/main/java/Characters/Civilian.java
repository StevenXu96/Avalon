package Characters;

import java.io.Serializable;

public class Civilian extends Character implements Serializable {

    private String name;

    public Civilian(String name){
        super(name);
    }

    public String skill(){
        return "You are a Civilian. You don't know anything else.";
    }

    public boolean check(){
        return true;
    }
}
