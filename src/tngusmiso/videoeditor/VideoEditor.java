package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class VideoEditor extends JFrame{
	
	private JPanel toolBar;
	private JPanel videoView;
	private JPanel resourceView;
	private JPanel timelineView;
	
	public VideoEditor() {
		setTitle("Video Editor");
		
		Container ve = getContentPane();
		ve.setLayout(new BorderLayout());
		
		videoView = new PreviewPanel();
		resourceView = new ResourcePanel();
		timelineView = new TimelinePanel();
		
		ve.add(videoView, BorderLayout.CENTER);
		ve.add(resourceView, BorderLayout.EAST);
		ve.add(timelineView, BorderLayout.SOUTH);

		setSize (1200,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VideoEditor();
	}

}
