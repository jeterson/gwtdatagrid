package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

/**
 * <code>Tr</code> element
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
