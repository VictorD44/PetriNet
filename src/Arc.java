
public abstract class Arc {
	private int poids;
	private Place place;
	private Transition transition;
	
	public int getPoids() {
		return this.poids;
	}
	public void setPoids(int p) {
		this.poids=p;
	}
	public abstract void step();
	
	public Place getPlace() {
		return this.place;
	}
	public Transition getTransition() {
		return this.transition;
	}
}
