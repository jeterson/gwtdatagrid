package com.jeterson.gwtdatagrid.client.js;

import com.google.gwt.dom.client.Element;

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Representação java script do objeto DataTable
 * Site do projeto oficial: <a href="https://datatables.net/">https://datatables.net/</a>
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
@JsType(isNative=true, namespace = JsPackage.GLOBAL)
public class JsDataTable extends JQueryElement{
	
	
	  @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
	    public static native JsDataTable $(JQueryElement element);

	    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
	    public static native JsDataTable $(Element element);
	    
	    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
	    public static native JsDataTable $(String selector);
	    
	    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
	    public static native JsDataTable $();
	    
	    @JsMethod
	    public native JsDataTable DataTable();
	    
	    @JsMethod
	    public native JsDataTable DataTable(JsDataTableOptions opt);
	    
	    @JsMethod 
	    public native JsDataTable destroy();
	    
	    @JsMethod
	    public native JsDataTable draw();
	    
	    @JsMethod
	    public native JsDataTable rows(String param);
	    
	    @JsMethod
	    public native Object data();
	    
	    
	    

	
}
