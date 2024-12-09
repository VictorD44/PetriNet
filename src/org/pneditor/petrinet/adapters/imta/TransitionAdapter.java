package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.imta.Transition;

public class TransitionAdapter extends AbstractTransition {
	private Transition transition;
	
	public TransitionAdapter(String label) {
		super(label);
		transition = new Transition();
	}

	public Transition getTransition() {
		return transition;
	}
}
