package model.interfaces;

import model.draw.Shape;

import java.awt.*;

public interface IShapeBuilder {

    public void buildShapeType();

    public void buildShapePrimaryColor();

    public void buildShapeSecondaryColor();

    public void buildShadingType();

    public void buildPaintCanvas();

    public void buildX1();

    public void buildX2();

    public void buildY1();

    public void buildY2();

    public void buildIsSelected();

    public void buildSelectSpace();

    public void buildPH();

    public void buildPW();

    public void buildIsDeleted();

    public void buildIsMoved();

    public Shape getShape();


    public void buildIsGroup();
}
