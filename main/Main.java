package main;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Main {

    //self explanatory, just some variables that are gonna be used quite a lot
    public static final int displayWidth = 600;
    public static final int displayHeight = 400;
    public static final double cameraWidth = 5;
    public static final boolean doAnimation = true;
    public static final double ambientConstant = 0.2;

    //THIS IS THE LOCATION OF THE TOP LEFT CORNER OF THE CAMERA BOX AND ONLY THAT. IT IS NOT THE MIDDLE OF THE CAMERA DO NOT BE FOOLED
    //ALSO DEFINE VALUE FOR MIDDLE OF CAMERA LATER
    public static final Vector3 cameraPosition = new Vector3(0, 0, 0);

    //THIS IS THE FOCAL POSITION FOR PERSPECTIVE CAMERA
    private static double focalLength = 3;
    public static final Camera cameraState = Camera.Perspective;

    public static final double cameraHeight = cameraWidth*displayHeight/displayWidth;
    public static final double widRat = cameraWidth/displayWidth;
    public static final double heiRat = cameraHeight/displayHeight;
    public static Vector3 focalPosition = cameraPosition.add(new Vector3(cameraWidth/2, cameraHeight/2, -focalLength));
    public static enum Camera {
        Orthographic, Perspective, JustBackground;
    }

    public static void main(String[] args){
        BufferedImage createdImage = new BufferedImage(displayWidth, displayHeight, BufferedImage.TYPE_INT_ARGB);

        //This is temporary, basically creating an ARGB color using bit shifting so I can paint the blank BufferedImage and show that it's working
        Color background = new Color(255, 255, 255, 0);

        // Setting up Jframe to display the BufferedImage
        JFrame jframe = new JFrame();
        jframe.setVisible(true);

        ImageFiller.fill(cameraState, createdImage, background, ShapeList.shapes());
        ImageIcon icon = new ImageIcon(createdImage);
        JLabel jLabel = new JLabel(icon);
        jframe.getContentPane().add(jLabel);
        jframe.pack();
    
        //System.out.println(widRat + "  " + heiRat);
        

        // This stuff below is just helpful. If you close the application without having this you'll have to terminate the java thread separately.
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
              System.exit(0); //This is the bit that closes the application after hitting X
            }}
        );

        while (doAnimation){
            ImageFiller.fill(cameraState, createdImage, background, ShapeList.shapeAnim1());
            jframe.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
