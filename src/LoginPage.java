import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginPage extends JPanel {
	private JTextField	txtID;
	private JPasswordField	txtPassWord;
	private int screenWidth,screenHeight;
	private int txtLength,txtHeight;
	private JLabel lblID,lblPassWord;
	private JButton btnLogin;
	private JLabel lblTitle;
	private ImageIcon im;
	
	public LoginPage(ex e) {
		setBackground(Color.orange);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height-70;
		screenSize.setSize(w, h);
		setPreferredSize(screenSize);
		setLayout(null);
		
		im = new ImageIcon("bg.jpg");
		Image settingImg = im.getImage();
		Image settingImg1 = settingImg.getScaledInstance(screenSize.width, screenSize.height, java.awt.Image.SCALE_SMOOTH);
		im.setImage(settingImg1);
		
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		screenWidth=(int)width;
		screenHeight=(int)height;
		txtLength=400;
		txtHeight=50;
		
		Font fnt = new Font("Verdana",Font.BOLD,30);
		
		lblTitle = new JLabel("오늘 뭐먹지?");
		lblTitle.setFont(new Font("Italic",Font.BOLD,80));
		lblTitle.setBounds(screenWidth/2-300,screenHeight/4,600,100);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		lblID = new JLabel(" ID ");
		lblID.setFont(fnt);
		lblID.setBounds(screenWidth/2-txtLength,screenHeight/2-txtHeight,txtLength,txtHeight);
		add(lblID);
		
		txtID = new JTextField();
		txtID.setText("");
		txtID.setFont(fnt);
		txtID.setBounds(screenWidth/2-txtLength/2,screenHeight/2-txtHeight,txtLength,txtHeight);
		add(txtID);
		
		txtPassWord = new JPasswordField();
		txtPassWord.setFont(fnt);
		txtPassWord.setText("");
		txtPassWord.setBounds(screenWidth/2-txtLength/2,screenHeight/2+txtHeight,txtLength,txtHeight);
		add(txtPassWord);
		
		lblPassWord = new JLabel("PASSWORD");
		lblPassWord.setFont(fnt);
		lblPassWord.setBounds(screenWidth/2-txtLength,screenHeight/2+txtHeight,txtLength,txtHeight);
		add(lblPassWord);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(fnt);
		btnLogin.setBounds(screenWidth/2+txtLength/2+10,screenHeight/2-txtHeight,txtLength/2,txtHeight*3);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if (txtID.getText().length() != 0 && txtPassWord.getText().length() != 0){
					String imsy = checkID(txtID.getText(),txtPassWord.getText());
					if(imsy!=null)
						e.ChangePanel(imsy,txtID.getText());
				}else {
					JOptionPane.showMessageDialog(null, "�Է��� ���� �ʾҽ��ϴ�",
							"Login Fail",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
	
	public String checkID(String Id,String pass){
	      BufferedReader    oBufReader = null;
	        HttpURLConnection httpConn   = null;
	        String strBuffer = "";
	        String strRslt   = "";
	      
	        try
	        {
	            String strEncodeUrl = "http://gywns41.dothome.co.kr/ownerLogin.php?ID="+Id+"&Password="+pass;
	            URL oOpenURL = new URL(strEncodeUrl);
	            System.out.println(strEncodeUrl);
	          
	            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
	            httpConn.setRequestMethod("POST");          
	            httpConn.connect();          
	            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
	  
	            //Buffer�� �ִ� ������ �о� ���ʷ� ȭ�鿡 �ѷ��ش�.
	            while((strBuffer = oBufReader.readLine()) != null)
	            {
	            	strBuffer.trim();

	            	System.out.println("str="+strBuffer);
	            	if(!strBuffer.equals(" ")){
	            	return strBuffer;
	            	}
	            }
	          
	        } catch( Exception ee) {
	          ee.getMessage();
	        }
		return null;
	}
	public void paintComponent (Graphics page) { // paint
		super.paintComponent(page);
		
		//page.drawImage(im.getImage(), 0, 0, null);
	}
}
