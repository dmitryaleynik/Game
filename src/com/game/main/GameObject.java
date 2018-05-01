package com.game.main;

import java.awt.*;

/**
 * Created by HP on 24.04.2017.
 */
public abstract class GameObject  implements  Observer   {
    protected float x , y;
    protected  ID id;
    protected double  velX,velY;

    public void update (Graphics graphics) {
        tick();
        render(graphics);

    }



    public GameObject(float x , float y, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }
    public abstract  void tick();
    public abstract  void render(Graphics g);

    public void setY(int y) {
        this.y = y;

    }
    public abstract  Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}


