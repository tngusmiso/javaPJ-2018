package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.media.*;

public class PreviewPanel extends JPanel{
	private VideoPanel videoPanel;
	private ControllerPanel controllerPanel;

	public PreviewPanel() {
		this.setLayout(new BorderLayout());

		videoPanel = new VideoPanel();
		controllerPanel = new ControllerPanel();

		add(videoPanel, BorderLayout.CENTER);
		add(controllerPanel, BorderLayout.SOUTH);
		
	}
	
	private class VideoPanel extends JPanel{
		private Player player;
		private File file;
		private URL fileURL;
		
		private VideoPanel() {
			try {
				createPlayer();
			}
			catch (Exception e) {
			}
		}
		
		private void createPlayer() {
			file = VideoEditor.resourceView.getFileArrayList().get(0);
			if ( file == null )
		         return;
			removePreviousPlayer();
			
			try {
				// create a new player and add listener
				player = Manager.createRealizedPlayer( file.toURI().toURL());
				player.start();  // start player
			}
			catch ( Exception e ){
				JOptionPane.showMessageDialog( this,
	            "Invalid file or location", "Error loading file",
	            JOptionPane.ERROR_MESSAGE );
			}
		}
		
		private void removePreviousPlayer(){
		      if ( player == null )
		         return;
		 
		      player.close();
		 
		      Component visual = player.getVisualComponent();
		      Component control = player.getControlPanelComponent();
		 
		      if ( visual != null ) remove( visual );
		 
		      if ( control != null ) remove( control );
		  }
	}
	
	private class ControllerPanel extends JPanel{
		private JButton playButton;
		private JLabel timeLabel;
		private JSlider timeSlider;
		
		private ControllerPanel() {
			playButton = new JButton("play");
			timeLabel = new JLabel("1:00 / 3:00");
			timeSlider = new JSlider();
			
			add(playButton);
			add(timeLabel);
			add(timeSlider);
			
			playButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					videoPanel.createPlayer();
				}
			});
		}
	}
}
