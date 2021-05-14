/*

package model.draw;

import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static controller.createShape.shapeArray;

public class shapeOLD {



    public PaintCanvasBase paintCanvas;
    public ShapeType shapeType;
    public Color primaryColor;
    public Color secondaryColor;
    public ShapeShadingType shadingType;
    public int X1;
    public int X2;
    public int Y1;
    public int Y2;

    public int[] triX;
    public int[] triY;

    public int pw;
    public int ph;
    public Rectangle selectSpace;

    public boolean shapeSelect;


    public shape(PaintCanvasBase paintCanvas, ShapeShadingType shadeType, Color primaryColor, Color secondaryColor,
                 ShapeType shapeType, int x1, int x2, int[] ints, int[] ints1, int pw, int ph,
                 Rectangle selectSpace, boolean select) {

        this.paintCanvas = paintCanvas;
        this.shapeType = shapeType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadeType;
        this.X1 = x1;
        this.X2 = x2;
        this.Y1 = Y1;
        this.Y2 = Y2;
        this.pw = pw;
        this.ph = ph;
        this.triX = ints;
        this.triY = ints1;
        this.selectSpace = selectSpace;
        this.shapeSelect = select;



    }

    public void selectUpdate (boolean value) {this.shapeSelect = value;}

    public void add(shapeBuilder shape){
        shapeArray.add((model.draw.shape) shape);
    }
}


*/