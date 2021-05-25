package model.draw;

import model.interfaces.Observer;
import model.interfaces.Status;

public class StatusObserver implements Observer {

    private boolean isDeleted;

    private static int observerIDTracker = 0;
    private int observerID;

    private Status statusGrabber;

    public StatusObserver(Status statusGrabber){
        this.statusGrabber = statusGrabber;
        this.observerID = ++ observerIDTracker;
    }

    @Override
    public void update(boolean isDeleted) {
        this.isDeleted = isDeleted;
        System.out.println("CHANGED");
    }
}
