package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class ResourcePanel extends JPanel{
	private ButtonPanel buttonPanel;
	private JList<String> resourceList;
	private JScrollPane scrollPane;
	
	public ResourcePanel() {
		this.setLayout(new BorderLayout());
		buttonPanel = new ButtonPanel();
		String exStr[] = {"예시1","예시2","예시3"};
		resourceList = new JList<String>(exStr);
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
		}
	}
}
