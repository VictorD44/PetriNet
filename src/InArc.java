
public class InArc extends Arc{

	public InArc(int w, Place p, Transition t) {
		super(w, p, t);
	}

	public boolean canStep() {
		return this.getPoids()<this.getPlace().getTokens();
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		if (this.canStep()) {
			this.getPlace().removeTokens(this.getPoids());
		}
	}

}
