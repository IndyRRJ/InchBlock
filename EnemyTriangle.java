
package indyics4ugame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class EnemyTriangle extends GameObject {
       
    private Handler handler;
    
    int ticknum = 0;
    
    public EnemyTriangle(int x, int y, int len, int wid, ID id, Handler handler) {
        super(x, y, len, wid, id);
        this.handler = handler;

    }


    
    public Rectangle getBounds() {
        return new Rectangle(x,y,len,wid);
    }

    public void tick() { 
        for (int i=0; i< handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if (ticknum >= 3){
                if(tempObject.getId() == ID.Player){ //move towards player
                
                    if ((x+wid/2) <= (tempObject.x+tempObject.wid/2)) {
                        x++;
                    } else if ((x+wid/2) >= (tempObject.x+tempObject.wid/2)) {
                        x--;
                    }
                    if ((y+len/2) <= (tempObject.y+tempObject.len/2)) {
                        y++;
                    } else if ((y+len/2) >= (tempObject.y+tempObject.len/2)) {
                        y--;
                    }                
                
                    
                }
                ticknum = 0;
            }
    
        }
        ticknum++;
    }
    
    public void collision() {
    }

    public void render(Graphics g) {
        
        int x1 = x;
        int x2 = x1 + wid/2;
        int x3 = x1 + wid;
        int xp[] = {x1,x2,x3,x1};

        int y1 = y; 
        int y2 = y + len;
        int y3 = y;
        int yp[] = {y1,y2,y3,y1};
        
        //System.out.println(x1);
        //System.out.println(x2);
        //System.out.println(x3);
        //System.out.println(xp[1]);
        //System.out.println(yp[1]);
        
        g.setColor(Color.RED);
        g.fillPolygon(xp, yp, 4); 
       // g.fill
        //g.drawRect(x1, y1, len, wid); 
            
        
        
    }



    
}
