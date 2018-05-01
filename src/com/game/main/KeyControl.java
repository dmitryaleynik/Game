package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by HP on 24.04.2017.
 */
public class KeyControl extends KeyAdapter {
    private Handler handler ;
    boolean [] keyControl =new boolean[4];
     public KeyControl(Handler handler){
         this.handler =handler;
         for (int i=0;i<keyControl.length;i++){
             keyControl[i]=false;
         }

     }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int key =e.getKeyCode();
        for (int i=0;i<handler.object.size();i++){
            GameObject temp= handler.object.get(i);

            if (temp.getId()==ID.Player1){


                if (key==KeyEvent.VK_W) {
                    temp.setVelY(-5);
                    keyControl[0]=true;
                }
                if (key==KeyEvent.VK_A) {
                    keyControl[1]=true;
                    temp.setVelX(-5);
                }
                if (key==KeyEvent.VK_S) {
                    keyControl[2]=true;
                    temp.setVelY(5);
                }
                if (key==KeyEvent.VK_D) {
                    keyControl[3]=true;
                    temp.setVelX(5);
                }

            }


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        super.keyReleased(e);
        int key=e.getKeyCode();
        for (int i=0;i<handler.object.size();i++){
            GameObject temp= handler.object.get(i);

            if (temp.getId()==ID.Player1){


                if (key==KeyEvent.VK_W) {

                    keyControl[0]=false;
                }
                if (key==KeyEvent.VK_A) {
                    keyControl[1]=false;


                }
                if (key==KeyEvent.VK_S) {
                    keyControl[2]=false;

                }
                if (key==KeyEvent.VK_D) {
                    keyControl[3]=false;

                }
                if (!keyControl[0] && !keyControl[2]){
                    temp.setVelY(0);
                }
                if (!keyControl[1] && !keyControl[3]){
                    temp.setVelX(0);
                }

            }




        }

    }
}
