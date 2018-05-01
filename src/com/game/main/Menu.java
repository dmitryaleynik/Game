package com.game.main;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by HP on 01.05.2017.
 */
public class Menu extends MouseAdapter {
    private  Game game ;
     private  Handler handler;
    public Menu (Game game,Handler handler){
        this.handler=handler;
        this.game=game;
    }
    public void render(Graphics g){
        Font font =new Font("arial",1,50);
        Font font2 = new Font("arial", 1, 30);
        Font font3 =new Font ("arial",1,10);


        if (game.getGameState().equals(Game.STATE.Menu)) {

            g.setFont(font);
            g.setColor(Color.white);

            g.drawString("Menu", 240, 50);
            g.setFont(font2);
            g.drawRect(210, 70, 200, 64);
            g.drawRect(210, 170, 200, 64);
            g.drawRect(210, 270, 200, 64);
            g.drawRect(210, 370, 200, 64);


            g.setColor(Color.red);

            g.drawString("Single game", 220, 110);
            g.drawString("Multiplay ", 240, 210);
            g.drawString("Help", 270, 310);
            g.drawString("Quit", 270, 410);
        }
         else if (game.getGameState().equals(Game.STATE.Help)){
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("Help",260,70);

            g.drawRect(Game.WIDTH/2-100,Game.HEIGHT/2-50-90,200,100);
            g.setFont(font3);
            g.drawString("This game is created by Dmitry Aleinik",Game.WIDTH/2-100+5,Game.HEIGHT/2-50-90+15);
            g.drawString("All rights are reserved",Game.WIDTH/2-100+5,Game.HEIGHT/2-50-90+40);
            g.drawRect(210, 350, 200, 64);
            g.setFont(font2);
            g.drawString("Back", 270, 390);

        }
        else if (game.getGameState().equals(Game.STATE.GameOver)){
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("GameOver",200,70);
            g.setFont(font2);
            g.drawString("Your score:"+game.getHud().getScore(),210,180);

            g.drawRect(350,350,200,64);
            g.drawString("Try again",385,390);
            g.drawRect(80,350,200,64);
            g.drawString("Menu",150,390);
        }
    }
    public void tick(){

    }
    @Override
    public void mousePressed (MouseEvent e){

        int mx=e.getX();
        int my =e.getY();
        if (game.getGameState().equals(Game.STATE.Menu)) {
            if (mouseOver(mx, my, 210, 70, 200, 64)) {
                game.setGameState(Game.STATE.Game);

            }
            if (mouseOver(mx, my,210, 370, 200, 64)) {
                System.exit(1);
            }
            if (mouseOver(mx, my,210, 170, 200, 64)) {
               game.setGameState(Game.STATE.Multiplay);
            }
            if (mouseOver(mx, my,210, 270, 200, 64)) {
                game.setGameState(Game.STATE.Help);
            }
        }
        else if (game.getGameState().equals(Game.STATE.Help)){
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
               game.setGameState(Game.STATE.Menu);
            }
        }
        else if (game.getGameState().equals(Game.STATE.GameOver)){
            if (mouseOver(mx,my,210,350,200,64)){
                game.restart();
                game.setGameState(Game.STATE.Game);
            }
            if (mouseOver(mx,my,80,350,200,64)){
                game.restart();
                game.setGameState(Game.STATE.Menu);
            }
        }

    }
    private boolean mouseOver(int mx, int my,int x , int y , int width, int height ){

        if (mx>x && mx< x+width){
            if (my>y && my<y+height){
                return  true;
            }
        }
          return  false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
}
