package alsoknownasthemanatees.dog;

import java.awt.Component;
import java.awt.Graphics2D;

public abstract class GameState {
	
	protected Component component;
	
	public GameState(Component component) {
		this.component = component;
	}
	
	public abstract void paint(Graphics2D g);
	
}
