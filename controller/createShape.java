package controller;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.draw.ellipse;
import model.draw.rectangle;
import model.draw.triangle;
import model.interfaces.IBuildShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class createShape {


    private PaintCanvasBase paintCanvas;

    public createShape(ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor,
                       ShapeShadingType shadeType, int mouseX, int mouseY, int mouseX2, int mouseY2,
                       PaintCanvasBase paintCanvas) {


        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        if (shapeType == shapeType.RECTANGLE){
            new rectangle(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor);
        }

        if (shapeType == shapeType.ELLIPSE){
            new ellipse(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor);
        }

        if (shapeType == shapeType.TRIANGLE){
            new triangle(mouseX, mouseY, mouseX2, mouseY2, paintCanvas, primaryColor);
        }


    }

}
