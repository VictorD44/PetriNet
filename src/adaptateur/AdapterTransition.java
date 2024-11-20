package adaptateur;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.imta.Transition;

public class AdapterTransition extends AbstractTransition {
	Transition transition;
	
	public AdapterTransition(String label) {
		super(label);
		transition = new Transition();
	}

}
