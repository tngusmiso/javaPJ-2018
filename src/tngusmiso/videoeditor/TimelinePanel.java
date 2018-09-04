package tngusmiso.videoeditor;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class TimelinePanel extends JPanel{
	private JTable timelineTable;
	
	public TimelinePanel() {
		setBackground(Color.gray);

		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Stuff","Stuff"},0);
			tableModel.addRow(new Object[] {"video"});
			tableModel.addRow(new Object[] {"text"});
			tableModel.addRow(new Object[] {"music"});
		
			timelineTable = new JTable(tableModel);
		
		add(timelineTable);
	}
}
