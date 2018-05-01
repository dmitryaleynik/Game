package com.game.main;

import java.awt.*;

/**
 * Created by HP on 24.04.2017.
 */
public class Trail extends  GameObject {
    private float alpha =1;
    private Handler handler;
    private Color color;
    private int width, height;
    float life ;
    public Trail(float x, float y, ID id,Handler handler,Color color,int width,int height,float life) {
        super(x, y, id);
        this.handler=handler;
        this.color=color;
        this.height =height;
        this.width =width;
        this.life =life;

    }
    private AlphaComposite makeTransparent(float alpha){

        int type =AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d= (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x,(int)y,width,height);
        g2d.setComposite(makeTransparent(1));
    }

    @Override
    public void tick() {

        if (alpha >life){
            alpha -= life;
        }else{
            handler.removeObject(this );

        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
