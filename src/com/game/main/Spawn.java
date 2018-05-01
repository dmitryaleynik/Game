package com.game.main;

import java.util.Random;

/**
 * Created by HP on 24.04.2017.
 */
public class Spawn {
    private Handler handler;
    private  HUD hud;
    private boolean start =false;
    private Random r =new Random();
    private int scoreKeeper=0;
    public Spawn (Handler handler,HUD hud){
        this.handler = handler ;
        this.hud=hud;

    }
    public void tick(){


        scoreKeeper++;
        if (scoreKeeper>=500){
            scoreKeeper=0;
            hud.setLevel(hud.getLevel()+1);
            if (hud.getLevel()==2){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Enemy,handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Enemy,handler));
            }
            else if (hud.getLevel()==3){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy,handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Enemy,handler));
            }
            else  if (hud.getLevel()==4){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.SmartEnemy,handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Enemy,handler));

            }

        }




    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}
