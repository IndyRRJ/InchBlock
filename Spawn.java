
package indyics4ugame;

import java.util.Random;



public class Spawn {
    private Handler handler;
    private Random r = new Random();
    
    
    private int time = 0;
    
    public Spawn(Handler handler) {
        this.handler = handler;

    }
    
    public void tick() {
        if (time == 0){
            /*
            int safeX = 80; //first safe tile will be over player
            int safeY = 480; //first safe tile will be over player
            int safeLenWid = 60;//each safetile will be this size
            int direction; //value determines if safezone will path up or to the right.
            do {//spawn safezones
                handler.addObject(new SafeZone(safeX,safeY,safeLenWid,safeLenWid,ID.SafeZone,handler));
                direction = r.nextInt(2);
                //System.out.println(direction);
                if (direction == 0) {
                    safeX = safeX + 60;
                } else if (direction == 1){
                    safeY = safeY - 60;
                }
                if (safeX > 700) safeX = 700;
                if (safeY < 40) safeY = 40;
            } while (safeX != 700 || safeY != 40);
            
            handler.addObject(new SafeZone(700,40,safeLenWid,safeLenWid,ID.SafeZone,handler));//guarantees a safezone at the end
            */
            
            //handler.addObject(new SafeZone(80,480,60,400,ID.SafeZone,handler));
            //handler.addObject(new SafeZone(420,40,440,60,ID.SafeZone,handler));
            //handler.addObject(new SafeZone(480,40,60,280,ID.SafeZone,handler));
            
            
            int Num = r.nextInt(8) + 3;//to determine how many walls spawn
            for (int i = 0; i<Num;i++){//spawn Walls on left zone
                int X = r.nextInt(360);
                int Y = r.nextInt(420);
                int Len = r.nextInt((480-Y)/2)+40;
                int Wid = r.nextInt((420-X)/2)+40;
                handler.addObject(new Wall(X,Y,Len,Wid,ID.Wall,handler));
            }
            Num = r.nextInt(6) + 3;//to determine how many walls spawn
            for (int i = 0; i<Num;i++){//spawn Walls on right zone
                int X = r.nextInt(320)+480;
                int Y = r.nextInt(420)+100;
                int Len = r.nextInt(200)+40;
                int Wid = r.nextInt(200)+40;
                handler.addObject(new Wall(X,Y,Len,Wid,ID.Wall,handler));
            }
            
            Num = r.nextInt(7)+1;//determine how many enemies spawn
            for (int i = 0; i<Num;i++){ //spawn enemies on left zone
                int X = r.nextInt(320);
                int Y = r.nextInt(380);
                int enemyType = r.nextInt(2);
                //System.out.println(enemyType);
                if (enemyType == 0){
                    handler.addObject(new EnemyCircle(X,Y,25,25, ID.EnemyCircle, handler));
                } else if (enemyType == 1){
                    handler.addObject(new EnemyTriangle(X,Y,25,25, ID.EnemyTriangle, handler));
                }
                
            }
            for (int i = 0; i<Num;i++){ //spawn enemies on left zone
                int X = r.nextInt(320)+480;
                int Y = r.nextInt(380)+100;
                int enemyType = r.nextInt(2);
                //System.out.println(enemyType);
                if (enemyType == 0){
                    handler.addObject(new EnemyCircle(X,Y,25,25, ID.EnemyCircle, handler));
                } else if (enemyType == 1){
                    handler.addObject(new EnemyTriangle(X,Y,25,25, ID.EnemyTriangle, handler));
                }
                
            }
            
            
            /*while (i<=wallNum) {
                int wallX = r.nextInt(780);
                int wallY = r.nextInt(560);
                int wallLenWid = r.nextInt(160)+40;
                boolean canPlace = true;
                
                for (int j=0; j< handler.object.size(); j++){//spawn walls outside of safeZone
                    GameObject tempObject = handler.object.get(i);
                    if(tempObject.getId() == ID.SafeZone){
                        if(tempObject.x + tempObject.wid >= wallX ){
                            if(tempObject.x <= wallX + wallLenWid){
                                if (tempObject.y + tempObject.len >= wallY){
                                    if (tempObject.y <= wallY + wallLenWid){
                                        canPlace = false;
                                        System.out.println("Error");
                                        
                                    }
                                }
                             }
                    
                    
                        }
                    }   
                    
                }
                if (canPlace == true){
                    handler.addObject(new Wall(wallX,wallY,wallLenWid,wallLenWid,ID.Wall,handler));
                    i++;
                }
            }*/
            
            
            
            
            
            
            handler.addObject(new Goal(710,50,40,40, ID.Goal, handler));
            //handler.addObject(new Wall(300,300,100,60,ID.Wall,handler));
        }
        time++;
        //System.out.println(time);
    }
    
    public void time() {
        this.time = time;
    }
    public void resetTime(){
        this.time = 0;
    }
    public int getTime(){
        return time;
    }
    
    
    
}
