import java.util.Scanner;

/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main (String[]args) {
        // create and initialize objects with data
        // ask for outside temp and pass it to Singleton Enviroment
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Outside temp:");
        int t = Integer.parseInt(myObj.nextLine()); 
        Environment.getInstance().setOutTemp(t);       
        
        //ask for desired temp and pass it to Singleton Enviroment
        Scanner myTemp = new Scanner(System.in);
        System.out.println("Enter Desired temp:");
        int d = Integer.parseInt(myObj.nextLine());  
        Environment.getInstance().setDesTemp(d);
        
        boolean start = true;
        
        Agent ag = new Agent();
        Graphics g = new Graphics();
        g.start();
        
        // loop
        while (true){
            StdDraw.enableDoubleBuffering();
            ag.sense();
            if (start){
                ag.startDecide();
                start = false;
            }
            else{
                ag.decide();
            }
            ag.act();
            StdDraw.show();
            g.image();
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(80,85,20,10);
            g.temp();
            
        }
        
    }
}
