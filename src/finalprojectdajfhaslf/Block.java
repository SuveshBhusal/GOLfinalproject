package finalprojectdajfhaslf;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Block {
    //attributes
    boolean alive;
    int neighborsAlive;
    Point pos;
    public Block() {
    }

    public Block(boolean alive, int neighborsAlive, Point pos) {
        this.alive = alive;
        this.neighborsAlive = neighborsAlive;
        this.pos = pos;
    }
    
    public ArrayList<ArrayList<Block>> initGrid(){ //replace 10 with n/size/number from scanner
        Random generator = new Random(); //generate the initial state
        ArrayList<ArrayList<Block>> grid = new ArrayList<>();
        for (int i=0; i<10; i++){
            ArrayList<Block> rows = new ArrayList();
            for (int j=0; j<10; j++){
                double alive = generator.nextDouble();
                Point p = new Point(i,j);
                if (alive<0.4){
                    //System.out.println("yay");
                    Block b = new Block(true,2,p);
                    rows.add(b);
                }
                else{
                    //System.out.println("nay");
                    Block b = new Block(false,2,p);
                    rows.add(b);
                }
            grid.add(rows);
            }
        }
        //System.out.print(grid.get(0).get(0).getPos()+"\n");
        return grid;
    }
    public void checkCorners(ArrayList<ArrayList<Block>> grid){
        int N = 9;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        
        if (grid.get(0).get(1).isAlive()==true){ count1+=1; }
        if (grid.get(1).get(0).isAlive()==true){ count1+=1; }
        if (grid.get(1).get(1).isAlive()==true){ count1+=1; }
        grid.get(0).get(0).setNeighborsAlive(count1);
        
        if (grid.get(N-1).get(0).isAlive()==true){ count2+=1; }
        if (grid.get(N).get(1).isAlive()==true){ count2+=1; }
        if (grid.get(N-1).get(1).isAlive()==true){ count2+=1; }
        grid.get(N).get(0).setNeighborsAlive(count2);

        if (grid.get(0).get(N-1).isAlive()==true){ count3+=1; }
        if (grid.get(1).get(N).isAlive()==true){ count3+=1; }
        if (grid.get(1).get(N-1).isAlive()==true){ count3+=1; }
        grid.get(0).get(N).setNeighborsAlive(count3);

        if (grid.get(N).get(N-1).isAlive()==true){ count4+=1; }
        if (grid.get(N-1).get(N).isAlive()==true){ count4+=1; }
        if (grid.get(N-1).get(N-1).isAlive()==true){ count4+=1; }
        grid.get(N).get(N).setNeighborsAlive(count4);
    }
    public void checkEdges(ArrayList<ArrayList<Block>> grid){
        int N = 9;
        for (int i=1; i<N; i++){
            int countLeft = 0;
            if (grid.get(0).get(i-1).isAlive()==true){ countLeft+=1; }
            if (grid.get(1).get(i-1).isAlive()==true){ countLeft+=1; }
            if (grid.get(1).get(i).isAlive()==true){ countLeft+=1; }
            if (grid.get(1).get(i+1).isAlive()==true){ countLeft+=1; }
            if (grid.get(0).get(i+1).isAlive()==true){ countLeft+=1; }
            grid.get(0).get(i).setNeighborsAlive(countLeft);
        }
        for (int i=1; i<N; i++){
            int countRight = 0;
            if (grid.get(N).get(i-1).isAlive()==true){ countRight+=1; }
            if (grid.get(N-1).get(i-1).isAlive()==true){ countRight+=1; }
            if (grid.get(N-1).get(i).isAlive()==true){ countRight+=1; }
            if (grid.get(N-1).get(i+1).isAlive()==true){ countRight+=1; }
            if (grid.get(N).get(i+1).isAlive()==true){ countRight+=1; }
            grid.get(N).get(i).setNeighborsAlive(countRight);
        }
        for (int i=1; i<N; i++){
            int countTop = 0;
            if (grid.get(i-1).get(0).isAlive()==true){ countTop+=1; }
            if (grid.get(i-1).get(1).isAlive()==true){ countTop+=1; }
            if (grid.get(i).get(1).isAlive()==true){ countTop+=1; }
            if (grid.get(i+1).get(1).isAlive()==true){ countTop+=1; }
            if (grid.get(i+1).get(0).isAlive()==true){ countTop+=1; }
            grid.get(i).get(0).setNeighborsAlive(countTop);
        }
        for (int i=1; i<N; i++){
            int countBot = 0;
            if (grid.get(i-1).get(N).isAlive()==true){ countBot+=1;}
            if (grid.get(i-1).get(N-1).isAlive()==true){ countBot+=1;}
            if (grid.get(i).get(N-1).isAlive()==true){ countBot+=1; }
            if (grid.get(i+1).get(N-1).isAlive()==true){ countBot+=1;}
            if (grid.get(i+1).get(N).isAlive()==true){ countBot+=1; }
            grid.get(i).get(N).setNeighborsAlive(countBot);
        }
    }
    public void checkCenter(ArrayList<ArrayList<Block>> grid){
        int N = 9;
        for (int i=1; i<N; i++){
            for (int j=1; j<N; j++){
                int countCenter = 0;
                if (grid.get(i+1).get(j).isAlive()==true){ countCenter+=1; }
                if (grid.get(i+1).get(j+1).isAlive()==true){ countCenter+=1; }
                if (grid.get(i).get(j+1).isAlive()==true){ countCenter+=1; }
                if (grid.get(i-1).get(j+1).isAlive()==true){ countCenter+=1; }
                if (grid.get(i-1).get(j).isAlive()==true){ countCenter+=1; }
                if (grid.get(i-1).get(j-1).isAlive()==true){ countCenter+=1; }
                if (grid.get(i).get(j-1).isAlive()==true){ countCenter+=1; }
                if (grid.get(i+1).get(j-1).isAlive()==true){ countCenter+=1; }
                grid.get(i).get(j).setNeighborsAlive(countCenter);
            }
        }
    }
    public void updateNeighborsAlive(ArrayList<ArrayList<Block>> grid){
        //edge cases: corners, edges, everything else
        //replace 9 with len-1 for each check method
        checkCorners(grid);
        checkEdges(grid);
        checkCenter(grid);
    }
    public void updateAlive(ArrayList<ArrayList<Block>> grid){
        //replace 9 with len-1 for each method
        int N = 9;
        for (int i=0; i<N+1; i++){
            for (int j=0; j<N+1; j++){
                boolean deadCon1 = grid.get(i).get(j).getNeighborsAlive()==2;
                boolean deadCon2 = grid.get(i).get(j).getNeighborsAlive()==3;
                boolean aliveCon = grid.get(i).get(j).getNeighborsAlive()==3;
                if (grid.get(i).get(j).isAlive()){
                    if (!(deadCon1||deadCon2)){
                        grid.get(i).get(j).setAlive(false);
                    }
                }
                else{//cell is currently dead
                    if (aliveCon){
                        grid.get(i).get(j).setAlive(true);
                    }
                }
            }
        }
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNeighborsAlive() {
        return neighborsAlive;
    }
    public void setNeighborsAlive(int neighborsAlive) {
        this.neighborsAlive = neighborsAlive;
    }

    public Point getPos() {
        return pos;
    }
    public void setPos(Point pos) {
        this.pos = pos;
    }
    
}
