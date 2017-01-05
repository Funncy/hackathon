import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuList extends JPanel {
	private JPanel[] menuArray;
	private JLabel[] lblMenuName;
	private JLabel[] lblMenuPrice;
	private JCheckBox[] bSoldOut;
	private int num = 8;
	
	private ArrayList<JPanel> menuArrayList;

	private String ResID;
	
	private double w;
	private double h;
	
	public MenuList(double w, double h,String ResID) {
		int height, width;
		this.w = w;
		this.h = h;
		height = (int) (h * 0.82);
		width = (int) (w * 0.6);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.white);
		this.setLayout(null);
		
		this.ResID = ResID;

		this.setLayout(new GridLayout(num, 1));
		
		menuArrayList = new ArrayList<JPanel>();
		System.out.println("MenuList start");

		
	}// MenuList
	
	
	
	public void setResID(String o)
	{
		ResID = o;
		getData();
	}
	
	private void getData()
	{
	      BufferedReader    oBufReader = null;
	        HttpURLConnection httpConn   = null;
	        String strBuffer = "";
	        String strRslt   = "";
	      
	        try
	        {
	            String strEncodeUrl = "http://gywns41.dothome.co.kr/OwnerGetMenu.php?ID="+ResID;
	            URL oOpenURL = new URL(strEncodeUrl);
	            System.out.println(strEncodeUrl);
	          
	            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
	            httpConn.setRequestMethod("POST");          
	            httpConn.connect();          
	            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
	            	
	            String[] arr;
	            //Buffer�� �ִ� ������ �о� ���ʷ� ȭ�鿡 �ѷ��ش�.
	            while((strBuffer = oBufReader.readLine()) != null)
	            {
	            	System.out.println("str="+strBuffer);
	            	
	            	arr = strBuffer.split(",");
	            	
	        
	            		menuArray = new JPanel[arr.length];
	            		for (int i = 0; i < arr.length-1; i++) {
	            			menuArray[i] = new JPanel();
	            			menuArray[i].setBackground(Color.white);
	            			menuArray[i].setBounds((int) (w * 0.001), (int) (h * 0.1 * i), (int) (w * 0.6), (int) (h * 0.1));
	            			menuArray[i].setLayout(null);
	            			menuArray[i].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.orange));
	            			this.add(menuArray[i]);
	            		} // for

	            		Font fnt = new Font("Verdana", Font.BOLD, 30);

	            		lblMenuName = new JLabel[arr.length];
	            		lblMenuPrice = new JLabel[arr.length];
	            		bSoldOut = new JCheckBox[arr.length];

	            		for (int i = 0; i < arr.length; i+=2) {
	            			lblMenuName[i] = new JLabel(arr[i]);
	            			lblMenuName[i].setFont(fnt);
	            			lblMenuName[i].setForeground(Color.black);
	            			lblMenuName[i].setBounds(0, 0, (int) (w * 0.2), (int) (h * 0.1));
	            			lblMenuName[i].setHorizontalAlignment(SwingConstants.CENTER);
	            			lblMenuName[i].setVerticalAlignment(SwingConstants.CENTER);
	            			menuArray[i].add(lblMenuName[i]);

	            			lblMenuPrice[i] = new JLabel(arr[i+1]);
	            			lblMenuPrice[i].setFont(fnt);
	            			lblMenuPrice[i].setForeground(Color.black);
	            			lblMenuPrice[i].setBounds((int)(w * 0.2), 0, (int) (w * 0.2), (int) (h * 0.1));
	            			lblMenuPrice[i].setHorizontalAlignment(SwingConstants.CENTER);
	            			lblMenuPrice[i].setVerticalAlignment(SwingConstants.CENTER);
	            			menuArray[i].add(lblMenuPrice[i]);

	            			bSoldOut[i] = new JCheckBox("Sold Out");
	            			bSoldOut[i].setFont(fnt);
	            			bSoldOut[i].setForeground(Color.black);
	            			bSoldOut[i].setBackground(Color.white);
	            			bSoldOut[i].setBounds((int)(w * 0.4), 0, (int) (w * 0.2), (int) (h * 0.1));
	            			bSoldOut[i].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.orange));
	            			menuArray[i].add(bSoldOut[i]);
	            		} // for
	            	}
	            	
	            
	          
	        } catch( Exception ee) {
	          ee.getMessage();
	        }
	}
}
