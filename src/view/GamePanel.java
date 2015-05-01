package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private JPanel fieldPanel;
	private JPanel scorePanel;
	
	public GamePanel(JPanel fieldPanel, JPanel scorePanel) {
		setLayout(new BorderLayout());
		add(fieldPanel, BorderLayout.CENTER);
		add(scorePanel, BorderLayout.SOUTH);
		setFieldPanel(fieldPanel);
		setScorePanel(scorePanel);
	}

	public JPanel getFieldPanel() {
		return fieldPanel;
	}

	public void setFieldPanel(JPanel fieldPanel) {
		this.fieldPanel = fieldPanel;
	}

	public JPanel getScorePanel() {
		return scorePanel;
	}

	public void setScorePanel(JPanel scorePanel) {
		this.scorePanel = scorePanel;
	}
	
	

}
