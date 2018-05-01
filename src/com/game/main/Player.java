package com.game.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by HP on 24.04.2017.
 */
public class Player extends  GameObject {
    Random r =new Random();
    Handler handler ;

    public Player(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;

    }

    @Override
    public void tick() {
            x += velX;
            y += velY;
        x=borders((int)x,0,Game.WIDTH-38);
        y=borders((int)y,0,Game.HEIGHT-67);
        colision();


        handler.addObject(new Trail(x,y, ID.Trail,handler,Color.white,32,32,0.1F));


    }
    public void colision(){


        for (int i=0;i<handler.object.size();i++){
            GameObject temp =handler.object.get(i);

           if (temp.getId()==ID.Enemy || temp.getId()== ID.FastEnemy || temp.getId()== ID.SmartEnemy || temp.getId()==ID.Boss1) {
               if ( this.getBounds().intersects(temp.getBounds())) {
                   HUD.HEALTH -= 2;
               }
           }
        }


    }
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
    public static int borders(int var, int min,int max){
        if (var>=max){
            return  max;
        }
        else if (var<=min){
            return  min;
        }
        return var;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);
    }
}
