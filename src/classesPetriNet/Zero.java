package classesPetriNet;
/**
 * Class that extends InArc and represents an arc that can make a step if there a no token on its place
 * We do not have to redefine step() because it is the same method
 */
public class Zero extends InArc{
	
	/**
	 * Constructor of the zero arc
	 * @param p (place of the arc)
	 * @param t (place of the transition)
	 */
	public Zero(Place p, Transition t) {
		super(1, p, t); //we set the weight of the arc at 1 by convention but this is never used
	}

	/**
	 * Method that check if it is possible to make a step for this arc
	 * @return a boolean that answer to this
	 */
	@Override
	public boolean canStep() {
		return this.getPlace().getTokens() < this.getWeight(); //if there is no token, we can make a step
	}
	
	/**
	 * Method that make a step (for a zero arc, it does nothing)
	 */
	@Override
	public void step() {
	}
}
