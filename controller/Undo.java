package controller;

import model.draw.Shape;
import model.draw.ShapeHolder;
import view.interfaces.PaintCanvasBase;

import static controller.shapeUtility.undoArray;




public class Undo implements ICommand {


    private final PaintCanvasBase paintCanvas;
    shapeUtility su = new shapeUtility();
    ShapeHolder SAL = ShapeHolder.getInstance();



    public Undo(PaintCanvasBase paintCanvas) { this.paintCanvas = paintCanvas;}


    @Override
    public void execute() {

        System.out.println(undoArray);
        System.out.println(SAL.getSA());

        SAL.removeSA(undoArray.get(0));
        undoArray.add(undoArray.remove(0));

        su.clearCanvas(paintCanvas);
        for (Shape sa : SAL.getSA()) {
            su.draw(sa);}

    }
}
