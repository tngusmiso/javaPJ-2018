package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.media.*;

public class PreviewPanel extends JFrame{
	private VideoPanel videoPanel;
	
	public PreviewPanel() {
		this.setLayout(new BorderLayout());

		videoPanel = new VideoPanel();
		
		add(videoPanel, BorderLayout.CENTER);
		
	}
	
	private class VideoPanel extends JPanel{
		private Player player;
		private File file;
		
		private VideoPanel() {
			file = VideoEditor.resourceView.getFileArray();
			createPlayer();
		}
		
		private void createPlayer() {
			if ( file == null )
		         return;
			removePreviousPlayer();
			
			try {
				// create a new player and add listener
				player = Manager.createPlayer( file.toURL() );
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
		 
		      Container c = getContentPane();
		      
		      if ( visual != null ) 
		         c.remove( visual );
		 
		      if ( control != null ) 
		         c.remove( control );
		  }
	}
}
