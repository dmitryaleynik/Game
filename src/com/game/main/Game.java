package com.game.main;

import org.newdawn.slick.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Random;

/**
 * Created by HP on 24.04.2017.
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Handler menuHandler;
    private Random r;
    private HUD hud;
    private Spawn spawner;
    AudioPlayer audioPlayer = new AudioPlayer(this);

    private Menu menu;

    public enum STATE {
        Menu, Game, Help, GameOver, Multiplay;
    }

    ;

    private STATE gameState = STATE.Menu;

    public Game() throws Exception {

        handler = new Handler();
        menuHandler = new Handler();
        new Window(WIDTH, HEIGHT, "Game", this);
        hud = new HUD();
        spawner = new Spawn(handler, hud);
        r = new Random();
        menu = new Menu(this, handler);

        if (gameState.equals(STATE.Menu)) {
            for (int i = 0; i < 10; i++) {
                menuHandler.addObject(new MenuBackground(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, menuHandler));
            }
        }
        handler.addObject(new Player(Game.WIDTH / 2 - 30, Game.HEIGHT / 2 - 30, ID.Player1, handler));
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH) - 20, r.nextInt(Game.HEIGHT) - 20, ID.Enemy, handler));


        addMouseListener(menu);
        this.addKeyListener(new KeyControl(handler));

    }

    public STATE getGameState() {
        return gameState;
    }

    public void setGameState(STATE gameState) {
        this.gameState = gameState;
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }

        }

    }

    public HUD getHud() {
        return hud;
    }

    public void setHud(HUD hud) {
        this.hud = hud;
    }

    private void tick() {


        if (!hud.alive()) {
            gameState = STATE.GameOver;
        }

        if (gameState.equals(STATE.Game)) {

            spawner.tick();
            handler.tick();
            hud.tick();

        } else if (gameState.equals(STATE.Menu) || gameState.equals(STATE.Help)) {
            menuHandler.tick();
            menu.tick();
            audioPlayer.playMelody("menu");
        } else if (gameState.equals(STATE.GameOver)) {
            menu.tick();
        }


    }

    private void render() {


        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (gameState.equals(STATE.Game)) {
            handler.render(g);
            hud.render(g);
        } else if (gameState.equals(STATE.Menu) || gameState.equals(STATE.Help)) {

            menu.render(g);
            menuHandler.render(g);

        } else if (gameState.equals(STATE.GameOver)) {


            menu.render(g);
        }

        g.dispose();
        bs.show();

    }


    public void restart() {
        handler.getList().clear();
        handler.addObject(new Player(Game.WIDTH / 2 - 30, Game.HEIGHT / 2 - 30, ID.Player1, handler));
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH) - 20, r.nextInt(Game.HEIGHT) - 20, ID.Enemy, handler));
        hud.restart();
        spawner.setStart(false);

    }

    public static void main(String[] args) throws Exception {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;

        } catch (Exception i) {
            i.printStackTrace();
        }
    }

    public Handler getHandler() {
        return handler;
    }
}
