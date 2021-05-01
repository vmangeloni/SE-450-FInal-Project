package model.draw;

import model.ShapeColor;
import model.ShapeType;
import model.ShapeShadingType;
import view.interfaces.PaintCanvasBase;
import static model.ShapeColor.returnColor;

import java.awt.*;

import static model.ShapeColor.returnColor;

public class ellipse {

    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private PaintCanvasBase paintCanvas;
    private final ShapeColor primColor;
    private final ShapeColor secColor;
    private final ShapeShadingType getShapeType;


    public ellipse (int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                    ShapeColor primaryColor, ShapeShadingType getShapeType, ShapeColor secColor){
        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;
        this.getShapeType = getShapeType;
        this.primColor = primaryColor;
        this.secColor = secColor;

        if(getShapeType == getShapeType.OUTLINE){
            drawOutlineEllipse(returnColor(primColor));
        }

        if(getShapeType == getShapeType.FILLED_IN){
            drawFilledEllipse(returnColor(primColor));
        }

        if(getShapeType == getShapeType.OUTLINE_AND_FILLED_IN){


            drawFilledEllipse(returnColor(primColor));
            drawOutlineEllipse(returnColor(secColor));
        }


    }

    public void drawOutlineEllipse(Color chooseColor){
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.drawOval(X1, Y1, pw, ph);
    }

    public void drawFilledEllipse(Color chooseColor){
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.fillOval(X1, Y1, pw, ph);
    }

}
