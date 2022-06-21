
package indyics4ugame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyCircle extends GameObject {
       
    private Handler handler;
    
    int ticknum = 0;
    public EnemyCircle(int x, int y, int len, int wid, ID id, Handler handler) {
        super(x, y, len, wid, id);
        this.handler = handler;
        
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,len,wid);
    }

    public void tick() { 
        Random ran = new Random();
        if (ticknum >= 50) {
            velx = ran.nextInt(5) - 2;
            //System.out.println(velx);
            vely = ran.nextInt(5) - 2;
            ticknum = 0;
        }
        if (x >= 800-wid) {//prevent out of bounds enemies
            velx = -2;
        } else if (x <= 0) {
            velx = 2;
        }
        if (y>= 570-len) {
            vely = -2;
        } else if (y <= 0){
            vely = 2;
        }
        x += velx;
        y += vely;
        ticknum ++;
        collision();
    }

    

    public void collision (){


    }

    public void render(Graphics g) {
        
        
        
        g.setColor(Color.red);
        g.fillOval(x,y,wid,len);
        
        
    }
    
}
