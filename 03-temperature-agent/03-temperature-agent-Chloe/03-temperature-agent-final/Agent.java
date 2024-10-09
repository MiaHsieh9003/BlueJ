
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
    
    public Agent(){
        outT = 0;
        desT = 0;
        cool = false;
    }
    
    //sense
    public void sense(){
        outT = Environment.getInstance().getOutTemp();
        desT = Environment.getInstance().getDesTemp();
    }
    
    //decide
    public void startDecide(){
        if (outT>desT-1){
            cool = true;
        }
        else{
            cool = false;
        }
    }
    
    public void decide(){
        if (outT>=desT+1){
            cool = true;
        }
        else if (outT <= desT-1){
            cool = false;
        }
    }
    //act
    public void act(){
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
