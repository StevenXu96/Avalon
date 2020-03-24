package com.something.avalon;

import Characters.Character;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class Vote extends AppCompatActivity {

    ArrayList<Characters.Character> characters_temp;
    ArrayList<Characters.Character> onMission;
    int success;
    int fail;
    int cap_num;
    int index;
    int accept;
    int votes;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote_screen);

        Intent intent = getIntent();
        characters_temp = (ArrayList<Character>) intent.getSerializableExtra("characters");
        final ArrayList<Characters.Character> characters = characters_temp;
        success = intent.getIntExtra("success", 0);
        fail = intent.getIntExtra("fail", 0);
        cap_num = intent.getIntExtra("cap", 0);
        index = intent.getIntExtra("index", 0);
        onMission = (ArrayList<Character>) intent.getSerializableExtra("onMission");
        accept = intent.getIntExtra("accept", 0);
        votes = intent.getIntExtra("votes", 0);

        final TextView who = (TextView) findViewById(R.id.whoVote);
        who.setText("Please pass the device to " + onMission.get(index).getName() + ". REMEMBER: Good people can Only vote SUCCESS, even if you press fail, the program will treat it as SUCCESS.");
        final Button good = (Button) findViewById(R.id.good);
        final Button bad = (Button) findViewById(R.id.bad);

        good.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                votes += 1;
                if (index == onMission.size()-1 ){
                    if (votes >= onMission.size()-accept){
                        AlertDialog.Builder builder = new AlertDialog.Builder(Vote.this);

                        builder.setCancelable(false);
                        builder.setTitle("SUCCESS");
                        builder.setMessage("There are " + votes + " success cards! MISSION SUCCESS");

                        builder.setPositiveButton("GREAT", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(success < 2) {
                                    if (characters.size() == 5) {
                                        Intent intent = new Intent(Vote.this, FivePlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                    else if (characters.size() == 6){
                                        Intent intent = new Intent(Vote.this, SixPlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                    else if (characters.size() == 7){
                                        Intent intent = new Intent(Vote.this, SevenPlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                    else if (characters.size() == 8){
                                        Intent intent = new Intent(Vote.this, EightPlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                }
                                else{
                                    if (characters.size() == 5) {
                                        Intent next = new Intent(Vote.this, WhoIsMerlin3.class);
                                        next.putExtra("test", characters);
                                        startActivity(next);
                                    }
                                    else if (characters.size() <= 7){
                                        Intent next = new Intent(Vote.this, WhoIsMerlin4.class);
                                        next.putExtra("test", characters);
                                        startActivity(next);
                                    }
                                    else if (characters.size() == 8){
                                        Intent next = new Intent(Vote.this, WhoIsMerlin5.class);
                                        next.putExtra("test", characters);
                                        startActivity(next);
                                    }
                                }
                            }
                        });
                        builder.show();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Vote.this);

                        builder.setCancelable(false);
                        builder.setTitle("FAILED");
                        builder.setMessage("There are " + votes + " success cards! MISSION FAILED!");

                        builder.setPositiveButton("Next Round", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(fail < 2) {
                                    if (characters.size() == 5) {
                                        Intent intent = new Intent(Vote.this, FivePlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                    else if (characters.size() == 6){
                                        Intent intent = new Intent(Vote.this, SixPlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                    else if (characters.size() == 7){
                                        Intent intent = new Intent(Vote.this, SevenPlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                    else if (characters.size() == 8){
                                        Intent intent = new Intent(Vote.this, EightPlayers.class);
                                        intent.putExtra("characters", characters);
                                        intent.putExtra("success", success + 1);
                                        intent.putExtra("fail", fail);
                                        intent.putExtra("cap", cap_num + 1);
                                        startActivity(intent);
                                    }
                                }
                                else{
                                    Intent i = new Intent(Vote.this, GameOver.class);
                                    i.putExtra("test", characters);
                                    startActivity(i);
                                }
                            }
                        });
                        builder.show();
                    }
                }
                else{
                    index += 1;
                    Intent i = new Intent(Vote.this, Vote.class);
                    i.putExtra("index", index);
                    i.putExtra("onMission", onMission);
                    i.putExtra("success", success);
                    i.putExtra("fail", fail);
                    i.putExtra("cap", cap_num);
                    i.putExtra("characters", characters);
                    i.putExtra("accept", accept);
                    i.putExtra("votes", votes);
                    startActivity(i);
                }
            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (onMission.get(index).check()){
                    votes += 1;
                    if (index == onMission.size()-1 ){
                        if (votes >= onMission.size()-accept){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Vote.this);

                            builder.setCancelable(false);
                            builder.setTitle("SUCCESS");
                            builder.setMessage("There are " + votes + " success cards! MISSION SUCCESS");

                            builder.setPositiveButton("GREAT", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(success < 2) {
                                        if (characters.size() == 5) {
                                            Intent intent = new Intent(Vote.this, FivePlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 6){
                                            Intent intent = new Intent(Vote.this, SixPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 7){
                                            Intent intent = new Intent(Vote.this, SevenPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 8){
                                            Intent intent = new Intent(Vote.this, EightPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                    }
                                    else{
                                        if (characters.size() == 5) {
                                            Intent next = new Intent(Vote.this, WhoIsMerlin3.class);
                                            next.putExtra("test", characters);
                                            startActivity(next);
                                        }
                                        else if (characters.size() <= 7){
                                            Intent next = new Intent(Vote.this, WhoIsMerlin4.class);
                                            next.putExtra("test", characters);
                                            startActivity(next);
                                        }
                                        else if (characters.size() == 8){
                                            Intent next = new Intent(Vote.this, WhoIsMerlin5.class);
                                            next.putExtra("test", characters);
                                            startActivity(next);
                                        }
                                    }
                                }
                            });
                            builder.show();

                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Vote.this);

                            builder.setCancelable(false);
                            builder.setTitle("FAILED");
                            builder.setMessage("There are " + votes + " success cards! MISSION FAILED!");

                            builder.setPositiveButton("Next Round", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (fail < 2) {
                                        if (characters.size() == 5) {
                                            Intent intent = new Intent(Vote.this, FivePlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 6){
                                            Intent intent = new Intent(Vote.this, SixPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 7){
                                            Intent intent = new Intent(Vote.this, SevenPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 8){
                                            Intent intent = new Intent(Vote.this, EightPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                    }
                                    else{
                                        Intent i = new Intent(Vote.this, GameOver.class);
                                        i.putExtra("test", characters);
                                        startActivity(i);
                                    }
                                }
                            });
                            builder.show();
                        }
                    }
                    else{
                        index += 1;
                        Intent i = new Intent(Vote.this, Vote.class);
                        i.putExtra("index", index);
                        i.putExtra("onMission", onMission);
                        i.putExtra("success", success);
                        i.putExtra("fail", fail);
                        i.putExtra("cap", cap_num);
                        i.putExtra("characters", characters);
                        i.putExtra("accept", accept);
                        i.putExtra("votes", votes);
                        startActivity(i);
                    }
                }
                else{
                    if (index == onMission.size()-1 ){
                        if (votes >= onMission.size()-accept){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Vote.this);

                            builder.setCancelable(false);
                            builder.setTitle("SUCCESS");
                            builder.setMessage("There are " + votes + " success cards! MISSION SUCCESS");

                            builder.setPositiveButton("GREAT", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (success < 2) {
                                        if (characters.size() == 5) {
                                            Intent intent = new Intent(Vote.this, FivePlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 6){
                                            Intent intent = new Intent(Vote.this, SixPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 7){
                                            Intent intent = new Intent(Vote.this, SevenPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 8){
                                            Intent intent = new Intent(Vote.this, EightPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                    }
                                    else{
                                        if (characters.size() == 5) {
                                            Intent next = new Intent(Vote.this, WhoIsMerlin3.class);
                                            next.putExtra("test", characters);
                                            startActivity(next);
                                        }
                                        else if (characters.size() <= 7){
                                            Intent next = new Intent(Vote.this, WhoIsMerlin4.class);
                                            next.putExtra("test", characters);
                                            startActivity(next);
                                        }
                                        else if (characters.size() == 8){
                                            Intent next = new Intent(Vote.this, WhoIsMerlin5.class);
                                            next.putExtra("test", characters);
                                            startActivity(next);
                                        }
                                    }
                                }
                            });
                            builder.show();

                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Vote.this);

                            builder.setCancelable(false);
                            builder.setTitle("FAILED");
                            builder.setMessage("There are " + votes + " success cards! MISSION FAILED!");

                            builder.setPositiveButton("Next Round", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(fail < 2) {
                                        if (characters.size() == 5) {
                                            Intent intent = new Intent(Vote.this, FivePlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 6){
                                            Intent intent = new Intent(Vote.this, SixPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 7){
                                            Intent intent = new Intent(Vote.this, SevenPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                        else if (characters.size() == 8){
                                            Intent intent = new Intent(Vote.this, EightPlayers.class);
                                            intent.putExtra("characters", characters);
                                            intent.putExtra("success", success + 1);
                                            intent.putExtra("fail", fail);
                                            intent.putExtra("cap", cap_num + 1);
                                            startActivity(intent);
                                        }
                                    }
                                    else{
                                        Intent i = new Intent(Vote.this, GameOver.class);
                                        i.putExtra("test", characters);
                                        startActivity(i);
                                    }
                                }
                            });
                            builder.show();
                        }
                    }
                    else{
                        index += 1;
                        Intent i = new Intent(Vote.this, Vote.class);
                        i.putExtra("index", index);
                        i.putExtra("onMission", onMission);
                        i.putExtra("success", success);
                        i.putExtra("fail", fail);
                        i.putExtra("cap", cap_num);
                        i.putExtra("characters", characters);
                        i.putExtra("accept", accept);
                        i.putExtra("votes", votes);
                        startActivity(i);
                    }
                }
            }
        });
    }
}
