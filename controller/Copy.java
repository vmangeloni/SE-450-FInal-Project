package controller;

import model.draw.Shape;
import model.draw.ShapeBuilder;
import model.draw.ShapeHolder;
import model.draw.shapeConstructor;
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

    public void copy(PaintCanvasBase paintCanvas, ApplicationState appState) {

        for (Shape s : SAL.getSA()) {
            if (s.getIsSelected() == true) {

                mouseHandler callMouse = new mouseHandler(paintCanvas, appState);
                createShape CS = new createShape(callMouse);
                IShapeBuilder shapeBuilderShape = new shapeConstructor(CS);
                ShapeBuilder shapeBuilder = new ShapeBuilder(shapeBuilderShape);
                shapeBuilder.makeShape();
                Shape newShape = shapeBuilder.getShape();

                newShape.setPaintCanvasBase(s.getPaintCanvasBase());
                newShape.setShapeShadingType(s.getShapeShadingType());
                newShape.setPrimaryColor(s.getPrimaryColor());
                newShape.setSecondaryColor(s.getSecondaryColor());
                newShape.setShapeType(s.getShapeType());
                newShape.setX2(s.getX2());
                newShape.setY2(s.getY2());
                newShape.setPW(s.getPW());
                newShape.setPH(s.getPH());
                newShape.setX2(s.getX2());
                newShape.setIsSelected(true);
                newShape.setX1(0);
                newShape.setY1(0);
                newShape.setSelectSpace(new Rectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH()));
                newShape.setIsMoved(true);

                copyArray.add(newShape);
            }
        }
    }
}
