public class OutArc extends Arc{

	public OutArc(int w, Place p, Transition t) {
		super(w, p, t);
	}

	@Override
	public void step() {
		this.getPlace().addTokens(this.getPoids());
	}

}
