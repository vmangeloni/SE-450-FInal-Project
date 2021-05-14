package model.draw;
import model.persistence.ApplicationState;


import model.interfaces.IShapeBuilder;

public class shapeConstructor implements IShapeBuilder {

    private shapeBuilder shapeBuilder;
    private ApplicationState appState;

    public shapeConstructor(){
        this.shapeBuilder = new shapeBuilder();
    }

    @Override
    public void buildShapeType() {

        //shapeBuilder.setShapeShadingType("test");

    }

    @Override
    public void buildShapePrimaryColor() {

    }

    @Override
    public void buildShapeSecondaryColor() {

    }

    @Override
    public void buildShadingType() {

    }

    @Override
    public void buildPaintCanvas() {

    }

    @Override
    public void buildX1() {

    }

    @Override
    public void buildX2() {

    }

    @Override
    public void buildY1() {

    }

    @Override
    public void buildY2() {

    }
}
