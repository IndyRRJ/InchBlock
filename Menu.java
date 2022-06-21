
package indyics4ugame;

import indyics4ugame.IndyICS4Ugame.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author thene
 */
public class Menu extends MouseAdapter {
    
    private IndyICS4Ugame indyICS4Ugame;
    private Handler handler;
    private Spawn spawn;
    
    int scorint;
    
    public Menu(IndyICS4Ugame indyICS4Ugame, Handler handler, Spawn spawn){
        this.indyICS4Ugame = indyICS4Ugame;
        this.handler = handler;
        this.spawn = spawn;
    }
    
    public void mousePressed(MouseEvent e){
        
        int mx = e.getX();
        int my = e.getY();
        
        
        if (mouseOver(mx,my,80,500,200,60)){//play button here
            if (indyICS4Ugame.gameState == STATE.Menu ){
                
                indyICS4Ugame.gameState = STATE.Game;
                
                handler.addObject(new Player(100,500,20,20, ID.Player, handler,indyICS4Ugame)); 
                
                spawn.resetTime();
                
                
            } else if (indyICS4Ugame.gameState == STATE.End || indyICS4Ugame.gameState == STATE.Win){
                indyICS4Ugame.gameState = STATE.Menu;

            }
            
        }
        if (mouseOver(mx,my,520, 500, 200, 60)){ // quit button
            if (indyICS4Ugame.gameState == STATE.Menu|| indyICS4Ugame.gameState == STATE.End || indyICS4Ugame.gameState == STATE.Win){
            System.exit(0 );
            } 
        }
        if (mouseOver(mx,my,300, 500, 200, 60)) { // instructions button
            if (indyICS4Ugame.gameState == STATE.Menu ){
                indyICS4Ugame.gameState = STATE.Instructions;
            } else if (indyICS4Ugame.gameState == STATE.Instructions){
                indyICS4Ugame.gameState = STATE.Menu;
                
            }
        }
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public boolean mouseOver(int mx, int my, int x, int y, int width, int height){ //is mouse hovering over a button?
        if (mx > x && mx < x + width){
            if (my>y && my <y+height){
                return true;
            } else return false;
        } else return false;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        if (indyICS4Ugame.gameState == STATE.Menu) {
            Font fnt = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.BLACK);
            g.drawRect(80, 500, 200, 60);
            g.drawRect(300, 500, 200, 60);
            g.drawRect(520, 500, 200, 60);
            g.drawString("InchBlock", 330, 100);
            g.drawString("Play", 125, 540);
            g.drawString("Instructions", 310, 540);
            g.drawString("Quit", 545, 540);
            g.setColor(Color.BLUE);
            g.fillRect(300, 200, 100, 150);
            g.setColor(Color.BLACK);
            g.fillOval(310, 220, 10, 10);
            g.fillOval(380, 220, 10, 10);
            g.drawArc(320, 250, 60, 10, 180, 180);
        } else if (indyICS4Ugame.gameState == STATE.Instructions){
            Font fnt = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.BLACK);
            g.drawRect(300, 500, 200, 60);
            g.drawString("Got it!", 310, 540);
            fnt = new Font("arial", 1, 20);
            g.setFont(fnt);
            
            g.drawString("Instructions:", 100, 100);//list the instructions
            fnt = new Font("arial", 1, 15);
            g.setFont(fnt);
            g.drawString("Objective: Reach the goal as fast as possible without getting hit by enemies.", 100, 140);
            g.drawString("The goal is for the player to be entirely within the green box.",100,160);
            g.drawString("Controls:", 100, 200);
            g.drawString("Shift: toggles whether the player can grow or shrink.", 120, 220);
            g.drawString("WASD: Player grows or shrinks in that direction.", 120, 240);
            g.drawString("Arrow keys: shoot a bullet in direction of arrow. Bullet size depends on size of player.", 120, 260);
            g.drawString("Scoring: Reaching the goal faster gives a lower score, and the lower the score, the better.",100, 300);
            g.drawString("Enemies:",100, 340);
            g.drawString("Red Circle: Moves randomly. Killed by 1 hit from a bullet.",120, 360);
            g.drawString("Red Triangle: Moves towards the player. Killed by 1 hit from a bullet.",120, 380);
            g.drawString("Red Wall: Doesn't move, but kills you if you touch it.",120, 400);
            g.drawString("Bullets get stopped by the wall, but enemies do not.",140, 420);
            g.drawString("The game is very tricky at first, so try your best!",100, 460);
            g.drawString("It will likely take you over a dozen tries to succeed for the first time.",100, 480);
        } else if (indyICS4Ugame.gameState == STATE.End) {//player has lost
            for (int i=0; i< handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);//clear all game objects

                        handler.removeObject(tempObject); 
                    }
            Font fnt = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.BLACK);
            g.drawRect(80, 500, 200, 60);
            g.drawRect(520, 500, 200, 60);
            g.drawString("Menu", 125, 540);
            g.drawString("Quit", 545, 540);
            g.drawString("You Lost!", 100, 100);
            
        } else if (indyICS4Ugame.gameState == STATE.Win) {// player has won
            for (int i=0; i< handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);//clear all game Objects
                        handler.removeObject(tempObject); 
                    }
            Font fnt = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.BLACK);
            g.drawRect(80, 500, 200, 60);
            g.drawRect(520, 500, 200, 60);
            g.drawString("Menu", 125, 540);
            g.drawString("Quit", 545, 540);
            g.drawString("You Won! Your score was: " + spawn.getTime(), 100, 100);


            //String score = Integer.toString(spawn.getTime());

            
            //g.drawString(score.toString(), 100, 200);
        }
    }
    



}
