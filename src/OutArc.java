/**
 * Class that extends Arc and represents an out-arc (an arc who go from a transition to a place)
 */
public class OutArc extends Arc{
	
	/**
	 * Constructor that call the super-constructor
	 * @param w (weight of the arc)
	 * @param p (place of the arc)
	 * @param t (transition of the arc)
	 */
	public OutArc(int w, Place p, Transition t) {
		super(w, p, t); //the require for the weight is checked in super
	}

	/**
	 * Method to make a step for its place when pulling a transition
	 * OutArc implements it to add as much tokens to its place than its weight
	 * @invariant this.weight > min_weight
	 */
	@Override
	public void step() {
		this.getPlace().addTokens(this.getWeight());
	}

}
