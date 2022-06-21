/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indyics4ugame;

import indyics4ugame.IndyICS4Ugame.STATE;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends GameObject {
    
    private IndyICS4Ugame indyICS4Ugame;
    Handler handler;
    

    
    public Player(int x, int y, int len, int wid, ID id, Handler handler,IndyICS4Ugame indyICS4Ugame) {
        super(x, y, len, wid, id);
        this.indyICS4Ugame = indyICS4Ugame;
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x,y,len,wid);
    }
        
   

    public void tick() {
        
        collision();
        if ((y + len) >= 600 & vely == 0 & extendLength >0) {//prevent out of bounds
            extendLength = 0;
        } else if (y <= 0 & vely < 0) {
            vely = 0;
            extendLength = 0;
        } else if (len <= 10 & extendLength < 0){//sets minimum player length
            vely = 0;
            extendLength = 0;
        }
        if ((x+wid) >= 800 & velx == 0 & extendWidth >0) {
            extendWidth = 0;
        } else if (x <= 0 & velx < 0) {
            extendWidth = 0;
            velx = 0;
        } else if (wid <= 10 & extendWidth < 0){//sets minimum player width
            velx = 0;
            extendWidth = 0;
        }
            

        x += velx;
        wid += extendWidth;
        y+= vely;
        len+= extendLength;
        
    }
    
    public void collision (){
        for (int i=0; i< handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.EnemyCircle || tempObject.getId() == ID.EnemyTriangle){
                if(tempObject.x + tempObject.wid >= this.x ){
                    if(tempObject.x <= this.x+this.wid){
                        if (tempObject.y + tempObject.len >= this.y){
                            if (tempObject.y <= this.y+this.len){
                                
                                indyICS4Ugame.gameState = STATE.End;   
                            }
                        }
                    }
                    
                    
                }
                //collision with enemy
            } else if (tempObject.getId() == ID.Goal){
                if (this.x >= tempObject.x && 
                        this.x + this.wid <= tempObject.x + tempObject.wid &&
                        this.y >= tempObject.y &&
                        this.y + this.len <= tempObject.y + tempObject.len){
                    indyICS4Ugame.gameState = STATE.Win;
                    
                }
            } else if (tempObject.getId() == ID.Wall){//collision with wall
                if (this.x + this.wid > tempObject.x){
                    if (this.x < tempObject.x){
                        if(this.y + this.len > tempObject.y){
                        if (this.y < tempObject.y+tempObject.len){
                            indyICS4Ugame.gameState = STATE.End;   
                        }
                    }
                    }
                    
                }
                if (this.x < tempObject.x + tempObject.wid){
                    if(this.x + this.wid > tempObject.x){
                        if (this.y + this.len > tempObject.y){
                        if (this.y < tempObject.y+tempObject.len){
                            indyICS4Ugame.gameState = STATE.End;   
                            
                        }
                    }
                    }
                }
                if (this.y + this.len > tempObject.y){
                    if (this.y < tempObject.y){
                        if(this.x + this.wid > tempObject.x){
                        if (this.x < tempObject.x+tempObject.wid){
                            indyICS4Ugame.gameState = STATE.End;   
                        }
                    }
                    }
                    
                }
                if (this.y < tempObject.y + tempObject.len){
                    if(this.y + this.len > tempObject.y){
                        if (this.x + this.wid > tempObject.x){
                        if (this.x < tempObject.x+tempObject.wid){
                            indyICS4Ugame.gameState = STATE.End;   
                            
                        }
                    }
                    }
                }
            }
    
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,wid,len);
    }
    

}
