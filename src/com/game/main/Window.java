package com.game.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by HP on 24.04.2017.
 */
public class Window  {

    public Window(int width,int height,String title,Game game){
        JFrame frame =new JFrame(title);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));

        frame.setMinimumSize(new Dimension(width,height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setFocusable(true);
//        frame.addKeyListener(new KeyControl(game.getHandler()));

        game.start();

    }
}
