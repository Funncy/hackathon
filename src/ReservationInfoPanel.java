import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import  com.pushraven.*;

public class ReservationInfoPanel extends JPanel {
	private ReservationData data;
	private JLabel lblData;
	private JButton btnDelete;
	private JButton btnMessage;
	private ImageIcon exit,message;
	
	private PrimaryPanel p;
	
	private DeleteListener deleteL;
	private MessageListener MessageL;
	
	private String a = "학번: ";
	private String b = "메뉴: ";
	public ReservationInfoPanel() {
		setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)(screenSize.width*0.36),(int)(screenSize.height*0.07)));
		setLayout(null);
		
		data = new ReservationData();
		
		deleteL = new DeleteListener();
		MessageL = new MessageListener();
		
		lblData = new JLabel();
		lblData.setBounds(3, 1, (int)(screenSize.width*0.3),(int)(screenSize.height*0.07));
		lblData.setText("<html>"+a+data.getStuNum()+"<br>"+b+data.getMenu()+"</html>");
		lblData.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setVerticalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.darkGray);
		add(lblData);
		

		exit = new ImageIcon("x.png");
		message = new ImageIcon("message.png");
		Image settingImg = exit.getImage();
		Image settingImg1 = settingImg.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
		exit.setImage(settingImg1);
		
		btnDelete = new JButton(exit);
		btnDelete.setText(data.getStuNum()+"");
		btnDelete.setBounds((int)(screenSize.width*0.36)-50, (int)(screenSize.height*0.07)-55, 45, 45);
		btnDelete.setBorderPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setFocusPainted(false);
		add(btnDelete);
		btnDelete.addActionListener(deleteL);
		
		btnMessage = new JButton(message);
		btnMessage.setText(data.getStuNum()+"");
		btnMessage.setBounds((int)(screenSize.width*0.36)-100, (int)(screenSize.height*0.07)-55, 45, 45);
		btnMessage.setBorderPainted(false);
		btnMessage.setContentAreaFilled(false);
		btnMessage.setFocusPainted(false);
		add(btnMessage);
		btnMessage.addActionListener(MessageL);
		
	}
	

	private String getData(String StudentID)
	{
	      BufferedReader    oBufReader = null;
	        HttpURLConnection httpConn   = null;
	        String strBuffer = "";
	        String strRslt   = "";
	      
	        try
	        {
	            String strEncodeUrl = "http://gywns41.dothome.co.kr/OwnerGetToken.php?ID="+StudentID;
	            URL oOpenURL = new URL(strEncodeUrl);
	            System.out.println(strEncodeUrl);
	          
	            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
	            httpConn.setRequestMethod("POST");          
	            httpConn.connect();          
	            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
	            	
	         
	            if((strBuffer = oBufReader.readLine()) != null)
	            {
	            	return strBuffer;
	            }
	            	
	            return null;
	          
	        } catch( Exception ee) {
	          ee.getMessage();
	          return null;
	        }
	}
	
	public void removeData()
	{
		String MenuID = data.getID()+"";
		
		 BufferedReader    oBufReader = null;
	        HttpURLConnection httpConn   = null;
	      
	        try
	        {
	            String strEncodeUrl = "http://gywns41.dothome.co.kr/OwnerRemoveReservation.php?ID="+MenuID;
	            URL oOpenURL = new URL(strEncodeUrl);
	            System.out.println(strEncodeUrl);
	          
	            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
	            httpConn.setRequestMethod("POST");          
	            httpConn.connect();          
	            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
	            
	    
	          
	        } catch( Exception ee) {
	          ee.getMessage();
	   
	        }
	}
	
	public void fcmTest1(String message,String StudentID,int flag) {
		
		
		String token = getData(StudentID);
		
		String title;
		if(flag==0){
			title = "주문완료";
		}
		else
		{
			removeData();
			title = "주문취소";
		}
		
		System.out.println(token+" "+StudentID);
		String my_key = "AAAABwxb4cM:APA91bEIkFuPGtS-6kEtpoi0D4Bk6vbDxU41g_6ui3WCEB-mxM3aadno2YjD103hqt4_5aykBS4lUlwvFfxZ08euNpc3rTfaLQ2QgjutEtoxY6ZLTJAwlR6y8Y_tr83AP86fQB-87Jvq";
		Pushraven.setKey(my_key);
		System.out.println("fcm2");
		Notification raven = new Notification();
		raven.title(title)
		  .text(message)
		  .color("#ff0000")
		  .to(token)
		  ;
		System.out.println("fcm3");
		
		raven.addRequestAttribute("delay_while_idle", true); // for request attributes
		raven.addNotificationAttribute("color", "#ff0000"); // for notification attirubtes
		
		System.out.println("fcm4");
		Pushraven.notification.title("title");
		System.out.println("fcm5");
		Pushraven.push(raven);
		System.out.println("fcm6");
		
	}
	
	
	public ReservationInfoPanel(ReservationData d, PrimaryPanel primary) {
		setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)(screenSize.width*0.36),(int)(screenSize.height*0.07)));
		setLayout(null);
		MessageL = new MessageListener();
		data = d;
		

		message = new ImageIcon("message.png");
		
		p = primary;
		
		deleteL = new DeleteListener();
		
		lblData = new JLabel();
		lblData.setBounds(3, 1, (int)(screenSize.width*0.3),(int)(screenSize.height*0.07));
		lblData.setText("<html>"+a+data.getStuNum()+"<br>"+b+data.getMenu()+"</html>");
		lblData.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setVerticalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.darkGray);
		add(lblData);

		exit = new ImageIcon("x.png");
		Image settingImg = exit.getImage();
		Image settingImg1 = settingImg.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
		exit.setImage(settingImg1);
		
		btnDelete = new JButton(exit);
		btnDelete.setText(data.getStuNum()+"");
		btnDelete.setBounds((int)(screenSize.width*0.36)-50, (int)(screenSize.height*0.07)-55, 45, 45);
		btnDelete.setBorderPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setFocusPainted(false);
		add(btnDelete);
		btnDelete.addActionListener(deleteL);
		
		btnMessage = new JButton(message);
		btnMessage.setText(data.getStuNum()+"");
		btnMessage.setBounds((int)(screenSize.width*0.36)-100, (int)(screenSize.height*0.07)-55, 45, 45);
		btnMessage.setBorderPainted(false);
		btnMessage.setContentAreaFilled(false);
		btnMessage.setFocusPainted(false);
		add(btnMessage);
		btnMessage.addActionListener(MessageL);
	}
	
	public ReservationData getData() {
		return data;
	}
	public void setData(ReservationData data) {
		this.data = data;
	}
	private class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton j =(JButton)event.getSource();
			String StudentID = j.getText().toString();
		
			String MessageBody = (String)JOptionPane.showInputDialog(
	                    null,
	                    "Input Message",
	                    "Message",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    "");
			fcmTest1(MessageBody,StudentID,1);//주문취소
		}
	}
	
	private class MessageListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton j =(JButton)event.getSource();
			String StudentID = j.getText().toString();
	
			String MessageBody = (String)JOptionPane.showInputDialog(
	                    null,
	                    "Input Message",
	                    "Message",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    "");
			fcmTest1(MessageBody,StudentID,0);//주문완료
			
		}
	}
}
