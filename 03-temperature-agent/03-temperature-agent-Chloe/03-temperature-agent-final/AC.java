
/**
 * Write a description of class AC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.concurrent.TimeUnit;
 
public class AC
{
    private boolean onOff;
    private double de;
    
    public AC(){
        onOff = false;
        de = Environment.getInstance().getDesTemp();
    }
    // turn on
    public void turnOn(){
        onOff = true;
    }
    // turn it off
    public void turnOff(){
        onOff = false;
    }
    // check status
    public boolean status(){
        return onOff;
    }
    // other stuff
    public void heater(){
        try{
            TimeUnit.MILLISECONDS.sleep(150);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        double te = Environment.getInstance().getOutTemp()+0.05;
        Environment.getInstance().setOutTemp(te);
        System.out.println("Outside Temp: "+ te +"Desire Temp: "+de);
    }
    
    public void cooler(){
        try{
            TimeUnit.MILLISECONDS.sleep(150);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        double te = Environment.getInstance().getOutTemp()-0.05;
        Environment.getInstance().setOutTemp(te);
        System.out.println("Outside Temp: "+ te +" Desire Temp: "+de);
    }
}
