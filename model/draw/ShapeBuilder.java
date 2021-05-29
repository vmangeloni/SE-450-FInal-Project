package model.draw;

import model.interfaces.IShapeBuilder;

public class ShapeBuilder {

    private IShapeBuilder ishapeBuilder;

    public ShapeBuilder(IShapeBuilder ishapeBuilder){
        this.ishapeBuilder = ishapeBuilder;
    }

    public Shape getShape() {
        return this.ishapeBuilder.getShape();
    }

    public void makeShape(){
        this.ishapeBuilder.buildShapeType();
        this.ishapeBuilder.buildPaintCanvas();
        this.ishapeBuilder.buildShapePrimaryColor();
        this.ishapeBuilder.buildShapeSecondaryColor();
        this.ishapeBuilder.buildShadingType();
        this.ishapeBuilder.buildX1();
        this.ishapeBuilder.buildY1();
        this.ishapeBuilder.buildX2();
        this.ishapeBuilder.buildY2();
        this.ishapeBuilder.buildIsSelected();
        this.ishapeBuilder.buildSelectSpace();
        this.ishapeBuilder.buildPW();
        this.ishapeBuilder.buildPH();
        this.ishapeBuilder.buildIsMoved();
        this.ishapeBuilder.buildIsDeleted();
        this.ishapeBuilder.buildIsGroup();
    }






}
