package alsoknownasthemanatees.dog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SplashScreen extends GameState {
	
	private BufferedImage dog, logo, pressAnyKey;
	private double elapsedTime = 0.0;
	
	public SplashScreen(Component component) {
		super(component);
		try {
			dog = ImageIO.read(SplashScreen.class.getResource("/DOG.png"));
			logo = ImageIO.read(SplashScreen.class.getResource("/SPLASH.png"));
			pressAnyKey = ImageIO.read(SplashScreen.class.getResource("/pressAnyKey.png"));
		} catch (IOException ex) {
			System.err.println(ex);
			System.exit(1);
		}
	}

	@Override
	public void paint(double dt, Graphics2D g) {
		g.setBackground(Color.getHSBColor((float) elapsedTime, 1.0f, 1.0f));
		g.clearRect(0, 0, component.getWidth(), component.getHeight());
		g.drawImage(dog, 0, 0, component.getWidth(), component.getHeight(), null);
		g.drawImage(logo, component.getWidth() / 2 - logo.getWidth() / 2, component.getHeight() / 2 - logo.getHeight() / 2, null);
		elapsedTime += dt;
		if (Math.floor(elapsedTime) % 2 == 0)
			g.drawImage(pressAnyKey, component.getWidth() / 2 - pressAnyKey.getWidth() / 2, component.getHeight() / 2 + logo.getHeight() / 2, null);
	}
	
}
