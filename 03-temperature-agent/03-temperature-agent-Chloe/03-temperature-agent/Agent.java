
/**
 * Write a description of class Agent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Agent
{
    private double outT;
    private double desT;
    private boolean cool;
    AC ac = new AC();
    // do what agents do
    //sense
    public Agent(){
        outT = 0;
        desT = 0;
        cool = false;
    }
    public void sense(){
        outT = Environment.getInstance().getOutTemp();
        desT = Environment.getInstance().getDesTemp();        
    }
    //decide
    public void checkTemp(){
        if (outT > desT-1){
            cool = true;
        }
        else{
            cool = false;
        }
    }
    //act
    public void onAC(){
        if (cool){
            ac.turnOn();
            ac.cooler();
        }
        else{
            ac.turnOff();
            ac.heater();
        }
    }
}
