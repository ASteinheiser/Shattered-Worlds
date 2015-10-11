import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameWindow extends JFrame implements KeyListener, ActionListener,MouseListener {
	private Map map;
	private Player player;
	private String pState, direction;
	private int move_count;
	private boolean minus = false,teleport = false;
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
		time = new Timer(20, this);

		addKeyListener(this);
		addMouseListener(this);

		add(map, BorderLayout.CENTER);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_A) {

			direction = "left";
			time.start();
		}

		if (keyCode == KeyEvent.VK_D) {
			direction = "right";
			time.start();
		}
		if (keyCode == KeyEvent.VK_S) {
			direction = "down";
			time.start();
		}
		if (keyCode == KeyEvent.VK_W) {
			direction = "up";
			time.start();
		}
		
		if(keyCode == KeyEvent.VK_SPACE){
			teleport = true;
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

	public void findState() {
		switch (direction) {
		case "left":
			if (!minus) {
				this.pState = "PlayerAnimations/Left_move_" + move_count
						+ ".png";
				if (move_count == 3) {
					minus = true;
				} else {
					move_count++;
				}
			} else {
				this.pState = "PlayerAnimations/Left_move_" + move_count
						+ ".png";
				if (move_count == 1) {
					minus = false;
				} else {
					move_count--;
				}
			}
			break;
		case "right":
			if (!minus) {
				this.pState = "PlayerAnimations/Right_move_" + move_count
						+ ".png";
				if (move_count == 3) {
					minus = true;
				} else {
					move_count++;
				}
			} else {
				this.pState = "PlayerAnimations/Right_move_" + move_count
						+ ".png";
				if (move_count == 1) {
					minus = false;
				} else {
					move_count--;
				}
			}
			break;
		case "down":
			if (!minus) {
				this.pState = "PlayerAnimations/Down_move_" + move_count
						+ ".png";
				if (move_count == 3) {
					minus = true;
				} else {
					move_count++;
				}
			} else {
				this.pState = "PlayerAnimations/Down_move_" + move_count
						+ ".png";
				if (move_count == 1) {
					minus = false;
				} else {
					move_count--;
				}
			}
			break;
		case "up":
			if (!minus) {
				this.pState = "PlayerAnimations/Up_move_" + move_count + ".png";
				if (move_count == 3) {
					minus = true;
				} else {
					move_count++;
				}
			} else {
				this.pState = "PlayerAnimations/Up_move_" + move_count + ".png";
				if (move_count == 1) {
					minus = false;
				} else {
					move_count--;
				}
			}
			break;

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (direction) {
		case "right":
			if (player.getXpos() <= screenSize.width * .95) {
				player.moveRight(player.getPlayerSpeed());
				findState();
				player.LoadImg(pState);
				map.repaint();
			}
			break;
		case "left":
			if (player.getXpos() >= 0 ) {
				player.moveLeft(player.getPlayerSpeed());
				findState();
				player.LoadImg(pState);
				map.repaint();
			}
			break;
		case "up":
			if (player.getYpos() >= 0 ) {
				player.moveUp(player.getPlayerSpeed());
				findState();
				player.LoadImg(pState);
				map.repaint();
			}
			break;
		case "down":
			if (player.getYpos() <= screenSize.height*.89 ) {
				player.moveDown(player.getPlayerSpeed());
				findState();
				player.LoadImg(pState);
				map.repaint();
			}
			
			break;

		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(teleport){
			player.setXpos(arg0.getX()-40);
			player.setYpos(arg0.getY()-40);
			map.repaint();
			teleport=false;
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
