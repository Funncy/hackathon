import java.awt.*;

public class ReservationData {
	private int ID;
	private long stuNum;
	private String menu;
	
	public ReservationData() {
		stuNum = 0;
		menu = null;
	}
	public ReservationData(int ID,long num, String m) {
		this.ID = ID;
		stuNum = num;
		menu = m;
	}
	public ReservationData(ReservationData data) {
		stuNum = data.stuNum;
		menu = data.menu;
	}
	
	public int getID() { return ID; }
	public void setID(int id) { ID= id;}
	public long getStuNum() {
		return stuNum;
	}
	public void setStuNum(long num) {
		this.stuNum = num;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String m) {
		this.menu = m;
	}
}
