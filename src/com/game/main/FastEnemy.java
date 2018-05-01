package com.game.main;

import java.awt.*;

/**
 * Created by HP on 24.04.2017.
 */
public class FastEnemy extends  GameObject {


    private Handler handler;
    public FastEnemy(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler =handler;
        velX=3;
        velY=7;

    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        if (y<=0|| y>Game.HEIGHT-60){
            velY*=-1;
        }
        if (x<=0|| x>Game.WIDTH-40){
            velX*=-1;
        }
       handler.addObject(new Trail(x,y, ID.Trail,handler,Color.green,10,10,0.1F));

    }

    @Override
    public void render(Graphics g) {


        g.setColor(Color.green);
        g.fillRect((int)x,(int)y,10,10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,10,10);
    }
}
