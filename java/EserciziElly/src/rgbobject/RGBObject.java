package rgbobject;

public abstract class RGBObject {
    protected int red ;
    protected int green;
    protected int blue;

    public RGBObject(int red, int green, int blue){
        this.blue = blue;
        this.green = green;
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public abstract boolean eqColor(RGBObject other);
}
