package adaptateur;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.imta.*;
import org.pneditor.petrinet.models.imta.Void;


public class PetriNetAdapter extends PetriNetInterface {
	private PetriNet petrinet = new PetriNet();
	
	@Override
	public AbstractPlace addPlace() {
		PlaceAdapter place = new PlaceAdapter(null);
		petrinet.addPlace(place.getPlace());
		return place;
	}

	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter transition = new TransitionAdapter(null);
		petrinet.addTransition(transition.getTransition());
		return transition;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		AbstractArc arc;
		Arc arc_var;
		if (source instanceof org.pneditor.petrinet.adapters.imta.PlaceAdapter) {
			arc_var = new InArc(1,((PlaceAdapter)source).getPlace(),((TransitionAdapter)destination).getTransition());
			arc = new ArcAdapter(arc_var,(PlaceAdapter)source,(TransitionAdapter)destination);
			((TransitionAdapter)destination).getTransition().addInArc((InArc)arc_var);
		} else {
			arc_var = new OutArc(1,((PlaceAdapter)destination).getPlace(),((TransitionAdapter)source).getTransition());
			arc = new ArcAdapter(arc_var,(PlaceAdapter)destination,(TransitionAdapter)source);
			((TransitionAdapter)source).getTransition().addOutArc((OutArc)arc_var);
		}
		petrinet.addArc(arc_var);
		return arc;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		Zero arc_var = new Zero(((PlaceAdapter)place).getPlace(),((TransitionAdapter)transition).getTransition());
		AbstractArc arc = new ArcAdapter(arc_var,(PlaceAdapter)place,(TransitionAdapter)transition);
		petrinet.addArc(arc_var);
		return arc;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		Void arc_var = new Void(((PlaceAdapter)place).getPlace(),((TransitionAdapter)transition).getTransition());
		AbstractArc arc = new ArcAdapter(arc_var,(PlaceAdapter)place,(TransitionAdapter)transition);
		petrinet.addArc(arc_var);
		return arc;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		petrinet.removePlace(((PlaceAdapter)place).getPlace());
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		petrinet.removeTransition(((TransitionAdapter)transition).getTransition());
		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		petrinet.removeArc(((ArcAdapter)arc).getArc());
		((ArcAdapter)arc).getArc().getTransition().removeArc(((ArcAdapter)arc).getArc());
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		return ((TransitionAdapter)transition).getTransition().canStep();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		petrinet.pull(((TransitionAdapter)transition).getTransition());
	}

}
