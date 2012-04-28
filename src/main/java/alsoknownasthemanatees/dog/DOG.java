package alsoknownasthemanatees.dog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DOG extends JPanel implements KeyListener {
	
	private long prevTime = System.nanoTime();
	
	public DOG() {
		setPreferredSize(new Dimension(800, 600));
		GameState.getStack().push(new SplashScreen(this));
	}
	
	@Override
	public void paint(Graphics graphics) {
		long elapsedTime = System.nanoTime() - prevTime;
		double dt = elapsedTime / 1000000000.0;
		prevTime += elapsedTime;
		Graphics2D g = (Graphics2D) graphics;
		GameState.getStack().peek().paint(dt, g);
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("THIS IS DOG");
		final DOG dog = new DOG();
		new Timer(16, new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				dog.repaint();
			}
			
		}).start();
		window.add(dog);
		window.addKeyListener(dog);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.dispose();
		window.setUndecorated(true);
		window.setVisible(true);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(window);
	}

	public void keyTyped(KeyEvent ke) {
		GameState.getStack().peek().keyTyped(ke);
	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == 27) {
			GameState.getStack().pop();
			if (GameState.getStack().empty()) System.exit(0);
		} else
			GameState.getStack().peek().keyPressed(ke);
	}

	public void keyReleased(KeyEvent ke) {
		GameState.getStack().peek().keyReleased(ke);
	}
	
}
