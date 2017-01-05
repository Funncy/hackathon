import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {
	private JLabel lblMenu;
	private JLabel lblState;

	private JPanel statePanel;
	private JLabel lblIconState;

	public Menu(double w, double h) {
		this.setBackground(Color.white);

		int height, width;
		height = (int) (h * 0.07);
		width = (int) (w * 0.6);
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLUE));
		this.setLayout(null);

		Font fnt = new Font("Verdana", Font.BOLD, 40);

		lblMenu = new JLabel("Manage Menu");
		lblMenu.setBounds(0, 0, (int) (width * 0.8), height);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setVerticalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.black);
		lblMenu.setFont(fnt);
		this.add(lblMenu);

		lblState = new JLabel("State");
		lblState.setBounds(0, 0, (int) (width * 0.9), height);
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setVerticalAlignment(SwingConstants.CENTER);
		lblState.setFont(fnt);
		lblState.setForeground(Color.black);
		this.add(lblState);

		statePanel = new JPanel();
		statePanel.setBounds((int) (width * 0.9), 0, (int) (width * 0.09), (int) (width * 0.09));
		statePanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLUE));
		statePanel.setLayout(null);
		statePanel.setOpaque(false);
		this.add(statePanel);

		ImageIcon start = new ImageIcon("circle.png");
		Image img = start.getImage();
		Image img1 = img.getScaledInstance((int) (h * 0.06), (int) (h * 0.06), java.awt.Image.SCALE_SMOOTH);
		start.setImage(img1);

		lblIconState = new JLabel();
		lblIconState.setBounds(0, 0, (int) (width * 0.1), height);
		lblIconState.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconState.setVerticalAlignment(SwingConstants.CENTER);
		lblIconState.setIcon(start);
		statePanel.add(lblIconState);
	}// Menu

	public void changeState(ImageIcon change) {
		lblIconState.setIcon(change);

	}
}// Big
