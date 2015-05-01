package controller;

import domain.SnakeGame;

public class GameController {
	
	private SnakeGame game;

	public GameController(SnakeGame game) {
		super();
		this.game = game;
	}

	public SnakeGame getGame() {
		return game;
	}

	public void setGame(SnakeGame game) {
		this.game = game;
	}
	
	public int getScore() {
		return this.getGame().getScore();
	}
	
	public int getLevel() {
		return this.getGame().getLevel();
	}
	

}
