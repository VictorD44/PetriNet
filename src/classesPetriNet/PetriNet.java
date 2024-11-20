package classesPetriNet;
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
		//we check if we are 2 same arcs
		boolean test = false;
		int Q;
		for (Arc a1 : arcs) {
			Q = 0;
			for (Arc a2 : arcs) {
				if (a1.equals(a2)) {
					if (Q != 0) { //it is normal to see 2 times the same arc in the same set, but not more
						throw new IllegalArgumentException("it is not possible to have 2 times the same arc in the PetriNet");
					} else {
						Q += 1;
					}
				} 
			}
		}
		this.arcs = arcs;
		this.places = places;
		this.transitions = transitions;
	}
	
	/**
	 * Method that add a place in the petrinet
	 * @param p (Place to add)
	 * @requires p not in places
	 * @ensures this.places = \old(this.places) with p added
	 */
	public void addPlace(Place p) {
		if (this.places.contains(p)) {
			throw new IllegalArgumentException("this place is already in the PetriNet");
		}
		this.places.add(p);
	}
	
	/**
	 * Method that add an arc in the petrinet (we don't make differences between InArc and OutArc here)
	 * @param a (Arc to add)
	 * @requires a not in arcs
	 * @ensures this.arcs = \old(this.arcs) with a added
	 */
	public void addArc(Arc a) {
		if (this.arcs.contains(a)) {
			throw new IllegalArgumentException("this arc is already in the PetriNet");
		} else {
			boolean test = true;
			for (Arc arc : arcs) { //we check if this arc is already in the petrinet in another instance
				test &= !a.equals(arc);
			}
			if (test) {
				this.arcs.add(a);
			} else {
				throw new IllegalArgumentException("this arc is already in the PetriNet");
			}
		}
	}
	
	/**
	 * Method that add a transition in the petrinet
	 * @param t (Transition to add)
	 * @requires t not in transitions
	 * @ensures this.transitions = \old(this.transitions) with t added
	 */
	public void addTransition(Transition t) {
		if (this.transitions.contains(t)) {
			throw new IllegalArgumentException("this transition is already in the PetriNet");
		}
		this.transitions.add(t);
	}
	
	/**
	 * Method that remove a place from the petrinet
	 * @param p (Place to remove)
	 * @requires p is in places
	 * @ensures this.places = \old(this.places) with p removed
	 */
	public void removePlace(Place p) {
		if (!this.places.contains(p)) {
			throw new IllegalArgumentException("this place is not in the PetriNet");
		}
		ArrayList<Arc> newArcs = new ArrayList<Arc>();
		for (Arc a:this.arcs) {
			if (a.getPlace()!=p) {
				newArcs.add(a);
			}
		}
		this.arcs=newArcs;
		this.places.remove(p);
	}
	
	/**
	 * Method that remove an arc from the petrinet
	 * @param a (Arc to remove)
	 * @requires a is in arcs
	 * @ensures this.arcs = \old(this.arcs) with p removed
	 */
	public void removeArc(Arc a) {
		if (!this.arcs.contains(a)) {
			throw new IllegalArgumentException("this arc in not in the PetriNet");
		}
		
		this.arcs.remove(a);
	}
	
	/**
	 * Method that remove a transition from the petrinet
	 * @param t (Transition to remove)
	 * @requires t is in transitions
	 * @ensures this.transitions = \old(this.transitions) with t removed
	 */
	public void removeTransition(Transition t) {
		if (!this.transitions.contains(t)) {
			throw new IllegalArgumentException("this transition is not in the PetriNet");
		}
		this.transitions.remove(t);
	}
	
	/**
	 * Method that pull a transition given if possible (method named "tirer" on the class diagram)
	 * @param t (Transition to pull)
	 * @requires t is in transitions
	 */
	public void pull(Transition t) {
		if (!this.transitions.contains(t)) {
			throw new IllegalArgumentException("this transition is not in the PetriNet");
		}
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
		Arc a1 = new InArc(3,p1,t);
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
		
		assert(p1.getTokens() == 1);
		assert(p2.getTokens() == 3);
	}
}
