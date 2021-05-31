package controller;

import model.ShapeShadingType;
import model.draw.Shape;
import model.draw.ShapeHolder;

import static controller.Copy.copyArray;
//import static controller.createShape.shapeArray;


public class Paste {

    shapeUtility su = new shapeUtility();
    ShapeHolder SAL = ShapeHolder.getInstance();


    public void paste(){

        for(Shape newShape: copyArray){
            su.draw(newShape);
            SAL.addSA(newShape);
        }
    }
}
