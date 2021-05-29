package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.draw.rectangle;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

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

    public void setShapeSelect (boolean shapeSelect);

    public void setSelectSpace (Rectangle selectSpace);

    public void setIsSelected(boolean isSelected);

    public void setPW(int pw);

    public void setPH(int ph);

    public void setIsGroup(boolean isGroup);

    public void setIsDeleted(boolean isDeleted);
}
