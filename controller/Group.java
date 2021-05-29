package controller;

import model.draw.Shape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static controller.createShape.shapeArray;

public class Group {

    int minX = 100000;
    int minY = 100000;
    int maxX = 0;
    int maxY = 0;
    int addPW = 0;
    int minPH = 0;
    PaintCanvasBase paintCanvas;


    public void group(PaintCanvasBase paintCanvas) {
        for (Shape sa : shapeArray) {
            if (sa.getIsSelected() == true) {
                sa.setIsGroup(true);
                getGroupLines(paintCanvas);
            }
        }
    }


    public void getGroupLines(PaintCanvasBase paintCanvas){
        for (Shape sa : shapeArray) {
            if (sa.getIsGroup() == true) {


                if (sa.getIsSelected() == true) {
                    sa.setIsGroup(true);
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

            drawDashedLine(minX, maxX, minY, maxY, addPW, minPH, paintCanvas);
        }


}





    public void drawDashedLine(int minX, int maxX, int minY, int maxY, int extraWid, int extraHeight, PaintCanvasBase pc){
        Graphics2D graphics2D = pc.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(minX - 5, minY - 5, (maxX - minX) + extraWid + 10, (maxY - minY) + extraHeight + 10);
    }
}
