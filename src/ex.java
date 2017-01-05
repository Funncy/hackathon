import javax.swing.JFrame;
//1110
public class ex extends JFrame{
	private LoginPage LP;
	private PrimaryPanel primary;
	
	public static void main(String[] args) {
		new ex();
	}
	
	public ex() {
		setTitle("Without 14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false); 
		LP = new LoginPage(this); // PrimaryPanel ����
		getContentPane().add(LP);
		
		primary = new PrimaryPanel(this);

		pack();
		setVisible(true);
	}
	public void ChangePanel(String ResID,String OwnerID) {
		this.remove(LP);
		primary.setOwner(OwnerID,ResID);
		getContentPane().add(primary);
		pack();
		setVisible(true);
	}
}