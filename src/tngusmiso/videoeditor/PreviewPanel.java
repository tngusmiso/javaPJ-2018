package tngusmiso.videoeditor;


import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PreviewPanel extends BorderPane{

	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mpane;
	
	public PreviewPanel (String file) {
		media = new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mpane = new Pane();
		
		mpane.getChildren().add(view);
		
		setCenter(mpane);
		
		player.play();
	}
}
