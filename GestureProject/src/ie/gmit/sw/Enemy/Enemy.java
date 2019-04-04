package ie.gmit.sw.Enemy;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ie.gmit.sw.Sprites.Blocks;
import ie.gmit.sw.Sprites.Player;

public class Enemy implements EnemyType{

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double delta, Player player, Blocks blocks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDirection(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deathScene() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collide(int i, Player player, Blocks blocks, ArrayList<EnemyType> enemys) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOutOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
