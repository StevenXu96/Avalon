package Characters;

import java.io.Serializable;

public abstract class Character implements Serializable{
    private String name;

    public Character(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public abstract String skill();

    public abstract boolean check();

    public abstract boolean merlin();

}
