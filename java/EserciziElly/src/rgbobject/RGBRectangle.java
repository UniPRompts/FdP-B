package rgbobject;

public class RGBRectangle extends RGBObject{
    private int width;
    private int height;

    public RGBRectangle(int red, int green, int blue, int width, int height){
        super(red, green, blue);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString(){
        return ("width: " + this.width + "\theight: " + this.height);
    }

    public boolean eqColor(RGBObject other) {
        return this.getRed() == other.getRed() &&
                this.getBlue() == other.getBlue() &&
                this.getGreen() == other.getGreen();
    }
}
