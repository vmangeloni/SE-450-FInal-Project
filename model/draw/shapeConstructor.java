package model.draw;


import controller.createShape;
import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShapeBuilder;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class shapeConstructor implements IShapeBuilder {

    private shape shape;
    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadeType;
    private MouseMode mode;
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;



    public shapeConstructor(createShape cs){
        this.shape = new shape();
        this.paintCanvas = cs.getPaintCanvasMaster();
        this.shapeType = cs.getShapeTypeMaster();
        this.primaryColor = cs.getPrimaryColorMaster();
        this.secondaryColor = cs.getSecondaryColorMaster();
        this.shadeType = cs.getShadeTypeMaster();
        this.X1 = cs.getX1Master();
        this.X2 = cs.getX2Master();
        this.Y1 = cs.getY1Master();
        this.Y2 = cs.getY2Master();
    }

    @Override
    public void buildShapeType() {
        final ShapeType shapeType = this.shapeType;
    }

    @Override
    public void buildShapePrimaryColor() {
        final ShapeColor primaryColor = this.primaryColor;
    }

    @Override
    public void buildShapeSecondaryColor() {
        final ShapeColor secondaryColor = this.secondaryColor;
    }

    @Override
    public void buildShadingType() {
        final ShapeShadingType shadeType = this.shadeType;
    }

    @Override
    public void buildPaintCanvas() {
        final PaintCanvasBase paintCanvasBase = this.paintCanvas;
    }

    @Override
    public void buildX1() {
        final int X1 = this.X1;

    }

    @Override
    public void buildX2() {
        final int X2 = this.X2;

    }

    @Override
    public void buildY1() {
        final int Y1 = this.Y1;
    }

    @Override
    public void buildY2() {
        final int Y2 = this.Y2;
    }
}
