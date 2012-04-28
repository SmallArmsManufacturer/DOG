package alsoknownasthemanatees.dog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainGame extends GameState {
	
	private BufferedImage dog;
	private Direction direction = Direction.UPRIGHT;
	
	public MainGame(Component component) {
		super(component);
		try {
			dog = ImageIO.read(SplashScreen.class.getResource("/DOG.png"));
		} catch (IOException ex) {
			System.err.println(ex);
			System.exit(1);
		}
	}

	@Override
	public void paint(double dt, Graphics2D g) {
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, component.getWidth(), component.getHeight());
		switch (direction) {
			case UPRIGHT:
				g.drawImage(dog, 0, 0, component.getWidth(), component.getHeight(), 0, 0, dog.getWidth(), dog.getHeight(), null);
				break;
			case UPLEFT:
				g.drawImage(dog, 0, 0, component.getWidth(), component.getHeight(), dog.getWidth(), 0, 0, dog.getHeight(), null);
				break;
			case DOWNRIGHT:
				g.drawImage(dog, 0, 0, component.getWidth(), component.getHeight(), 0, dog.getHeight(), dog.getWidth(), 0, null);
				break;
			case DOWNLEFT:
				g.drawImage(dog, 0, 0, component.getWidth(), component.getHeight(), dog.getWidth(), dog.getHeight(), 0, 0, null);
				break;
		}
	}
	
	public enum Direction { UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT }
	
	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (direction == Direction.DOWNLEFT)
					direction = Direction.UPLEFT;
				else if (direction == Direction.DOWNRIGHT)
					direction = Direction.UPRIGHT;
				break;
			case KeyEvent.VK_DOWN:
				if (direction == Direction.UPLEFT)
					direction = Direction.DOWNLEFT;
				else if (direction == Direction.UPRIGHT)
					direction = Direction.DOWNRIGHT;
				break;
			case KeyEvent.VK_LEFT:
				if (direction == Direction.UPRIGHT)
					direction = Direction.UPLEFT;
				else if (direction == Direction.DOWNRIGHT)
					direction = Direction.DOWNLEFT;
				break;
			case KeyEvent.VK_RIGHT:
				if (direction == Direction.UPLEFT)
					direction = Direction.UPRIGHT;
				else if (direction == Direction.DOWNLEFT)
					direction = Direction.DOWNRIGHT;
				break;
		}
	}
	
}
