package controller;

import model.draw.*;
import model.draw.Shape;
import model.interfaces.IShapeBuilder;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

import java.awt.*;

//import static controller.createShape.shapeArray;



public class Copy {

    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;

    public static ArrayList<Shape> copyArray = new ArrayList();
    ShapeHolder SAL = ShapeHolder.getInstance();

    public void copy() {

        for (Shape s : SAL.getSA()) {
            if (s.getIsSelected() == true) {

                CloneFactory shapeMaker = new CloneFactory();
                Shape newShape = (Shape) shapeMaker.getClone(s);

                newShape.setX1(0);
                newShape.setY1(0);
                newShape.setSelectSpace(new Rectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH()));
                newShape.setIsMoved(true);

                copyArray.add(newShape);
            }
        }
    }
}
