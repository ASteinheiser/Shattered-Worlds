import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GameLauncher extends Canvas{

	private BufferStrategy strategy;
	private boolean aPressed = false, dPressed = false, wPressed = false, sPressed = false, mousePressed = false;
	private boolean logicRequiredThisLoop = false, gameRunning = true, waitingForKeyPress = true;
	private String message = "";

	public Game(){
		JFrame gameContainer = new JFrame("Shattered Worlds");
		
		JPanel gamePanel = (JPanel) gameContainer.getContentPane();
		gamePanel.setPreferredSize(new Dimension(800,600));
		gamePanel.setLayout(null);

		setBounds(0, 0, 800, 600);
		gamePanel.add(this);

		setIgnoreRepaint(true);

		gameContainer.pack();
		gameContainer.setResizable(false);
		gameContainer.setVisible(true);

		//closes the game if the user tries to close the window
		gameContainer.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		//allows the game to listen to key inputs
		addKeyListener(new KeyInputHandler());
		requestFocus();
		
		//allows java awt to manage accelerated graphics
		createBufferStrategy(2);
		strategy = getBufferStrategy();

		//shows the entities on startup
		initEntities();
	}
	//clears all old data and makes a fresh game
	private void startGame(){
		entities.clear();
		initEntities();

		aPressed = false;
		dPressed = false;
		wPressed = false;
		sPressed = false;
		mousePressed = false;
	}
	private void initEntities(){
		//TO BE FILLED
	}
	public void updateLogic(){
		logicRequiredThisLoop = true;
	}
	public void notifyDeath() {
		message = "You died...";
		waitingForKeyPress = true;
	}
	public void pause(){
		message = "Game Paused";
		waitingForKeyPress = true;
	}
	public static void main(String argv[]){
		Game g = new Game();
		g.gameLoop();
	}
}