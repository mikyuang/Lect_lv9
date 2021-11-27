package controller;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TablePanel extends Util{

	Vector<String> colName = new Vector<>();
	public boolean chioces[][] = new boolean[4][4];
	JTable table = null;

	public TablePanel() {
		setLayout(null);
		setBounds(0, 570, 500, 120);
		setTable();
	}


	private void setTable() {
		this.colName.add("메뉴");
		this.colName.add("가격");
		this.colName.add("개수");

		this.table = new JTable(StarFrame.choiceMeun, colName);
		this.table.setBounds(0, 0, 500, 120);
		this.table.setVisible(true);
		add(this.table);

		JScrollPane js = new JScrollPane(table); 
		js.setBounds(0, 0, 500, 120);
		js.setAutoscrolls(true);
		js.setVisible(true);
		add(js);

	}

	
}
