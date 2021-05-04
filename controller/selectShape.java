package controller;

import model.draw.rectangle;
import model.draw.shape;

import java.awt.*;

import static controller.createShape.shapeArray;

public class selectShape {
    private Rectangle selectShapes;

    private int selectX;
    private int selectY;
    private int selectX2;
    private int selectY2;

    public selectShape(mouseHandler callMouse){


        selectX = callMouse.getMouseX();
        selectY= callMouse.getMouseY();
        selectX2 = callMouse.getMouseX2();
        selectY2 = callMouse.getMouseY2();

        int pw = selectX2 - selectX;
        int ph = selectY2 - selectY;

        for (shape s: shapeArray){
            System.out.println(s.shapeSelect);
        }

        selectShapes = new Rectangle(selectX, selectX2, pw, ph);

        for (shape s: shapeArray){
            if(s.selectSpace.intersects(selectShapes)){
                s.selectUpdate(true);
                System.out.println(s.shapeSelect);
                }
            }
    }
}

//CREATE ARRAY OF SHAPES
//USE PARAMETERS
//MARK AS TRUE IF INTERSECTED