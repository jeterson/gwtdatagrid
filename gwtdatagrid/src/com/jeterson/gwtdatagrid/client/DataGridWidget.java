package com.jeterson.gwtdatagrid.client;

import com.google.gwt.user.client.ui.FlowPanel;

/**
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
 */
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
