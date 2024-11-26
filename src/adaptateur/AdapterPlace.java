package adaptateur;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.imta.Place;

public class AdapterPlace extends AbstractPlace {
	private Place place;
	
	public AdapterPlace(String label) {
		super(label);
		place = new Place(0);
	}
	
	@Override
	public void addToken() {
		place.addTokens(1);
	}

	@Override
	public void removeToken() {
		place.removeTokens(1);
	}

	@Override
	public int getTokens() {
		return place.getTokens();
	}

	@Override
	public void setTokens(int tokens) {
		place.setTokens(tokens);
	}

	public Place getPlace() {
		return place;
	}
}
