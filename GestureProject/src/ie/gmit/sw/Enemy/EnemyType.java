package ie.gmit.sw.Enemy;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ie.gmit.sw.Sprites.Blocks;
import ie.gmit.sw.Sprites.Player;

public interface EnemyType {

	public abstract void draw(Graphics2D g);
	public abstract void update(double delta, Player player, Blocks blocks);
	public abstract void changeDirection(double delta);
	
	public abstract boolean deathScene();
	public abstract boolean collide(int i, Player player, Blocks blocks, ArrayList<EnemyType> enemies);
	public abstract boolean isOutOfBounds();
}
