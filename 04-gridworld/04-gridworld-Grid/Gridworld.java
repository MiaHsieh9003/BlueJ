
/**
 * Write a description of class Environment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gridworld
{
    int [][] grid;
    public Gridworld(){
        
    }
    
    // your grid (2d array with your map) goes here.
    public void map(){
        int row =0;
        int col =0;
        grid = new int[][] { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},           
                    {1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},  
                    {1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1}, 
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},  
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}; 
        for (int number [] : grid) {
            for (int num: number){
                if (num == 1){
                    StdDraw.setPenRadius(0.0035);
                    StdDraw.square(row+2,col+4,0.5);
                }
                else if (num ==0){
                    StdDraw.setPenRadius(0.0005);
                    StdDraw.square(row+2,col+4,0.5);
                }
                row++;
            }
            row = 0;
            col++;
        }
    }
    
    // code for your Gridworld
    public void start(){
        StdDraw.setCanvasSize();
        StdDraw.setXscale(0,20);
        StdDraw.setYscale(0,20);
        map();
    }
        
    
    // Add methods that the agent will use.
    
    
    
}
