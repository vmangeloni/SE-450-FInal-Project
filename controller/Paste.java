package controller;

import model.ShapeShadingType;
import model.draw.Shape;

import static controller.Copy.copyArray;
import static controller.createShape.shapeArray;

public class Paste {

    shapeUtility su = new shapeUtility();


    public void paste(){

        for(Shape newShape: copyArray){
            su.draw(newShape);
            shapeArray.add(newShape);
        }
    }
}
