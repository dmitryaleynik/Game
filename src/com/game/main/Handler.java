package com.game.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by HP on 24.04.2017.
 */
public class Handler {
LinkedList <GameObject>  object =new LinkedList<>();
    private boolean start =false ;

    public void tick() {


        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();


        }
    }
    public void render(Graphics g){



            for (int i = 0; i < object.size(); i++) {
                GameObject tempObject = object.get(i);
                tempObject.render(g);
            }


    }
    public void addObject(GameObject object){
        this.object.add(object);

    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void clearEnemy (){

            for (int i=0 ;i <object.size();i++){

                    object.remove(object.get(i));

            }
    }
    public LinkedList<GameObject> getList() {
        return object;
    }
}
