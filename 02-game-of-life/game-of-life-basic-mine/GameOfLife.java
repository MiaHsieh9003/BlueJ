import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class GameOfLife here.
 *
 * @Chloe Chen (your name)
 * @8/23 (a version number or a date)
 */
public class GameOfLife
{    
    // Write your code here.
    // instance variables
    // constructors
    // methods
    private int size;
    private Squares [][] cells;
    private boolean start;
    int click_count = 0;
    
    public GameOfLife(){
        size = 0;
        start = true;
    }
    
    public void drawGrid(){
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLACK);
        
        for (int i = 1; i< size+1; i++){
            for (int j = 1; j<size+1;j++){
                cells [i][j] = new Squares(i,j,false);
                cells [i][j].drawWhite();
            }
        }
    }
    
    public void basicGameStartDraw(){
        cells[3][28].drawBlack();
        AddNeiBlackNum(3,28, "PRESENT");
        cells[4][27].drawBlack();
        AddNeiBlackNum(4,27, "PRESENT");
        cells[2][26].drawBlack();
        AddNeiBlackNum(2,26, "PRESENT");
        cells[3][26].drawBlack();
        AddNeiBlackNum(3,26, "PRESENT");
        cells[4][26].drawBlack();
        AddNeiBlackNum(4,26, "PRESENT");
        
        resetNextNei();
    }
    
    //update black cells number of neighbors 
    public void AddNeiBlackNum(int i, int j, String choose){
        //i
        if(j-1>0){
            cells[i][j-1].neighborAdd(choose);
        }
        if(j+1<size+1){
            cells[i][j+1].neighborAdd(choose);
        }
        
        //i-1
        if(i-1 > 0){
            cells[i-1][j].neighborAdd(choose);
            if(j-1>0){
                cells[i-1][j-1].neighborAdd(choose);
            }
            if(j+1<size+1){
                cells[i-1][j+1].neighborAdd(choose);
            }
        }
        //i+1
        if(i+1 < size+1){
            cells[i+1][j].neighborAdd(choose);
            if(j-1>0){
                cells[i+1][j-1].neighborAdd(choose);
            }
            if(j+1<size+1){
                cells[i+1][j+1].neighborAdd(choose);
            }
        }
    }

    public void SubNeiBlackNum(int i, int j, String choose){
        // y down direction check
        if(j-1>0){
            if(cells[i][j-1].getNei()>0){
                cells[i][j-1].neighborSub(choose);
            }            
        }
        // y up direction check
        if(j+1<size+1){
            if(cells[i][j+1].getNei()>0){
                cells[i][j+1].neighborSub(choose);                
            }
        }
        
        // x left direction check
        if(i-1 > 0){
            cells[i-1][j].neighborSub(choose);
            if(j-1>0){
                if(cells[i-1][j-1].getNei()>0){
                    cells[i-1][j-1].neighborSub(choose);
                }
            }
            if(j+1<size+1){
                if(cells[i-1][j+1].getNei()>0){
                    cells[i-1][j+1].neighborSub(choose);
                }
            }
        }
        // x right direction check
        if(i+1 < size+1){
            cells[i+1][j].neighborSub(choose);
            if(j-1>0){
                if(cells[i+1][j-1].getNei()>0){
                    cells[i+1][j-1].neighborSub(choose);
                }
            }
            if(j+1<size+1){
                if(cells[i+1][j+1].getNei()>0){
                    cells[i+1][j+1].neighborSub(choose);
                }
            }
        }
    }
    
    public void resetNextNei(){
        for (int i = 1; i< size+1; i++){
            for (int j = 1; j<size+1;j++){  
                cells[i][j].setNextNei(cells[i][j].getNei());
            }
        }
    }
    public void resetNei(){
        for (int i = 1; i< size+1; i++){
            for (int j = 1; j<size+1;j++){  
                cells[i][j].setNei(cells[i][j].getNextNei());
            }
        }
    }
        
    //button
    public void addComponentsToPane(Container pane) {          
    
        pane.setLayout(null);
    
        JButton btn = new JButton("點我");
        // Set the size and position of the button
        btn.setBounds(50, 480, 100, 30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //update(cells); // 更新塗黑處
                btn.setText("已經" + click_count++ + " 下");
            }
        });
        pane.add(btn);
    }
    
    public void update(Squares [][] cells){        
        StdDraw.setCanvasSize();
        StdDraw.setXscale(-2,32);
        StdDraw.setYscale(-2,32);
        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(StdDraw.BLACK);
        this.size = 30;
        drawGrid();
        //basicGameStartDraw();
        for (int i = 1; i< size+1; i++){
            for (int j = 1; j<size+1;j++){
                if(cells[i][j].blackOrNot()){
                    if(cells[i][j].getNei() == 2 || cells[i][j].getNei() == 3){                        
                        cells[i][j].drawBlack();
                    }
                    else{                       
                        cells[i][j].drawWhite();
                        SubNeiBlackNum(i, j, "NEXT");                        
                    }
                }else{
                    if(cells[i][j].getNei() == 3){
                        cells[i][j].drawBlack();
                        AddNeiBlackNum(i, j, "NEXT");   
                    }
                }
            }
        }
        //printNeiNum();
        resetNei();
        //printNeiNum();
        
    }
    
    public void printNeiNum(){
        for (int j = size; j>0;j--){
            for (int i = 1; i<size+1; i++){
            
                System.out.print(cells[i][j].getNei());
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printNextNeiNum(){
        for (int i = 1; i< size+1; i++){
            for (int j = 1; j<size+1;j++){
                System.out.print(cells[i][j].getNextNei());
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void start() {
        StdDraw.setCanvasSize();
        StdDraw.setXscale(-2,32);
        StdDraw.setYscale(-2,32);
        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(StdDraw.BLACK);
        this.size = 30;
        
        //cells 初始化
        this.cells = new Squares[size+1][size+1];
        
        drawGrid();
        basicGameStartDraw();
        
        /*try{
            while(true){
                update();     
                Thread.sleep(300);              
            }           
        }catch (Exception e) {
          System.out.println(e);
        }*/
    }
    
    
    
    
}
