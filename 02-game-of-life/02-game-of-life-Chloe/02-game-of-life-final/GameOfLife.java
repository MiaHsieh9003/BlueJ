import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.awt.Container;

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
    int click_count = 0;
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
        for (int i = 0; i< size; i++){
            for (int j = 0; j<size;j++){
                StdDraw.square(i+0.5, j+0.5, 0.5);
                cells [i][j] = new Squares(i,j,false);
                count++;
            }
        }
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
        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        for (int i = 0; i< size; i++){
            for (int j = 0; j<size;j++){
                if(placer[i][j]==true){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                }else{
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                }
            }
        }
        drawGrid(size);
        StdDraw.show();
    }
    
    public void rules(){
        int alive = 0;
        while(start){
            if (StdDraw.isMousePressed()){
                if (StdDraw.mouseX()>5 && StdDraw.mouseX()<9 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                    break;
                }
            }
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
                    break;
                }
            }
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
        Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(1.5, -1.75, "Start");
        StdDraw.text(6.5, -1.75, "Pause");
        StdDraw.show();
        if (StdDraw.isMousePressed()){
            x = StdDraw.mouseX();
            y = StdDraw.mouseY();
            a = (int)x;
            b = (int)y;
            if(!(a<0)&&!(b<0)&&!(a>=size)&&!(b>=size)){
                if (placer[a][b]==false){
                placer[a][b]=true;
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(a+0.5,b+0.5,0.5);
                try{
                    TimeUnit.MILLISECONDS.sleep(150);
                }
                catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                
                }else if (placer[a][b]==true){
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
            }
            else{
                if (StdDraw.mouseX()>0 && StdDraw.mouseX()<4 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                StdDraw.setMouseIsPressed(false);
                rules();
                }
            }
        }
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
        }
    }
    
    //while(true) {
          //  if(StdDraw.isMousePressed()){
            //    System.out.println("Mouse pos: " + StdDraw.mouseX() + ", "+ StdDraw.mouseY());
            //}
        //}
        /*public void addComponentsToPane(Container pane) {          
    
        pane.setLayout(null);
    
        JButton btn = new JButton("Pause");
        // Set the size and position of the button
        btn.setBounds(7, 2, 5, 2);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //update(cells); // 更新塗黑處
                btn.setText("Paused");
                start = false;
            }
        });
        pane.add(btn);
    }*/
    
    
}
