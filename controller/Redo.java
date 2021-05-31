package controller;

import model.draw.Shape;
import view.interfaces.PaintCanvasBase;

//import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;

import java.io.IOException;

public class Redo implements ICommand{

    private final PaintCanvasBase paintCanvas;
    shapeUtility su = new shapeUtility();


    public Redo(PaintCanvasBase paintCanvas) { this.paintCanvas = paintCanvas;}  {

    }

    @Override
    public void execute()  {
        CommandHistory.redo();

        /*
        int undoSize = undoArray.size() - 1;
        int shapeSize = shapeArray.size() - 1;



        if(shapeArray.get(shapeSize).equals(undoArray.get(undoSize))){


            undoArray.add(0, shapeArray.remove(shapeSize));
            undoArray.remove(undoSize + 1);
            shapeArray.add(undoArray.get(0));
        }
        else{

            shapeArray.add(undoArray.get(undoSize));
            undoArray.add(0, undoArray.remove(undoSize));
        }



        su.clearCanvas(paintCanvas);

        for (Shape sa : shapeArray) {
            su.draw(sa);
        }

        /*
        System.out.println("--------------REDO---------------");
        System.out.println("SHAPE "+ shapeArray);
        System.out.println("UNDO " + undoArray);
        */


        /*

        //shapeArray.add(undoArray.get(0));


        shapeArray.add(redoArray.get(0));
        undoArray.add(redoArray.get(0));
        redoArray.remove(0);

        System.out.println("------------------REDO-------------------------");
        System.out.println("SHAPE: " + shapeArray);
        System.out.println("UNDO: " + undoArray);
        System.out.println("REDO: " + redoArray);


        su.clearCanvas(paintCanvas);

        for (Shape sa : shapeArray) {
            su.draw(sa);
            }

         */
    }
}
