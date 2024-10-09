
/**
 * Write a description of class ThermostatAgent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Agent
{
    // code your agent.
    // instance variables
    private static Agent m_instance;
    private int [][] grid;
    private int [][] map;
    private boolean isWall;
    private int right;
    private int [] loc;
    private int x;
    private int y;
    private int [] gold;
    private int gx;
    private int gy;
    private boolean atGoal;
    
    // constructor
    private Agent(){
        grid = new int [][] {{1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                            };
                    /*{ {1, 1, 1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},           
                    {0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},  
                    {0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1}, 
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},  
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}; 
                    x = 1;
                    y = 10;
                    gx = 5;
                    gy = 0;
                    */
        
        isWall = false;
        x = 28;
        y = 28;
        loc = new int [] {x, y};
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        right = 2;
        gx = 0;
        gy = 2;
        gold = new int[] {gx, gy};
        atGoal = false;
        
    }
    
    public static Agent getInstance(){
        if(m_instance==null){
            m_instance = new Agent();
        }
        
        return m_instance;
    }
    
    //getter and setter methods
    public int [][] getGrid(){
        return grid;
    }
    
    /*public void setLoc(int a, int b){
        loc[0] = a;
        loc[1] = b;
    }*/
    
    public int locX(){
        return loc[0];
    }
    
    public int locY(){
        return loc[1];
    }
    
    /*public void setG(int a, int b){
        gold[0] = a;
        gold[1] = b;
    }*/
    
    public int goldX(){
        //***return gx
        return gold[1];
    }
    
    public int goldY(){
        //***return gy
        return gold[0];
    }
    
    public boolean getGoal(){
        return atGoal;
    }
    
    // add sense decide act methods
    //sense senses whether or not there is a wall on the right side of the object and to change directions
    public void sense() {
        x = loc[1];
        y = loc[0];
        //if(x < grid.length 
        //System.out.println(grid[0].length + " " +grid.length);
        
        // 1 - grid right, 2 - grid up, 3 - grid left, 4 - grid down
        if (right == 1) {
            // Check if x+1 is within bounds
            if (x + 1 < grid.length && grid[x + 1][y] == 0) {
                right = 4;
            }
            // Check if x+1 and y+1 are within bounds for further checks
            else if (x + 1 < grid.length && y + 1 < grid[0].length && grid[x + 1][y] == 1 && grid[x][y + 1] == 1) {
                right = 2;
            }
            else if (y + 1 < grid[0].length && grid[x][y + 1] == 0) {
                right = 1;
            }
        }
        else if (right == 2) {
            // Check if y+1 is within bounds
            if ((y + 1 < grid[0].length) && (grid[x][y + 1] == 0)) {
                right = 1;
            }
            // Check if x-1 and y+1 are within bounds
            else if (y + 1 < grid[0].length && x - 1 >= 0 && grid[x][y + 1] == 1 && grid[x - 1][y] == 1) {
                right = 3;
            }
            else if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                right = 2;
            }
        }
        else if (right == 3) {
            // Check if x-1 is within bounds
            if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                right = 2;
            }
            // Check if x-1 and y-1 are within bounds
            else if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y] == 1 && grid[x][y - 1] == 1) {
                right = 4;
            }
            else if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                right = 3;
            }
        }
        else if (right == 4) {
            // Check if y-1 is within bounds
            if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                right = 3;
            }
            // Check if x+1 and y-1 are within bounds
            else if (y - 1 >= 0 && x + 1 < grid.length && grid[x][y - 1] == 1 && grid[x + 1][y] == 1) {
                right = 1;
            }
            else if (x + 1 < grid.length && grid[x + 1][y] == 0) {
                right = 4;
            }
        }
        //System.out.println("x: " + x + " y: " + y + " right: "+ right);
    }
    
    //decides if touches treasure
    public boolean decide(){
        if (loc[1]==gold[0] && loc[0]==gold[1]){
            atGoal = true;
        }
        else{
            atGoal = false;
        }
        System.out.println("atGoal: " + atGoal);
        return atGoal;
    }
    
    //checks direction and move the object forward based on direction
    public void act(){
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        if (right == 1){
            //if (grid[loc[0]][loc[1]+1]==0){
                loc[0] = loc [0]+1;
            //}
        }
        else if (right == 2){
            //if (grid[loc[0]-1][loc[1]]==0){
                loc[1] = loc [1]-1;
            //}
        }
        else if (right == 3){
            //if (grid[loc[0]][loc[1]-1]==0){
                loc[0] = loc [0]-1;
            //}
        }
        else if (right == 4){
            //if (grid[loc[0]+1][loc[1]]==0){
                loc[1] = loc [1]+1;
            //}
        }
    }

    
}
