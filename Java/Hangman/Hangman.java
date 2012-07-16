/** 

Michael Bristol

Project 2
Hangman will create a GUI interface for the user to use, it will also create the actionListner in which will tell the buttons what to do.

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class Hangman extends JPanel
{
private JButton submit,skip,hint,restart;
private JTextField dashed,defF,answer;
private JLabel statusLabel, scoreLabel;
private JPanel panel1;
private JPanel buttonPanel, fieldPanel,labelPanel;
private int score,tempscore;
ReadText text;

/**Hangman constructer that initilizes all the Jbuttons, fields, and panel and also starts the first definition and name for the GUI
*/	
  public Hangman()
	{
		
	//Starts the file
		text=new ReadText();
		text.scanText();
		score=0;
		tempscore=0;	
	 //creates the buttons and adds listener

	skip = new JButton("Skip");
	skip.addActionListener( new skipListener());
	hint = new JButton("Hint");
	hint.addActionListener( new hintListener());
	submit = new JButton("Submit");
	submit.addActionListener( new submitListener());
	restart= new JButton("Restart");
	//creates the textfeilds textLabels  and listener and the score Label

	defF= new JTextField(40);//make it the text.txt and make it length()
	defF.setEditable(false);
	dashed= new JTextField(20);
	dashed.setEditable(false);
	answer = new JTextField(20);//make it the length of the world 
	answer.setEditable(true);
	statusLabel= new JLabel();
	scoreLabel=new JLabel();
	

	//sets up the buttons panel
	buttonPanel = new JPanel();
	buttonPanel.setLayout( new BorderLayout());
	buttonPanel.add(skip, BorderLayout.WEST);
	buttonPanel.add(hint, BorderLayout.EAST);
	//sets the text field panel
	fieldPanel = new JPanel();
	fieldPanel.setLayout( new BorderLayout());
	fieldPanel.add(defF, BorderLayout.CENTER);
	fieldPanel.add(answer, BorderLayout.SOUTH);
	fieldPanel.add(dashed, BorderLayout.NORTH);
	//sets up the label panel
	labelPanel = new JPanel();
	labelPanel.setLayout(new BorderLayout());
	labelPanel.add(scoreLabel, BorderLayout.WEST);
	labelPanel.add(statusLabel, BorderLayout.EAST);
	
 	//adds the feildPanel, labelPanel and button Panel together
	panel1 = new JPanel();
	panel1.setLayout( new BorderLayout());
	panel1.add(buttonPanel, BorderLayout.WEST);
	panel1.add(fieldPanel, BorderLayout.EAST);
	panel1.add(labelPanel, BorderLayout.NORTH);
	//add panel to frame
	setLayout(new BorderLayout());
	add(panel1, BorderLayout.CENTER);
	add(submit, BorderLayout.EAST);
	setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	//begining text 
	text.nextWord();
	dashed.setText(text.dash);
	defF.setText(text.def);
	tempscore= score+text.word.length();
	scoreLabel.setText("Score: 0");
	}

  /** The display method will display the GUI for the user.
   */
	
	public void display()
	{
	JFrame frame = new JFrame(" Hangman Game");
 	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	 frame.setContentPane(this);
	frame.pack();   
 	frame.setVisible(true);
	}

/** The hintListener class will replace a dash with a character from the word, also the points allowed for each word is reduced everytime the hint button is pressed
 */
	private class hintListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event) 
   		{
		text.hintWord();
 		dashed.setText(text.dash);
		tempscore = tempscore - 1;
       		 }
	}
 
/** The skipListener class will display the next word and next definition will pressed, will also display the restart button when the end of the file is reached
 */
	private class skipListener implements ActionListener
  	{
		  public void actionPerformed (ActionEvent event)
	  	{
			try
			{	
		
			text.nextWord();
			dashed.setText(text.dash);
			defF.setText(text.def);
			tempscore= score + text.word.length();//sets the max points the user can get for the word
			}
			catch(Exception e)
			{
			statusLabel.setText("Game over");
			answer.setEditable(false);
			    panel1.add(restart, BorderLayout.SOUTH);
                        restart.addActionListener( new restartListener());
	   		}
		}

	}
/** The submitLIstener class when the submit button is clicked it will determine if the word guess is correct will display the next def and word, it will also display the restart button
 */
	private class submitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
			{
		
			try
			{
			if((answer.getText()).equalsIgnoreCase(text.word))
			{
		
			score = tempscore;
			scoreLabel.setText("Score " + score);
			statusLabel.setText("Correct");
			answer.setText("");
			text.nextWord();
			tempscore= score+ text.word.length();//sets the max points allow
			dashed.setText(text.dash);
			defF.setText(text.def);
			}
			else
			{
			statusLabel.setText("Incorrect");
			answer.setText("");
			}
			}
			catch(Exception e)
			{
			statusLabel.setText("Game over");
                	answer.setEditable(false);
			panel1.add(restart, BorderLayout.SOUTH);
			restart.addActionListener( new restartListener());
			}

		}	
	}
/** The restartListener will restart the GUI action and will reset the count
 */
	private class restartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
			{
				text.restart();
				score=0;
				scoreLabel.setText("Score: 0");	
				text.nextWord();
				 tempscore= score+ text.word.length();
                        	dashed.setText(text.dash);
                       		 defF.setText(text.def);
				answer.setEditable(true);
					panel1.remove(restart);
				

			
			}
	}



}
