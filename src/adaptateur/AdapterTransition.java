package adaptateur;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.imta.Transition;

public class AdapterTransition extends AbstractTransition {
	private Transition transition;
	
	public AdapterTransition(String label) {
		super(label);
		transition = new Transition();
	}

	public Transition getTransition() {
		return transition;
	}
}
