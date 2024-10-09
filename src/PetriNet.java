import java.util.ArrayList;

public class PetriNet {
	private ArrayList<Arc> arcs;
	private ArrayList<Place> places;
	private ArrayList<Transition> transitions;
	
	public PetriNet() {
		this.arcs= new ArrayList<Arc>();
		this.places=new ArrayList<Place>();
		this.transitions=new ArrayList<Transition>();
	}
	
	/**
	 * @param arcs
	 * @param places
	 * @param transitions
	 */
	public PetriNet(ArrayList<Arc> arcs, ArrayList<Place> places, ArrayList<Transition> transitions) {
		this.arcs = arcs;
		this.places = places;
		this.transitions = transitions;
	}
	public void addPlace(Place p) {
		this.places.add(p);
	}
	public void addArc(Arc a) {
		this.arcs.add(a);
	}
	public void addTransition(Transition t) {
		this.transitions.add(t);
	}
	public void removePlace(Place p) {
		this.places.remove(p);
	}
	public void removeArc(Arc a) {
		this.arcs.remove(a);
	}
	public void removeTransition(Transition t) {
		this.transitions.remove(t);
	}
	
	public void tirer(Transition t) {
		t.step();
	}
}
