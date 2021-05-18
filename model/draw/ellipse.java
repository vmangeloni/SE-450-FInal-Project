package model.draw;

import model.ShapeColor;
import model.ShapeType;
import model.ShapeShadingType;
import model.interfaces.IShapeBuilder;
import view.interfaces.PaintCanvasBase;

//import static controller.createShape.shapeArray;
import static model.ShapeColor.returnColor;

import java.awt.*;

public class ellipse {

    private Rectangle selectSpace;

    public ellipse(IShapeBuilder newShape) {

        ShapeBuilder shapeBuilder = new ShapeBuilder(newShape);
        shapeBuilder.makeShape();
        Shape nwSPE = shapeBuilder.getShape();


        if(nwSPE.getShapeShadingType() == ShapeShadingType.OUTLINE) {
            drawOutlineEllipse(nwSPE, nwSPE.getPrimaryColor()); }

        if(nwSPE.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
            drawFilledEllipse(nwSPE, nwSPE.getPrimaryColor()); }

        if(nwSPE.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            drawFilledEllipse(nwSPE, nwSPE.getPrimaryColor());
            drawOutlineEllipse(nwSPE, nwSPE.getSecondaryColor());}
    }

    public void drawOutlineEllipse(Shape nwSPE, ShapeColor color) {

        int pw = nwSPE.getX2() - nwSPE.getX1();
        int ph = nwSPE.getY2() - nwSPE.getY1();

        selectSpace = new Rectangle(nwSPE.getX1(), nwSPE.getY1(), pw, ph);

        Graphics2D graphics2D = nwSPE.getPaintCanvasBase().getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.drawOval(nwSPE.getX1(), nwSPE.getY1(), pw, ph);
    }

    public void drawFilledEllipse(Shape nwSPE, ShapeColor color) {

        int pw = nwSPE.getX2() - nwSPE.getX1();
        int ph = nwSPE.getY2() - nwSPE.getY1();

        selectSpace = new Rectangle(nwSPE.getX1(), nwSPE.getY1(), pw, ph);


        Graphics2D graphics2D = nwSPE.getPaintCanvasBase().getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.fillOval(nwSPE.getX1(), nwSPE.getY1(), pw, ph);
    }
}













/*
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private int pw;
    private int ph;
    private PaintCanvasBase paintCanvas;
    private final ShapeColor primColor;
    private final ShapeColor secColor;
    private final ShapeShadingType getShadeType;
    private Rectangle selectSpace;


    public ellipse (int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                    ShapeColor primaryColor, ShapeShadingType getShadeType, ShapeColor secColor){
        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;
        this.getShadeType = getShadeType;
        this.primColor = primaryColor;
        this.secColor = secColor;
        this.pw = mouseX2 - mouseX;
        this.ph = mouseY2 - mouseY;



        if(getShadeType == getShadeType.OUTLINE){
            drawOutlineEllipse(returnColor(primColor));
            createShape();
        }

        if(getShadeType == getShadeType.FILLED_IN){
            drawFilledEllipse(returnColor(primColor));
            createShape();
        }

        if(getShadeType == getShadeType.OUTLINE_AND_FILLED_IN){


            drawFilledEllipse(returnColor(primColor));
            drawOutlineEllipse(returnColor(secColor));
            createShape();
        }


    }

    public void drawOutlineEllipse(Color chooseColor){
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        selectSpace = new Rectangle(X1, X2, X2 - X1, Y2 - Y1);

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.drawOval(X1, Y1, pw, ph);
    }

    public void drawFilledEllipse(Color chooseColor){
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        selectSpace = new Rectangle(X1, X2, X2 - X1, Y2 - Y1);

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.fillOval(X1, Y1, pw, ph);
    }

    public void createShape() {
        /*
        shape x = new shape(paintCanvas, getShadeType, returnColor(primColor), returnColor(secColor),
                ShapeType.ELLIPSE, X1, X2, new int[]{0, 0, 0}, new int[]{0, 0, 0}, pw, ph, selectSpace, false);
        shapeArray.add(x);*/

