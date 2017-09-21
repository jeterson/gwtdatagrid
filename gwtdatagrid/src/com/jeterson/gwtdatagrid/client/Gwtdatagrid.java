package com.jeterson.gwtdatagrid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwtdatagrid implements EntryPoint {
	
	public void onModuleLoad() {
		FlowPanel  f = new FlowPanel();
		f.setHeight("300px");
		
		f.add(new DataGridView());
		RootPanel.get().add(f);
	}
}
