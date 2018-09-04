package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class PreviewPanel extends JPanel{

	private JButton playButton;
	private JButton pauseButton;
	private JLabel currentTimeLabel;
	private JLabel leftTimeLabel;
	private JSlider timeSlider;	
	
	public PreviewPanel() {
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
