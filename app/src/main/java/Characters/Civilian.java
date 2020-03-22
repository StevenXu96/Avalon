package Characters;

public class Civilian extends Character{

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
