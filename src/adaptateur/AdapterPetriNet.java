package adaptateur;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.imta.PetriNet;

public class AdapterPetriNet extends PetriNetInterface {
	private PetriNet petrinet = new PetriNet();
	
	@Override
	public AbstractPlace addPlace() {
		AdapterPlace place = new AdapterPlace(null);
		petrinet.addPlace(place.getPlace());
		return place;
		
	}

	@Override
	public AbstractTransition addTransition() {
		AdapterTransition transition = new AdapterTransition(null);
		petrinet.addTransition(transition.getTransition());
		return transition;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		petrinet.removePlace(((AdapterPlace)place).getPlace());
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		petrinet.removeTransition(((AdapterTransition)transition).getTransition());
		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		return ((AdapterTransition)transition).getTransition().canStep();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		petrinet.pull(((AdapterTransition)transition).getTransition());
	}

}
