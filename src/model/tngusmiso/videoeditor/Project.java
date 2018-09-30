package model.tngusmiso.videoeditor;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.swing.undo.UndoableEditSupport;

public class Project {
	private int version;
	private String name;
	private File folder;
	private int framerate;	//프레임 속도
	private int width;
	private int heigth;
	private ArrayList<> resources;
	private ArrayList<> timelineObjects;
	private Color backgroudnColor;
	private UndoableEditSupport undoSupport;
	
	public Project() {
		
	}
	
}
