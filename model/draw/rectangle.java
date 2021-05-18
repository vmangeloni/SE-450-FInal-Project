package model.draw;

import model.interfaces.IShapeBuilder;

import model.ShapeColor;
import model.ShapeShadingType;


import java.awt.*;

import static controller.createShape.shapeArray;
import static model.ShapeColor.returnColor;


public class rectangle {

    private Rectangle selectSpace;

    public rectangle(IShapeBuilder newShape) {



        ShapeBuilder shapeBuilder = new ShapeBuilder(newShape);
        shapeBuilder.makeShape();
        Shape nwSPE = shapeBuilder.getShape();


        if(nwSPE.getShapeShadingType() == ShapeShadingType.OUTLINE) {
            drawOutlineRectangle(nwSPE, nwSPE.getPrimaryColor());
            addShape(nwSPE); }

        if(nwSPE.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
            drawFilledRectangle(nwSPE, nwSPE.getPrimaryColor());
            addShape(nwSPE);}

        if(nwSPE.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            drawFilledRectangle(nwSPE, nwSPE.getPrimaryColor());
            drawOutlineRectangle(nwSPE, nwSPE.getSecondaryColor());
            addShape(nwSPE);}
    }

    public void drawOutlineRectangle(Shape nwSPE, ShapeColor color) {

        int pw = nwSPE.getX2() - nwSPE.getX1();
        int ph = nwSPE.getY2() - nwSPE.getY1();

        nwSPE.setPW(pw);
        nwSPE.setPH(ph);

        selectSpace = new Rectangle(nwSPE.getX1(), nwSPE.getY1(), pw, ph);
        nwSPE.setSelectSpace(selectSpace);

        Graphics2D graphics2D = nwSPE.getPaintCanvasBase().getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.drawRect(nwSPE.getX1(), nwSPE.getY1(), pw, ph);
    }

    public void drawFilledRectangle(Shape nwSPE, ShapeColor color) {

        int pw = nwSPE.getX2() - nwSPE.getX1();
        int ph = nwSPE.getY2() - nwSPE.getY1();

        nwSPE.setPW(pw);
        nwSPE.setPH(ph);

        selectSpace = new Rectangle(nwSPE.getX1(), nwSPE.getY1(), pw, ph);
        nwSPE.setSelectSpace(selectSpace);

        Graphics2D graphics2D = nwSPE.getPaintCanvasBase().getGraphics2D();
        graphics2D.setColor(returnColor(color));
        graphics2D.fillRect(nwSPE.getX1(), nwSPE.getY1(), pw, ph);
    }

    public void addShape(Shape nwSPE) {
        shapeArray.add(nwSPE);
    }




}



/*
public class rectangle {


    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private PaintCanvasBase paintCanvas;
    private final ShapeColor primColor;
    private final ShapeColor secColor;
    private final ShapeShadingType getShadeType;
    private int pw;
    private int ph;
    private Rectangle selectSpace;







    public rectangle(int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                     ShapeColor primaryColor, ShapeShadingType getShadeType, ShapeColor secColor) {

        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;
        this.primColor = primaryColor;
        this.getShadeType = getShadeType;
        this.secColor = secColor;
        this.pw = pw;
        this.ph = ph;


        if(getShadeType == getShadeType.OUTLINE){
            drawOutlineRectangle(returnColor(primColor));
            //createShape();

        }

        if(getShadeType == getShadeType.FILLED_IN){
            drawFilledRectangle(returnColor(primColor));
            //createShape();
        }

        if(getShadeType == getShadeType.OUTLINE_AND_FILLED_IN){

            drawFilledRectangle(returnColor(primColor));
            drawOutlineRectangle(returnColor(secColor));
            //createShape();
        }



    }

    public void drawOutlineRectangle(Color chooseColor) {
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        selectSpace = new Rectangle(X1, X2, X2 - X1, Y2 - Y1);

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.drawRect(X1, Y1, pw, ph);



    }

    public void drawFilledRectangle(Color chooseColor) {
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        selectSpace = new Rectangle(X1, X2, X2 - X1, Y2 - Y1);

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.fillRect(X1, Y1, pw, ph);


    }

    /*
    public void createShape() {

        Shape x = new Shape(paintCanvas, getShadeType, returnColor(primColor), returnColor(secColor),
                ShapeType.RECTANGLE, X1, X2, new int[]{0, 0, 0}, new int[]{0, 0, 0}, pw, ph, selectSpace, false);
        shapeArray.add(x);


    }
    */




