package model.draw;


import model.interfaces.Observer;
import model.interfaces.Status;


import java.util.ArrayList;

public class StatusGrabber implements Status {

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
        s.setIsDeleted(isDeleted);
        s.setIsGroup(false);
        s.setIsSelected(false);
        notifyObserver();

    }
}
