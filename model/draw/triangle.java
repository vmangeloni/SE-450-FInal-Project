package model.draw;

import model.ShapeColor;
import model.ShapeType;
import model.ShapeShadingType;
import view.interfaces.PaintCanvasBase;
import static model.ShapeColor.returnColor;

import java.awt.*;

import static model.ShapeColor.returnColor;

public class triangle {

    private final ShapeColor primColor;
    private final ShapeColor secColor;
    private final ShapeShadingType getShapeType;
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private int [] triX;
    private int [] triY;
    private PaintCanvasBase paintCanvas;

    public triangle (int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                     ShapeColor primaryColor, ShapeShadingType getShapeType, ShapeColor secColor){
        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;
        this.primColor = primaryColor;
        this.getShapeType = getShapeType;
        this.secColor = secColor;

        if(getShapeType == getShapeType.OUTLINE){
            drawOutlineTriangle(returnColor(primColor));
        }

        if(getShapeType == getShapeType.FILLED_IN){
            drawFilledriangle(returnColor(primColor));
        }

        if(getShapeType == getShapeType.OUTLINE_AND_FILLED_IN){


            drawFilledriangle(returnColor(primColor));
            drawOutlineTriangle(returnColor(secColor));
        }
    }

    public void drawOutlineTriangle(Color chooseColor){
        triX = new int[] {X2, X1, X1};
        triY = new int[] {Y2, Y1, Y1};

        int[] drawX = new int[] {triX[0] + 13, triX[1] - 7, triX[2] - 7};
        int[] drawY = new int[] {triY[0] + 3, triY[1] + 4, triY[2] - 9};

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.drawPolygon(drawX, drawY, 3);
    }

    public void drawFilledriangle(Color chooseColor){
        triX = new int[] {X2, X1, X1};
        triY = new int[] {Y2, Y1, Y1};

        int[] drawX = new int[] {triX[0] + 13, triX[1] - 7, triX[2] - 7};
        int[] drawY = new int[] {triY[0] + 3, triY[1] + 4, triY[2] - 9};

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(chooseColor);
        graphics2D.fillPolygon(drawX, drawY, 3);
    }

}

