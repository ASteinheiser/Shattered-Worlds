import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel {

	private GameWindow gameWindow;
	private int playerSize, playerSpeed, moveCount, Xpos, Ypos;
	private boolean minus;
	private Image playerImg;
	private String state, direction, pState, playerClass;

	public Player(String playerClass, GameWindow gameWindow) {
		this.gameWindow = gameWindow;

		Xpos = 0;
		Ypos = 0;
		moveCount = 1;
		playerSpeed = 15;
    playerSize = 80;

		this.playerClass = playerClass;

		super.setPreferredSize(new Dimension(playerSize, playerSize));
		state = "PlayerAnimations/" + playerClass + "/Down_still.png";

    LoadImg(this.state);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

		g.drawImage(playerImg, Xpos, Ypos, playerSize, playerSize, null);
	}

	public void LoadImg(String state){
		this.state=state;

    ImageIcon img = new ImageIcon(state);
    playerImg = img.getImage();
	}

	public void spaceAbility() {
		switch(playerClass) {
			case "Ninja":
				Ninja ninja = new Ninja(gameWindow);
				ninja.spaceAbility();
				break;
		}
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

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public String getPState() {
		return pState;
	}

	public void findState() {
		switch (direction) {

		case "left":
			if (!minus) {
				this.pState = "PlayerAnimations/" + playerClass + "/Left_move_" + moveCount
						+ ".png";
				if (moveCount == 3) {
					minus = true;
				}else{
					moveCount++;
				}
			}else{
				this.pState = "PlayerAnimations/" + playerClass + "/Left_move_" + moveCount
						+ ".png";
				if (moveCount == 1) {
					minus = false;
				}else{
					moveCount--;
				}
			}
			break;

		case "right":
			if (!minus) {
				this.pState = "PlayerAnimations/" + playerClass + "/Right_move_" + moveCount
						+ ".png";
				if (moveCount == 3) {
					minus = true;
				}else{
					moveCount++;
				}
			}else{
				this.pState = "PlayerAnimations/" + playerClass + "/Right_move_" + moveCount
						+ ".png";
				if (moveCount == 1) {
					minus = false;
				}else{
					moveCount--;
				}
			}
			break;

		case "down":
			if (!minus) {
				this.pState = "PlayerAnimations/" + playerClass + "/Down_move_" + moveCount
						+ ".png";
				if (moveCount == 3) {
					minus = true;
				}else{
					moveCount++;
				}
			}else{
				this.pState = "PlayerAnimations/" + playerClass + "/Down_move_" + moveCount
						+ ".png";
				if (moveCount == 1) {
					minus = false;
				}else{
					moveCount--;
				}
			}
			break;

		case "up":
			if (!minus) {
				this.pState = "PlayerAnimations/" + playerClass + "/Up_move_" + moveCount + ".png";
				if (moveCount == 3) {
					minus = true;
				}else{
					moveCount++;
				}
			}else{
				this.pState = "PlayerAnimations/" + playerClass + "/Up_move_" + moveCount + ".png";
				if (moveCount == 1) {
					minus = false;
				}else{
					moveCount--;
				}
			}
			break;
		}
	}
}
