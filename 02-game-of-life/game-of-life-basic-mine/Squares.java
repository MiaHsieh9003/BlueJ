
/**
 * Write a description of class Squares here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Squares
{
    // instance variables - replace the example below with your own
    private double xPosition;
    private double yPosition;
    private boolean color;
    private int neighBlack;
    private int nextNighBlack;
    
    public boolean WHITE = false;
    public boolean BLACK = true;

    /**
     * Constructor for objects of class Squares
     */
    public Squares(double x, double y, boolean c)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.color = c;
        this.neighBlack = 0;
        this.nextNighBlack = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getxPosition()
    {
        return xPosition;
    }
    public double getYPosition()
    {
        return yPosition;
    }
    public boolean blackOrNot()
    {
        return color;
    }
    // get neighbor number value
    public int getNei(){
        return neighBlack;
    }
    public int getNextNei(){
        return nextNighBlack;
    }
    // set neighbor number value
    public void setNei(int n){
        this.neighBlack = n;
    }
    public void setNextNei(int n){
        this.nextNighBlack = n;
    }
    
    
    /* public void nextNeighborAdd(){
        this.nextNighBlack ++;
    }
    public void nextNeighborSub(){
        this.nextNighBlack --;
    } */
    
    //neighbor change
    public void neighborAdd(String s){
        if(s == "NEXT"){    //change next nei
            this.nextNighBlack ++;
        }else if(s == "PRESENT"){   //change present nei
            this.neighBlack ++;            
        }
    }
    public void neighborSub(String s){
        if(s == "NEXT"){    //change next nei
            this.nextNighBlack --;
        }else if(s == "PRESENT"){   //change present nei
            this.neighBlack --;            
        }
    }  
    
    //square color change
    public void drawChange(){
        if(blackOrNot() == WHITE){
            this.color = BLACK;
            drawBlack();            
        }else if(blackOrNot() == BLACK){
            this.color = WHITE;
            drawWhite();
        }        
    }
    
    public void drawWhite(){
        StdDraw.filledSquareWhite(this.xPosition, this.yPosition, 0.5);
        this.color = WHITE;
    }
    public void drawBlack(){
        StdDraw.filledSquare(this.xPosition, this.yPosition, 0.5);
        this.color = BLACK;
    }
    
}
