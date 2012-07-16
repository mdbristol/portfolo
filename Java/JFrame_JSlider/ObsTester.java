import javax.swing.JFrame;

/**
 * 
 * @author Michael Bristol
 *The ObsTester is the main method that will start all three GUI's. It also will pass each others frames.
 */



public class ObsTester
{
   public static void main(String[] args)
   {

	 
	   frameOne one = new frameOne();///display shape
	   frameTwo two= new frameTwo();//has the change button
	  frameThree three = new frameThree();//shows the status
	   
	  //Sets frame one and three to accept frame two
	   three.setSubjectFrame(two);
	  one.setSubjectFrame(two);
	   
	  //frame to sends information to each frame
	   two.setFrame1(one);
	   two.setFrame3(three);
	
	   //creates frame one
	   JFrame frame1 = one ;
       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame1.pack();
       frame1.setVisible(true);
       
       //creates frame 2 
       JFrame frame2 = two;
       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame2.pack();
       frame2.setVisible(true);

       //creates frame 3
       JFrame frame3 = three;
       frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame3.pack();
       frame3.setVisible(true);

   }
}
