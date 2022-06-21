/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indyics4ugame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;



public class IndyICS4Ugame extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 23132341 ;
    
    
    private Thread thread1; 
    private boolean running = false;
    
    private Handler handler;
    private Random r;
    private Spawn spawn;
    private Menu menu;
    
    public enum STATE {
         Menu,
         Instructions,
         Game,
         End,
         Win;
    }
    
    public STATE gameState = STATE.Menu;
            
    public IndyICS4Ugame(){ //creates window
        handler = new Handler();
        spawn = new Spawn(handler);
        menu = new Menu(this,handler,spawn);
    
        this.addMouseListener(menu);
        
        
        this.addKeyListener(new KeyInput(handler));
                
        new Window(800,630,"InchBlock",this);
        
        
        
        r = new Random();
        
        if(gameState == STATE.Game){
            
        }
    }

    public synchronized void start(){
        thread1 = new Thread(this);
        thread1.start();
        running = true;
    }
    
    
    public synchronized void stop(){
        try{
            thread1.join();
            running = false;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer >1000){
                timer+= 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }
     
    private void tick() {
        if (gameState == STATE.Game) {
        handler.tick();
        spawn.tick();
        //menu.resetScore();
        } else if (gameState == STATE.Menu||gameState == STATE.Instructions||
                gameState == STATE.End || gameState == STATE.Win){
            menu.tick();
            
            
        }
    }
    

    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 800, 601);
        
        handler.render(g);

        if (gameState == STATE.Game) {
            
        } else if (gameState == STATE.Menu || gameState == STATE.Instructions || 
                gameState == STATE.End || gameState == STATE.Win){
            menu.render(g);//renders the menu
            
        }
        
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {
        new IndyICS4Ugame();
    }
    
}
