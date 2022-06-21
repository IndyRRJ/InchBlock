/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indyics4ugame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author thene
 */
public abstract class GameObject {
    
    protected int x, y;
    protected ID id;
    protected int velx, vely;
    protected int len, wid;
    protected int extendLength, extendWidth;


    public GameObject(int x, int y, int len, int wid, ID id){
        this.x = x;
        this.y = y;
        this.len =len;
        this.wid = wid;
        this.id = id;
    }
    public abstract void tick();
    public abstract void collision();
    public abstract void render(Graphics g);
    
    public abstract Rectangle getBounds(); //for collision detection
    
    public void setX(int x){
        this.x = x;//made after player class
    }
    public void setY(int y) {
        this.y = y; // note: made after player class
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId(){
        return id;        
    }
    public void setVelx(int velx){
        this.velx = velx;
    }
    public int getVelx(){
        return velx;
    }
    public void setVely(int vely){
        this.vely = vely;
    }
    public int getVely(){
        return vely;
    }
    public void setLen(int len){
        this.len = len;
    }
    public int getLen(){
        return len;
    }
    public void setWid(int wid){
        this.wid = wid;
    }
    public int getwid(){
        return wid;
    }
    public void setextendLength(int extendLength){
        this.extendLength = extendLength;
    }
    public void setextendWidth(int extendWidth) {
        this.extendWidth = extendWidth; 
    }
    public int getextendLength() {
        return extendLength;
    }
    public int getextendWidth() {
        return extendWidth;
    }
}
