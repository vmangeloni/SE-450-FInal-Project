package model.draw;

import model.ShapeColor;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static model.ShapeColor.returnColor;

public class triangle {

    private final ShapeColor primColor;
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private int [] triX;
    private int [] triY;
    private PaintCanvasBase paintCanvas;

    public triangle (int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                     ShapeColor primaryColor){
        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;
        this.primColor = primaryColor;

        drawTriangle();
    }

    public void drawTriangle(){
        triX = new int[] {X2, X1, X1};
        triY = new int[] {Y2, Y1, Y1};

        int[] drawX = new int[] {triX[0] + 13, triX[1] - 7, triX[2] - 7};
        int[] drawY = new int[] {triY[0] + 3, triY[1] + 4, triY[2] - 9};

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(returnColor(primColor));
        graphics2D.drawPolygon(drawX, drawY, 3);
    }

}

