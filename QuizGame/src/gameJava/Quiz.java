package gameJava;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {
	
//	The Java ActionListener is notified whenever you click on the button or menu item.
//	It is notified against ActionEvent. The ActionListener interface is found in java.awt.event package.
//	It has only one method: actionPerformed().

	String questions[]= {
			            "Which company created Java?",
			            "Which year Java was created?",
			             "What was Java Originally called?",
			             "Who is credited with creating java?"
	                    };
	String [][] options = {
			{"sun Microsystem","Starbucks","Microsoft","Alphabet"},
			{"1989","1976","1972","1492"},
			{"Apple","Latte","Oak","Coffee"},
			{"Charles Babbage","Steve Jobs","James Gosling","Mark"}
	};
	
	char[] answers= {
			'A',
			'B',
			'C',
			'C'
			
	};
	
	char guess;
	char answer;
	int index;
	int correct_guesses=0;
	int total_questions=questions.length; //dynamically
	int result;
	int seconds=10;
	
	
	//Gui components
	JFrame frame=new JFrame(); //frame to hold everything
	JTextField textfield= new JTextField(); //hold current question that we are on
	JTextArea textarea=new JTextArea();
	JLabel image=new JLabel();
	
//	ImageIcon img=new ImageIcon("backimage.jpg");
//	JLabel background=new JLabel("",img,JLabel.CENTER);
//	background.setBounds(0, 0, 500, 500);
	
	JButton buttonA=new JButton();
	JButton buttonB=new JButton();
	JButton buttonC=new JButton();
	JButton buttonD=new JButton();
	
	//Labels to hold all the different answers
	JLabel answer_labelA=new JLabel();
	JLabel answer_labelB=new JLabel();
	JLabel answer_labelC=new JLabel();
	JLabel answer_labelD=new JLabel();
	
	JLabel time_Label=new JLabel();
	JLabel seconds_left=new JLabel();
	
	JTextField number_right=new JTextField();
	JTextField percentage=new JTextField();
	

	Timer timer=new Timer(1000,new ActionListener() {
		//@Override
		public void actionPerformed(ActionEvent e)
		{
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayanswer();
			}
		}
	});
	
	
	public Quiz() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
//		 frame.getContentPane(); //Gets the content layer
//       // JLabel label = new JLabel(); //JLabel Creation
//        image.setIcon(new ImageIcon("backimage.jpg")); //Sets the image to be displayed as an icon
//        Dimension size = image.getPreferredSize(); //Gets the size of the image
//        image.setBounds(50, 30, size.width, size.height); 
		
		
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
	    textfield.setBorder(BorderFactory.createBevelBorder(1));
	    textfield.setHorizontalAlignment(JTextField.CENTER);
	    textfield.setEditable(false);
	   

		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		//textarea.setHorizontalAlignment(JTextField.CENTER);
		textarea.setEditable(false);
		//textarea.setText("anu sample text");
	    
	    buttonA.setBounds(0, 100, 100, 100);
	    buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
	    buttonA.setFocusable(false);
	    buttonA.addActionListener(this);
	    buttonA.setText("A");
	    
	    
	    buttonB.setBounds(0, 200, 100, 100);
	    buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
	    buttonB.setFocusable(false);
	    buttonB.addActionListener(this);
	    buttonB.setText("B");
	    
	    buttonC.setBounds(0, 300, 100, 100);
	    buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
	    buttonC.setFocusable(false);
	    buttonC.addActionListener(this);
	    buttonC.setText("C");
	    
	    buttonD.setBounds(0, 400, 100, 100);
	    buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
	    buttonD.setFocusable(false);
	    buttonD.addActionListener(this);
	    buttonD.setText("D");
	    
	    answer_labelA.setBounds(125,100,500,100);
	    answer_labelA.setBackground(new Color(50,50,50));
	    answer_labelA.setForeground(new Color(25,255,0));
	    answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
	    
	    answer_labelB.setBounds(125,200,500,100);
	    answer_labelB.setBackground(new Color(50,50,50));
	    answer_labelB.setForeground(new Color(25,255,0));
	    answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
	    
	    answer_labelC.setBounds(125,300,500,100);
	    answer_labelC.setBackground(new Color(50,50,50));
	    answer_labelC.setForeground(new Color(25,255,0));
	    answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
	    
	    answer_labelD.setBounds(125,400,500,100);
	    answer_labelD.setBackground(new Color(50,50,50));
	    answer_labelD.setForeground(new Color(25,255,0));
	    answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
	    
	    seconds_left.setBounds(535,510,100,100);
	    seconds_left.setBackground(new Color(25,25,25));
	    seconds_left.setForeground(new Color(255,0,0)); 
	    seconds_left.setFont(new Font("Ink free",Font.BOLD,60));
	    seconds_left.setBorder(BorderFactory.createBevelBorder(1));
	    seconds_left.setOpaque(true);
	    seconds_left.setHorizontalAlignment(JTextField.CENTER);
	    seconds_left.setText(String.valueOf(seconds));
	    
	    
	    time_Label.setBounds(535,475,100,25);
	    time_Label.setBackground(new Color(50,50,50));
	    time_Label.setForeground(new Color(255,0,0));
	    time_Label.setFont(new Font("MV Boli",Font.PLAIN,20));
	    time_Label.setHorizontalAlignment(JTextField.CENTER);
	    time_Label.setText("timer>:D");
	    
	   number_right.setBounds(225,225,200,100);
	   number_right.setBackground(new Color(25,25,25));
	   number_right.setForeground(new Color(25,255,0));
	   number_right.setFont(new Font("Ink Free",Font.PLAIN,50));
	   number_right.setBorder(BorderFactory.createBevelBorder(1));
	   number_right.setHorizontalAlignment(JTextField.CENTER);
	   number_right.setEditable(false);
	   
	   percentage.setBounds(225, 325, 200, 100);
	   percentage.setBackground(new Color(25,25,25));
	   percentage.setForeground(new Color(25,255,0));
	   percentage.setFont(new Font("Ink Free",Font.PLAIN,50));
	   percentage.setBorder(BorderFactory.createBevelBorder(1)); 
	   percentage.setHorizontalAlignment(JTextField.CENTER);
	   percentage.setEditable(false);
	   
//	   frame.add(percentage);
//	   frame.add(number_right);
	  // frame.add(background);
	   frame.add(image);
	    frame.add(time_Label);
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
		
		NextQuestion();
	}
	
	public void NextQuestion()
	{
		if(index>=total_questions)
		{
			results();
		}
		else
		{
			textfield.setText("Question"+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA)
		{
			answer='A';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonB)
		{
			answer='B';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonC)
		{
			answer='C';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonD)
		{
			answer='D';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}
		displayanswer();
	}
	public void displayanswer()
	{
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index]!='A')
			answer_labelA.setForeground(new Color(225,0,0));
		if(answers[index]!='B')
			answer_labelB.setForeground(new Color(225,0,0));
		if(answers[index]!='C')
			answer_labelC.setForeground(new Color(225,0,0));
		if(answers[index]!='D')
			answer_labelD.setForeground(new Color(225,0,0));
		
		
		//difficult  part of the program

		Timer pause=new Timer(2000,new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e)
			{
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer=' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				NextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results()
	{
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result=(int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}
}
