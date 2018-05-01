package com.game.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by HP on 01.05.2017.
 */
public class MenuBackground extends  GameObject {
    private Handler handler;
    Random r = new Random();
    private int red=r.nextInt(255);
    private int green=r.nextInt(255);
    private int blue=r.nextInt(255);

    private  Color color;
    public MenuBackground(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler =handler;
        velX=3;
        velY=7;
        color=new Color( red,green,blue);
       velX =(r.nextInt(14)-7);
        velY=(r.nextInt(14) -7);


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
       // handler.addObject(new Trail(x,y, ID.Trail,handler, color,20,20,0.03F));

    }

    @Override
    public void render(Graphics g) {


        g.setColor(color);
        g.fillRect((int)x,(int)y,20,20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,20,20);
    }
}
