package controller;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.Util;

public class TablePanel extends Util{

	Vector<String> colName = new Vector<>();
	public boolean itemOrdered[][] = new boolean[4][4];
	JTable table = null;

	public TablePanel() {
		setLayout(null);
		setBounds(100, 680, 600, 120);
		setTable();
	}


	private void setTable() {
		this.colName.add("메뉴");
		this.colName.add("가격");
		this.colName.add("개수");

		//this.table = new JTable(StarFrame.selectItems, colName);
		this.table.setBounds(0, 0, 600, 120);
		this.table.setGridColor(Color.gray);
		this.table.setVisible(true);
		add(this.table);

		JScrollPane js = new JScrollPane(table); 
		js.setBounds(0, 0, 600, 120);
		js.setAutoscrolls(true);
		js.setVisible(true);
		add(js);

	}

	
}
