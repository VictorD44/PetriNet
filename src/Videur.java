
public class Videur extends InArc{
	
	public Videur(Place p, Transition t) {
		super(0, p, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canStep() {
		return this.getPlace().getTokens()>0;
	}
	
	@Override
	public void step() {
		this.getPlace().setTokens(0);
	}
}
