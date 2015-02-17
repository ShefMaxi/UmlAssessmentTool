class TwoD {
    int x, y;
    TwoD(int a, int b) {
        x=a; y=b;
    }
}
class ThreeD extends TwoD {
    int z;
    ThreeD(int a, int b, int c) {
        super(a,b); z=c;
    }
}
class FourD extends ThreeD {
    int t;
    FourD(int a, int b, int c, int d) {
        super(a,b,c); t=d;
    }
}

class Coords<T extends TwoD> {
    T[] coords;
    Coords(T[] o) { coords=o;}
}

public class WildcardExample {
    static public void main(String[] args)
    {
        TwoD a = new TwoD(2, 1);
        ThreeD b = new ThreeD(3, 2, 1);
        FourD c = new FourD(4, 3, 2, 1);

        Coords<TwoD> cs2 = new Coords<TwoD>(new TwoD[] { a, b, c });
        Coords<ThreeD> cs3 = new Coords<ThreeD>(new ThreeD[] { b, c });

        showXY(cs2);
        showXYZ(cs3);
    }

    static void showXY(Coords<?> c) {
        for (int i=0; i< c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
    }
    static void showXYZ(Coords<? extends ThreeD> c) {
        for (int i=0; i< c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
    }
}
