package controller;


import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseHandler implements MouseListener {


    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadeType;
    private MouseMode mode;

    private int mouseX;
    private int mouseY;
    private int mouseX2;
    private int mouseY2;


    public mouseHandler(PaintCanvasBase paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }



    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        this.mouseX2 = e.getX();
        this.mouseY2 = e.getY();

        int pw = mouseX2 - mouseX;
        int ph = mouseY2 - mouseY;

        this.shapeType = appState.getActiveShapeType();
        this.primaryColor = appState.getActivePrimaryColor();
        this.secondaryColor = appState.getActiveSecondaryColor();
        this.shadeType = appState.getActiveShapeShadingType();
        this.mode = appState.getActiveMouseMode();


        if (this.mode == mode.DRAW){
            new createShape(this.shapeType, this.primaryColor, this.secondaryColor, this.shadeType,
                    this.mouseX,this.mouseY,this.mouseX2,this.mouseY2, this.paintCanvas);
        }

        if (this.mode == mode.SELECT){
            new selectShape(this);
        }

        if (this.mode == mode.MOVE){
            new selectShape(this);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    public int getMouseX() {return this.mouseX;}
    public int getMouseY() {return this.mouseY;}
    public int getMouseX2() {return this.mouseX2;}
    public int getMouseY2() {return this.mouseY2;}

}
