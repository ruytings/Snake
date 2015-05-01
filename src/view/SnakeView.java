package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeView extends JFrame {
	
	private JPanel gamePanel;
	
	public SnakeView(JPanel gamePanel) {
		this.setResizable(false);
		this.setTitle("Snake");
		this.setVisible(true);
		this.setSize(607, 600);
		this.setBackground(Color.YELLOW);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setGamePanel(gamePanel);
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
		setMainPanel(gamePanel);
	}
	
	public void setMainPanel(JPanel gamePanel){
        setContentPane(gamePanel);
	}
	
	
	
	
	

}
