package Characters;

import java.util.ArrayList;
import java.util.Collections;

public class CharacterFactory {

    private ArrayList<String> player_names;

    public CharacterFactory(ArrayList<String> names){
        this.player_names = names;
    }

    public ArrayList<Character> construct(){
        ArrayList<Character> people = new ArrayList<>();
        Collections.shuffle(this.player_names);
        switch(this.player_names.size()){
            case 5:
                ArrayList<String> bad5guys = new ArrayList<>();
                bad5guys.add(this.player_names.get(4));
                bad5guys.add(this.player_names.get(3));
                Collections.shuffle(bad5guys);
                Character p1 = new Civilian(this.player_names.get(0));
                ArrayList<String> merlin5Morgana = new ArrayList<>();
                merlin5Morgana.add(this.player_names.get(2));
                merlin5Morgana.add(this.player_names.get(4));
                Collections.shuffle(merlin5Morgana);
                Character p2 = new Percival(this.player_names.get(1), merlin5Morgana);
                Character p3 = new Merlin(this.player_names.get(2), bad5guys);
                Character p4 = new Assassin(this.player_names.get(3), bad5guys);
                Character p5 = new Morgana(this.player_names.get(4), bad5guys);
                people.add(p1);
                people.add(p2);
                people.add(p3);
                people.add(p4);
                people.add(p5);
                break;

            case 6:
                ArrayList<String> bad6guys = new ArrayList<>();
                bad6guys.add(this.player_names.get(4));
                bad6guys.add(this.player_names.get(3));
                Collections.shuffle(bad6guys);
                Character p61 = new Civilian(this.player_names.get(0));
                ArrayList<String> merlin6Morgana = new ArrayList<>();
                merlin6Morgana.add(this.player_names.get(2));
                merlin6Morgana.add(this.player_names.get(4));
                Collections.shuffle(merlin6Morgana);
                Character p62 = new Percival(this.player_names.get(1), merlin6Morgana);
                Character p63 = new Merlin(this.player_names.get(2), bad6guys);
                Character p64 = new Assassin(this.player_names.get(3), bad6guys);
                Character p65 = new Morgana(this.player_names.get(4), bad6guys);
                Character p66 = new Civilian(this.player_names.get(5));
                people.add(p61);
                people.add(p62);
                people.add(p63);
                people.add(p64);
                people.add(p65);
                people.add(p66);
                break;

            default:
                break;
        }
        return people;
    }
}
