package com.jeterson.gwtdatagrid.client;

import java.util.ArrayList;
import java.util.Collections;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.jeterson.gwtdatagrid.client.tablesorter.ResourceInjector;
import com.jeterson.gwtdatagrid.client.tablesorter.Resources;

public class DataGridView extends FlowPanel {

	static{
		ResourceInjector.injectJS(Resources.INSTANCE.floatHead());
	}
	int pagina = 0;
	int tamanhoPagina = 100;

	private final Button btnNext = new Button("Next");
	private final Button btnPreviows = new Button("Previows");
	private final DataGrid grid = new DataGrid();
	private DataGridBody corpo = new DataGridBody();
	private DataGridHeader cabeca = new DataGridHeader();
	private final HorizontalPanel h = new HorizontalPanel();
	private final TextBox txtSearch = new TextBox();
	public DataGridView() {

		addAttachHandler(e->{
			if(e.isAttached()){
				

			}
		});

		create();
		configurarAcao();
		paginar();

		grid.getElement().setId(Document.get().createUniqueId());


		this.add(grid);
		this.add(h);
		h.add(btnPreviows);
		h.add(btnNext);
		h.add(txtSearch);
		txtSearch.addValueChangeHandler(e->{
			TextBox t = (TextBox) e.getSource();
			filter(t.getText(), 0);
		});
	}


	

	

	private void create(){


		DataGridCellHeader cel1 = new DataGridCellHeader();
		DataGridCellHeader cel2 = new DataGridCellHeader();
		DataGridCellHeader cel3 = new DataGridCellHeader();
		DataGridCellHeader cel4 = new DataGridCellHeader();	
		DataGridCellHeader cel5 = new DataGridCellHeader();
		DataGridCellHeader cel6 = new DataGridCellHeader();
		DataGridCellHeader cel7 = new DataGridCellHeader();
		cel1.addDomHandler(e->{sort(0);}, ClickEvent.getType());
		cel1.setText("CODIGO");
		cel2.setText("DESCRICAO");
		cel3.setText("DATA");
		cel4.setText("IDADE");
		cel5.setText("PRECO");
		cel6.setText("MARCA");
		cel7.setText("UNIDADE");

		setHeaders(cel1, cel2, cel3, cel4, cel5, cel6, cel7);
		corpo.addAllRows(new Object[][]{
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Maça", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Uva", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Goiaba", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Manga", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Caju", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Laranha", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Poca", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Abacaxi", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" },
			{1,"Banana", "01/01/2017", 20, 12.5, "Rural", "UN" }
		});


		grid.add(cabeca);
		grid.add(corpo);
	}

	private void configurarAcao(){
		btnNext.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(pagina < corpo.getAllRows().size() / tamanhoPagina - 1){
					pagina++;
					paginar();	
				}

			}
		});

		btnPreviows.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(pagina > 0){
					pagina--;
					paginar();	
				}

			}
		});
	}

	public void setHeaders(DataGridCellHeader...cellHeaders){
		cabeca.clear();
		DataGridRow row = new DataGridRow();
		for(int i=0;i<cellHeaders.length;i++){
			cellHeaders[i].setIndex(i);
			cellHeaders[i].addDomHandler(e->{
				DataGridCellHeader c = (DataGridCellHeader) e.getSource();
				sort(c.getIndex());
			}, ClickEvent.getType());

			row.add(cellHeaders[i]);
		}
		cabeca.add(row);
	}

	public void setRows(DataGridRow...rows){
		corpo.clear();
		for(int i=0;i<rows.length;i++){
			corpo.add(rows[i]);
			corpo.addAllRows(rows[i]);
		}
	}

	private void paginar(){

		corpo.clear();
		corpo.clearCurrentRows();
		for(int b = pagina * tamanhoPagina;b<corpo.getAllRows().size() && b<(pagina+1)*tamanhoPagina;b++){
			/*DataGridRow row = new DataGridRow();
			for(int j=0;j<7;j++){
				DataGridCell cel = new DataGridCell();
				cel.setText("Field Page: "+Character.toString((char)(b+64)) +" id "+ (j));
				row.add(cel);
			}
			 */
			

			corpo.addCurrentRows(corpo.getAllRows().get(b));
			corpo.add(corpo.getAllRows().get(b));
			
		}
		//resize(grid.getElement(), colNumber);



	}

	private void filter(String filter, int col){
		filter = filter.toUpperCase();


		for(int i=0;i<corpo.getAllRows().size();i++){
			DataGridCell cell = corpo.getAllRows().get(i).getCells().get(col);
			if(cell.getText().toUpperCase().contains(filter)){
				corpo.getAllRows().get(i).getElement().getStyle().setDisplay(Display.BLOCK);
			}else{
				corpo.getAllRows().get(i).getElement().getStyle().setDisplay(Display.NONE);
			}
		}

		if(!filter.isEmpty()){
			corpo.clear();
			for(DataGridRow r : corpo.getAllRows()){
				corpo.add(r);
			}
		}else{
			corpo.clear();
			for(DataGridRow r : corpo.getCurrentRows()){
				corpo.add(r);
			}
		}
		

	}

	/**
	 * Faz a ordenação da coluna da table
	 * @param col indice da coluna que será ordenada
	 */
	private void sort(int col){
		boolean switching = true;
		boolean shoudSwitch = false;
		ArrayList<DataGridRow> rows;
		int i=0;
		String dir = "asc";
		String x = "",y="";
		int switchCount = 0;
		while(switching){
			rows = null;
			rows = corpo.getCurrentRows();

			switching = false;

			for(i=0;i<(rows.size()-1);i++){
				shoudSwitch = false;

				x = rows.get(i).getCells().get(col).getText();
				y = rows.get(i+1).getCells().get(col).getText();

				if(dir.equals("asc")){
					
					/**
					 * Verificamos se é um número, se for, ordenamos numericamente
					 */
					if(isNumber(x) && isNumber(y)){
						if(Double.parseDouble(x) > Double.parseDouble(y)){
							shoudSwitch = true;
							break;
						}
					}else{
						if(x.compareTo(y) > 0){
							shoudSwitch = true;
							break;
						}
					}


				}else if(dir.equals("desc")){
					/**
					 * Verificamos se é um número, se for, ordenamos numericamente
					 */
					if(isNumber(x) && isNumber(y)){
						if(Double.parseDouble(x) < Double.parseDouble(y)){
							shoudSwitch = true;
							break;
						}
					}else{
						if(x.compareTo(y) < 0){
							shoudSwitch = true;
							break;
						}
					}
				}
			}
			if(shoudSwitch){
				rows.get(i).getElement().getParentNode().insertBefore(rows.get(i+1).getElement(), rows.get(i).getElement());
				/**
				 * Estava dando loop infinito pois era alterado a posicao dos nodes no DOM html, e não era trocado
				 * a posicao do array list, depois de aplicar o swap, funcionou liso
				 */
				Collections.swap(rows, i+1, i);

				switching = true;
				switchCount++;
			}else{
				if(switchCount == 0 & dir.equals("asc")){
					dir = "desc";
					switching = true;
				}
			}

		}

	}


	private boolean isNumber(String val){
		try{
			Double.parseDouble(val);
			return true;
		}catch (Exception e) {
			return false;
		}
	}







}
