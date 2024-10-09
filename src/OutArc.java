
public class OutArc extends Arc{

	@Override
	public void step() {
		// TODO Auto-generated method stub
		this.getPlace().addJetons(this.getPoids());
	}

}
