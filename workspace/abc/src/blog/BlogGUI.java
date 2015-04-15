package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import abc.Post;
import abc.User;

public class BlogGUI{
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private JLabel postTextAreaLabel;
	private Blog myBlog;
	
	public BlogGUI() {
		myBlog = new Blog(new User(1, "DefaultUser", "a@cse.ust.hk"));
	}
	
	public void setWindow() {
	mainFrame= new JFrame("Your Name");
	mainFrame.setSize(500,500);
	mainFrame.setLayout(new GridLayout());
	postTextArea = new JTextArea(20,40);
	postTextArea.setText("What's on your mind?");
	postTextArea.setBackground(Color.decode("#FFFFE0"));
	postTextArea.addKeyListener(new lengthListener());
	postContent=new JTextArea();
	postContent.setEditable(false);
	postContent.setText("Here is put my posts!");
	refresh = new JButton("refresh");
	refresh.addActionListener(new refreshListener());
	post = new JButton("post");
	post.addActionListener(new postListener());
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new BorderLayout());
	buttonPanel.add(refresh,BorderLayout.WEST);
	buttonPanel.add(post, BorderLayout.EAST);
	JPanel subPanel = new JPanel();
	postTextAreaLabel = new JLabel("You can still input 140 characters");
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
	class postListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String content = postTextArea.getText();
			postTextArea.setText("");
			postContent.setText(content);
			Post newPost = new Post(Calendar.getInstance().getTime(), content);
			myBlog.add(newPost);
			myBlog.save("M:/DefaultUser.blog");
		}
	}
	class refreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			myBlog.load("M:/DefaultUser.blog");
			postContent.setText(myBlog.toString());
		}
	}
	class lengthListener implements KeyListener {
		public void keyTyped(KeyEvent e){
		}
		public void keyPressed(KeyEvent e){
		}
		public void keyReleased(KeyEvent e){
			int length = postTextArea.getText().length();
			postTextAreaLabel.setText("You can still input "+(140-length)+" characters");
		}
	}
}
