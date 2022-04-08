package main;
public class Color {

    private int a, r, g, b;
    public Color(int a, int r, int g, int b){
        this.a = Math.min(a, 255);
        this.r = Math.min(r, 255);
        this.g = Math.min(g, 255);
        this.b = Math.min(b, 255);
    }

    public int getA(){
        return a;
    }
    public int getR(){
        return r;
    }
    public int getG(){
        return g;
    }
    public int getB(){
        return b;
    }

    public int argb(){
        return ((a<<24) | (r <<16) | (g<<8) | b);
    }

    public Color times(double scalar){
        return new Color(round(a*scalar), round(r*scalar), round(g*scalar), round(b*scalar));
    }

    private int round(double a){
        return (int) (a+0.5);
    }

    //huge mistake not using a double or a float or something to keep the color values ;c
    public Color multiply(Color color){
        return new Color(round(((double)a*color.getA())/255), round(((double)r*color.getR())/255), round(((double)g*color.getG())/255), round(((double)b*color.getB())/255));
    }
}
