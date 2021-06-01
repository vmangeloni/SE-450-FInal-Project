package controller;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.draw.Shape;
import model.draw.ShapeHolder;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


import static model.ShapeColor.WHITE;
import static model.ShapeColor.returnColor;

public class shapeUtility implements ICommand, IUndoable{

    private int setX1;
    private int setX2;
    private int setY1;
    private int setY2;
    private int setPW;
    private int setPH;


    int minX = 100000;
    int minY = 100000;
    int maxX = 0;
    int maxY = 0;
    int addPW = 0;
    int minPH = 0;

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
                System.out.println(newShape.getSecondaryColor());
            }

            if(newShape.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
                drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                }

            if(newShape.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                drawOutlineRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getSecondaryColor());
                System.out.println(newShape.getSecondaryColor());
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
                drawOutlineEllipse(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getSecondaryColor());
            }
        }

        if (newShape.getShapeType() == ShapeType.TRIANGLE){
            if (newShape.getShapeShadingType() == ShapeShadingType.OUTLINE) {
                drawOutlineTriangle(newShape.getX1(), newShape.getY1(), newShape.getX2(), newShape.getY2(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
            }
            if (newShape.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
                drawFilledTriangle(newShape.getX1(), newShape.getY1(), newShape.getX2(), newShape.getY2(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
            }
            if (newShape.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                drawFilledTriangle(newShape.getX1(), newShape.getY1(), newShape.getX2(), newShape.getY2(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                drawOutlineTriangle(newShape.getX1(), newShape.getY1(), newShape.getX2(), newShape.getY2(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
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

    public void drawFilledTriangle(int X1, int Y1, int X2, int Y2, PaintCanvasBase paintCanvasBase, ShapeColor color) {

        int [] triX = new int[] {X2, X1, X1};
        int [] triY = new int[] {Y2, Y2, Y1};

        int[] drawX = new int[] {triX[0], triX[1], triX[2]};
        int[] drawY = new int[] {triY[0], triY[1], triY[2]};

        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.fillPolygon(drawX, drawY, 3);
    }

    public void drawOutlineTriangle(int X1, int Y1, int X2, int Y2, PaintCanvasBase paintCanvasBase, ShapeColor color) {

        int [] triX = new int[] {X2, X1, X1};
        int [] triY = new int[] {Y2, Y1, Y1};

        int[] drawX = new int[] {triX[0], triX[1], triX[2]};
        int[] drawY = new int[] {triY[0], triY[1], triY[2]};

        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.drawPolygon(drawX, drawY, 3);
    }


    public void clearCanvas(PaintCanvasBase paintCanvasBase){
        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
        graphics2D.setColor(returnColor(WHITE));
        graphics2D.fillRect(0, 0, paintCanvasBase.getWidth(), paintCanvasBase.getHeight());
    }


    public void drawGroupLines(ShapeHolder SAL, PaintCanvasBase paintCanvas, mouseHandler cMouse) {
        for (Shape sa : SAL.getSA()) {
            if (sa.getIsGroup() == true) {

                if (sa.getSelectSpace().getX() < minX) {
                    minX = (int) sa.getSelectSpace().getX();
                }

                if (sa.getSelectSpace().getY() < minY) {
                    minY = (int) sa.getSelectSpace().getY();
                    minPH = (int) sa.getSelectSpace().getHeight();

                }

                if (sa.getSelectSpace().getX() > maxX) {
                    maxX = (int) sa.getSelectSpace().getX();
                    addPW = (int) sa.getSelectSpace().getWidth();
                }

                if (sa.getSelectSpace().getY() > maxY) {
                    maxY = (int) sa.getSelectSpace().getY();
                }

                if (sa.getSelectSpace().getHeight() > minPH) {
                    minPH = (int) sa.getSelectSpace().getHeight();
                }

            }
        }

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(minX - 5, minY - 5, (maxX - minX) + addPW + 10, (maxY - minY) + minPH + 10);
    }


    @Override
    public void execute() throws IOException {}

    @Override
    public void undo() {}

    @Override
    public void redo() {}
}


