package controller;


import model.draw.Shape;
import model.draw.ShapeHolder;

import static controller.Copy.copyArray;
import static controller.shapeUtility.undoArray;



public class Paste {

    shapeUtility su = new shapeUtility();
    ShapeHolder SAL = ShapeHolder.getInstance();


    public void paste(){

        for(Shape newShape: copyArray){
            su.draw(newShape);
            SAL.addSA(newShape);
            undoArray.add(0, newShape);
        }
    }
}
