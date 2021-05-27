package controller;

import model.ShapeShadingType;
import model.draw.Shape;

import static controller.Copy.copyArray;
import static controller.createShape.shapeArray;

public class Paste {

    shapeUtility su = new shapeUtility();


    public void paste(){

        for(Shape newShape: copyArray){

            if(newShape.getShapeShadingType() == ShapeShadingType.OUTLINE) {
                su.drawOutlineRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                shapeArray.add(newShape); }

            if(newShape.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
                su.drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                shapeArray.add(newShape);}

            if(newShape.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
                su.drawFilledRectangle(newShape.getX1(), newShape.getY1(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getPrimaryColor());
                su.drawOutlineRectangle(newShape.getX1(), newShape.getX2(), newShape.getPW(), newShape.getPH(),
                        newShape.getPaintCanvasBase(), newShape.getSecondaryColor());
                shapeArray.add(newShape);}
        }

    }
}
