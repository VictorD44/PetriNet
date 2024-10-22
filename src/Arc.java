/**
 * Abstract class that represents an arc (in general without considering in/out/zero/void)
 */
public abstract class Arc {
	private int weight; //weight of the arc
	private Place place; //place of the arc
	private Transition transition; //transition of the arc
	
	/**
	 * Constructor to create an arc (it is this one to use in general)
	 * @param w (weight of the arc)
	 * @param p (place of the arc)
	 * @param t (transition of the arc)
	 */
	public Arc(int w, Place p, Transition t) {
		this.place = p;
		this.weight = w;
		this.transition = t;
	}
	
	/**
	 * Second constructor to create an arc without specifying a weight (it may be useful for zero-arc and void-arc)
	 * @param p (place of the arc)
	 * @param t (transition of the arc)
	 */
	public Arc(Place p, Transition t) {
		this(1, p, t);
	}
	
	/**
	 * Getter for the weight
	 * @return weight (of the arc)
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Setter for the weight
	 * @param w (weight of the arc)
	 */
	public void setWeight(int w) {
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

