package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import org.pneditor.petrinet.models.imta.Arc;
import org.pneditor.petrinet.models.imta.InArc;
import org.pneditor.petrinet.models.imta.Zero;

public class ArcAdapter extends AbstractArc {
	private Arc arc;
	private PlaceAdapter adapterPlace;
	private TransitionAdapter adapterTransition;

	public ArcAdapter(Arc arc, PlaceAdapter place, TransitionAdapter transition) {
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
		return this.arc instanceof org.pneditor.petrinet.models.imta.Void; //Problème avec classe Void déjà presente en Java
	}

	@Override
	public boolean isRegular() {
		// TODO Auto-generated method stub
		return (this.arc instanceof InArc)
				&& !this.isInhibitory()
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
	
	public Arc getArc() {
		return this.arc;
	}

}
