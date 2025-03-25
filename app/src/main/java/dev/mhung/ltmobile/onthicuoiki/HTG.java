package dev.mhung.ltmobile.onthicuoiki;


public class HTG {
    private double a, b, c;

    boolean kiemTraTG() {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return false;
        } else {
            return true;
        }
    }

    double tinhChuVi() {return a + b + c;
    }

    double tinhDienTich() {
        double p = tinhChuVi() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public HTG(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
