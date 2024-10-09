import java.util.ArrayList;

/**
 * Class that represents the petrinet with of main method to test it
 */
public class PetriNet {
	private ArrayList<Arc> arcs; //list of petrinet's arcs
	private ArrayList<Place> places; //list of petrinet's places
	private ArrayList<Transition> transitions; //list of petrinet's transitions
	
	/**
	 * Constructor of the Petrinet without any arcs, places or transitions (they will be add later)
	 */
	public PetriNet() {
		this.arcs = new ArrayList<Arc>();
		this.places = new ArrayList<Place>();
		this.transitions = new ArrayList<Transition>();
	}
	
	/**
	 * Constructor of the Petrinet with arcs, places and transitions given
	 * @param arcs (list of petrinet's arcs)
	 * @param places (list of petrinet's places)
	 * @param transitions (list of petrinet's transitions)
	 */
	public PetriNet(ArrayList<Arc> arcs, ArrayList<Place> places, ArrayList<Transition> transitions) {
		this.arcs = arcs;
		this.places = places;
		this.transitions = transitions;
	}
	
	/**
	 * Method that add a place in the petrinet
	 * @param p (Place to add)
	 */
	public void addPlace(Place p) {
		this.places.add(p);
	}
	
	/**
	 * Method that add an arc in the petrinet (we don't make differences between InArc and OutArc here)
	 * @param a (Arc to add)
	 */
	public void addArc(Arc a) {
		this.arcs.add(a);
	}
	
	/**
	 * Method that add a transition in the petrinet
	 * @param t (Transition to add)
	 */
	public void addTransition(Transition t) {
		this.transitions.add(t);
	}
	
	/**
	 * Method that remove a place from the petrinet
	 * @param p (Place to remove)
	 */
	public void removePlace(Place p) {
		this.places.remove(p);
	}
	
	/**
	 * Method that remove an arc from the petrinet
	 * @param a (Arc to remove)
	 */
	public void removeArc(Arc a) {
		this.arcs.remove(a);
	}
	
	/**
	 * Method that remove a transition from the petrinet
	 * @param t (Transition to remove)
	 */
	public void removeTransition(Transition t) {
		this.transitions.remove(t);
	}
	
	/**
	 * Method that pull a transition given if posible (method named "tirer" on the class diagram)
	 * @param t (Transition to pull)
	 */
	public void pull(Transition t) {
		t.step(); //we just call the method step from the transition
	}
	
	/**
	 * Main method to test an instance of a Petrinet
	 * @param args
	 */
	public static void main(String[] args) {
		PetriNet petri = new PetriNet();
		Place p1 = new Place(4);
		Place p2 = new Place(1);
		Transition t = new Transition();
		Arc a1 = new InArc(5,p1,t);
		Arc a2 = new OutArc(2,p2,t);
		t.addInArc((InArc)a1);
		t.addOutArc((OutArc)a2);
		petri.addArc(a1);
		petri.addArc(a2);
		petri.addPlace(p2);
		petri.addPlace(p1);
		petri.addTransition(t);
		System.out.println(p1.getTokens() +" "+p2.getTokens());
		petri.pull(t);
		System.out.println(p1.getTokens() +" "+p2.getTokens());
	}
}
