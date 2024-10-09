import java.awt.Font;

/**
 * Write a description of class Graphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Graphics
{
    // instance variables - replace the example below with your own
    private static int WIN_WIDTH;
    private static int WIN_HEIGHT;

    public Graphics()
    {
        WIN_WIDTH = 20;
        WIN_HEIGHT = 80;
    }
    
    public void cold(){
        StdDraw.picture(50,  25, "images/roomr.jpg");
        StdDraw.picture(50,  52, "images/ACbg.png");
        StdDraw.picture(55,  22, "images/coldbgr.png");
    }
    
    public void hot(){
        StdDraw.picture(50,  25, "images/roomr.jpg");
        StdDraw.picture(50,  52, "images/ACbg.png");
        StdDraw.picture(55,  22, "images/meltbgr.png");
    }
    
    public void image(){
        if (Environment.getInstance().getOutTemp()>Environment.getInstance().getDesTemp()+1){
            hot();
        }else{
            cold();
        }
    }
    
    public void temp(){
        //String OT = Double.toString(Environment.getInstance().getOutTemp());
        //String DT = Double.toString(Environment.getInstance().getDesTemp());
        String OTT = String.format("%.3f",Environment.getInstance().getOutTemp());
        String DTT= String.format("%.3f",Environment.getInstance().getDesTemp());
        Font font = new Font("Arial", Font.BOLD, 10);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(80, 85, "Current Temperature: "+ OTT);
        StdDraw.text(80, 80, "Desire Temperature: "+ DTT);
    }
    
    
    public void start(){
        StdDraw.setCanvasSize();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.picture(20,  80, "images/sunr.jpg");
        StdDraw.picture(50,  25, "images/roomr.jpg");
        hot();
    }
    
}
