package com.game.main;

import org.newdawn.slick.Music;
import org.newdawn.slick.state.GameState;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.HashMap;

/**
 * Created by HP on 01.05.2017.
 */
public class AudioPlayer {
    private HashMap <String,Clip> music;
    private Game game;
    boolean start =false;
     public AudioPlayer (Game game){
         this.game =game;
         music=new HashMap<>();
         addMelody("Z:\\song.wav","menu");
     }

    public void addMelody (String filepath, String state)  {
        try {
        AudioInputStream audioInputStream;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
            music.put(state,clip);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public  void playMelody(String state){
        try {

            if (start==false) {
                AudioInputStream audioInputStream;
                audioInputStream = AudioSystem.getAudioInputStream(new File("Z:\\song.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                    clip.start();
                start=true;
            }

            // music.put(state,clip);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }


    }

}



