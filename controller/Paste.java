package controller;

import model.ShapeShadingType;
import model.draw.Shape;

import static controller.Copy.copyArray;
import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;

public class Paste {

    shapeUtility su = new shapeUtility();


    public void paste(){

        for(Shape newShape: copyArray){
            su.draw(newShape);
            shapeArray.add(newShape);
            undoArray.add(0, newShape);

        }

    }
}
