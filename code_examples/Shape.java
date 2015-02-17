import sheffield.*;

public abstract class Shape
{

    protected double x;
    protected double y;

    public void setPosition(double xval, double yval)
    {
        x = xval;
        y = yval;
    }

    public abstract void draw(EasyGraphics g);

    public abstract double area();

}
