import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Map extends JPanel{

	private int mapWidth = 800, mapHeight = 600;
	private Image map;
  private Player player;

	public Map(){
		super.setPreferredSize(new Dimension(mapWidth,mapHeight));
		ImageIcon img = new ImageIcon("Maps/grass.jpg");

		map = img.getImage();
		player = new Player("Ninja");
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponents(g);

		g.drawImage(map, 0, 0, getWidth(),getHeight(),null);
		player.paintComponent(g);;
		g.dispose();
	}
	public Player getPlayer() {
		return player;
	}
}
