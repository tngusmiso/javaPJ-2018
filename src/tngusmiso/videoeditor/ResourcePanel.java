package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ResourcePanel extends JPanel{
	private ButtonPanel buttonPanel;
	private JList<String> resourceList;
	private JScrollPane scrollPane;
	private DefaultListModel model;
	
	public ResourcePanel() {
		this.setLayout(new BorderLayout());
		buttonPanel = new ButtonPanel();
		model= new DefaultListModel();
		resourceList = new JList<String>(model);;
		resourceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane = new JScrollPane(resourceList);
		
		add(buttonPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}
	
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
	
	public void addListMember(File file) {
		int pos = resourceList.getModel().getSize();
		model.add(pos, file.getName());
	}
	public void removeListMember() {
		int res = resourceList.getSelectedIndex();
		if(res<0) {
			JOptionPane.showMessageDialog(null,"제거할 리소스를 선택하세.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		model.removeElementAt(res);
	}
	
}
