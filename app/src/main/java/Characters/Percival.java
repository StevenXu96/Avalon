package Characters;

import java.util.ArrayList;

public class Percival extends Character{

    private String name;
    private ArrayList<String> merlinMorgana;

    public Percival(String name, ArrayList<String> merlinMorgana){
        super(name);
        this.merlinMorgana = merlinMorgana;
    }

    public String skill(){
        return "you are Percival, the 2 names you are going to see are: " + this.merlinMorgana.get(0)
                + " and " + this.merlinMorgana.get(1) + "! But you don't know who is who.";
    }

    public boolean check(){
        return true;
    }
}