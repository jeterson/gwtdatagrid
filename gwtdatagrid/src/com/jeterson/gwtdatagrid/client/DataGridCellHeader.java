package com.jeterson.gwtdatagrid.client;

/**
 * <code>Th</code> Element
 * @author jeterson
 *
 */
public class DataGridCellHeader extends DataGridWidget{

	private int index;
	public DataGridCellHeader() {
		super("th");
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	
}
