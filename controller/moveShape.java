package controller;


import model.draw.*;
import model.draw.Shape;
import java.awt.*;
import java.util.ArrayList;

import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;


public class moveShape {

    public static ArrayList<Shape> MoveShapeArray = new ArrayList();

    shapeUtility su = new shapeUtility();
    Group gp = new Group();

    Shape S;
    int maxX = 0;
    int maxY = 0;

    public moveShape(mouseHandler callMouse, createShape CS) {

        for (Shape sa : shapeArray) {
            if (sa.getIsSelected() == true || sa.getIsGroup() == true) {
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
                System.out.println(s);

                CloneFactory shapeMaker = new CloneFactory();
                Shape newShape = (Shape) shapeMaker.getClone(s);

                int DiffX = callMouse.getMouseX() - s.getX1();
                int DiffY = callMouse.getMouseY() - s.getY1();

                int additionalX = s.getX1() - maxX;
                int additionalY = s.getY1() - maxY;
                int newX = s.getX1() + DiffX + additionalX;
                int newY = s.getY1() + DiffY + additionalY;

                newShape.setX1(newX);
                newShape.setY1(newY);
                newShape.setSelectSpace(new Rectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH()));
                newShape.setIsMoved(true);

                if(s.getIsGroup() == false){
                    newShape.setIsSelected(true);
                }
                else{
                    newShape.setIsGroup(true);
                }

                System.out.println("--------BREAK---------------");
                System.out.println(newShape.getIsSelected());
                System.out.println(newShape.getIsGroup());

                StatusGrabber statusGrabber = new StatusGrabber();
                StatusObserver observer1 = new StatusObserver(statusGrabber);
                statusGrabber.setIsDeletedObserver(s, true);

                shapeArray.remove(s);
                shapeArray.add(newShape);

                su.clearCanvas(s.getPaintCanvasBase());
            }
        }

        new selectShape(callMouse);
        gp.getGroupLines(callMouse.getPaintCanvas(), callMouse);

        for (Shape sa : shapeArray){
            su.draw(sa);

            if(!undoArray.contains(sa)){
                undoArray.add(sa);}
        }




        /*
        for (Shape sa : shapeArray) {
            System.out.println(sa);
        }

         */










        //System.out.println("--------------MOVE---------------");
        //System.out.println("SHAPE "+ shapeArray);
        //System.out.println("UNDO " + undoArray);





    }

}
