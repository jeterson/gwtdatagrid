package com.jeterson.gwtdatagrid.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * <code>Th</code> Element
 * 
 * <br/>
 * 
 * <br/>
 * Copyright 2017 Jeterson Miranda Gomes
 * <br/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *<p>     http://www.apache.org/licenses/LICENSE-2.0 </p>
 * <br/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <br/>
 * @author jeterson
 *
 */
public class DataGridCellHeader extends DataGridWidget{

	private int index;
	public DataGridCellHeader(String text) {
		super("th");
		setText(text);
	}
	
	public DataGridCellHeader() {
		super("");
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
	}
	
	@Override
	public String getText() {
		return super.getText();
	}
	
	
	
	public  HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	
}
