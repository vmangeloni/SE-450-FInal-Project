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
import static controller.shapeUtility.undoArray;
import static model.ShapeColor.returnColor;

public class moveShape {

    public static ArrayList<Shape> MoveShapeArray = new ArrayList();

    shapeUtility su = new shapeUtility();
    Group gp = new Group();

    Shape S;
    int maxX = 0;
    int maxY = 0;

    public moveShape(mouseHandler callMouse, createShape CS) {

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
            if (s.getIsSelected() == true || s.getIsGroup() == true) {

                IShapeBuilder shapeBuilderShape = new shapeConstructor(CS);
                ShapeBuilder shapeBuilder = new ShapeBuilder(shapeBuilderShape);
                shapeBuilder.makeShape();
                Shape newShape = shapeBuilder.getShape();

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
                newShape.setIsSelected(true);
                newShape.setX1(newX);
                newShape.setY1(newY);
                newShape.setSelectSpace(new Rectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH()));
                newShape.setIsMoved(true);
                newShape.setIsGroup(s.getIsGroup());


                StatusGrabber statusGrabber = new StatusGrabber();
                StatusObserver observer1 = new StatusObserver(statusGrabber);
                statusGrabber.setIsDeletedObserver(s, true);

                shapeArray.remove(s);
                shapeArray.add(newShape);

                su.clearCanvas(s.getPaintCanvasBase());


            }
        }

        new selectShape(callMouse);
        gp.getGroupLines(callMouse.getPaintCanvas());

        for (Shape sa : shapeArray){
            su.draw(sa);

            if(!undoArray.contains(sa)){
                undoArray.add(sa);}
        }








        //System.out.println("--------------MOVE---------------");
        //System.out.println("SHAPE "+ shapeArray);
        //System.out.println("UNDO " + undoArray);





    }

}
