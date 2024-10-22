/**
 * Abstract class that represents an arc (in general without considering in/out/zero/void)
 */
public abstract class Arc {
	protected int min_weight = 0; //minimum weight for an arc in general
	private int weight; //weight of the arc
	private Place place; //place of the arc
	private Transition transition; //transition of the arc
	
	/**
	 * Constructor to create an arc 
	 * @param w (weight of the arc)
	 * @param p (place of the arc)
	 * @param t (transition of the arc)
	 * @requires w > min_weight
	 */
	public Arc(int w, Place p, Transition t) {
		if (w <= min_weight) {
			throw new IllegalArgumentException("the weight must be straight positive");
		}
		this.place = p;
		this.weight = w;
		this.transition = t;
	}
	
	/**
	 * Getter for the weight
	 * @return weight (of the arc)
	 * @requires weight > min_weight
	 */
	public int getWeight() {
		assert(this.weight > min_weight);
		return this.weight;
	}
	
	/**
	 * Setter for the weight
	 * @param w (weight of the arc)
	 * @requires w >= min_weight
	 */
	public void setWeight(int w) {
		if (w <= min_weight) {
			throw new IllegalArgumentException("the weight must be straight positive");
		}
		this.weight = w;
	}
	
	/**
	 * Method to make a step for its place when pulling a transition
	 * Depends on the type of the arc (each type will implement its own method)
	 */
	public abstract void step();
	
	/**
	 * Getter for the place
	 * @return place (of the arc)
	 */
	public Place getPlace() {
		return this.place;
	}
	
	/**
	 * Setter for the transition
	 * @return transition (of the arc)
	 */
	public Transition getTransition() {
		return this.transition;
	}
}

