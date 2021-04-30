package model.draw;

import model.ShapeColor;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class ellipse {

    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    private PaintCanvasBase paintCanvas;

    public ellipse (int mouseX, int mouseY, int mouseX2, int mouseY2, PaintCanvasBase paintCanvas,
                    ShapeColor primaryColor){
        this.X1 = mouseX;
        this.Y1 = mouseY;
        this.X2 = mouseX2;
        this.Y2 = mouseY2;
        this.paintCanvas = paintCanvas;

        drawEllipse();
    }

    public void drawEllipse(){
        int pw = X2 - X1;
        int ph = Y2 - Y1;

        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.drawOval(X1, Y1, pw, ph);
    }

}
