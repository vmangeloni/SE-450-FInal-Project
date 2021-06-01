package controller;

import model.draw.Shape;
import model.draw.ShapeHolder;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

//import static controller.createShape.shapeArray;


public class Group {

    int minX = 100000;
    int minY = 100000;
    int maxX = 0;
    int maxY = 0;
    int addPW = 0;
    int minPH = 0;

    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;


    shapeUtility su = new shapeUtility();
    ShapeHolder SAL = ShapeHolder.getInstance();


    public void group(PaintCanvasBase paintCanvas, ApplicationState applicationState) {

        mouseHandler callMouse = new mouseHandler(paintCanvas, applicationState);

        for (Shape sa : SAL.getSA()) {
            if (sa.getIsSelected() == true || sa.getIsGroup() == true) {
                sa.setIsSelected(true);
                sa.setIsGroup(true);
                sa.setIsMoved(false);


            }
        }

        getGroupLines(paintCanvas, callMouse);

    }


    public void getGroupLines(PaintCanvasBase paintCanvas, mouseHandler cMouse){
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
        new selectShape(cMouse);
        drawDashedLine(minX, maxX, minY, maxY, addPW, minPH, paintCanvas);
    }



    public void drawDashedLine(int minX, int maxX, int minY, int maxY, int extraWid, int extraHeight, PaintCanvasBase pc){
        Graphics2D graphics2D = pc.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(minX - 5, minY - 5, (maxX - minX) + extraWid + 10, (maxY - minY) + extraHeight + 10);
    }
}
