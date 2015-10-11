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

public class GameWindow extends JFrame implements KeyListener,ActionListener,MouseListener {
	private Map map;
	private Player player;
	private Timer time;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public GameWindow() {
		super("Shattered Worlds");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();

    if (keyCode == KeyEvent.VK_A) {
      player.setDirection("left");
      time.start();
    }
    if (keyCode == KeyEvent.VK_D) {
      player.setDirection("right");
      time.start();
    }
    if (keyCode == KeyEvent.VK_S) {
      player.setDirection("down");
      time.start();
    }
    if (keyCode == KeyEvent.VK_W) {
      player.setDirection("up");
      time.start();
    }

    if(keyCode == KeyEvent.VK_SPACE){
      player.toggleTeleport();
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

  @Override
  public void actionPerformed(ActionEvent e) {

    switch (player.getDirection()) {
    case "right":
      if (player.getXpos() <= screenSize.width * .95) {
        player.moveRight(player.getPlayerSpeed());
        player.findState();
        player.LoadImg(player.getPState());
        map.repaint();
      }
      break;
    case "left":
      if (player.getXpos() >= 0 ) {
        player.moveLeft(player.getPlayerSpeed());
        player.findState();
        player.LoadImg(player.getPState());
        map.repaint();
      }
      break;
    case "up":
      if (player.getYpos() >= 0 ) {
        player.moveUp(player.getPlayerSpeed());
        player.findState();
        player.LoadImg(player.getPState());
        map.repaint();
      }
      break;
    case "down":
      if (player.getYpos() <= screenSize.height*.89 ) {
        player.moveDown(player.getPlayerSpeed());
        player.findState();
        player.LoadImg(player.getPState());
        map.repaint();
      }
      break;
    }
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
    if(player.getTeleport()){
      player.setXpos(arg0.getX()-40);
      player.setYpos(arg0.getY()-40);

      map.repaint();
      player.toggleTeleport();
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
