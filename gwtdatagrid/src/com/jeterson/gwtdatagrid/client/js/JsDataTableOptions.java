package com.jeterson.gwtdatagrid.client.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options do objeto {@link com.jeterson.gwtdatagrid.client.js.JsDataTable}
 * Veja em: {@link https://datatables.net/}
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
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDataTableOptions {

	@JsProperty
	public boolean scroller;
	@JsProperty
	public boolean deferRender;
	@JsProperty
	public int scrollY;
	
}
