package model.draw;

import controller.shapeUtility;
import model.interfaces.IShapeBuilder;

import model.ShapeColor;
import model.ShapeShadingType;
import view.interfaces.PaintCanvasBase;


import java.awt.*;

import static controller.createShape.shapeArray;
import static model.ShapeColor.returnColor;


public class rectangle {

    private Rectangle selectSpace;

    public rectangle(Shape nwSPE) {

        shapeUtility su = new shapeUtility();
        su.shapeUtility(nwSPE.getX1(), nwSPE.getX2(), nwSPE.getY1(), nwSPE.getY2());

        nwSPE.setX1(su.getX1Utility());
        nwSPE.setY1(su.getY1Utility());
        nwSPE.setX2(su.getX2Utility());
        nwSPE.setY2(su.getY2Utility());
        nwSPE.setPW(su.getPWUtility());
        nwSPE.setPH(su.getPHUtility());

        System.out.println(nwSPE.getIsDeleted());

        selectSpace = new Rectangle(nwSPE.getX1(), nwSPE.getY1(), nwSPE.getPW(), nwSPE.getPH());
        nwSPE.setSelectSpace(selectSpace);

        if(nwSPE.getShapeShadingType() == ShapeShadingType.OUTLINE) {
            su.drawOutlineRectangle(nwSPE.getX1(), nwSPE.getY1(), nwSPE.getPW(), nwSPE.getPH(),
                    nwSPE.getPaintCanvasBase(), nwSPE.getPrimaryColor());
            addShape(nwSPE); }

        if(nwSPE.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
            su.drawFilledRectangle(nwSPE.getX1(), nwSPE.getY1(), nwSPE.getPW(), nwSPE.getPH(),
                    nwSPE.getPaintCanvasBase(), nwSPE.getPrimaryColor());
            addShape(nwSPE);}

        if(nwSPE.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            su.drawFilledRectangle(nwSPE.getX1(), nwSPE.getY1(), nwSPE.getPW(), nwSPE.getPH(),
                    nwSPE.getPaintCanvasBase(), nwSPE.getPrimaryColor());
            su.drawOutlineRectangle(nwSPE.getX1(), nwSPE.getX2(), nwSPE.getPW(), nwSPE.getPH(),
                    nwSPE.getPaintCanvasBase(), nwSPE.getSecondaryColor());
            addShape(nwSPE);}

    }

    public void addShape(Shape nwSPE) {
        shapeArray.add(nwSPE);
    }




}