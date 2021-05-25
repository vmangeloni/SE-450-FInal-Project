package model.interfaces;



public interface Status {
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();
}
