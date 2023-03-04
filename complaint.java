import java.io.Serializable;

@SuppressWarnings("serial")
public class complaint implements Serializable {
	String dept;
	int cNo;
	String d;
	String comp;
	String soln;

	public complaint(int cNo, String d, String dept, String comp, String soln) {
		this.cNo = cNo;
		this.d = d;
		this.dept = dept;
		this.comp = comp;
		this.soln = soln;
	}

	@Override
	public String toString() {
		return (this.cNo + " " + this.d + " " + this.dept + " " + this.comp + " " + this.soln);
	}
}
