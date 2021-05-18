package controller;

import model.draw.Shape;

import java.awt.*;

import static controller.createShape.shapeArray;

//import static controller.createShape.shapeArray;

public class selectShape {
    private Rectangle selectShapes;

    private int selectX;
    private int selectY;
    private int selectX2;
    private int selectY2;

    public selectShape(mouseHandler callMouse) {


        selectX = callMouse.getMouseX();
        selectY= callMouse.getMouseY();
        selectX2 = callMouse.getMouseX2();
        selectY2 = callMouse.getMouseY2();

        int pw = selectX2 - selectX;
        int ph = selectY2 - selectY;


        selectShapes = new Rectangle(selectX, selectY, pw, ph);

        for (Shape s: shapeArray){
            if(s.getSelectSpace().intersects(selectShapes)){
                s.setIsSelected(true);
                drawDashedLine(s, Color.BLACK);
            }
            else{
                s.setIsSelected(false);
                drawDashedLine(s, Color.WHITE);
                }
            }

    }

    public void drawDashedLine(Shape s, Color color) {
        Graphics2D graphics2D = s.getPaintCanvasBase().getGraphics2D();

        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
        graphics2D.drawRect(s.getX1() - 5, s.getY1() - 5, s.getPW() + 10, s.getPH() + 10);

    }
}

//CREATE ARRAY OF SHAPES
//USE PARAMETERS
//MARK AS TRUE IF INTERSECTED