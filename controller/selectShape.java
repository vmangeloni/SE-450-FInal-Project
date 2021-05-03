package controller;

import model.draw.rectangle;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class selectShape {
    private Rectangle selectShapes;

    private int selectX;
    private int selectY;
    private int selectX2;
    private int selectY2;

    public selectShape(mouseHandler callMouse){


        selectX = callMouse.getMouseX();
        selectY= callMouse.getMouseX2();
        selectX2 = callMouse.getMouseY();
        selectY2 = callMouse.getMouseY2();

        int pw = selectX2 - selectX;
        int ph = selectY2 - selectY;

        selectShapes = new Rectangle(selectX, selectX2, pw, ph);
        System.out.println(selectX + " " + selectY);

    }
}

//CREATE ARRAY OF SHAPES
//USE PARAMETERS
//MARK AS TRUE IF INTERSECTED