package model.draw;

import controller.shapeUtility;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.Observer;
import model.interfaces.Status;


import java.util.ArrayList;

public class StatusGrabber implements Status {

    shapeUtility su = new shapeUtility();

    private ArrayList<Observer> observers;
    private boolean isDeleted;

    public StatusGrabber() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: observers){
            observer.update(isDeleted);
        }
    }


    public void setIsDeletedObserver(Shape s, boolean newDeleteStatus){
        this.isDeleted = newDeleteStatus;
        System.out.println(isDeleted);
        s.setIsDeleted(isDeleted);
        s.setIsSelected(false);
        //s.setPrimaryColor(ShapeColor.WHITE);
        //s.setSecondaryColor(ShapeColor.WHITE);
        notifyObserver();

        /*
        if(s.getShapeShadingType() == ShapeShadingType.OUTLINE) {
            su.drawOutlineRectangle(s.getX1(), s.getY1(), s.getPW(), s.getPH(),
                    s.getPaintCanvasBase(), s.getPrimaryColor()); }

        if(s.getShapeShadingType() == ShapeShadingType.FILLED_IN) {
            su.drawFilledRectangle(s.getX1(), s.getY1(), s.getPW(), s.getPH(),
                    s.getPaintCanvasBase(), s.getPrimaryColor()); }

        if(s.getShapeShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            su.drawFilledRectangle(s.getX1(), s.getY1(), s.getPW(), s.getPH(),
                    s.getPaintCanvasBase(), s.getPrimaryColor());
            su.drawOutlineRectangle(s.getX1(), s.getX2(), s.getPW(), s.getPH(),
                    s.getPaintCanvasBase(), s.getSecondaryColor()); }

         */
    }
}
