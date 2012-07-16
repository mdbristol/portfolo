import javax.swing.JFrame;


public class Bounce
  {
     public static void main(String[] args)
     {
        JFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
     }
  } 
