package main;
import java.awt.image.BufferedImage;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Main {

    //self explanatory, just some variables that are gonna be used quite a lot
    public static final int displayWidth = 450;
    public static final int displayHeight = 300;
    public static final double cameraWidth = 5;
    public static final double ambientConstant = 0.2;

    //THIS IS THE LOCATION OF THE TOP LEFT CORNER OF THE CAMERA BOX AND ONLY THAT. IT IS NOT THE MIDDLE OF THE CAMERA DO NOT BE FOOLED
    //ALSO DEFINE VALUE FOR MIDDLE OF CAMERA LATER
    public static final Vector3 cameraPosition = new Vector3(0, 0, 0);

    //THIS IS THE FOCAL POSITION FOR PERSPECTIVE CAMERA
    private static double focalLength = 3;
    public static Camera cameraState = Camera.Orthographic;
    public static Shader shaderState = Shader.Original;
    public static Display displayState = Display.Animation;

    public static final double cameraHeight = cameraWidth*displayHeight/displayWidth;
    public static final double widRat = cameraWidth/displayWidth;
    public static final double heiRat = cameraHeight/displayHeight;
    public static Vector3 focalPosition = cameraPosition.add(new Vector3(cameraWidth/2, cameraHeight/2, -focalLength));
    public static enum Camera {
        Orthographic, Perspective, JustBackground;
    }
    public static enum Shader { //incredibly sexy code that lets me increment things well. i wish i wrote it
        Original, Ambient, Diffusion, Specular, Phong {@Override public Shader next() { return values()[0];};}; public Shader next(){return values()[ordinal()+1];}
    }
    public static enum Display {
        Animation, Pause {@Override public Display next() { return values()[0];};}; public Display next(){return values()[ordinal()+1];}
    }

    public static void main(String[] args){
        BufferedImage createdImage = new BufferedImage(displayWidth, displayHeight, BufferedImage.TYPE_INT_ARGB);

        //This is temporary, basically creating an ARGB color using bit shifting so I can paint the blank BufferedImage and show that it's working
        Color background = new Color(255, 255, 255, 0);

        // Setting up Jframe to display the BufferedImage
        JFrame jframe = new JFrame();
        jframe.setVisible(true);

        ImageFiller.fill(cameraState, shaderState, createdImage, background, ShapeList.shapes());
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

        jframe.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyChar() == ' '){
                    shaderState = shaderState.next();
                    if (displayState == Display.Pause){
                        ImageFiller.fill(cameraState, shaderState, createdImage, background, ShapeList.shapes());
                        jframe.repaint();
                    }    
                } else if (e.getKeyChar() == ','){
                    displayState = displayState.next();
                }
            }

            public void keyReleased(KeyEvent e){

            }

            public void keyTyped(KeyEvent e){

            }
        });
        
        
        while (true){
            switch (displayState){
                case Animation:
                    ImageFiller.fill(cameraState, shaderState, createdImage, background, ShapeList.shapeAnim1());
                    jframe.repaint();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case Pause:
                    break;
            }
        }
    }
}
