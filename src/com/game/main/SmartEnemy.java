package com.game.main;

import java.awt.*;

/**
 * Created by HP on 24.04.2017.
 */
public class SmartEnemy extends  GameObject {

    private Player player;
    private  Handler handler;
    public SmartEnemy(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (GameObject i : handler.getList()) {
            if (i.getId() == ID.Player1) {
                player = (Player) i;
            }
        }
    }
    @Override
    public void render(Graphics g) {

        g.setColor(Color.pink);
        g.fillRect((int)x,(int)y,20,20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,20,20);
    }

    @Override
    public void tick() {
        float xPlayer= player.getX();
        float yPlayer =player.getY();

        double dist = Math.sqrt((xPlayer-x)*(xPlayer-x)+(yPlayer-y)*(yPlayer-y));
        velX=1.5*(xPlayer-x)/dist;
        velY=1.5*(yPlayer- y)/dist;

        x+=velX;
        y+=velY;
        if (y<=0|| y>Game.HEIGHT-60){
            velY*=-1;
        }
        if (x<=0|| x>Game.WIDTH-40){
            velX*=-1;
        }
        handler.addObject(new Trail((int)x,(int)y, ID.Trail,handler,Color.pink,20,20,0.02F));
    }
}
