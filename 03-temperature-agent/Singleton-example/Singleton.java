
/**
 * Write a description of class Singleton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Singleton
{
    // 1. private static reference
    private static Singleton m_instance;
    
    // instance variables for your problem
    private String data;
    
    // 2. private constructor
    private Singleton () {
        data = "GGMU";
    }
    
    // 3. static access to unique instance
    public static Singleton getInstance() {
        if (m_instance == null) {
            m_instance = new Singleton();
        }
        
        return m_instance;
    }
    
    // methods that are part of your problem.
    public void setData (String rhs) {
        data = rhs;
    }
    
    public String getData() {
        return data;
    }
}
