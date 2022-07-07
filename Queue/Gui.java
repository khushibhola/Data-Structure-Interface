import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Khushi Bhola(0404531)
 *
 */
public class Gui implements ActionListener 
{
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel circularQueueTitle,enqueueLabel,dequeueLabel,clearLabel,emptyLabel,emptyAnswerLabel,sizeLabel,sizeDisplay,frontLabel,frontDisplay,toStringLabel,toStringDisplay;
	private static JTextField enqueueTF;
	private static JButton  enqueueButton, dequeueButton,clearButton;
	private static QueueGui<String> list = new QueueGui<String>();

	public static void main(String args[])
	{ 
		frame=new JFrame("Circular Queue");
		frame.setSize(800,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel=new JPanel();
		panel.setLayout(null);

		frame.add(panel);

		circularQueueTitle=new JLabel("Circular Queue of String");
		circularQueueTitle.setBounds(200,0,200,25);
		panel.add(circularQueueTitle);

		// creating a label, textField and a button to add elements in the circular queue
		enqueueLabel=new JLabel("Element to insert");
		enqueueLabel.setBounds(10,60,150,25);
		panel.add(enqueueLabel);

		enqueueTF=new JTextField();
		enqueueTF.setBounds(250,60,200,25);
		enqueueTF.setBackground(Color.pink);
		panel.add(enqueueTF);

		enqueueButton=new JButton("Enqueue");
		enqueueButton.setBounds(500,60,150,25);
		panel.add(enqueueButton);
		enqueueButton.addActionListener(new Gui());

		// creating a label and a button to delete elements in the circular queue
		dequeueLabel=new JLabel("Deletion");
		dequeueLabel.setBounds(10,90,150,25);
		panel.add(dequeueLabel);

		dequeueButton=new JButton("Dequeue");
		dequeueButton.setBounds(500,90,150,25);
		panel.add(dequeueButton);
		dequeueButton.addActionListener(new Gui());

		// creating a label and a button to clear elements in the queue
		clearLabel=new JLabel("Clear the Queue");
		clearLabel.setBounds(10,120,250,25);
		panel.add(clearLabel);

		clearButton=new JButton("Clear");
		clearButton.setBounds(500,120,150,25);
		panel.add(clearButton);
		clearButton.addActionListener(new Gui());

		// creating a label and a button to check if the queue is empty or not
		emptyLabel=new JLabel("Is Empty ?");
		emptyLabel.setBounds(10,210,200,25);
		panel.add(emptyLabel);

		emptyAnswerLabel=new JLabel(); // text field for index
		emptyAnswerLabel.setBounds(250,210,200,25);
		emptyAnswerLabel.setBackground(Color.pink);
		panel.add(emptyAnswerLabel);


		// creating labels to display the front element of the queue
		frontLabel=new JLabel("Front");
		frontLabel.setBounds(10,240,150,25);
		panel.add(frontLabel);

		frontDisplay=new JLabel();
		frontDisplay.setBounds(250,240,200,25);
		frontDisplay.setBackground(Color.pink);
		panel.add(frontDisplay);

		// creating labels to display the size of the queue
		sizeLabel=new JLabel("Size");
		sizeLabel.setBounds(10,270,200,25);
		panel.add(sizeLabel);

		sizeDisplay=new JLabel();
		sizeDisplay.setBounds(250,270,200,25);
		sizeDisplay.setBackground(Color.pink);
		panel.add(sizeDisplay);

		// creating labels to display the queue
		toStringLabel=new JLabel("toString");
		toStringLabel.setBounds(10,300,200,25);
		panel.add(toStringLabel);

		toStringDisplay=new JLabel();
		toStringDisplay.setBounds(250,300,200,25);
		toStringDisplay.setBackground(Color.pink);
		panel.add(toStringDisplay);

		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Enqueue")
		{
			list.enqueue(enqueueTF.getText());
			update();
		}
		if(e.getActionCommand() == "Dequeue")
		{
			list.dequeue();
			update();
		}
		if(e.getActionCommand() == "Clear")
		{
			list.clear();
			update();
		}	
	}
	public void update()
	{
		boolean empty=list.empty();
		emptyAnswerLabel.setText(String.valueOf(empty));
		String front=list.front();
		frontDisplay.setText(front);
		int size=list.size();
		sizeDisplay.setText(String.valueOf(size));
		String toString=list.toString();
		toStringDisplay.setText(toString);
	}
}