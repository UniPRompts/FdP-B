package rgbobject;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        RGBRectangle r1 = new RGBRectangle(125, 80, 200, 100, 50);
        RGBRectangle r2 = new RGBRectangle(220, 76, 88, 32, 10);
        RGBRectangle r3 = new RGBRectangle(125, 80, 200, 155, 156);

        HashSet<RGBRectangle> set = new HashSet<>();
        set.add(r1);
        set.add(r2);
        set.add(r3);

        for(RGBRectangle r : set)
            if(r1.eqColor(r))
                System.out.println(r);
    }
}
