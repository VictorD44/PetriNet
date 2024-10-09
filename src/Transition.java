import java.util.ArrayList;

public class Transition {
	private ArrayList<InArc> arcsEntrants;
	private ArrayList<OutArc> arcsSortants;
	
	public Transition() {
		this.arcsEntrants=new ArrayList<InArc>();
		this.arcsSortants=new ArrayList<OutArc>();
	}
	public void addInArc(InArc a) {
		if (a.getTransition()==this) {
			this.arcsEntrants.add(a);
		}
	}
	public void addOutArc(OutArc a) {
		if (a.getTransition()==this) {
			this.arcsSortants.add(a);
		}
	}
}
