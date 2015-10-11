public class Ninja {

  private GameWindow gameWindow;
  private Player player;

  public Ninja(GameWindow gameWindow) {
    this.player = gameWindow.getPlayer();
    this.gameWindow = gameWindow;
  }

  public void spaceAbility(){
    player.setXpos(player.getXpos()+100);
    player.setYpos(player.getYpos()+100);
    gameWindow.setPlayer(player);
  }
}
