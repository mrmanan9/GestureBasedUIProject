package ie.gmit.sw.Levels;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ie.gmit.sw.Enemy.Enemy;
import ie.gmit.sw.Enemy.EnemyType;
import ie.gmit.sw.Sprites.Blocks;
import ie.gmit.sw.Sprites.Player;

public class LevelOne implements LevelInterface{
	
	private Player player;
	private ArrayList<EnemyType> enemies = new ArrayList<EnemyType>();

	public LevelOne(Player player){
		this.player = player;
		addEnemies();

	}

	@Override
	public void draw(Graphics2D g) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).draw(g);
		}
	}

	@Override
	public void update(double delta, Blocks blocks) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).update(delta, player, blocks);
		}
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).collide(i, player, blocks, enemies);
		}
		hasDirectionChange(delta);
	}

	@Override
	public void hasDirectionChange(double delta) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.size(); i++){
			if(enemies.get(i).isOutOfBounds()){
				changeDurectionAllEnemys(delta);
			}
		}
	}

	@Override
	public void changeDurectionAllEnemys(double delta) {
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).changeDirection(delta);
		}
	}

	@Override
	public boolean isGameOver() {
		return false;
	}

	@Override
	public void destory() {
		
	}

	@Override
	public void reset() {
		enemies.clear();
		addEnemies();

	}
	
	public void addEnemies() {
		for(int y = 0; y < 5; y++){
			for(int x = 0; x < 10; x++){
				EnemyType e = new Enemy(150 + (x * 40), 25 + (y * 40), 1 , 3, "./Images/a1.png");
				enemies.add(e);
			}
		}
	}

	@Override
	public boolean isComplete() {
		return enemies.isEmpty();
	}

}