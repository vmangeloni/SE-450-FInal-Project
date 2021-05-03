

package model.draw;

import controller.mouseHandler;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class shape {

    protected PaintCanvasBase paintCanvas;
    protected ShapeType shapeType;
    protected Color primaryColor;
    protected Color secondaryColor;
    protected ShapeShadingType shadingType;
    protected int X1;
    protected int X2;
    protected int Y1;
    protected int Y2;

    protected int[] triX;
    protected int[] triY;

    protected int pw;
    protected int ph;

    protected boolean select = false;


    public shape(PaintCanvasBase paintCanvas, ShapeShadingType shadeType, Color primaryColor, Color secondaryColor,
                 ShapeType shapeType, int x1, int x2, int[] ints, int[] ints1, int pw, int ph) {
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


    }
}


