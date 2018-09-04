package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;

public class ResourcePanel extends JPanel{
	private JButton addButton;
	private JButton removeButton;
	private JList<String> resourceList;
	private JScrollPane scrollPane;
	
	public ResourcePanel() {
		addButton = new JButton("add");
		removeButton = new JButton("remove");
		
		String exStr[] = {"예시1","예시2","예시3"};
		resourceList = new JList<String>(exStr);
		resourceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane = new JScrollPane(resourceList);
		
		add(addButton);
		add(removeButton);
		add(scrollPane);
	}
}
