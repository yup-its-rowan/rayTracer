package main;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Main {

    //self explanatory, just some variables that are gonna be used quite a lot
    public static final int width = 450;
    public static final int height = 300;
    public static final Camera cameraState = Camera.JustBackground;
    public static enum Camera {
        Orthographic, Perspective, JustBackground;
    }

    public static void main(String[] args) {
        BufferedImage createdImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //This is temporary, basically creating an ARGB color using bit shifting so I can paint the blank BufferedImage and show that it's working
        Color background = new Color(255, 255, 255, 0);
        
        ImageFiller.fill(cameraState, createdImage, background, ShapeList.shapes());

        // Setting up Jframe to display the bufferedimage
        JFrame jframe = new JFrame();
        jframe.getContentPane().add(new JLabel(new ImageIcon(createdImage)));
        jframe.pack();
        jframe.setVisible(true);

        // This stuff below is just helpful. If you close the application without having this you'll have to terminate the java thread separately.
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
              System.exit(0); //This is the bit that closes the application after hitting X
            }});
        
    }
}
