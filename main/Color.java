package main;
public class Color {

    private int color = 0;
    public Color(int a, int r, int g, int b){
        color = ((a<<24) | (r <<16) | (g<<8) | b);
    }

    public int argb(){
        return color;
    }
}
