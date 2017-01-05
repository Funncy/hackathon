import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StateStore extends JPanel {

	private ImageIcon cir, tri, x;
	private JButton bntCir, bntTri, bntX;
	private JLabel lblCir, lblTri, lblX;

	private PrimaryPanel main;

	private stateChangeListener stateChange;

	public StateStore(double w, double h, PrimaryPanel p) {
		this.setBackground(Color.yellow);

		int height, width;
		height = (int) (h * 0.08);
		width = (int) (w * 0.6);
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLUE));
		this.setBackground(Color.white);
	
		this.setLayout(null);

		cir = new ImageIcon("circle.png");
		Image cir_1 = cir.getImage();
		Image cir_2 = cir_1.getScaledInstance((int) (h * 0.06), (int) (h * 0.06), java.awt.Image.SCALE_SMOOTH);
		cir.setImage(cir_2);

		tri = new ImageIcon("triangle.png");
		Image tri_1 = tri.getImage();
		Image tri_2 = tri_1.getScaledInstance((int) (h * 0.06), (int) (h * 0.06), java.awt.Image.SCALE_SMOOTH);
		tri.setImage(tri_2);

		x = new ImageIcon("x.png");
		Image x_1 = x.getImage();
		Image x_2 = x_1.getScaledInstance((int) (h * 0.06), (int) (h * 0.06), java.awt.Image.SCALE_SMOOTH);
		x.setImage(x_2);

		Font fnt = new Font("Verdana", Font.BOLD, 40);

		stateChange = new stateChangeListener();

		bntCir = new JButton(cir);
		bntCir.setBounds((int) (w * 0.001), 0, (int) (h * 0.075), (int) (h * 0.078));
		bntCir.setHorizontalAlignment(SwingConstants.CENTER);
		bntCir.setVerticalAlignment(SwingConstants.CENTER);
		bntCir.setFocusPainted(false);
		bntCir.setBorderPainted(false);
		bntCir.setContentAreaFilled(false);
		bntCir.addMouseListener(stateChange);
		this.add(bntCir);

		lblCir = new JLabel("EMPTY");
		lblCir.setFont(fnt);
		lblCir.setVerticalAlignment(SwingConstants.CENTER);
		lblCir.setHorizontalAlignment(SwingConstants.LEFT);
		lblCir.setForeground(Color.BLACK);
		lblCir.setBounds((int) (w * 0.003 + h * 0.075), 0, (int) (w * 0.2), height);
		this.add(lblCir);

		bntTri = new JButton(tri);
		bntTri.setBounds((int) (w * 0.2), 0, (int) (h * 0.075), (int) (h * 0.078));
		bntTri.setHorizontalAlignment(SwingConstants.CENTER);
		bntTri.setVerticalAlignment(SwingConstants.CENTER);
		bntTri.setFocusPainted(false);
		bntTri.setBorderPainted(false);
		bntTri.setContentAreaFilled(false);
		bntTri.addMouseListener(stateChange);
		this.add(bntTri);

		lblTri = new JLabel("SPARE");
		lblTri.setFont(fnt);
		lblTri.setVerticalAlignment(SwingConstants.CENTER);
		lblTri.setHorizontalAlignment(SwingConstants.LEFT);
		lblTri.setForeground(Color.BLACK);
		lblTri.setBounds((int) (w * 0.003 + h * 0.075 + w * 0.2), 0, (int) (w * 0.2), height);
		this.add(lblTri);

		bntX = new JButton(x);
		bntX.setBounds((int) (w * 0.4), 0, (int) (h * 0.075), (int) (h * 0.078));
		bntX.setHorizontalAlignment(SwingConstants.CENTER);
		bntX.setVerticalAlignment(SwingConstants.CENTER);
		bntX.setFocusPainted(false);
		bntX.setBorderPainted(false);
		bntX.setContentAreaFilled(false);
		bntX.addMouseListener(stateChange);
		this.add(bntX);

		lblX = new JLabel("FULL");
		lblX.setFont(fnt);
		lblX.setVerticalAlignment(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setForeground(Color.BLACK);
		lblX.setBounds((int) (w * 0.003 + h * 0.075 + w * 0.4), 0, (int) (w * 0.2), height);
		this.add(lblX);

		main = p;
	}
	
	private void changeState(int flag){
		
		
		System.out.println("test");
	      BufferedReader    oBufReader = null;
	        HttpURLConnection httpConn   = null;
	        String strBuffer = "";
	        String strRslt   = "";
	        
	        int id = Integer.parseInt(main.getRedID().trim());
	      
	        try
	        {
	            String strEncodeUrl = "http://gywns41.dothome.co.kr/OwnerUpdateState.php?ID="+id+"&state="+flag;
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

	public class stateChangeListener implements MouseListener {
		public void mouseClicked(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
			Object obj = event.getSource();

			if (obj == bntCir) {
				main.stateChange(cir);

			} else if (obj == bntTri) {
				main.stateChange(tri);

			} else if (obj == bntX) {
				main.stateChange(x);

			}
		}

		public void mousePressed(MouseEvent event) {
			Object obj = event.getSource();

			if (obj == bntCir) {
				changeState(0);
				main.stateChange(cir);

			} else if (obj == bntTri) {
				changeState(1);
				main.stateChange(tri);

			} else if (obj == bntX) {
				changeState(2);
				main.stateChange(x);

			}
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}
	}// stateChange
}// Big
