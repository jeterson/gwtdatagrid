package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;

/**
 * <code>Thead</code> element
 * @author jeterson
 *
 */
public class DataGridHeader extends DataGridWidget {

	private ArrayList<DataGridRow> rows = new ArrayList<DataGridRow>();
	public DataGridHeader() {
		super("thead");
	}
	
	@Override
	public void add(Widget w) {
		super.add(w);
		if(w instanceof DataGridRow){
			rows.add((DataGridRow) w);
		}
	}
}
