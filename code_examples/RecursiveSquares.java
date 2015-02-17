import sheffield.*;

public class RecursiveSquares
{

    static void drawSquare(EasyGraphics graphics, int x1, int y1, int x2, int y2)
    {
        graphics.moveTo(x1, y1);
        graphics.lineTo(x1, y2);
        graphics.lineTo(x2, y2);
        graphics.lineTo(x2, y1);
        graphics.lineTo(x1, y1);
    }

    static void square(EasyGraphics graphics, int xc, int yc, int r)
    {
        int x1, y1, x2, y2, newr;

        if (r < 3)
            ; // stop
        else
        {
            x1 = xc - r;
            x2 = xc + r;
            y1 = yc - r;
            y2 = yc + r;
            drawSquare(graphics, x1, y1, x2, y2);
            newr = r / 2;
            square(graphics, x1, y1, newr);
            square(graphics, x1, y2, newr);
            square(graphics, x2, y1, newr);
            square(graphics, x2, y2, newr);
        }
    }

    public static void main(String[] args)
    {
        // create a graphics window

        EasyGraphics graphics = new EasyGraphics(400, 400);

        square(graphics, 200, 200, 50);
    }
}
