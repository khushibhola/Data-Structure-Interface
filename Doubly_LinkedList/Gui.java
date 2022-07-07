import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui implements ActionListener 
{
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel doublyLinkedListTitle,addBack,addFront,addAfter,removeFirst,removeLast,removeAt,displayForward,displayBackword,size,sizeDisplay,displayForwardValue,displayBackwordValue;
	private static JTextField addBackTF,addFrontTF,addAfterTF,addAfterIndexTF,removeAfterIndexTF;
	private static JButton  addBackButton, addFrontButton,addAfterButton,removeFirstButton,removeLastButton,removeAtButton;
	private static DoublyLLGui<String> list = new DoublyLLGui<String>();

	public static void main(String args[])
	{ 
		frame=new JFrame("Doubly LinkedList");
		frame.setSize(800,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel=new JPanel();
		panel.setLayout(null);

		frame.add(panel);

		doublyLinkedListTitle=new JLabel("Doubly LinkedList of String");
		doublyLinkedListTitle.setBounds(200,0,200,25);
		panel.add(doublyLinkedListTitle);

		// creating a label, textField and a button to add in the back
		addBack=new JLabel("Add element in the Back");
		addBack.setBounds(10,60,150,25);
		panel.add(addBack);

		addBackTF=new JTextField();
		addBackTF.setBounds(250,60,200,25);
		addBackTF.setBackground(Color.pink);
		panel.add(addBackTF);

		addBackButton=new JButton("Add Back");
		addBackButton.setBounds(500,60,150,25);
		panel.add(addBackButton);
		addBackButton.addActionListener(new Gui());

		// creating a label, textField and a button to add element in front
		addFront=new JLabel("Add element in the Front");
		addFront.setBounds(10,90,150,25);
		panel.add(addFront);

		addFrontTF=new JTextField();
		addFrontTF.setBounds(250,90,200,25);
		addFrontTF.setBackground(Color.pink);
		panel.add(addFrontTF);

		addFrontButton=new JButton("Add Front");
		addFrontButton.setBounds(500,90,150,25);
		panel.add(addFrontButton);
		addFrontButton.addActionListener(new Gui());

		// creating a label, textField and a button to add element in the specified index
		addAfter=new JLabel("Add element at position (element,position)");
		addAfter.setBounds(10,120,250,25);
		panel.add(addAfter);

		addAfterTF=new JTextField(); // text field for element
		addAfterTF.setBounds(250,120,150,25);
		addAfterTF.setBackground(Color.pink);
		panel.add(addAfterTF);

		addAfterIndexTF=new JTextField(); // text field for index
		addAfterIndexTF.setBounds(410,120,40,25);
		addAfterIndexTF.setBackground(Color.pink);
		panel.add(addAfterIndexTF);

		addAfterButton=new JButton("Add After");
		addAfterButton.setBounds(500,120,150,25);
		panel.add(addAfterButton);
		addAfterButton.addActionListener(new Gui());

		// creating a label and a button to remove the first element
		removeFirst=new JLabel("Remove element in the front");
		removeFirst.setBounds(10,150,200,25);
		panel.add(removeFirst);

		removeFirstButton=new JButton("Remove First");
		removeFirstButton.setBounds(500,150,150,25);
		panel.add(removeFirstButton);
		removeFirstButton.addActionListener(new Gui());

		// creating a label and a button to remove the last element
		removeLast=new JLabel("Remove element in the last");
		removeLast.setBounds(10,180,200,25);
		panel.add(removeLast);

		removeLastButton=new JButton("Remove Last");
		removeLastButton.setBounds(500,180,150,25);
		panel.add(removeLastButton);
		removeLastButton.addActionListener(new Gui());

		// creating a label, textField and a button to remove at the index specified
		removeAt=new JLabel("Remove at position (position)");
		removeAt.setBounds(10,210,200,25);
		panel.add(removeAt);

		removeAfterIndexTF=new JTextField(); // text field for index
		removeAfterIndexTF.setBounds(250,210,200,25);
		removeAfterIndexTF.setBackground(Color.pink);
		panel.add(removeAfterIndexTF);

		removeAtButton=new JButton("Remove At");
		removeAtButton.setBounds(500,210,150,25);
		panel.add(removeAtButton);
		removeAtButton.addActionListener(new Gui());

		// creating a label, textField and a button to display the size of the list
		size=new JLabel("Size of the List");
		size.setBounds(10,240,150,25);
		panel.add(size);

		sizeDisplay=new JLabel();
		sizeDisplay.setBounds(250,240,200,25);
		sizeDisplay.setBackground(Color.pink);
		panel.add(sizeDisplay);

		// creating a label, textField and a button to display the element forward manner
		displayForward=new JLabel("Display Forward");
		displayForward.setBounds(10,270,200,25);
		panel.add(displayForward);

		displayForwardValue=new JLabel();
		displayForwardValue.setBounds(250,270,200,25);
		displayForwardValue.setBackground(Color.pink);
		panel.add(displayForwardValue);

		// creating a label, textField and a button to display the element Backward manner
		displayBackword=new JLabel("Display Backword");
		displayBackword.setBounds(10,300,200,25);
		panel.add(displayBackword);

		displayBackwordValue=new JLabel();
		displayBackwordValue.setBounds(250,300,200,25);
		displayBackwordValue.setBackground(Color.pink);
		panel.add(displayBackwordValue);

		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Add Back")
		{
			list.addBack(addBackTF.getText());
			update();
		}
		if(e.getActionCommand() == "Add Front")
		{
			list.addFront(addFrontTF.getText());
			update();
		}
		if(e.getActionCommand() == "Add After")
		{
			try
			{
				int x= Integer.parseInt(addAfterIndexTF.getText());
				list.addAfter(addAfterTF.getText(),x);
				update();
			}catch(NumberFormatException ex)
			{

				JOptionPane.showMessageDialog(null, "One of the field is empty");
			}
		}
		if(e.getActionCommand() == "Remove First")
		{
			list.removeFirst();
			update();
		}
		if(e.getActionCommand() == "Remove Last")
		{	
			list.removeLast();
			update();
		}
		if(e.getActionCommand() == "Remove At")
		{
			try
			{
				list.removeAt(Integer.parseInt(removeAfterIndexTF.getText()));	
				update();
			}
			catch(NumberFormatException exe)
			{
				JOptionPane.showMessageDialog(null, "please enter the position");
			}
		}	
	}
	public void update()
	{
		String tempDisplayForward=list.display();
		displayForwardValue.setText(tempDisplayForward);
		String tempDisplayBackword=list.displayBackWord();
		displayBackwordValue.setText(tempDisplayBackword);
		sizeDisplay.setText(String.valueOf(list.getSize()));
	}
}