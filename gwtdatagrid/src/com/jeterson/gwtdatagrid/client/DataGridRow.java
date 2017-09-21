package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

/**
 * <code>Tr</code> element
 * @author jeterson
 *
 */
public class DataGridRow extends DataGridWidget {

	private ArrayList<DataGridCell> cells = new ArrayList<DataGridCell>();
	public DataGridRow() {
		super("tr");
	}

	public void addCells(DataGridCell...cells){
		for(int i=0;i<cells.length;i++){
			add(cells[i]);
			this.cells.add(cells[i]);
		}
	}
	
	public void addCells(Object... values){
		for(int i=0;i<values.length;i++){
			DataGridCell cel = new DataGridCell();
			cel.setText(values[i]+"");
			addCells(cel);
		}
	}
	
	
	public ArrayList<DataGridCell> getCells() {
		return cells;
	}
}
