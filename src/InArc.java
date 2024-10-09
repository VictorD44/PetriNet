/**
 * Class that extends Arc and represents an in-arc (an arc who go from a place to a transition)
 */
public class InArc extends Arc{

	/**
	 * Constructor that call the super-constructor
	 * @param w (weight of the arc)
	 * @param p (place of the arc)
	 * @param t (transition of the arc)
	 */
	public InArc(int w, Place p, Transition t) {
		super(w, p, t);
	}

	/**
	 * Method that check if this arc allow the transition to be pulled
	 * @return bool (boolean who allow or not the step)
	 */
	public boolean canStep() {
		//if there are more tokens on the place than the transition's weight, we can make a step
		return this.getWeight() < this.getPlace().getTokens(); 
	}
	
	/**
	 * Method to make a step for its place when pulling a transition
	 * InArc implements it to remove as much tokens to its place than its weight
	 */
	@Override
	public void step() {
		if (this.canStep()) {
			this.getPlace().removeTokens(this.getWeight());
		}
	}

}
