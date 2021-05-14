package model.draw;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShapePlan;
import view.interfaces.PaintCanvasBase;

public class shapeBuilder implements IShapePlan {

    private ShapeType shapeType;
    private ShapeColor PrimaryColor;
    private ShapeColor SecondaryColor;
    private ShapeShadingType shapeShadingType;
    private PaintCanvasBase paintCanvas;
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;

    @Override
    public void setShapeType(ShapeType setShapeType) {
        shapeType = setShapeType;

    }

    public ShapeType getShapeType() {return shapeType;}

    @Override
    public void setPrimaryColor(ShapeColor setPrimaryColor) {
        PrimaryColor = setPrimaryColor;
    }

    public ShapeColor getPrimaryColor() {return PrimaryColor;}

    @Override
    public void setSecondaryColor(ShapeColor setSecondaryColor) {
        SecondaryColor = setSecondaryColor;
    }

    public ShapeColor getSecondaryColor() {return SecondaryColor;}

    @Override
    public void setShapeShadingType(ShapeShadingType setShapeShadingType) {
        shapeShadingType = setShapeShadingType;
    }

    public ShapeShadingType getShapeShadingType() {return shapeShadingType;}

    @Override
    public void setPaintCanvasBase(PaintCanvasBase setPaintCanvas) {
        paintCanvas = setPaintCanvas;
    }

    public PaintCanvasBase getPaintCanvasBase() {return paintCanvas;}

    @Override
    public void setX1(int setX1) {
        X1 = setX1;

    }

    public int getX1() {return X1;}

    @Override
    public void setX2(int setX2) {
        X2 = setX2;

    }

    public int getX2() {return X2;}

    @Override
    public void setY1(int setY1) {
        Y1 = setY1;

    }

    public int getY1() {return Y1;}

    @Override
    public void setY2(int setY2) {
        Y2 = setY2;

    }

    public int getY2() {return Y2;}
}
