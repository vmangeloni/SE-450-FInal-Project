package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface IShapePlan {

    public void setShapeType(ShapeType setShapeType);

    public void setPrimaryColor(ShapeColor setPrimaryColor);

    public void setSecondaryColor(ShapeColor setSecondaryColor);

    public void setShapeShadingType(ShapeShadingType setShapeShadingType);

    public void setPaintCanvasBase (PaintCanvasBase setPaintCanvas);

    public void setX1(int setX1);

    public void setX2(int setX2);

    public void setY1(int setY1);

    public void setY2(int setY2);

}
