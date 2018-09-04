package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class PreviewPanel extends JPanel{

	private PlayerPanel playerPanel;
	private VideoPanel videoPanel;
	
	public PreviewPanel() {
		this.setLayout(new BorderLayout());

		videoPanel = new VideoPanel();		
		playerPanel = new PlayerPanel();
		
		add(videoPanel, BorderLayout.CENTER);
		add(playerPanel, BorderLayout.SOUTH);
		
	}
	
	private class VideoPanel extends JPanel{
		private JLabel vLabel;
		
		private VideoPanel() {
			setBackground(Color.black);
			vLabel = new JLabel("video area");
			add(vLabel);
		}
	}
	
	private class PlayerPanel extends JPanel{
		private JButton playButton;
		private JButton pauseButton;
		private JLabel currentTimeLabel;
		private JLabel leftTimeLabel;
		private JSlider timeSlider;	
		
		private PlayerPanel() {
			setBackground(Color.white);
			playButton = new JButton("paly");
			pauseButton = new JButton("pause");
			currentTimeLabel = new JLabel("1:00");
			leftTimeLabel = new JLabel("/ 3:00");
			timeSlider = new JSlider();
			
			add(playButton);
			add(pauseButton);
			add(currentTimeLabel);
			add(leftTimeLabel);
			add(timeSlider);
		}
	}
}
