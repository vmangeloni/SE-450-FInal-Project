package model.draw;

import model.ShapeColor;
import model.ShapeShadingType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static model.ShapeColor.returnColor;

public class rectangle {


    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private PaintCanvasBase paintCanvas;
    private final ShapeColor primColor;
    private final ShapeColor secColor;
    private final ShapeShadingType getShapeType;






    public rectangle(int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                     ShapeColor primaryColor, ShapeShadingType getShapeType, ShapeColor secColor) {
        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;
        this.primColor = primaryColor;
        this.getShapeType = getShapeType;
        this.secColor = secColor;


        if(getShapeType == getShapeType.OUTLINE){
            drawOutlineRectangle(returnColor(primColor));
        }

        if(getShapeType == getShapeType.FILLED_IN){
            drawFilledRectangle(returnColor(primColor));
        }

        if(getShapeType == getShapeType.OUTLINE_AND_FILLED_IN){

            drawFilledRectangle(returnColor(primColor));
            drawOutlineRectangle(returnColor(secColor));
        }

    }

    public void drawOutlineRectangle(Color chooseColor) {
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.drawRect(X1, Y1, pw, ph);

    }

    public void drawFilledRectangle(Color chooseColor) {
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.fillRect(X1, Y1, pw, ph);

    }



}
