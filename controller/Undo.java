package controller;

import model.draw.Shape;
import view.interfaces.PaintCanvasBase;



//import static controller.createShape.shapeArray;


public class Undo implements ICommand {


    private final PaintCanvasBase paintCanvas;
    shapeUtility su = new shapeUtility();



    public Undo(PaintCanvasBase paintCanvas) { this.paintCanvas = paintCanvas;}


    @Override
    public void execute() {


        /*int shapeArraySize = shapeArray.size() - 1;

        if (!undoArray.get(0).equals(shapeArray.get(shapeArraySize))){
            shapeArray.add(undoArray.get(0));
            undoArray.add(undoArray.remove(0));
        }
        else{
            shapeArray.remove(undoArray.get(0));
            undoArray.add(undoArray.remove(0));
        }

         */


        //-----------------------------------------
        //su.clearCanvas(paintCanvas);

        //for (Shape sa : shapeArray) {
            //su.draw(sa);}

        /*
        System.out.println("--------------UNDO---------------");
        System.out.println("SHAPE "+ shapeArray);
        System.out.println("UNDO " + undoArray);

         */







        /*


        int arraySize = shapeArray.size();

        if(!shapeArray.contains(undoArray.get(0))){
            shapeArray.add(undoArray.get(0));
        }

        shapeArray.remove(undoArray.get(0));
        redoArray.add(undoArray.get(0));
        undoArray.remove(0);


        if(arraySize > 1){
            if(!shapeArray.contains(undoArray.get(0))){
                shapeArray.add(undoArray.get(0));
            }
        }

        System.out.println("------------------UNDO-------------------------");
        System.out.println("SHAPE: " + shapeArray);
        System.out.println("UNDO: " + undoArray);
        System.out.println("REDO: " + redoArray);



         */
    }



}
