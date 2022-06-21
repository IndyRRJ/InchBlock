
package indyics4ugame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Goal extends GameObject {
       
    private Handler handler;
    
    int ticknum = 0;
    public Goal(int x, int y, int len, int wid, ID id, Handler handler) {
        super(x, y, len, wid, id);
        this.handler = handler;
        
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,len,wid);
    }

    public void tick() { 

    }

    

    public void collision (){


    }

    public void render(Graphics g) {
        
        
        
        g.setColor(Color.GREEN);
        g.fillRect(x,y,wid,len);
        
        
    }
    
}
