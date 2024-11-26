package adaptateur;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import classesPetriNet.Arc;
import classesPetriNet.InArc;
import classesPetriNet.Zero;

public class AdapterArc extends AbstractArc {
	private Arc arc;
	private AdapterPlace adapterPlace;
	private AdapterTransition adapterTransition;

	public AdapterArc(Arc arc, AdapterPlace place, AdapterTransition transition) {
		this.arc=arc;
		this.adapterPlace=place;
		this.adapterTransition=transition;
	}
	@Override
	public AbstractNode getSource() {
		if(this.arc instanceof InArc) {
			return this.adapterPlace;
		}
		else {
			return this.adapterTransition;
		}
	}

	@Override
	public AbstractNode getDestination() {
		if(this.arc instanceof InArc) {
			return this.adapterTransition;
		}
		else {
			return this.adapterPlace;
		}
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return this.arc instanceof classesPetriNet.Void; //Problème avec classe Void déjà presente en Java
	}

	@Override
	public boolean isRegular() {
		// TODO Auto-generated method stub
		return (this.arc instanceof InArc)
				&& !this.isRegular()
				&& !this.isReset();
	}

	@Override
	public boolean isInhibitory() {
		// TODO Auto-generated method stub
		return this.arc instanceof Zero;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return this.arc.getWeight() ;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		this.arc.setWeight(multiplicity);

	}

}
