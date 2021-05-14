package controller;

import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.draw.ellipse;
import model.draw.rectangle;
//import model.draw.shape;
import model.draw.shapeConstructor;
import model.draw.triangle;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class createShape {
    //public static ArrayList<shape> shapeArray = new ArrayList();
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

        this.paintCanvas = callMouse.getPaintCanvas();
        this.shapeType = callMouse.getShapeType();
        this.primaryColor = callMouse.getPrimaryColor();
        this.secondaryColor = callMouse.getSecondaryColor();
        this.shadeType = callMouse.getShadeType();
        this.X1 = callMouse.getMouseX();
        this.X2 = callMouse.getMouseX2();
        this.Y1 = callMouse.getMouseY();
        this.Y2 = callMouse.getMouseY2();
        shapeConstructor cs = new shapeConstructor(this);
        cs.buildShapePrimaryColor();
    }
    public PaintCanvasBase getPaintCanvasMaster() {return paintCanvas;}
    public ShapeType getShapeTypeMaster() {return shapeType;}
    public ShapeColor getPrimaryColorMaster() {return primaryColor;}
    public ShapeColor getSecondaryColorMaster() {return primaryColor;}
    public ShapeShadingType getShadeTypeMaster() {return shadeType;}
    public int getX1Master() {return X1;}
    public int getX2Master() {return X2;}
    public int getY1Master() {return Y1;}
    public int getY2Master() {return Y2;}
}



   /*
        if (shapeType == shapeType.RECTANGLE){
            new rectangle(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor, shadeType, secondaryColor);
        }

        if (shapeType == shapeType.ELLIPSE){
            new ellipse(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor, shadeType, secondaryColor);
        }

        if (shapeType == shapeType.TRIANGLE){
            new triangle(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor, shadeType, secondaryColor);
        }*/