package com.jeterson.gwtdatagrid.client;

import com.google.gwt.user.client.ui.FlowPanel;

public class DataGridWidget extends FlowPanel{

	
	public DataGridWidget(String tag) {
		super(tag);
	}
	
	public DataGridWidget() {
		
	}
	
	public void setText(String text){
		getElement().setInnerText(text);
	}
	public String getText(){
		return getElement().getInnerText();
	}
	
	public void setAttribute(String name, Object value){
		getElement().setAttribute(name, value + "");
	}
	
	public String getAttributte(String name){
		return getElement().getAttribute(name);
	}
}
