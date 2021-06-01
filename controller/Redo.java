package controller;

import model.draw.Shape;
import model.draw.ShapeHolder;
import view.interfaces.PaintCanvasBase;


import static controller.shapeUtility.undoArray;

public class Redo implements ICommand{

    private final PaintCanvasBase paintCanvas;
    shapeUtility su = new shapeUtility();
    ShapeHolder SAL = ShapeHolder.getInstance();


    public Redo(PaintCanvasBase paintCanvas) { this.paintCanvas = paintCanvas;}  {

    }

    @Override
    public void execute()  {
        CommandHistory.redo();

        int undoSize = undoArray.size() - 1;

        SAL.addSA(undoArray.get(undoSize));
        undoArray.add(0, undoArray.remove(undoSize));

        su.clearCanvas(paintCanvas);

        for (Shape sa : SAL.getSA()) {
            su.draw(sa);}
    }
}
