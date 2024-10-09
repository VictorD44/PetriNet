public class Zero extends InArc{
	
	public Zero(Place p, Transition t) {
		super(0, p, t);
	}

	@Override
	public boolean canStep() {
		return this.getPlace().getTokens() == 0;
	}
}
