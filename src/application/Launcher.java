package application;


import controller.GameController;
import domain.*;
import view.*;

public class Launcher {
	
	public static void main(String args[]) {
			Chronometer chronometer = new Chronometer(110);
			SnakeGame game = new SnakeGame(chronometer);
			chronometer.addObserver(game);
			GameController controller = new GameController(game);
			FieldPanel fieldPanel = new FieldPanel(controller);
			ScorePanel scorePanel = new ScorePanel(controller);
			game.addObserver(fieldPanel);
			game.addObserver(scorePanel);
			GamePanel gamePanel = new GamePanel(fieldPanel, scorePanel);
			SnakeView view = new SnakeView(gamePanel);
			view.setMainPanel(gamePanel);
			game.moveSnakeLeft();
	}

}
