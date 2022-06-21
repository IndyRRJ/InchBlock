
package indyics4ugame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
    
    private Handler handler;

    
    public KeyInput(Handler handler){
        this.handler = handler;

    }
    
    boolean extension = true; // controls whether player is growing or shrinking
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        //System.out.println(key);
        
        for(int i=0; i<handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId()==ID.Player){
                
                //System.out.println(tempObject.len);
                //System.out.println(tempObject.wid);

                //System.out.println(tempObject.y);
                //System.out.println(tempObject.extendLength);

                //Player key Events (controls)
                //Screen must be clicked before controls work, for some reason
                
                if (key == KeyEvent.VK_SHIFT /*& key == KeyEvent.VK_W*/) {
                    if (extension) {
                        extension = false;
                    } else {
                        extension = true;
                    }
                    
                }
                if (key == KeyEvent.VK_W) {
                    //do {
                    if (extension){
                        tempObject.setVely(-2);
                        tempObject.setextendLength(2);
                    } else {
                        tempObject.setVely(0);
                        tempObject.setextendLength(-2);
                    }
                }                  
                if (key == KeyEvent.VK_S) {
                    if (extension){
                        tempObject.setextendLength(2);
                    } else {
                        tempObject.setVely(2);
                        tempObject.setextendLength(-2);
                    }


                }
                if (key == KeyEvent.VK_A) {
                    if (extension){
                        tempObject.setVelx(-2);
                        tempObject.setextendWidth(2);
                    } else {
                        tempObject.setVelx(0);
                        tempObject.setextendWidth(-2);
                    }

                }
                if (key == KeyEvent.VK_D) {
                    if (extension){
                        tempObject.setextendWidth(2);
                    } else {
                        tempObject.setVelx(2);
                        tempObject.setextendWidth(-2);
                    }

                
                }
                if (key==KeyEvent.VK_UP){
                    handler.addObject(new Bullet(tempObject.x + ((tempObject.wid/2)-tempObject.wid/20),
                            tempObject.y ,tempObject.len/10,tempObject.wid/10, ID.Bullet, handler, 0));
                } else if (key==KeyEvent.VK_DOWN){
                    handler.addObject(new Bullet(tempObject.x + ((tempObject.wid/2)-tempObject.wid/20),
                            tempObject.y + tempObject.len ,tempObject.len/10,tempObject.wid/10, ID.Bullet, handler, 1));
                } else if (key==KeyEvent.VK_LEFT){
                    handler.addObject(new Bullet(tempObject.x,
                            tempObject.y + ((tempObject.len/2)-tempObject.len/20) ,tempObject.len/10,tempObject.wid/10, ID.Bullet, handler, 2));
                } else if (key==KeyEvent.VK_RIGHT){
                    handler.addObject(new Bullet(tempObject.x + tempObject.wid,
                            tempObject.y + ((tempObject.len/2)-tempObject.len/20) ,tempObject.len/10,tempObject.wid/10, ID.Bullet, handler, 3));
                }//Bullet Controls, 0 = Up, 1 = Down, 2 = Left, 3 = Right.
                
            }
            
        }
        
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i=0; i<handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId()==ID.Player){
                //Player key Events (controls)
                //Screen must be clicked before controls work, for some reason
                if (key == KeyEvent.VK_W){
                    tempObject.setVely(0);
                    tempObject.setextendLength(0);

                }                  
                if (key == KeyEvent.VK_S){
                    tempObject.setVely(0);
                    tempObject.setextendLength(0);

                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelx(0);
                    tempObject.setextendWidth(0);

                }
                if (key == KeyEvent.VK_D){
                    tempObject.setVelx(0);
                    tempObject.setextendWidth(0);
 
                }
                

                
            }
            
        }
        
    }
}
