package controller;

import model.draw.Shape;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;


public class Delete {
    shapeUtility su = new shapeUtility();
    public static ArrayList<Shape> deleteArray = new ArrayList();

    public void delete(PaintCanvasBase paintCanvas) {

        for (Shape sa : shapeArray) {
            if (sa.getIsSelected() == true) {
                deleteArray.add(sa);
            }

        }

        for (Shape dsa: deleteArray){
            shapeArray.remove(dsa);
            undoArray.remove(dsa);
            undoArray.add(0, dsa);
        }


        su.clearCanvas(paintCanvas);
        for (Shape sa : shapeArray) {
            su.draw(sa);
        }


    }
}

