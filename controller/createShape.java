package controller;

import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.draw.ellipse;
import model.draw.rectangle;
import model.draw.shape;
import model.draw.triangle;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class createShape {

    public static ArrayList<shape> shapeArray = new ArrayList();

    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadeType;
    private MouseMode mode;
    private int mouseX;
    private int mouseX2;
    private int mouseY;
    private int mouseY2;


    public createShape(mouseHandler callMouse) {


        if (shapeType == shapeType.RECTANGLE){
            new rectangle(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor, shadeType, secondaryColor);
        }

        if (shapeType == shapeType.ELLIPSE){
            new ellipse(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor, shadeType, secondaryColor);
        }

        if (shapeType == shapeType.TRIANGLE){
            new triangle(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor, shadeType, secondaryColor);
        }

    }

}
