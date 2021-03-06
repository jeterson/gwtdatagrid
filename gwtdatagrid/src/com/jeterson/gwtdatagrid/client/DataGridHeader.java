package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;

/**
 * <code>Thead</code> element
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
