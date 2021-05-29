package controller;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.draw.Shape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static controller.createShape.shapeArray;
import static model.ShapeColor.WHITE;
import static model.ShapeColor.returnColor;

public class shapeUtility implements ICommand, IUndoable{

    private int setX1;
    private int setX2;
    private int setY1;
    private int setY2;
    private int setPW;
    private int setPH;

    public static ArrayList<Shape> undoArray = new ArrayList();

    public void shapeUtility(int X1, int X2, int Y1, int Y2) {
        this.setX1 = getShapeRecCoord(X1, X2, Y1, Y2)[0];
        this.setY1 = getShapeRecCoord(X1, X2, Y1, Y2)[1];
        this.setX2 = getShapeRecCoord(X1, X2, Y1, Y2)[2];
        this.setY2 = getShapeRecCoord(X1, X2, Y1, Y2)[3];
        this.setPW = getShapeRecCoord(X1, X2, Y1, Y2)[4];
        this.setPH = getShapeRecCoord(X1, X2, Y1, Y2)[5];

    }

    public int[] getShapeRecCoord (int X1, int X2, int Y1, int Y2) {

        int recCords[] = new int[6];

        if (X1 > X2 && Y1 > Y2){
            recCords[0] = X2;
            recCords[1] = Y2;
            recCords[2] = X1;
            recCords[3] = Y1;
            recCords[4] = X1 - X2;
            recCords[5] = Y1 - Y2;
        }

        else if (X1 < X2 && Y1 > Y2){
            recCords[0] = X1;
            recCords[1] = Y2;
            recCords[2] = X2;
            recCords[3] = Y2;
            recCords[4] = X2 - X1;
            recCords[5] = Y1 - Y2;
        }

        else if (X1 > X2 && Y1 < Y2){
            recCords[0] = X2;
            recCords[1] = Y1;
            recCords[2] = X1;
            recCords[3] = Y2;
            recCords[4] = X1 - X2;
            recCords[5] = Y2 - Y1;
        }

        else {
            recCords[0] = X1;
            recCords[1] = Y1;
            recCords[2] = X2;
            recCords[3] = Y2;
            recCords[4] = X2 - X1;
            recCords[5] = Y2 - Y1;
        }


        return recCords;
    }

    public int getX1Utility() {return setX1;}
    public int getX2Utility() {return setX2;}
    public int getY1Utility() {return setY1;}
    public int getY2Utility() {return setY2;}
    public int getPWUtility() {return setPW;}
    public int getPHUtility() {return setPH;}


    public void draw(Shape newShape) {
        if (newShape.getShapeType() == ShapeType.RECTANGLE) {

            if (newShape.getShapeShadingType() == ShapeShadingType.OUTLINE) {
                drawOutlineRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
            }

            if(newShape.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
                drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                }

            if(newShape.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                drawOutlineRectangle(newShape.getX1(), newShape.getX2(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getSecondaryColor());
                }

        }

        if (newShape.getShapeType() == ShapeType.ELLIPSE) {
            if (newShape.getShapeShadingType() == ShapeShadingType.OUTLINE) {
                drawOutlineEllipse(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
            }
            if (newShape.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
                drawFilledEllipse(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
            }
            if (newShape.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                drawFilledEllipse(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                drawOutlineEllipse(newShape.getX1(), newShape.getX2(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getSecondaryColor());
            }

        }
    }

    public void drawOutlineRectangle(int X1, int Y1, int pw, int ph, PaintCanvasBase paintCanvasBase, ShapeColor color) {

        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.drawRect(X1, Y1, pw, ph);
    }

    public void drawFilledRectangle(int X1, int Y1, int pw, int ph, PaintCanvasBase paintCanvasBase, ShapeColor color)  {

        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.fillRect(X1, Y1, pw, ph);
    }

    public void drawOutlineEllipse(int X1, int Y1, int pw, int ph, PaintCanvasBase paintCanvasBase, ShapeColor color) {

        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.drawOval(X1, Y1, pw, ph);
    }

    public void drawFilledEllipse(int X1, int Y1, int pw, int ph, PaintCanvasBase paintCanvasBase, ShapeColor color) {

        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.fillOval(X1, Y1, pw, ph);
    }







    public void clearCanvas(PaintCanvasBase paintCanvasBase){
        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(WHITE));
        graphics2D.fillRect(0, 0, paintCanvasBase.getWidth(), paintCanvasBase.getHeight());


    }

    @Override
    public void execute() throws IOException {
        CommandHistory.add(this);
        System.out.println("EXECUTE!!!");
    }

    @Override
    public void undo() {
        System.out.println("UNDO!!!");

    }

    @Override
    public void redo() {
        System.out.println("REDO!!!");

    }
}


