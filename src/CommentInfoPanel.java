import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CommentInfoPanel extends JPanel {
	private CommentData data;
	private JLabel lblComment;

	public CommentInfoPanel() {
		setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)(screenSize.width*0.36),(int)(screenSize.height*0.07)));
		setLayout(null);
		
		data = new CommentData();
		
		lblComment = new JLabel();
		lblComment.setBounds(3, 1, (int)(screenSize.width*0.3),(int)(screenSize.height*0.07));
		lblComment.setText("<html>"+"이름 : "+data.getName()+"<br>"+"한줄평 : "+data.getComment()+"</html>");
		lblComment.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblComment.setHorizontalAlignment(SwingConstants.CENTER);
		lblComment.setVerticalAlignment(SwingConstants.CENTER);
		lblComment.setHorizontalTextPosition(SwingConstants.LEFT);
		lblComment.setForeground(Color.DARK_GRAY);
		add(lblComment);
	}
	
	public CommentInfoPanel(CommentData d) {
		setBackground(Color.darkGray);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)(screenSize.width*0.36),(int)(screenSize.height*0.07)));
		setLayout(null);
		
		data = d;
		
		
		lblComment = new JLabel();
		lblComment.setBounds(3, 1, (int)(screenSize.width*0.3),(int)(screenSize.height*0.07));
		lblComment.setText("<html>"+"이름 : "+data.getName()+"<br>"+"한줄평 : "+data.getComment()+"</html>");
		lblComment.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblComment.setHorizontalAlignment(SwingConstants.CENTER);
		lblComment.setVerticalAlignment(SwingConstants.CENTER);
		lblComment.setHorizontalTextPosition(SwingConstants.LEFT);
		lblComment.setForeground(Color.DARK_GRAY);
		add(lblComment);
	}
	public CommentInfoPanel(String s, String c) {
		setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)(screenSize.width*0.36),(int)(screenSize.height*0.07)));
		setLayout(null);
		
		data = new CommentData();
		
		data.setName(s);
		data.setComment(c);
		
		
		lblComment = new JLabel();
		lblComment.setBounds(3, 1, (int)(screenSize.width*0.3),(int)(screenSize.height*0.07));
		lblComment.setText("<html>"+"이름 : "+data.getName()+"<br>"+"한줄평 : "+data.getComment()+"</html>");
		lblComment.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblComment.setHorizontalAlignment(SwingConstants.CENTER);
		lblComment.setVerticalAlignment(SwingConstants.CENTER);
		lblComment.setHorizontalTextPosition(SwingConstants.LEFT);
		lblComment.setForeground(Color.DARK_GRAY);
		add(lblComment);
	}

	public CommentData getData() {
		return data;
	}

	public void setData(CommentData data) {
		this.data = data;
	}
	public void setName(String name) {
		data.setName(name);
	}
	public void setComment(String comment) {
		data.setComment(comment);
	}
}
