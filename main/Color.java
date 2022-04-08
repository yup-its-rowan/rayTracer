package main;
public class Color {

    public static final Color Black = new Color(0, 0, 0);
    private int r, g, b;
    public Color(int r, int g, int b){
        this.r = Math.max(Math.min(r, 255), 0);
        this.g = Math.max(Math.min(g, 255), 0);
        this.b = Math.max(Math.min(b, 255), 0);
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

    public Color add(Color c){
        return new Color(r+c.getR(), g+c.getG(), b+c.getB());
    }

    public int argb(){
        return ((255<<24) | (r <<16) | (g<<8) | b);
    }

    public Color times(double scalar){
        return new Color(round(r*scalar), round(g*scalar), round(b*scalar));
    }

    private int round(double a){
        return (int) (a+0.5);
    }

    //huge mistake not using a double or a float or something to keep the color values ;c
    public Color multiply(Color color){
        return new Color(round(((double)r*color.getR())/255), round(((double)g*color.getG())/255), round(((double)b*color.getB())/255));
    }
}
