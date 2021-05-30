package model.draw;

import model.interfaces.IShapeBuilder;
import model.interfaces.IShapePlan;


public class CloneFactory {


    public IShapePlan getClone(IShapePlan shapeToClone){
        return shapeToClone.makeCopy();
    }


}
