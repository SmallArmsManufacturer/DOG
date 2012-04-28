package alsoknownasthemanatees.dog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SplashScreen extends GameState {
	
	private BufferedImage dog;
	
	public SplashScreen(Component component) {
		super(component);
		try {
			dog = ImageIO.read(SplashScreen.class.getResource("/DOG.png"));
		} catch (IOException ex) {
			System.err.println(ex);
			System.exit(1);
		}
	}

	@Override
	public void paint(Graphics2D g) {
		g.drawImage(dog, 0, 0, component.getWidth(), component.getHeight(), null);
		g.setColor(Color.BLACK);
		int strlen = (int) g.getFontMetrics().getStringBounds("PRESS ANY KEY", g).getWidth();
		g.drawString("PRESS ANY KEY", component.getWidth() / 2 - strlen / 2, component.getHeight() / 2);
	}
	
}
