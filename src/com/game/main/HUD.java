package com.game.main;

import java.awt.*;

/**
 * Created by HP on 24.04.2017.
 */
public class HUD {

    public static int HEALTH = 100;
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = Player.borders(HEALTH, 0, 100);
        greenValue = Player.borders(greenValue, 0, 255);
        score++;

    }


    public boolean alive (){
        if (HEALTH>0){
            return true;
        }
        else return  false;
    }
    public void restart(){
        HEALTH=100;
        level=1;
        score=0;
    }
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        g.drawString("Score:" + score, 10, 64);
        g.drawString("Level:" +  level ,10 ,84);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
