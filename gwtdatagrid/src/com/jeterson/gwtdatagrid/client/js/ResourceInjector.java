package com.jeterson.gwtdatagrid.client.js;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.TextResource;
/**
 * Injetor de dependencias javascript
 
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
public class ResourceInjector {

	public static void injectJS(TextResource resource){
		ScriptInjector.fromString(resource.getText()).setWindow(ScriptInjector.TOP_WINDOW).setRemoveTag(false).inject();
		
	}
	
	public static void injectJS(DataResource resource){
		ScriptInjector.fromUrl(resource.getSafeUri().asString()).setWindow(ScriptInjector.TOP_WINDOW).setRemoveTag(false).inject();
	}
	
	public static void injetcCss(TextResource resource){
		StyleInjector.inject(resource.getText());
	}
	
	public static native boolean jQueryIsLoaded() /*-{
		if(typeof jQuery !== 'undefined')
			return true;
		else
			return false;
	}-*/;
}
