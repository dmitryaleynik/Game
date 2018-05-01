package com.game.main;

import sun.java2d.cmm.ColorTransform;

import java.awt.*;

/**
 * Created by HP on 24.04.2017.
 */
public class BasicEnemy extends  GameObject {
    private  Handler handler;
    public BasicEnemy(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        velX=5;
        velY=5;
        this.handler =handler;
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,20,20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,20,20);
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
        handler.addObject(new Trail((int)x,(int)y, ID.Trail,handler,Color.red,20,20,0.05F));
    }
}
