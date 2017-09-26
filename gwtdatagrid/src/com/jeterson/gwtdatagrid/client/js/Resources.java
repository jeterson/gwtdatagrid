package com.jeterson.gwtdatagrid.client.js;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Scripts de dependencias  
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
public interface Resources extends ClientBundle{

	public static final Resources INSTANCE = GWT.create(Resources.class);
	
	@Source("datatable-bootstrap.js")
	TextResource datatable_bootstrap_js();
	
	@Source("datatable.min.js")
	TextResource datatable_min_js();
	
	@Source("table-datatable-scroller.min.js")
	TextResource table_datatable_scroller_min_js();
	
	@Source("jquery-2.2.4.min.js")
	TextResource jquery_2_2_4_min_js();
}
