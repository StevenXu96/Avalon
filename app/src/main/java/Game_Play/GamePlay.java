package Game_Play;

import Characters.*;

import java.util.ArrayList;

public class GamePlay{

    private CharacterFactory factory;


    public GamePlay(ArrayList<String> names){
        this.factory = new CharacterFactory(names);
    }


}
