
public class Zero extends InArc{
	
	@Override
	public boolean canStep() {
		return this.getPlace().getJetons()==0;
	}
}
