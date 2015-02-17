import sheffield.*;

public class Rectangle extends Shape
{

    private double width;
    private double height;

    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }

    public void draw(EasyGraphics g)
    {
        g.moveTo(x, y);
        g.lineTo(x + width, y);
        g.lineTo(x + width, y + height);
        g.lineTo(x, y + height);
        g.lineTo(x, y);
    }

    public double area()
    {
        return width * height;
    }

}
