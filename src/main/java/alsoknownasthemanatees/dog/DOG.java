package alsoknownasthemanatees.dog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DOG extends JPanel {
	
	Stack<GameState> gameStates = new Stack<GameState>();
	
	public DOG() {
		setPreferredSize(new Dimension(800, 600));
		gameStates.push(new SplashScreen(this));
	}
	
	@Override
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		gameStates.peek().paint(g);
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("THIS IS DOG");
		window.add(new DOG());
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
