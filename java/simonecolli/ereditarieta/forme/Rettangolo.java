public class Rettangolo implements Forma, Transform{
    
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza){
        
        if(base <= 0 || altezza <= 0)
            throw new ValoriNegativiException();
        this.base = base;
        this.altezza = altezza;
    }
    @Override
    public double perimetro() {
        return this.base * 2 + this.altezza * 2;
    }

    @Override
    public double area() {
        return this.base * this.altezza;
    }

    @Override
    public void disegna() {
        System.out.println();
        for (int i = 0; i < altezza; i++) {
            for (int j = 0; j < base; j++) {
                if(i == 0 || i == altezza - 1 || j == 0 || j == base - 1)
                    System.out.print("+");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void scale(double s) {
        this.altezza *= s;
        this.base *= s;
    }
}
