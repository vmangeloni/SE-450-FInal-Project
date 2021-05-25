package controller;

import model.ShapeColor;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static model.ShapeColor.returnColor;

public class shapeUtility {

    private int setX1;
    private int setX2;
    private int setY1;
    private int setY2;
    private int setPW;
    private int setPH;

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

}
