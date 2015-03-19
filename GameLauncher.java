import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.*;

public class GameLauncher extends Canvas{

	private ArrayList entities = new ArrayList();
	private BufferStrategy strategy;
	private boolean aPressed = false, dPressed = false, wPressed = false, sPressed = false, mousePressed = false;
	private boolean logicRequiredThisLoop = false, gameRunning = true, waitingForKeyPress = true;
	private String message = "";

	public GameLauncher(){
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
//		gameContainer.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				System.exit(0);
//			}
//		});

		//allows the game to listen to key inputs
//		addKeyListener(new KeyInputHandler());
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
	public void gameLoop(){
		long lastLoopTime = System.currentTimeMillis();
		
		while (gameRunning) {
		
		// work out how long its been since the last update, this will be used to calculate how far the entities should move this loop
			long delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();

			// Get hold of a graphics context for the accelerated surface and blank it out
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);

			g.dispose();
//			strategy.show();

			//this should make it run at 100 fps
			try{
				Thread.sleep(10);
			}
			catch (Exception e){
			}
		}
	}
	public static void main(String argv[]){
		GameLauncher g = new GameLauncher();
		g.gameLoop();
	}
}