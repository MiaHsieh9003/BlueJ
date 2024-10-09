import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
public class GameOfLife
{
    //
    
    // Write your code here.
    // instance variables
    // constructors
    // methods
    private int count;
    private int size;
    private Squares [][] cells;
    private ArrayList<Squares> ad;
    private String key;
    private boolean start;
    private boolean [][] placer ;
    public GameOfLife(){
        count = 0;
        size = 0;
        cells = new Squares[30][30];
        ad = new ArrayList<Squares>();
        key = "";
        start = true;
        placer = new boolean [30][30];
    }
    
    public void drawGrid(int sizes){
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLACK);
        //double x = 0.5;
        //double y = 0.5;
        for (int i = 0; i< size; i++){
            for (int j = 0; j<size;j++){
                StdDraw.square(i+0.5, j+0.5, 0.5);
                cells [i][j] = new Squares(i,j,false);
                //y=j+0.5;
                count++;
            }
            //x++;
        }
        //StdDraw.square(0.5, 29.5, 0.5);
    }
    
    public void init(){
        cells[5][26].setBoolean(true);
        cells[6][25].setBoolean(true);
        cells[6][24].setBoolean(true);
        cells[5][24].setBoolean(true);
        cells[4][24].setBoolean(true);
        
        placer[5][26]=true;
        placer[6][25]=true;
        placer[6][24]=true;
        placer[5][24]=true;
        placer[4][24]=true;
        fill();
        
    }
    
    
    public void fill(){
        for (int i = 0; i< size; i++){
            for (int j = 0; j<size;j++){
                if(placer[i][j]==true){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                    StdDraw.show();
                }else{
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                    StdDraw.show();
                }
            }
        }
    }
    
    public void rules1(){
        int num = 4;
        int alive = 0;
        while(start){
            for (int i = 0; i<size; i++){
                for (int j = 0; j<size; j++){
                    if (i==0 || j==0 || i==29 || j==29){
                            if (i==0 && j==0){
                                if (cells[i][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if(j==29 && i==29){
                                if (cells[i-1][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j-1].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if(j==29 && i==0){
                                if (cells[i+1][j].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j-1].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if(i==29 && j==0){
                                if (cells[i][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if (i == 0){
                                if (cells[i][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j-1].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if (i == 29){
                                if (cells[i-1][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if (j == 0){
                                if (cells[i-1][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j+1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j].getBoolean()==true){
                                    alive++;
                                }
                            }
                            else if (j == 29){
                                if (cells[i+1][j].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i+1][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j-1].getBoolean()==true){
                                    alive++;
                                }
                                if (cells[i-1][j].getBoolean()==true){
                                    alive++;
                                }
                            }
                    }
                    else{
                        if (cells[i-1][j+1].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i][j+1].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i+1][j+1].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i+1][j].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i+1][j-1].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i][j-1].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i-1][j-1].getBoolean()==true){
                            alive++;
                        }
                        if (cells[i-1][j].getBoolean()==true){
                            alive++;
                        }
                    }
                    if (cells[i][j].getBoolean()==true){
                        if (alive < 2){
                            placer[i][j] = false;
                        }
                        else if (alive > 3){
                            placer[i][j] = false;
                        }
                    }
                    else if (cells[i][j].getBoolean()==false){
                        if (alive ==3){
                            placer[i][j]=true;
                        }
                    }
                    alive = 0;
                } 
            }
            fill();
            for (int k = 0; k<size;k++){
                for (int l = 0; l<size; l++){
                    cells[k][l].setBoolean(placer[k][l]);
                }
            }
            if (StdDraw.isMousePressed()){
                if (StdDraw.mouseX()>5 && StdDraw.mouseX()<9 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                    //start = false;
                    break;
                }
            }
            //num--;
        }
    }
    
    public void rules(){
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        while (start) {
            // Loop through the grid
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int alive = 0;
        
                    // Check all 8 neighbors
                    for (int[] dir : directions) {
                        int ni = i + dir[0];  // Neighbor row
                        int nj = j + dir[1];  // Neighbor column
        
                        // Ensure we stay within bounds
                        if (ni >= 0 && ni < size && nj >= 0 && nj < size) {
                            if (cells[ni][nj].getBoolean() == true) {
                                alive++;
                            }
                        }
                    }
        
                    // Apply Game of Life rules
                    if (cells[i][j].getBoolean()) {
                        if (alive == 2 || alive == 3){
                            placer[i][j] = true;
                        }
                        else{
                            placer[i][j]=false;
                        }
                    } else {
                        if (alive == 3){
                            placer[i][j] = true;
                        }
                        else{
                            placer[i][j]=false;
                        }
                    }
                }
            }
            fill();
            // Update the cells with the new state
            for (int k = 0; k < size; k++) {
                for (int l = 0; l < size; l++) {
                    cells[k][l].setBoolean(placer[k][l]);
                }
            }
        
              // Additional operations after each iteration (if needed)
        }
    }
    
    
    public void getCount(){
        System.out.println(count);
    }
    
    public void inter(){
        double x = 0;
        int a = 0;
        double y = 0;
        int b = 0;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledRectangle(1.5,-1.5,2,1);
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledRectangle(6.5,-1.5,2,1);
        StdDraw.show();
        if (StdDraw.isMousePressed()){
            x = StdDraw.mouseX();
            y = StdDraw.mouseY();
            a = (int)x;
            b = (int)y;
            if (!(a<0)&&!(b<0) && placer[a][b]==false){
                placer[a][b]=true;
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(a+0.5,b+0.5,0.5);
                try{
                    TimeUnit.MILLISECONDS.sleep(150);
                }
                catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                
            }else if (!(a<0)&&!(b<0) && placer[a][b]==true){
                placer[a][b]=false;
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(a+0.5,b+0.5,0.5);
                try{
                    TimeUnit.MILLISECONDS.sleep(150);
                }
                catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
            else if (StdDraw.mouseX()>0 && StdDraw.mouseX()<4 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                rules();
            }
            else if (StdDraw.mouseX()>5 && StdDraw.mouseX()<9 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                    // Loop through the grid
            /*    for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        // If the cell is currently black (alive)
                        if (placer[i][j]) {
                            // Set it to white (dead)
                            placer[i][j] = false;
                            // Update the display to reflect the change
                            StdDraw.setPenColor(StdDraw.WHITE);
                            StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                        }
                    }
                }
                StdDraw.show();  // Show the changes made to the screen 
                */
            }
        }
    }
    
    public boolean keys(){
        //Scanner input = new Scanner(System.in);
        //key = input.next();
        //if (key.equals("s")){
          //  rules();
        //}
        //else if (key.equals("p")){
          //  start = false;
        //}
        //else if (key.equals("i")){
            
        //}
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledRectangle(1.5,-1.5,2,1);
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledRectangle(6.5,-1.5,2,1);
        StdDraw.show();
        if(StdDraw.isMousePressed()){
            if (StdDraw.mouseX()>0 && StdDraw.mouseX()<4 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                //rules();
                return false;
            }
            else if (StdDraw.mouseX()>5 && StdDraw.mouseX()<9 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                //break;
                return false;
            }
            else{
                return true;
            }
        }
        return true;
    }
    
    public void start() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize();
        StdDraw.setXscale(-2.5,31.5);
        StdDraw.setYscale(-2.5,31.5);
        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(StdDraw.BLACK);
        size = 30;
        drawGrid(size);
        StdDraw.show();
        while (true){
          inter();
          //keys();
        }
        //getCount();
        //init();
        //rules();
        
    }
    
    //while(true) {
          //  if(StdDraw.isMousePressed()){
            //    System.out.println("Mouse pos: " + StdDraw.mouseX() + ", "+ StdDraw.mouseY());
            //}
        //}
    
    
}
