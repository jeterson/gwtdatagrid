package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;

/**
 * <code>Tbody</code> element
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
