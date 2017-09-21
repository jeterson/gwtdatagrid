package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;

/**
 * <code>Tbody</code> element
 * @author jeterson
 *
 */
public class DataGridBody extends DataGridWidget {

	private ArrayList<DataGridRow> currentRows = new  ArrayList<DataGridRow>();
	private ArrayList<DataGridRow> fullRows = new  ArrayList<DataGridRow>();
	public DataGridBody(){
		super("tbody");
	}
	
	public void clearCurrentRows(){
		currentRows.clear();
	}
	
	public void clearAllRows(){
		fullRows.clear();
	}
	
	@Override
	public void add(Widget w) {
		super.add(w);
		
	}
	
	
	public void addCurrentRows(DataGridRow r){
		currentRows.add(r);
	}
	
	public void addAllRows(Object[][] rowscells){
		for(int i = 0;i<rowscells.length;i++){
			DataGridRow rows = new DataGridRow();
			rows.addCells(rowscells[i]);
			addAllRows(rows);
		}
	}
	public void addAllRows(DataGridRow... r){
		for(DataGridRow e : r)
			fullRows.add(e);
	}
	
	public ArrayList<DataGridRow> getCurrentRows() {
		return currentRows;
	}
	
	public ArrayList<DataGridRow> getAllRows() {
		return fullRows;
	}
}
