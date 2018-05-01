package com.game.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;


/**
 * Created by HP on 30.04.2017.
 */
public class Boss1 extends  GameObject {
    private  Handler handler;
    boolean fl =true;
    private Timer timer1;
    private Timer timer2;

    public void explosion (){
        handler.removeObject(this);
    }
    public Boss1(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        velX=0;
        velY=2;

        this.handler =handler;



         timer1 =new Timer(1400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                fl=false;
                velY=0;
                velX=4;

            }
        });
        timer1.start();
        System.out.println(Game.WIDTH);
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,100,100);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,100,100);
    }

    @Override
    public void tick() {

        if (fl==false){
            timer1.stop();
        }
        x+=velX;
        y+=velY;

        if (x<=20){
            velX*=-1;
        }
        if (x>=530){
            velX*=-1;
        }


    }
}
