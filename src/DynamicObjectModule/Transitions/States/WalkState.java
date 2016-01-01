package DynamicObjectModule.Transitions.States;

import Common.StateType;
import DynamicObjectModule.Entities.Sprite;

public class WalkState extends State {
	private int _direction;

	public WalkState(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void enter() {
		
	}

	@Override
	public void execute() {
		
	}

	@Override
	public void exit() {

	}

	@Override
	public String getType() {
		return StateType.WALK;
	}
}
