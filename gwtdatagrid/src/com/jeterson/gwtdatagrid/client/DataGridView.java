package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.jeterson.gwtdatagrid.client.js.JsDataTable;
import com.jeterson.gwtdatagrid.client.js.JsDataTableOptions;
import com.jeterson.gwtdatagrid.client.js.ResourceInjector;
import com.jeterson.gwtdatagrid.client.js.Resources;

import gwt.material.design.jquery.client.api.JQuery;

/**
 * Grid para apresentação de dados
 
 * <br/>
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
public class DataGridView extends FlowPanel {

	/**
	 * Injeta as dependencias na página
	 */
	static{

		if(!ResourceInjector.jQueryIsLoaded())
			ResourceInjector.injectJS(Resources.INSTANCE.jquery_2_2_4_min_js());

		ResourceInjector.injectJS(Resources.INSTANCE.datatable_min_js());
		ResourceInjector.injectJS(Resources.INSTANCE.datatable_bootstrap_js());
		ResourceInjector.injectJS(Resources.INSTANCE.table_datatable_scroller_min_js());

	}
	
	private ArrayList<DataGridCell> cellfooters = new ArrayList<>();

	private final DataGrid grid = new DataGrid();
	private final DataGridBody corpo = new DataGridBody();
	private final DataGridHeader cabeca = new DataGridHeader();
	private final DataGridFooter rodape = new DataGridFooter();
	private HorizontalPanel h = new HorizontalPanel();
	private Button b1  =new Button("B1");
	private Button b2  =new Button("B2");

	public DataGridView() {
		this.add(grid);
		grid.add(cabeca);
		grid.add(corpo);
		grid.add(rodape);
		teste();
		
		grid.addStyleName("table table-bordered table-hover order-column");
		createHeaders("Codigo", "Descricao", "Preco");
		
		grid.addHandler(e->{
			new Timer() {
				
				@Override
				public void run() {
					draw();
					
				}
			}.schedule(100);
		}, ResizeEvent.getType());
		
		
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		init();
		
	}
	
	
	private void init() {
		JsDataTableOptions o = new JsDataTableOptions();
		o.deferRender = true;
		o.scroller = true;
		o.scrollY = 400;
		JsDataTable.$(grid.getElement()).DataTable(o);
		
		
		new Timer() {
			
			@Override
			public void run() {
				JsDataTable.$(grid.getElement()).DataTable().draw();
				
			}
		}.schedule(100);;
		
		
	}
	
	/**
	 * Retorna a linha selecionada
	 * @return
	 */
	public DataGridRow getSelectedRow() {
		JsDataTable table =  JsDataTable.$(getElement()).DataTable();
		JsArrayMixed arr = (JsArrayMixed) table.rows(".selected").data();
		JsArrayString r = null;
		DataGridRow row = new DataGridRow();
		if(arr.length() >= 1) {
			r = (JsArrayString) arr.getObject(0);
			
			for(int i=0;i<r.length();i++) {
				DataGridCell td = new DataGridCell(r.get(i));
				row.add(td);
			}
		}
		
		
		
		return row;
	}
	
	public void destroy() {
		JsDataTable.$(grid.getElement()).DataTable().destroy();
	}
	
	public void clearData() {
		destroy();
		corpo.clear();
		init();
	}
	
	public void draw() {
		JsDataTable.$(grid.getElement()).DataTable().draw();
	}
	
	
	private void teste() {
		this.add(h);
		h.add(b1);
		h.add(b2);
		
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				clearData();
			}
		});
		
		
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				destroy();
				for(int i=0;i<10000;i++) {
					DataGridRow row = new DataGridRow();
					row.addCells(1, "Teste " + i, (i*1.5));
					insertRow(row);
				}
				
				init();
				
			}
			
			
		});
		
		
	}
	
	
	public void createHeaders(String...cellHeaders) {
		DataGridRow rowHeader = new DataGridRow();
		for(String s : cellHeaders) {
			DataGridCellHeader c = new DataGridCellHeader(s);
			rowHeader.add(c);
		}
		cabeca.add(rowHeader);
		createFooters(cellHeaders);
	}
	
	public void createFooters(String... footers) {
		DataGridRow rowHeader = new DataGridRow();
		for(@SuppressWarnings("unused") String s : footers) {
			DataGridCell c = new DataGridCell();
			rowHeader.add(c);
			cellfooters.add(c);
		}
		rodape.add(rowHeader);
	}
	
	public void insertRow(DataGridRow row) {
		
		/**
		 * Handler pra indicar uma linha selecionada
		 */
		row.addDomHandler(e->{
			DataGridRow r = (DataGridRow) e.getSource();
			
			JQuery.$("#"+grid.getElement().getId() + " tbody tr.selected").removeClass("selected");
			
			if(r.getElement().hasClassName("selected"))
				r.removeStyleName("selected");
			else
				r.addStyleName("selected");
		}, ClickEvent.getType());
		
		corpo.add(row);
	}
	
	public void createRows(DataGridRow...rows) {
		for(DataGridRow r: rows) {
			corpo.add(r);
		}
	}
	
	public void createHeaders(DataGridCellHeader... cellHeaders) {
		DataGridRow rowHeader = new DataGridRow();

		for(DataGridCellHeader header:cellHeaders) {
			rowHeader.add(header);
		}

		cabeca.add(rowHeader);
	}


















}
