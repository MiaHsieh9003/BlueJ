
/**
 * Write a description of class Environment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Environment
{
    private static Environment m_instance;
    private double outTemp;
    private double desTemp;
    private Environment(){
        outTemp = 0;
        desTemp = 0; 
    }
    
    public static Environment getInstance(){
        if (m_instance == null){
            m_instance = new Environment();
        }
        
        return m_instance;
    }
    
    // method to return temp
    public double getOutTemp(){
        return outTemp;
    }
    
    public double getDesTemp(){
        return desTemp;
    } 
    
    // method to change temp
    public void setOutTemp(double userTemp){
        outTemp = userTemp;
    }
    
    public void setDesTemp(double wantTemp){
        desTemp = wantTemp;
    }
       
}
