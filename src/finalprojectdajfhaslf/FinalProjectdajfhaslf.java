package finalprojectdajfhaslf;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalProjectdajfhaslf {
    
    //default parameters:
    /*
    grid = 10x10
    intial alive = 40%
    */
    public static void main(String[] args) {
        Block theBlock = new Block();
        ArrayList<ArrayList<Block>> theGrid = theBlock.initGrid(); //grid setup
        int generation = 0;
//        System.out.println("before0: "+theGrid.get(0).get(0).isAlive());
//        System.out.println("before10: "+theGrid.get(1).get(0).isAlive());
//        System.out.println("before1: "+theGrid.get(1).get(1).isAlive());
        //start the simulation
        for (int i=0;i<20;i++){
        //methods: update neighbors alive
        theBlock.updateNeighborsAlive(theGrid);
        //update alive
        theBlock.updateAlive(theGrid);
        generation+=1;
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(FinalProjectdajfhaslf.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        System.out.println(generation);
//        System.out.println("after0: "+theGrid.get(0).get(0).isAlive());
//        System.out.println("before10: "+theGrid.get(1).get(0).isAlive());
//        System.out.println("after1: "+theGrid.get(1).get(1).isAlive());
    }
    /*
    scanner for initGrid, checkNeighbors
    */
}

