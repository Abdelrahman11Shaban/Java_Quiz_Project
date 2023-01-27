
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class Quiz implements ActionListener{
	
	String[] questions = 	{
								"What is the capital of Egypt?",
								"What is the capital of France?",
								"What is the capital of England?",
								"What is the capital of Spain?"
							};
	
	String[][] options = 	{
								{"Paris","London","Cairo","Madrid"},
								{"Paris","London","Cairo","Madrid"},
								{"Paris","London","Cairo","Madrid"},
								{"Paris","London","Cairo","Madrid"}
							};
	
	char[] answers = 		{
								'C',
								'A',
								'B',
								'D'
							};
	
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 5;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextArea number_right = new JTextArea();
	JTextArea percentage = new JTextArea();
	JTextArea congrats = new JTextArea("Congratulations you passed the exam! :)");
	JTextArea failure = new JTextArea("Unfortunately, you failed the exam.\n Good luck next time! :( ");
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		//Override the seconds value.
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(-1,0,650,50);
		textfield.setBackground(new Color(86,109,122));
		textfield.setForeground(new Color(255,255,255));
		textfield.setFont(new Font("Arial",Font.BOLD,30));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(25,100,650,50);
		textarea.setBackground(new Color(255,255,255));
		textarea.setForeground(new Color(50,50,50));
		textarea.setFont(new Font("Times New Roman",Font.BOLD,35));	
		textarea.setEditable(false);
		
		buttonA.setBounds(25,170,75,75);
		buttonA.setFont(new Font("Arial",Font.BOLD,30));
		buttonA.setBackground(new Color(80,100,120));
		buttonA.setForeground(new Color(255,255,255));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(25,270,75,75);
		buttonB.setFont(new Font("Arial",Font.BOLD,30));
		buttonB.setBackground(new Color(80,100,120));
		buttonB.setForeground(new Color(255,255,255));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(25,370,75,75);
		buttonC.setFont(new Font("Arial",Font.BOLD,30));
		buttonC.setBackground(new Color(80,100,120));
		buttonC.setForeground(new Color(255,255,255));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(25,470,75,75);
		buttonD.setFont(new Font("Arial",Font.BOLD,30));
		buttonD.setBackground(new Color(80,100,120));
		buttonD.setForeground(new Color(255,255,255));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,160,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(50,50,50));
		answer_labelA.setFont(new Font("Arial",Font.PLAIN,30));
		
		answer_labelB.setBounds(125,260,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(50,50,50));
		answer_labelB.setFont(new Font("Arial",Font.PLAIN,30));
		
		answer_labelC.setBounds(125,360,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(50,50,50));
		answer_labelC.setFont(new Font("Arial",Font.PLAIN,30));
		
		answer_labelD.setBounds(125,460,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(50,50,50));
		answer_labelD.setFont(new Font("Arial",Font.PLAIN,30));
		
		// Second Left
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(255,255,255));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Times New Roman",Font.BOLD,60));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));				
		
		number_right.setBounds(250,225,200,100);
		number_right.setBackground(new Color(255,255,255));
		number_right.setForeground(new Color(50,50,50));
		number_right.setFont(new Font("Arial",Font.BOLD,50));
		number_right.setEditable(false);
		
		percentage.setBounds(250,325,200,100);
		percentage.setBackground(new Color(255,255,255));
		percentage.setForeground(new Color(50,50,50));
		percentage.setFont(new Font("Arial",Font.BOLD,50));	
		percentage.setEditable(false);
		
		congrats.setBounds(20,425,650,100);
		congrats.setBackground(new Color(255,255,255));
		congrats.setForeground(new Color(50,50,50));
		congrats.setFont(new Font("Arial",Font.BOLD,30));	
		congrats.setEditable(false);
		
		failure.setBounds(40,425,500,100);
		failure.setBackground(new Color(255,255,255));
		failure.setForeground(new Color(50,50,50));
		failure.setFont(new Font("Arial",Font.BOLD,30));	
		failure.setEditable(false);
		
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
		
		
	}
	public void nextQuestion() {
		
		if(index >= total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));    //Set at the header the next question number
			textarea.setText(questions[index]);         //The next question from the questions array
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	
	//The action (button is pressed)
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			displayAnswer();
	}
	
	//Display the answer actoin
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		if(answers[index] == 'A')
			answer_labelA.setForeground(new Color(25,255,0));
		if(answers[index] == 'B')
			answer_labelB.setForeground(new Color(25,255,0));
		if(answers[index] == 'C')
			answer_labelC.setForeground(new Color(25,255,0));
		if(answers[index] == 'D')
			answer_labelD.setForeground(new Color(25,255,0));
		
		//This timer will not be processed by the compiler until the line pause.start() is reached.
		Timer pause = new Timer(2000, new ActionListener() {  
			
			//Override on the changed color.
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(50,50,50));
				answer_labelB.setForeground(new Color(50,50,50));
				answer_labelC.setForeground(new Color(50,50,50));
				answer_labelD.setForeground(new Color(50,50,50));
				answer = ' ';                                          //Get back to the initial situation
				seconds=5;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;  //The only place that index is incremented at.
				nextQuestion();
			}
		});
		pause.setRepeats(false);   //Specify false to make the timer stop after sending its first action,
		                          //if it's true the two timers (timer)&(pause) will work together 
		                         //and the method displayanswer will not be seen by the compiler except for the first time.
		pause.start();
	}
	public void results(){
		
		buttonA.hide();
		buttonB.hide();
		buttonC.hide();
		buttonD.hide();
		seconds_left.hide();
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		if (correct_guesses < (total_questions/2) ) {
			frame.add(number_right);
		    frame.add(percentage);
		    frame.add(failure);
		}
		else {
			frame.add(number_right);
	    	frame.add(percentage);
	    	frame.add(congrats);
		}
		
		
	}
	
	
public static void main(String[] args) {
		
		Quiz quiz = new Quiz(); //Anonymous Object
	}
}
