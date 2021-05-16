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

    private Shape shape;
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
        this.shape = new Shape();
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
        final ShapeType ST = this.shapeType;
        shape.setShapeType(ST);
    }

    @Override
    public void buildShapePrimaryColor() {
        final ShapeColor PC = this.primaryColor;
        shape.setPrimaryColor(PC);
    }

    @Override
    public void buildShapeSecondaryColor() {
        final ShapeColor SC = this.secondaryColor;
        shape.setSecondaryColor(SC);
    }

    @Override
    public void buildShadingType() {
        final ShapeShadingType sst = this.shadeType;
        shape.setShapeShadingType(sst);
    }

    @Override
    public void buildPaintCanvas() {
        final PaintCanvasBase paintCanvasBase = this.paintCanvas;
        shape.setPaintCanvasBase(paintCanvasBase);
    }

    @Override
    public void buildX1() {
        final int x1 = this.X1;
        shape.setX1(x1);

    }

    @Override
    public void buildX2() {
        final int x2 = this.X2;
        shape.setX1(x2);

    }

    @Override
    public void buildY1() {
        final int y1 = this.Y1;
        shape.setY1(y1);
    }

    @Override
    public void buildY2() {
        final int y2 = this.Y2;
        shape.setY2(y2);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }
}
