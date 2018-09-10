package tngusmiso.videoeditor;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class FilePicker { 
	private JFileChooser fc;
	private FileNameExtensionFilter audioFilter;
	private FileNameExtensionFilter videoFilter;
	private FileNameExtensionFilter imageFilter;
	public FilePicker(){
		fc = new JFileChooser();
		audioFilter = new FileNameExtensionFilter("audio", "mp3", "wav");
		videoFilter = new FileNameExtensionFilter("video","mp4", "mpg", "mpeg", "avi", "mkv");
		imageFilter = new FileNameExtensionFilter("images", "bmp", "png", "gif", "jpg", "jpeg");
	}
	
	public void ChooseFiles() {
		fc.setFileFilter(audioFilter);
		fc.addChoosableFileFilter(videoFilter);
		fc.addChoosableFileFilter(imageFilter);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int ret = fc.showOpenDialog(null);
		
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		VideoEditor.resourceView.addListMember(fc.getSelectedFile());
	}
}