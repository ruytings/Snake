package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameController;
import domain.Observer;

public class ScorePanel extends JPanel implements Observer {
	
	private GameController controller;
	private JLabel scoreLabel = new JLabel("Score: " + "        ");
	private JLabel levelLabel = new JLabel("Level: ");
	
	public ScorePanel(GameController controller) {
		super();
		this.setBackground(Color.BLACK);
		setController(controller);
		scoreLabel.setFont(new Font("Serif", Font.PLAIN, 31));
		scoreLabel.setForeground(Color.YELLOW);
		levelLabel.setFont(new Font("Serif", Font.PLAIN, 31));
		levelLabel.setForeground(Color.YELLOW);
		add(scoreLabel);
		add(levelLabel);
		update();
	}

	public GameController getController() {
		return controller;
	}

	public void setController(GameController controller) {
		if(controller != null) {
			this.controller = controller;
		}
	}
	
	public void update() {
		scoreLabel.setText("Score: " + controller.getScore() + "          ");
		levelLabel.setText("Level: " + controller.getLevel());
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public void setLevelLabel(JLabel levelLabel) {
		this.levelLabel = levelLabel;
	}
	
	
	
	

}
