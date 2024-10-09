
public abstract class Arc {
	private int poids;
	private Place place;
	private Transition transition;
	
	public Arc(int w, Place p, Transition t) {
		this.place=p;
		this.poids=w;
		this.transition=t;
	}
	public Arc(Place p, Transition t) {
		this(1, p, t);
	}
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
