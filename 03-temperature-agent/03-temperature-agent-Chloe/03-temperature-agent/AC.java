
/**
 * Write a description of class AC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AC
{
    private boolean onOff;
    
    public AC(){
        onOff = false;
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
        //Increase the enviroment temp 
        double temp;
        Environment en = Environment.getInstance();
        temp = en.getOutTemp()+0.5;
        en.setOutTemp(temp);
    }
    
    public void cooler(){
        double temp;
        //Decrease the enviroment temp 
        Environment en = Environment.getInstance();
        temp = en.getOutTemp()-0.5;
        en.setOutTemp(temp);
    }
}
