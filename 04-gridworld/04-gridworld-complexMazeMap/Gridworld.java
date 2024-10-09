import java.util.concurrent.TimeUnit;

/**
 * Write a description of class Environment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gridworld
{
    private int x;
    private int y;
    //goldXY
    private int gx, gy;
    
    public Gridworld(){
       x = Agent.getInstance().locX();
       y = Agent.getInstance().locY();
       gx = Agent.getInstance().goldX();
       gy = Agent.getInstance().goldY();
    }
    
    // your grid (2d array with your map) goes here.
    public void map(){
        int row =0;
        int col =0;
        int [][] grid = Agent.getInstance().getGrid(); 
        for (int number [] : grid) {
            for (int num: number){
                if (num == 1){
                    StdDraw.setPenRadius(0.0035);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(row+2,col+4,0.5);
                }
                else if (num ==0){
                    StdDraw.setPenRadius(0.0005);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(row+2,col+4,0.5);
                }
                row++;
            }
            row = 0;
            col++;
        }
        StdDraw.show();
    }
    
    public void objMov(){
        x = Agent.getInstance().locX();
        y = Agent.getInstance().locY();        
        StdDraw.picture(x+2, y+4, "images/jakebgr.png");    //our location
        StdDraw.picture(gx+2, gy+4, "images/finhar.png");   //***the target pic
        StdDraw.show();
        //System.out.println(x +" "+ y);
    }
    
    

    // code for your Gridworld
    public void start(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize();
        //**change bigger scale
        StdDraw.setXscale(0,34);
        StdDraw.setYscale(0,34);
        while (true){
            map();
            objMov();
            try{                
                TimeUnit.MILLISECONDS.sleep(200);                
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
            
            Agent.getInstance().sense();
            if(Agent.getInstance().decide()){                
                break;
            }
            Agent.getInstance().act();
        }
    }
        
    
    // Add methods that the agent will use.
    
    
    
}
