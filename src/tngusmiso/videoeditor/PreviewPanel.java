package tngusmiso.videoeditor;

import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;

public class PreviewPanel extends BorderPane{

	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mpane;
	PlayerBar bar;
	

	public PreviewPanel () {
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mpane = new Pane();
		bar=new PlayerBar(player);
		
		mpane.getChildren().add(view);
		
		setCenter(mpane);
		setBottom(bar);		
	}
	
	public void playMedia (String file) {
		media = new Media(file);
		player.play();
	}
	
	private class PlayerBar extends HBox{	
		Slider time =new Slider();
		Slider vol = new Slider();
		
		Button playButton = new Button("||");
		Label volume = new Label("Volume : ");
		
		MediaPlayer play;
		public PlayerBar (MediaPlayer paly) {
			player = play;
			
			setAlignment(Pos.CENTER);
			setPadding(new Insets(5,10,5,10));
			
			vol.setPrefWidth(70);
			vol.setMinWidth(30);
			vol.setValue(100);
			
			HBox.setHgrow(time, Priority.ALWAYS);
			
			playButton.setPrefWidth(30);
			
			getChildren().add(playButton);
			getChildren().add(time);
			getChildren().add(volume);
			getChildren().add(vol);		
		}
	}
}
