/**
 * Class that extends InArc and represents an arc who remove all tokens from its place if there is at least one token
 */
public class Videur extends InArc{
	
	/**
	 * Constructor of the class
	 * @param p (the place of the arc)
	 * @param t (the transition of the transition)
	 */
	public Videur(Place p, Transition t) {
		super(0, p, t); //we set the weight of the arc at 0 by convention but this is never used
	}

	/**
	 * Method that check if it is possible to make a step for this arc
	 * @return a boolean that answer to this
	 */
	@Override
	public boolean canStep() {
		return this.getPlace().getTokens() > 0; //if there is at least one token, we can step
	}
	
	/**
	 * Method that make a step for this arc
	 */
	@Override
	public void step() {
		this.getPlace().setTokens(0); //we remove all tokens from the place
	}
}
