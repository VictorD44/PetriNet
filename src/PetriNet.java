import java.util.ArrayList;

public class PetriNet {
	private ArrayList<Arc> arcs;
	private ArrayList<Place> places;
	private ArrayList<Transition> transitions;
	
	public void addPlace(Place p) {
		this.places.add(p);
	}
	public void addArc(Arc a) {
		this.arcs.add(a);
	}
	public void addTransition(Transition t) {
		this.transitions.add(t);
	}
}
