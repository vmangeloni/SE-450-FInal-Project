package controller;

import model.draw.Shape;
import model.draw.ShapeHolder;

import java.awt.*;

//import static controller.createShape.shapeArray;



public class selectShape {
    private Rectangle selectShapes;

    private int selectX;
    private int selectY;
    private int selectX2;
    private int selectY2;
    private int selectPW;
    private int selectPH;


    public selectShape(mouseHandler callMouse) {


        //DRAG
        selectX = callMouse.getMouseX();
        selectY = callMouse.getMouseY();
        selectX2 = callMouse.getMouseX2();
        selectY2 = callMouse.getMouseY2();

        shapeUtility su = new shapeUtility();
        su.shapeUtility(selectX, selectX2, selectY, selectY2);
        ShapeHolder SAL = ShapeHolder.getInstance();

        selectX = su.getX1Utility();
        selectY = su.getY1Utility();
        selectX2 = su.getX2Utility();
        selectY2 = su.getY2Utility();
        selectPW = su.getPWUtility();
        selectPH = su.getPHUtility();

        selectShapes = new Rectangle(selectX, selectY, selectPW + 1, selectPH + 1);


        for (Shape s: SAL.getSA()){
            if(s.getSelectSpace().intersects(selectShapes) || s.getIsMoved() == true){

                if (s.getIsDeleted() == false) {
                    s.setIsSelected(true);

                    if(s.getIsGroup() == false){
                        drawDashedLine(s, Color.BLACK);}
                    s.setIsMoved(false);
                }
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

