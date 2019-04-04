package ie.gmit.sw.Levels;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ie.gmit.sw.Enemy.EnemyType;
import ie.gmit.sw.Sprites.Blocks;
import ie.gmit.sw.Sprites.Player;

public class LevelOne implements LevelInterface{
	
	private Player player;
	private ArrayList<EnemyType> enemies = new ArrayList<EnemyType>();
	
	public LevelOne(Player player){
		this.player = player;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double delta, Blocks blocks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hasDirectionChange(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDurectionAllEnemys(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
