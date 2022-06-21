
package indyics4ugame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bullet extends GameObject {
       
    private Handler handler;
    
    int ticknum = 0;
    int direction;
    
    public Bullet(int x, int y, int len, int wid, ID id, Handler handler, int direction) {
        super(x, y, len, wid, id);
        this.handler = handler;
        this.direction = direction;
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,len,wid);
    }

    public void tick() { 
        if (direction == 0){
            y = y-3;
        } else if (direction == 1){
            y = y+3;
        } else if (direction == 2){
            x = x-3;           
        } else if (direction == 3){
            x = x+3;
        }
        collision();
    }


    public void collision (){
        for (int i=0; i< handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.EnemyCircle || tempObject.getId() == ID.EnemyTriangle){//collision with enemy
                if(tempObject.x + tempObject.wid >= this.x ){
                    if(tempObject.x <= this.x+this.wid){
                        if (tempObject.y + tempObject.len >= this.y){
                            if (tempObject.y <= this.y+this.len){
                                handler.removeObject(tempObject);
                                handler.removeObject(this);
                            }
                        }
                    }
                    
                    
                }
            } else if (tempObject.getId() == ID.Wall){//collision with wall
                if (this.x + this.wid >= tempObject.x){
                    if (this.x <= tempObject.x){
                        if(this.y + this.len > tempObject.y){
                        if (this.y < tempObject.y+tempObject.len){
                            handler.removeObject(this);

                        }
                    }
                    }
                    
                }
                if (this.x <= tempObject.x + tempObject.wid){
                    if(this.x + this.wid >= tempObject.x){
                        if (this.y + this.len > tempObject.y){
                        if (this.y < tempObject.y+tempObject.len){
                            handler.removeObject(this);

                            
                        }
                    }
                    }
                }
                if (this.y + this.len >= tempObject.y){
                    if (this.y <= tempObject.y){
                        if(this.x + this.wid > tempObject.x){
                        if (this.x < tempObject.x+tempObject.wid){
                            handler.removeObject(this);

                        }
                    }
                    }
                    
                }
                if (this.y <= tempObject.y + tempObject.len){
                    if(this.y + this.len >= tempObject.y){
                        if (this.x + this.wid > tempObject.x){
                        if (this.x < tempObject.x+tempObject.wid){
                            handler.removeObject(this);
                            
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
