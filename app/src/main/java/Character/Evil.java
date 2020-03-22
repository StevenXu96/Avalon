package Character;

public class Evil extends Character{

    private String name;

    public Evil(String name){
        super(name);
    }

    public String skill(){
        return "you are just a bad guy!";
    }

    public boolean check(){
        return false;
    }
}