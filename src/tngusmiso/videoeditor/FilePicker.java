package tngusmiso.videoeditor;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class FilePicker extends JFileChooser {
	private FileNameExtensionFilter audioFilter;
	private FileNameExtensionFilter videoFilter;
	private FileNameExtensionFilter imageFilter;
	public FilePicker(){
		//필터 설정 
		audioFilter = new FileNameExtensionFilter("audio", "mp3", "wav");
		videoFilter = new FileNameExtensionFilter("video","mp4", "mpg", "mpeg", "avi", "mkv");
		imageFilter = new FileNameExtensionFilter("images", "bmp", "png", "gif", "jpg", "jpeg");
		
		//필터 적용 
		setFileFilter(audioFilter);
		addChoosableFileFilter(videoFilter);
		addChoosableFileFilter(imageFilter);
		
		//파일만 선택 가능
		setFileSelectionMode(JFileChooser.FILES_ONLY);
		int ret = showOpenDialog(null);
		
		
		//파일을 선택하지 않았을 경
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		//선택된 파일은 ListMember추가 
		VideoEditor.resourceView.addListMember(this.getSelectedFile());
	
	}
}