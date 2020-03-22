package Game_Play;

import Character.*;

import java.util.ArrayList;

public class GamePlay{

    private CharacterFactory factory;


    public GamePlay(ArrayList<String> names){
        this.factory = new CharacterFactory(names);
    }


}
