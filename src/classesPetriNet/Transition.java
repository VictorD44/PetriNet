package classesPetriNet;
import java.util.ArrayList;


/**
 * Class that represents a transition
 */
public class Transition {
	private ArrayList<InArc> inArc; //list of all the arcs that enter in the transition
	private ArrayList<OutArc> outArc; //list of all the arcs that go out from the transition
	
	/**
	 * Constructor of the transition
	 * At the creation, there are no arcs described
	 */
	public Transition() {
		this.inArc = new ArrayList<InArc>();
		this.outArc = new ArrayList<OutArc>();
	}
	
	/**
	 * Method to add an InArc to the transition
	 * @param a (InArc)
	 * @requires a.getTransition() == this
	 * @ensures inArc = \old(inArc) with a added
	 */
	public void addInArc(InArc a) {
		if (a.getTransition() != this) { //we check if information match between this and a
			throw new IllegalArgumentException("this arc does not enter in this transition");
		}
		this.inArc.add(a);
	}
	
	/**
	 * Method to add an OutArc to the transition
	 * @param a (OutArc)
	 * @requiresa.getTransition() == this
	 * @ensures outArc = \old(outArc) with a added
	 */
	public void addOutArc(OutArc a) {
		if (a.getTransition() != this) { //we check if information match between this and a
			throw new IllegalArgumentException("this arc does not left from this transition");
		}
		this.outArc.add(a);
	}
	
	/**
	 * Method that make a step when the transition is pulled
	 */
	public void step() {
		//first we check if it is ok for each InArc to make a step
		boolean res = true;
		for (InArc a : this.inArc) {
			res &= a.canStep();
		}
		//if yes we make a step for each InArc and OutArc
		if (res) {
			for (InArc a : this.inArc) {
				a.step();
			}
			for (OutArc a : this.outArc) {
				a.step();
			}
		}
	}
	
	/**
	 * Method that return if the transition can step
	 * @return boolean (is trigeable)
	 */
	public boolean canStep() {
		boolean res = true;
		for (InArc a : this.inArc) {
			res &= a.canStep();
		}
		return res;
	}
}
