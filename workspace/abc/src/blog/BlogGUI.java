package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlogGUI implements ActionListener{
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI() {

	}
	
	public void setWindow() {
	mainFrame= new JFrame("Your Name");
	mainFrame.setSize(500,500);
	mainFrame.setLayout(new GridLayout());
	postTextArea = new JTextArea(20,40);
	postTextArea.setText("What's on your mind?");
	postTextArea.setBackground(Color.decode("#FFFFE0"));
	postContent=new JTextField(20);
	postContent.setEditable(false);
	postContent.setText("Here is put my posts!");
	refresh = new JButton("refresh");
	refresh.addActionListener(this);
	post = new JButton("post");
	post.addActionListener(this);
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new BorderLayout());
	buttonPanel.add(refresh,BorderLayout.WEST);
	buttonPanel.add(post, BorderLayout.EAST);
	JPanel subPanel = new JPanel();
	JLabel postTextAreaLabel = new JLabel("You can still input 140 characters");
	subPanel.setLayout(new BorderLayout());
	subPanel.setSize(200,400);
	subPanel.add(postTextAreaLabel,BorderLayout.PAGE_START);
	subPanel.add(postTextArea,BorderLayout.CENTER);
	subPanel.add(buttonPanel,BorderLayout.SOUTH);
	JPanel mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	mainPanel.setSize(400, 400);
	mainPanel.add(subPanel,BorderLayout.NORTH);
	mainPanel.add(postContent,BorderLayout.SOUTH);

	mainFrame.add(mainPanel);
	mainFrame.setVisible(true);
	mainFrame.setLayout(new FlowLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == post) {
			postContent.setText("You click POST!");
		}
		if(e.getSource() == refresh) {
			postContent.setText("You click REFRESH!");
		}
	}
	
}
