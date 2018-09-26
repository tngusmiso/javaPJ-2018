package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class ResourcePanel extends JPanel{
	
	public ArrayList<File> fileArray;	// filChooser에서 선택한 File객체 저장하는 ArrayList
	
	private ButtonPanel buttonPanel;	// add button, remove button 배치되어 있는 Pannel
	private JList<String> resourceList;	// fileArray에 저장된 객체들의 이름만 보여주는 리스트
	private DefaultListModel model;		// resourceList의 모델 
	private JScrollPane scrollPane;		// resourceList를 담고있는 스크롤 팬
	
	
	//생성자 
	public ResourcePanel() {
		this.setLayout(new BorderLayout());	
		
		fileArray = new ArrayList();
		
		buttonPanel = new ButtonPanel();
		model= new DefaultListModel();
			resourceList = new JList<String>(model);
			resourceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(resourceList);
		
		add(buttonPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	
	//ResourcePannel에 포함된 ButtonPannel에 대한 클래
	private class ButtonPanel extends JPanel{
		private JLabel label;
		private JButton addButton;
		private JButton removeButton;
		
		private ButtonPanel() {
			label = new JLabel("resources");
			addButton = new JButton("add");
			removeButton = new JButton("remove");
			
			add(label);
			add(addButton);
			add(removeButton);
			
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePicker fp = new FilePicker();
					fp.ChooseFiles();
				}
			});
			
			removeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeListMember();
				}
			});
		}
	}
	
	//fileChooser에서 파일을 열면 호출되는 함수.
	public void addListMember(File file) {
		fileArray.add(file);	//fileArray에 File객체 저장 
		int pos = resourceList.getModel().getSize();
		model.add(pos, file.getName());		//model에는 파일명만 저장 
	}
	
	//remove button을 눌렀을 때 호출되는 함수 
	public void removeListMember() {
		int resIdx = resourceList.getSelectedIndex();
		if(resourceList.getModel().getSize()<=0) {
			JOptionPane.showMessageDialog(null,"리소스가 비어있습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(resIdx<0) {
			JOptionPane.showMessageDialog(null,"제거할 리소스를 선택하세요.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		model.removeElementAt(resIdx);
		fileArray.remove(resIdx);
	}
	
	public File getFileArray(){
		return fileArray.get(0);
	}
	
}
