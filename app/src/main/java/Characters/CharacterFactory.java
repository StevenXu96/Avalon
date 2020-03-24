package Characters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CharacterFactory implements Serializable {

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

            case 7:
                ArrayList<String> bad7guys = new ArrayList<>();
                ArrayList<String> merlin7Morgana = new ArrayList<>();
                bad7guys.add(this.player_names.get(3));
                bad7guys.add(this.player_names.get(4));
                bad7guys.add(this.player_names.get(6));
                merlin7Morgana.add(this.player_names.get(2));
                merlin7Morgana.add(this.player_names.get(4));
                Collections.shuffle(bad7guys);
                Collections.shuffle(merlin7Morgana);
                Character p71 = new Civilian(this.player_names.get(0));
                Character p72 = new Percival(this.player_names.get(1), merlin7Morgana);
                Character p73 = new Merlin(this.player_names.get(2), bad7guys);
                Character p74 = new Assassin(this.player_names.get(3), bad7guys);
                Character p75 = new Morgana(this.player_names.get(4), bad7guys);
                Character p76 = new Civilian(this.player_names.get(5));
                Character p77 = new Evil(this.player_names.get(6), bad7guys);
                people.add(p71);
                people.add(p72);
                people.add(p73);
                people.add(p74);
                people.add(p75);
                people.add(p76);
                people.add(p77);
                break;

            case 8:
                ArrayList<String> bad8guys = new ArrayList<>();
                ArrayList<String> merlin8Morgana = new ArrayList<>();
                bad8guys.add(this.player_names.get(3));
                bad8guys.add(this.player_names.get(4));
                bad8guys.add(this.player_names.get(6));
                merlin8Morgana.add(this.player_names.get(2));
                merlin8Morgana.add(this.player_names.get(4));
                Collections.shuffle(bad8guys);
                Collections.shuffle(merlin8Morgana);
                Character p81 = new Civilian(this.player_names.get(0));
                Character p82 = new Percival(this.player_names.get(1), merlin8Morgana);
                Character p83 = new Merlin(this.player_names.get(2), bad8guys);
                Character p84 = new Assassin(this.player_names.get(3), bad8guys);
                Character p85 = new Morgana(this.player_names.get(4), bad8guys);
                Character p86 = new Civilian(this.player_names.get(5));
                Character p87 = new Evil(this.player_names.get(6), bad8guys);
                Character p88 = new Civilian(this.player_names.get(7));
                people.add(p81);
                people.add(p82);
                people.add(p83);
                people.add(p84);
                people.add(p85);
                people.add(p86);
                people.add(p87);
                people.add(p88);
                break;
        }
        return people;
    }
}
