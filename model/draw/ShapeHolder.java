package model.draw;

import java.util.ArrayList;

public class ShapeHolder {
    private static ShapeHolder firstInstance = null;

    private ShapeHolder(){};

    private ArrayList<Shape> ShapeArrayList =  new ArrayList<Shape> ();

    public static ShapeHolder getInstance(){
        if(firstInstance == null){
            firstInstance = new ShapeHolder();
        }
        return firstInstance;
    }

    public void addSA (Shape shape){
        ShapeArrayList.add(shape);
    }

    public void removeSA (Shape shape){
        ShapeArrayList.remove(shape);
    }

    public ArrayList<Shape> getSA (){
        return firstInstance.ShapeArrayList;
    }

    public Shape getSAINDEX (int indexget){
        return firstInstance.ShapeArrayList.get(indexget);
    }

}
