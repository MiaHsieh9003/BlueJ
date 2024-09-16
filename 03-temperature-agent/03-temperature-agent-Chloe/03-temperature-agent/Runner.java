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
         Agent agent;
        // ask for outside temp and pass it to Singleton Enviroment
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Outside temp:");
        int t = Integer.parseInt(myObj.nextLine()); 
        Environment.getInstance().setOutTemp(t);       
        
        // ask for desired temp and pass it to Singleton Enviroment
        Scanner myTemp = new Scanner(System.in);
        System.out.println("Enter Outside temp:");
        int d = Integer.parseInt(myObj.nextLine());  
        Environment.getInstance().setDesTemp(d);
        
        // create and initialize objects with data
        
        // loop
        
    }
}
