package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class TimelinePanel extends JPanel{
	private JLabel videoLabel;
	private JLabel textLabel;
	private JLabel musicLabel;
	
	public TimelinePanel() {
		videoLabel =new JLabel("video");
		textLabel = new JLabel("text");
		musicLabel = new JLabel("music");
		
		add(videoLabel);
		add(textLabel);
		add(musicLabel);
	}
}
