package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class VideoEditor extends JFrame{
	
	public static JPanel toolBar;
	public static PreviewPanel videoView;
	public static ResourcePanel resourceView;
	public static TimelinePanel timelineView;
	
	public VideoEditor() {
		setTitle("Video Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ve = getContentPane();
		ve.setLayout(new BorderLayout());
		
		videoView = new PreviewPanel();
		resourceView = new ResourcePanel();
		timelineView = new TimelinePanel();
		
		//ve.add(videoView, BorderLayout.CENTER);
		ve.add(resourceView, BorderLayout.EAST);
		ve.add(timelineView, BorderLayout.SOUTH);

		setSize (1200,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VideoEditor();
	}

}
