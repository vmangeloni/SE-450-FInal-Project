package controller;

import model.draw.Shape;
import model.draw.ShapeHolder;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

//import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;


public class Delete {
    shapeUtility su = new shapeUtility();
    public static ArrayList<Shape> deleteArray = new ArrayList();
    ShapeHolder SAL = ShapeHolder.getInstance();

    public void delete(PaintCanvasBase paintCanvas) {

        for (Shape sa : SAL.getSA()) {
            if (sa.getIsSelected() == true) {
                deleteArray.add(sa);
            }

        }

        for (Shape dsa: deleteArray){
            SAL.getSA().remove(dsa);
            undoArray.remove(dsa);
            undoArray.add(0, dsa);
        }


        su.clearCanvas(paintCanvas);
        for (Shape sa : SAL.getSA()) {
            su.draw(sa);
        }


    }
}

