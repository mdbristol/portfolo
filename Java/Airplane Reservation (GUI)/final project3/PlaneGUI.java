
/** Michael Bristol
 * PlaneGUI
 * This class is to create a GUI using the classes of project 1
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import javax.swing.*;
import java.io.IOException;

public class PlaneGUI extends JPanel
{

	private JButton search;
	private JLabel info,instructionLabel,statusLabel;
	private JTextField status,searchF;
	private JTextArea info_P, instructions;
	private JPanel instructionsPanel, infoPanel2, buttonPanel, buttonPanel2,fieldPanel,infoPanel,topPanel,bottomPanel,centerPanel,westPanel,eastPanel;
	
	mybutton[][] buttons ;
	private planeControl pc;
	int row, col;
	public PlaneGUI()
	{
		pc= new planeControl();
		
		//creates the button and addds listener
	
		search= new JButton("Search");
		search.addActionListener(new searchListener());

		//sets up JLabels and Jfeilds
		statusLabel= new JLabel("Status:");
		info=new JLabel("Passenger Information");
		instructionLabel= new JLabel("Instructions:");
		
		status= new JTextField(20);
		status.setEditable(false);
		info_P= new JTextArea(6, 15);
		info_P.setMargin(new Insets(5,5,5,5));
		info_P.setEditable(false);
		instructions= new JTextArea(7,15);
		instructions.setMargin(new Insets(3,3,3,3));
		instructions.setEditable(false);
		searchF= new JTextField(20);


		//creates the array of buttons and adds them
		buttons= new mybutton[10][3];
		buttonPanel= new JPanel();
		buttonPanel.setLayout(new GridLayout (10,3));	
		for(int i =0; i<buttons.length; i++)
			for(int j=0; j<buttons[0].length; j++)
				{
					buttons[i][j]=new mybutton(i,j);
					buttons[i][j].setText(buttons[i][j].toString());
					buttonPanel.add(buttons[i][j]);
					buttons[i][j].addActionListener( new buttonsListener());
					
					
					buttons[i][j].setBackground(null);
                                                
                                    	

				}

		//creates the instructions
		instructionsPanel= new JPanel();
		instructionsPanel.setLayout(new BorderLayout());
		instructionsPanel.add(instructionLabel, BorderLayout.NORTH);
		instructionsPanel.add(instructions,BorderLayout.CENTER);

		//creates the panel for the rest of the buttons
		buttonPanel2=new JPanel();
		buttonPanel2.setLayout(new BorderLayout());
		buttonPanel2.add(search, BorderLayout.WEST);
		buttonPanel2.add(searchF, BorderLayout.CENTER);
		//feild and view panel
		fieldPanel= new JPanel();
		fieldPanel.setLayout(new BorderLayout());
		fieldPanel.add(status, BorderLayout.CENTER);
		fieldPanel.add(statusLabel, BorderLayout.WEST);
		
		

		infoPanel=new JPanel();
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(info,BorderLayout.NORTH);

	
		
		infoPanel2= new JPanel();	
		 infoPanel2.setLayout(new BorderLayout());
          infoPanel2.add(info_P, BorderLayout.CENTER);
               
               		

		//topPanel 
		topPanel= new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(fieldPanel, BorderLayout.NORTH);
		//BottomPanel
		bottomPanel=new JPanel();
		bottomPanel.setLayout( new BorderLayout());
		bottomPanel.add(buttonPanel2, BorderLayout.SOUTH);
		//westPanel
		westPanel=new JPanel();
		westPanel.setLayout( new BorderLayout());
		westPanel.add(buttonPanel, BorderLayout.WEST);
		//centerPanel
		
		centerPanel= new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(infoPanel2, BorderLayout.CENTER);
		centerPanel.add(infoPanel, BorderLayout.NORTH);
		//east Panel
		eastPanel= new JPanel();
		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(instructionsPanel, BorderLayout.EAST);
		//adds panels to frame
		
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		//sets any preconditions
		




	

	
	}

/**
the display method will start the GUI
*/
		public void display()
		{
			JFrame frame = new JFrame(" Plane GUI ");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(this);
			frame.pack();
			frame.setVisible(true);
			instructions.setText("Gray seat buttons\n are available seats.\n Green seat buttons,\n are reserved seats. \n To reserve:\n Click disired seat,\n Enter your information\n and click the save button. \n To cancel: Click seat and then  \n Cancel button. \n To View a seat: \n Click the desired seat,\n Click view seat.\n To Search: \n Enter the name next,\n to the search botton, \n (first name)");  
			pc.initPlane();
		}


	
/**
the searchListener will act when the search button is pressed
*/	
	
		private class searchListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
			String search=searchF.getText();
			String result = pc.searchPassenger(search);	
			info_P.setText(result);
				
			
			
			
			}
		}
	
/**
the buttonsListener will act when one of the array of butttons is pressed
*/	

		private class buttonsListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
		
  			Object button = event.getSource();
             		mybutton temp=(mybutton)button;
        	     	row=temp.getRow();
             		col=temp.getCol();
             
             		if(pc.isVacant(row, col)==true)
            			 {
          			   pc.addPassenger(row, col);
          			   buttons[row][col].setBackground(Color.GREEN);

            }
             else
             {
                    JFrame frame=new JFrame();
                    Object[] possibilities = {"View Reservation", "Cancel Reservation"};
                    String s = (String)JOptionPane.showInputDialog(
                    frame,
                    "Choose An Option:",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "view"
                   );


 if (s=="View Reservation")
 {
    info_P.setText("Located at: " +buttons[row][col].toString() +"\n" + pc.viewseat(row, col));
    }
 else if ( s=="Cancel Reservation")
 {
pc.cancelSeat(row,col);
buttons[row][col].setBackground(null);
}
	     }


             
             
                }
             

			}
		}





