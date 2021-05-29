package model.draw;

//import controller.CommandHistory;
import controller.CommandHistory;
import controller.ICommand;
import controller.createShape;
import controller.shapeUtility;
import model.interfaces.IShapeBuilder;

import model.ShapeColor;
import model.ShapeShadingType;
import view.interfaces.PaintCanvasBase;


import java.awt.*;

import static controller.createShape.shapeArray;
import static controller.shapeUtility.undoArray;


public class rectangle  {

    private Rectangle selectSpace;

    public rectangle(createShape CS) {

        IShapeBuilder newShape = new shapeConstructor(CS);
        ShapeBuilder shapeBuilder = new ShapeBuilder(newShape);
        shapeBuilder.makeShape();
        Shape nwSPE = shapeBuilder.getShape();

        shapeUtility su = new shapeUtility();
        su.shapeUtility(nwSPE.getX1(), nwSPE.getX2(), nwSPE.getY1(), nwSPE.getY2());

        nwSPE.setX1(su.getX1Utility());
        nwSPE.setY1(su.getY1Utility());
        nwSPE.setX2(su.getX2Utility());
        nwSPE.setY2(su.getY2Utility());
        nwSPE.setPW(su.getPWUtility());
        nwSPE.setPH(su.getPHUtility());

        selectSpace = new Rectangle(nwSPE.getX1(), nwSPE.getY1(), nwSPE.getPW(), nwSPE.getPH());
        nwSPE.setSelectSpace(selectSpace);

        su.draw(nwSPE);
        addShape(nwSPE);
        }

    public void addShape(Shape nwSPE) {
        shapeArray.add(nwSPE);

        if(!undoArray.contains(nwSPE)){
            undoArray.add(0, nwSPE);}

        /*
        System.out.println("--------------DRAW---------------");
        System.out.println("SHAPE "+ shapeArray);
        System.out.println("UNDO " + undoArray); */
    }


}