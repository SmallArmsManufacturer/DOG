package alsoknownasthemanatees.dog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DOG extends JPanel {
	
	private Stack<GameState> gameStates = new Stack<GameState>();
	private long prevTime = System.nanoTime();
	
	public DOG() {
		setPreferredSize(new Dimension(800, 600));
		gameStates.push(new SplashScreen(this));
	}
	
	@Override
	public void paint(Graphics graphics) {
		long elapsedTime = System.nanoTime() - prevTime;
		double dt = elapsedTime / 1000000000.0;
		prevTime += elapsedTime;
		Graphics2D g = (Graphics2D) graphics;
		gameStates.peek().paint(dt, g);
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("THIS IS DOG");
		final DOG dog = new DOG();
		new Timer(1, new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				dog.repaint();
			}
			
		}).start();
		window.add(dog);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
