package controller;

import model.*;
import model.draw.*;
import model.draw.Shape;
import model.interfaces.IShapeBuilder;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;
import java.util.ArrayList;



public class createShape {

    //public static ArrayList<Shape> shapeArray = new ArrayList();


    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadeType;
    private MouseMode mode;
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;


    public createShape(mouseHandler callMouse) {

        this.mode = callMouse.getMouseMode();
        this.paintCanvas = callMouse.getPaintCanvas();
        this.shapeType = callMouse.getShapeType();
        this.primaryColor = callMouse.getPrimaryColor();
        this.secondaryColor = callMouse.getSecondaryColor();
        this.shadeType = callMouse.getShadeType();
        this.X1 = callMouse.getMouseX();
        this.X2 = callMouse.getMouseX2();
        this.Y1 = callMouse.getMouseY();
        this.Y2 = callMouse.getMouseY2();


        if (this.mode == mode.DRAW){
            new shapeSketch(this);
        }

        if (this.mode == mode.MOVE){
            new moveShape(callMouse, this);
        }

    }
    public PaintCanvasBase getPaintCanvasMaster() {return paintCanvas;}
    public ShapeType getShapeTypeMaster() {return shapeType;}
    public ShapeColor getPrimaryColorMaster() {return primaryColor;}
    public ShapeColor getSecondaryColorMaster() {return secondaryColor;}
    public ShapeShadingType getShadeTypeMaster() {return shadeType;}
    public int getX1Master() {return X1;}
    public int getX2Master() {return X2;}
    public int getY1Master() {return Y1;}
    public int getY2Master() {return Y2;}

}



