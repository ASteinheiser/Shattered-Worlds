public class Ninja {

  private GameWindow gameWindow;
  private Player player;
  private int teleportRange, screenHeight, screenWidth, playerOffset;

  public Ninja(GameWindow gameWindow) {
    playerOffset = 10;
    screenHeight = gameWindow.getScreenHeight();
    screenWidth = gameWindow.getScreenWidth();
    this.player = gameWindow.getPlayer();
    this.gameWindow = gameWindow;
  }

  public void spaceAbility(){

    teleportRange = 300;

    if(player.getDirection() == "left"){
      if (player.getXpos() - teleportRange < 0) {
        teleportRange = player.getXpos();
      }
      player.setXpos(player.getXpos() - teleportRange - playerOffset);

    } else if (player.getDirection() == "right") {
      if (player.getXpos() + teleportRange > screenWidth) {
        teleportRange = screenWidth - player.getXpos() - player.getPlayerSize();
      }
      player.setXpos(player.getXpos() + teleportRange + playerOffset);

    } else if (player.getDirection() == "up") {
      if (player.getYpos() - teleportRange < 0) {
        teleportRange = player.getYpos();
      }
      player.setYpos(player.getYpos() - teleportRange);

    } else if (player.getDirection() == "down") {
      if (player.getYpos() + teleportRange > screenHeight) {
        teleportRange = screenHeight - player.getYpos() - player.getPlayerSize();
      }
      player.setYpos(player.getYpos() + teleportRange - playerOffset);
    }

    gameWindow.setPlayer(player);
  }
}
