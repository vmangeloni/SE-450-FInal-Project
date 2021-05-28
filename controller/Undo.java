package controller;

import model.draw.Shape;
import view.interfaces.PaintCanvasBase;


import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;


public class Undo implements ICommand {


    private final PaintCanvasBase paintCanvas;
    shapeUtility su = new shapeUtility();

    public Undo(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
    }


    @Override
    public void execute() {
        CommandHistory.undo();

        int arraySize = shapeArray.size();

        shapeArray.remove(undoArray.get(0));
        undoArray.remove(0);

        if(arraySize > 1){
            if(!shapeArray.contains(undoArray.get(0))){
                shapeArray.add(undoArray.get(0));
            }
        }

        su.clearCanvas(paintCanvas);

        for (Shape sa : shapeArray) {
            su.draw(sa);}

    }

}
