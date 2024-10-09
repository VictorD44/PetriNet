
public class Zero extends InArc{
	
	public Zero(Place p, Transition t) {
		super(0, p, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canStep() {
		return this.getPlace().getJetons()==0;
	}
}
