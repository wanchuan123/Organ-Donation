package UserInterfaceModule;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import CentralizedDataCenter.Entities.Sprite;
import CentralizedDataCenter.Entities.StateType;
import Common.Constants;

public class Controller implements KeyListener {
	protected static Map<Integer, Integer> _keyCodeToDirection = new HashMap<Integer, Integer>() {
		{
			put(KeyEvent.VK_UP, Constants.ACTIONCODE_NORTH);
			put(KeyEvent.VK_DOWN, Constants.ACTIONCODE_SOUTH);
			put(KeyEvent.VK_LEFT, Constants.ACTIONCODE_WEST);
			put(KeyEvent.VK_RIGHT, Constants.ACTIONCODE_EAST);
		}
	};

	protected Sprite _entity;
	protected boolean _isDirectionKeyPressed = false;
	protected String data;
	protected Controller(Sprite sprite) {
		_entity = sprite;
		_isDirectionKeyPressed = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyCode())) {
			_isDirectionKeyPressed = true;

			data = _entity.getID()+" "+_keyCodeToDirection.get(e.getKeyCode())+" "+StateType.WALK;
			
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			data = _entity.getID()+" "+StateType.ATTACK;
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_X) {
			data = _entity.getID()+" "+StateType.STEAL;
			
		}
		
		GameManager.getInstance().sendtoTcp(data);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (_keyCodeToDirection.containsKey(e.getKeyCode())) {
			_isDirectionKeyPressed = false;
			
			data = _entity.getID()+" "+StateType.IDLE;
		}
		GameManager.getInstance().sendtoTcp(data);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}