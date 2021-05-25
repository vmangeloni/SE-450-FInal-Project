package controller;

import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.draw.*;
import model.draw.Shape;
import model.interfaces.IShapeBuilder;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

import static controller.createShape.shapeArray;
import static model.ShapeColor.returnColor;

public class moveShape {

    public static ArrayList<Shape> MoveShapeArray = new ArrayList();
    shapeUtility su = new shapeUtility();

    Shape S;
    int maxX = 0;
    int maxY = 0;

    public moveShape(mouseHandler callMouse, createShape cs, Shape newShape) {

        for (Shape sa : shapeArray) {
            if (sa.getIsSelected() == true) {
                MoveShapeArray.add(sa);
                if (sa.getX1() > maxX){
                    maxX = sa.getX1();
                }
                if (sa.getY1() > maxY){
                    maxY = sa.getY1();
                }
            }
        }



        for (Shape s: MoveShapeArray) {
            if (s.getIsSelected() == true) {

                int DiffX = callMouse.getMouseX() - s.getX1();
                int DiffY = callMouse.getMouseY() - s.getY1();

                int additionalX = s.getX1() - maxX;
                int additionalY = s.getY1() - maxY;
                int newX = s.getX1() + DiffX + additionalX;
                int newY = s.getY1() + DiffY + additionalY;

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
                newShape.setIsSelected(s.getIsSelected());
                newShape.setX1(newX);
                newShape.setY1(newY);
                newShape.setSelectSpace(new Rectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH()));

                StatusGrabber statusGrabber = new StatusGrabber();
                StatusObserver observer1 = new StatusObserver(statusGrabber);
                statusGrabber.setIsDeletedObserver(false);
;
                if(newShape.getShapeShadingType() == ShapeShadingType.OUTLINE) {
                    su.drawOutlineRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                            newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                    shapeArray.add(newShape); }

                if(newShape.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
                    su.drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                            newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                    shapeArray.add(newShape);}

                if(newShape.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                    su.drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                            newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                    su.drawOutlineRectangle(newShape.getX1(), newShape.getX2(), newShape.getPW(), newShape.getPH(),
                            newShape.getPaintCanvasBase(), newShape.getSecondaryColor());
                    shapeArray.add(newShape);}



            }
        }

    }

}
