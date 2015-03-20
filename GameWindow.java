import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameWindow extends JFrame implements KeyListener,ActionListener{
	private Map map;
	private Player player;
	private String pState, direction;
	private int move_count;
	private boolean minus = false;
	private Timer time;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public GameWindow() {
		super("Shattered Worlds");

		// setIgnoreRepaint(true); // Don't know what this means
		pack();
		setResizable(false);
		setLayout(new BorderLayout());
		setSize(screenSize.width, screenSize.height);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		move_count = 1;
		map = new Map();
		player = map.getPlayer();
		time = new Timer(20,this);
		
		addKeyListener(this);

		add(map, BorderLayout.CENTER);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_LEFT) {
			
			direction = "left";
			time.start();
		}

		if (keyCode == KeyEvent.VK_RIGHT) {
			direction = "right";
			time.start();
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			direction = "down";
			time.start();
		}
		if (keyCode == KeyEvent.VK_UP) {
			direction = "up";
			time.start();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		time.stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void findState(){
		switch(direction){
		case"left":
			if(!minus){
				this.pState = "PlayerAnimations/Left_move_"+move_count+".png";
			if(move_count==3){
				minus=true;
			}
			else{
				move_count++;
			}
			}else{
				this.pState = "PlayerAnimations/Left_move_"+move_count+".png";
				if(move_count==1){
					minus=false;
				}
				else{
					move_count--;
				}
			}
			break;
		case "right":
			if(!minus){
				this.pState = "PlayerAnimations/Right_move_"+move_count+".png";
			if(move_count==3){
				minus=true;
			}
			else{
				move_count++;
			}
			}else{
				this.pState = "PlayerAnimations/Right_move_"+move_count+".png";
				if(move_count==1){
					minus=false;
				}
				else{
					move_count--;
				}
			}
			break;
		case "down":
			if(!minus){
				this.pState = "PlayerAnimations/Down_move_"+move_count+".png";
			if(move_count==3){
				minus=true;
			}
			else{
				move_count++;
			}
			}else{
				this.pState = "PlayerAnimations/Down_move_"+move_count+".png";
				if(move_count==1){
					minus=false;
				}
				else{
					move_count--;
				}
			}
			break;
		case "up":
			if(!minus){
				this.pState = "PlayerAnimations/Up_move_"+move_count+".png";
			if(move_count==3){
				minus=true;
			}
			else{
				move_count++;
			}
			}else{
				this.pState = "PlayerAnimations/Up_move_"+move_count+".png";
				if(move_count==1){
					minus=false;
				}
				else{
					move_count--;
				}
			}
			break;
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		findState();
		player.LoadImg(pState);
		switch(direction){
		case "right":
			player.moveRight(player.getPlayerSpeed());
			break;
		case "left":
			player.moveLeft(player.getPlayerSpeed());
			break;
		case "up":
			player.moveUp(player.getPlayerSpeed());
			break;
		case "down":
			player.moveDown(player.getPlayerSpeed());
			break;
		
	}
		map.repaint();
	}

}
