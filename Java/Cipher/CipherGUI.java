
/** Michael Bristol
 * This GUI is going to be creating or generating there own keys that would be used in a cipher codes.
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import javax.swing.*;
import java.io.IOException;

public class CipherGUI extends JPanel
{

	private JButton check, generate;
	private JLabel key;
	private JTextField inputKey,status;
	private JTextArea  instructions;
	private JPanel buttonPanel,keyPanel, centerPanel,bottomPanel,topPanel;
	private int checksum;
	private cipherControl cc;
	private usercheck uc;
	private boolean good;

/**
 * constructer for the GUI that will initalize all important variables and declare the parts of the GUI and add them to be displayed.
 */
 	
	public CipherGUI()
	{
		//initalize variables
		checksum=0;
		good=false;
		cc = new cipherControl();
		uc = new usercheck();

		//creates the button and addds listener
	
		check= new JButton("Check");
		check.addActionListener(new checkListener());
		generate= new JButton("Generate");
		generate.addActionListener( new generateListener());

		//sets up JLabels and Jfeilds
		key= new JLabel("Key:");
		
		
		inputKey= new JTextField(20);
		inputKey.setEditable(true);
		status = new JTextField(20);
		status.setEditable(false);
		 instructions = new JTextArea(7,15);
 		 instructions.setEditable(false);		 
	

		//creates the panel for the rest of the buttons
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(check, BorderLayout.WEST);
		buttonPanel.add(generate, BorderLayout.EAST);
		//feild and view panel
		keyPanel= new JPanel();
		keyPanel.setLayout(new BorderLayout());
		keyPanel.add(key, BorderLayout.WEST);
		keyPanel.add(inputKey, BorderLayout.CENTER);
		
		

		

	
		
               
               		

		//topPanel 
		topPanel= new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(keyPanel, BorderLayout.NORTH);
		//BottomPanel
		bottomPanel=new JPanel();
		bottomPanel.setLayout( new BorderLayout());
		bottomPanel.add(status, BorderLayout.SOUTH);
	
		//centerPanel
		
		centerPanel= new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(buttonPanel, BorderLayout.CENTER);
	
	
		//adds panels to frame
		
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.EAST);
		add( instructions, BorderLayout.SOUTH);
	
		add(centerPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		//sets any preconditions
		




	

	
	}

/**
the display method will start the GUI
*/
		public void display()
		{
			JFrame frame = new JFrame(" Cipher Program ");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(this);
			frame.pack();
			frame.setVisible(true);
			 instructions.setText("To create your own Cipher key: Enter a even number\n key " +
			 "in the \"Key\" field and click \"Check \".\nYour key can ONLY " +
			 "contain numerical digits.\n\n To generate a random key:"+
			 "click the \"Generate\"\n button.");
			
		}


	
/**
The checkListener will check the conditions of the users inputed text to determine if it meets its conditions.
*/	
	
		private class checkListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
			String usertext= inputKey.getText();
			int length = usertext.length();//gets length of userInput
			for(int i = 0; i<usertext.length(); i++)//for loop that will check input for authorized characters
				{
					if(Character.isDigit(usertext.charAt(i)))//if all chars are digits
						good = true;//sets good to true
					else
					good = false;//else sets good to false
				}
				if(usertext != null  && length >=2 && length <= 20 && good == true)//checks if input is null and of adequate length
				{
			
					if(length %2 == 0)//if input is even number of digits
					{
						uc.addToKey(length, usertext);//calls addToKey from userKey class
						uc.addComponents(length);//calls addComponents from userKey class
						uc.checkKey(length);//calls checkKey from userKey class
						status.setText(uc.result());//calls result from userKey class and sets it as text
						uc.resetCollections(length);//calls resetCollections from userKey class
					}
					else if(length %2 != 0)//if userInput is an odd number of digits the user is prompted
					{
						JOptionPane.showMessageDialog(null,
						"Your key must be an even number of digits",
						"Key error", JOptionPane.ERROR_MESSAGE);
						inputKey.setText("");
					}
				}
				else//if userInput is null, has unauthorized chars or is not adequate length
					{
						JOptionPane.showMessageDialog(null,
						"You must enter a key atleast 2 digits and less than 20 digits long.\nOnly digits may be entered",
						"Key error", JOptionPane.ERROR_MESSAGE);
					}
		
			



			
			}
		}
	
/**
the generatelistener will generate a random number that has been defined from the controller and print out a key.
*/	

		private class generateListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				inputKey.setText(""); //sets the textfeild to blank
				cc.checkInput();
				cc.getCheckSum();
				cc.firstHalf();
				cc.secondHalf();
				cc.full();
				status.setText(cc.toString());
				cc.clear();

					
			

  			}
            }
        


             
         
             

			}
		





