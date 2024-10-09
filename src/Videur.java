
public class Videur extends InArc{
	
	@Override
	public boolean canStep() {
		return this.getPlace().getJetons()>0;
	}
	
	@Override
	public void step() {
		this.getPlace().setJetons(0);
	}
}
