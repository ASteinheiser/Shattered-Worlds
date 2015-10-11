import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel {

	private int playerSize, playerSpeed, Xpos, Ypos;
	private Image player;
	private String state;

	public Player() {
		Xpos = 0;
		Ypos = 0;
		playerSpeed = 15;
    playerSize = 80;

		super.setPreferredSize(new Dimension(playerSize, playerSize));
		state = "PlayerAnimations/Down_still.png";

    LoadImg(this.state);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

		g.drawImage(player, Xpos, Ypos, playerSize, playerSize, null);
	}

	public void LoadImg(String state){
		this.state=state;

    ImageIcon img = new ImageIcon(state);
    player = img.getImage();
	}

  public int getPlayerSpeed() {
    return playerSpeed;
  }

  public void setPlayerSpeed(int playerSpeed) {
    this.playerSpeed = playerSpeed;
  }
  public int getXpos() {
		return Xpos;
	}

	public void setXpos(int xpos) {
		Xpos = xpos;
	}

	public int getYpos() {
		return Ypos;
	}

	public void setYpos(int ypos) {
		Ypos = ypos;
	}

	public Image getPlayer() {
		return player;
	}

	public void setPlayer(Image player) {
		this.player = player;
	}

	public void moveRight(int amount) {
		Xpos += amount;
	}

	public void moveLeft(int amount) {
		Xpos -= amount;
	}

	public void moveDown(int amount) {
		Ypos += amount;
	}

	public void moveUp(int amount) {
		Ypos -= amount;
	}
}
