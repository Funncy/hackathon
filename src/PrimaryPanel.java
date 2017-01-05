import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class PrimaryPanel extends JPanel{
	private JPanel 	ReservationTitle;
	private JPanel 	ReservationPanel;
	private JPanel 	CommentTitle;
	private JPanel 	CommentPanel;
	private JLabel 	lblReservationTitle;
	private JLabel	lblCommentTitle;
	private JButton	btnMore;
	
	private CommentInfoPanel com1;
	private CommentInfoPanel com2;
	private CommentInfoPanel com3;
	private CommentInfoPanel com4;
	
	private int Width, Height;
	private int arrayLength = 11;
	
	JScrollPane scroll, scroll1, scroll2;
	private GridBagLayout Gbag = new GridBagLayout();
	private GridBagLayout Gbag1 = new GridBagLayout();
	
	private ArrayList<ReservationData>	RdataList;
	private ArrayList<CommentData>		CdataList;
	
	private JScrollPane scrollPane;
	
	private Menu menu;
	private JPanel manageMenu;
	private StateStore stateStore;
	private double screenWidth, screenHeight;
	
	private String OwnerID;
	private String ResID;
	
	public PrimaryPanel(ex E) {
		setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height-80;
		Width = screenSize.width;
		Height = screenSize.height;
		
		screenSize.setSize(w, h);
		setPreferredSize(screenSize);	// ũ��� ���� ����
		setLayout(null);	// ���̾ƿ� NULL
		
		RdataList = new ArrayList<ReservationData>();
		CdataList = new ArrayList<CommentData>();
		
		ReservationTitle = new JPanel();
		ReservationTitle.setBounds((int)(screenSize.width*0.6), 0, (int)(screenSize.width*0.4), (int)(screenSize.height*0.07));
		ReservationTitle.setBackground(Color.cyan);
		this.add(ReservationTitle);
		
		lblReservationTitle = new JLabel("Reservation List");
		lblReservationTitle.setFont(new Font("Verdana", Font.BOLD, 40));
		lblReservationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservationTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblReservationTitle.setForeground(Color.darkGray);
		lblReservationTitle.setVisible(true);
		ReservationTitle.add(lblReservationTitle);
		
		ReservationPanel = new JPanel();
		ReservationPanel.setBounds((int)(screenSize.width*0.6), (int)(screenSize.height*0.07), (int)(screenSize.width*0.4), (int)(screenSize.height*0.63));
		ReservationPanel.setBackground(Color.white);
		ReservationPanel.setLayout(Gbag);
		this.add(ReservationPanel);
		
		scroll = new JScrollPane(ReservationPanel);
		scroll.setBounds((int)(screenSize.width*0.6), (int)(screenSize.height*0.07), (int)(screenSize.width*0.4), (int)(screenSize.height*0.63));
		add(scroll);
		
		CommentTitle = new JPanel();
		CommentTitle.setBounds((int)(screenSize.width*0.6), (int)(screenSize.height*0.7), (int)(screenSize.width*0.4), (int)(screenSize.height*0.07));
		CommentTitle.setBackground(Color.cyan);
		this.add(CommentTitle);
		
		lblCommentTitle = new JLabel("add Menu");
		lblCommentTitle.setFont(new Font("Verdana", Font.BOLD, 40));
		lblCommentTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblCommentTitle.setForeground(Color.darkGray);
		lblCommentTitle.setVisible(true);
		CommentTitle.add(lblCommentTitle);
		
		CommentPanel = new JPanel();
		CommentPanel.setBounds((int)(screenSize.width*0.6), (int)(screenSize.height*0.77), (int)(screenSize.width*0.4), (int)(screenSize.height*0.23));
		CommentPanel.setBackground(Color.white);
		CommentPanel.setLayout(Gbag1);
		this.add(CommentPanel);
		
		scroll1 = new JScrollPane(CommentPanel);
		scroll1.setBounds((int)(screenSize.width*0.6), (int)(screenSize.height*0.77), (int)(screenSize.width*0.4), (int)(screenSize.height*0.23));
		add(scroll1);
		
		MakeList();
		ListManager();
		
		com1 = new CommentInfoPanel("������","������� ơơơ");
		create_form1(com1, 0, 0, (int)(screenSize.width*0.3),(int)(screenSize.height*0.07)); 
		com2 = new CommentInfoPanel("������", "���־�� ������");
		create_form1(com2, 0, (int)(screenSize.height*0.07)*1, (int)(screenSize.width*0.3), (int)(screenSize.height*0.07));
		com3 = new CommentInfoPanel("��ȿ��", "���ָ��ָ��ָ���");
		create_form1(com3, 0,(int)(screenSize.height*0.07)*2,(int)(screenSize.width*0.3),(int)(screenSize.height*0.07)); 
		com4 = new CommentInfoPanel("�����", "����������������");
		create_form1(com4, 0,(int)(screenSize.height*0.07)*3,(int)(screenSize.width*0.3),(int)(screenSize.height*0.07)); 
		
		btnMore = new JButton("add");
		btnMore.setFont(new Font("Verdana", Font.BOLD, 20));
		btnMore.setForeground(Color.PINK);
		btnMore.setLocation(100,100);
		CommentTitle.add(btnMore);
		btnMore.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String FoodName = (String)JOptionPane.showInputDialog(
 	                    null,
 	                    "Input FoodName",
 	                    "FoodName",
 	                    JOptionPane.PLAIN_MESSAGE,
 	                    null,
 	                    null,
 	                    "");
				String FoodPrice = (String)JOptionPane.showInputDialog(
 	                    null,
 	                    "Input FoodPrice",
 	                    "FoodPrice",
 	                    JOptionPane.PLAIN_MESSAGE,
 	                    null,
 	                    null,"");
				
				addData(FoodName,FoodPrice);
				
			}
			
		});
		
		screenWidth = screenSize.getWidth();
		screenHeight = screenSize.getHeight();

		menu = new Menu(screenWidth, screenHeight);
		menu.setBounds(0, 0, (int) (screenWidth * 0.6), (int) (screenHeight * 0.07));
		this.add(menu);

		manageMenu = new MenuList(screenWidth, screenHeight,OwnerID);
		manageMenu.setBounds(0, (int) (screenHeight * 0.07), (int) (screenWidth * 0.6), (int) (screenHeight * 0.82));
		this.add(manageMenu);
		scrollPane = new JScrollPane(manageMenu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, (int) (screenHeight * 0.07), (int) (screenWidth * 0.6), (int) (screenHeight * 0.82));
		this.add(scrollPane);
		
		stateStore = new StateStore(screenWidth, screenHeight, this);
		stateStore.setBounds(0, (int) (screenHeight * 0.89), (int) (screenWidth * 0.6), (int) (screenHeight * 0.11));
		this.add(stateStore);
		
	}
	public void stateChange(ImageIcon change) {
		menu.changeState(change);
	}
	
	public void addData(String Name,String Price)
	{
		BufferedReader    oBufReader = null;
        HttpURLConnection httpConn   = null;
        String strBuffer = "";
        String strRslt   = "";
        String Id = ResID.trim();
	 try
        {
            String strEncodeUrl = "http://gywns41.dothome.co.kr/OwnerInsertMenu.php?ResID="+Id+"&Price="+Price+"&FoodName="+Name;
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
	
	public void setOwner(String owner,String ResID)
	{
		OwnerID = owner;
		this.ResID = ResID;
		((MenuList)manageMenu).setResID(ResID);
		MakeList() ;
		ListManager();
	}

	public void create_form(Component cmpt, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		this.Gbag.setConstraints(cmpt, gbc);
		ReservationPanel.add(cmpt);
		ReservationPanel.updateUI();
	}

	public void create_form1(Component cmpt1, int x, int y, int w, int h) {
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridx = x;
		gbc1.gridy = y;
		gbc1.gridwidth = w;
		gbc1.gridheight = h;
		this.Gbag1.setConstraints(cmpt1, gbc1);
		CommentPanel.add(cmpt1);
		CommentPanel.updateUI();
	}
	public void MakeList() {
		 BufferedReader    oBufReader = null;
	        HttpURLConnection httpConn   = null;
	        String strBuffer = "";
	        String strRslt   = "";
		 try
	        {
	            String strEncodeUrl = "http://gywns41.dothome.co.kr/OwnerGetReservation.php?ID="+ResID;
	            URL oOpenURL = new URL(strEncodeUrl);
	            System.out.println(strEncodeUrl);
	          
	            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
	            httpConn.setRequestMethod("POST");          
	            httpConn.connect();          
	            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
	            strBuffer = oBufReader.readLine();
	            String[] arr;
	            
	            System.out.println(strBuffer);
	            arr = strBuffer.split(",");
	            
	            for(int i=0;i<arr.length-1;i+=3)
	            {
	            	  System.out.println("add");
	            	RdataList.add(new ReservationData(Integer.parseInt(arr[i]),Long.parseLong(arr[i+1]), arr[i+2]));
	            }
	            	
	            
	          
	        } catch( Exception ee) {
	          ee.getMessage();
	        }
		 ReservationPanel.updateUI();
	}
	
	public String getRedID() { return ResID ; }
	
	public void ListManager() {
		ReservationInfoPanel p;
		if (RdataList.size() != 0) {
			for (int i = 0; i < RdataList.size(); i++) {
				p = new ReservationInfoPanel(RdataList.get(i), this);
				create_form(p, 0, (int) (Height * 0.07) * i, (int) (Width * 0.36), (int) (Height * 0.07));
			}
		}
		ReservationPanel.updateUI();
		
	}
	public ArrayList<ReservationData> getRdataList() {
		return RdataList;
	}
	public void setRdataList(ArrayList<ReservationData> rdataList) {
		RdataList = rdataList;
	}
	public JPanel getReservationPanel() {
		return ReservationPanel;
	}
	
}
