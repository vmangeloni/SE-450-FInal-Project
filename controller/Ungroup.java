package controller;

import model.draw.Shape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import static controller.createShape.shapeArray;




public class Ungroup {
    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;



    public void ungroup(PaintCanvasBase paintCanvas, ApplicationState appState) {

        shapeUtility su = new shapeUtility();
        mouseHandler callMouse = new mouseHandler(paintCanvas, appState);


        for (Shape sa : shapeArray) {
            if(sa.getIsGroup() == true){
                sa.setIsSelected(true);
                sa.setIsGroup(false);
                sa.setIsMoved(true);
            }
        }

        su.clearCanvas(paintCanvas);

        for (Shape sa : shapeArray){
            su.draw(sa);}
        new selectShape(callMouse);

    }
}

