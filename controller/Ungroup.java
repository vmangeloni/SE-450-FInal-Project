package controller;

import model.draw.Shape;
import model.draw.ShapeHolder;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;



public class Ungroup {
    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;



    public void ungroup(PaintCanvasBase paintCanvas, ApplicationState appState) {

        shapeUtility su = new shapeUtility();
        mouseHandler callMouse = new mouseHandler(paintCanvas, appState);
        ShapeHolder SAL = ShapeHolder.getInstance();


        for (Shape sa : SAL.getSA()) {
            if(sa.getIsGroup() == true){
                sa.setIsSelected(true);
                sa.setIsGroup(false);
                sa.setIsMoved(true);
            }
        }

        su.clearCanvas(paintCanvas);

        for (Shape sa : SAL.getSA()){
            su.draw(sa);}
        new selectShape(callMouse);

    }
}

