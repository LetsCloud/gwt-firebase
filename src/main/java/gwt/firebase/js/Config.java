/*
 * #%L
 * LetsCloud
 * %%
 * Copyright (C) 2020 LetsCloudTeam
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
/**
 * 
 */
package gwt.firebase.js;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author robi
 *
 */
@JsType(isNative = false)
public class Config {
	@JsProperty
	public native void setApiKey(String apiKey);

	@JsProperty
	public native String getApiKey();

	@JsProperty
	public native void setAuthDomain(String authDomain);

	@JsProperty
	public native String getAuthDomain();

	@JsProperty
	public native void setProjectId(String projectId);

	@JsProperty
	public native String getProjectId();

	@JsProperty
	public native void setDatabaseURL(String databaseURL);

	@JsProperty
	public native String getDatabaseURL();

	@JsProperty
	public native void setStorageBucket(String storageBucket);

	@JsProperty
	public native String getStorageBucket();

	@JsProperty
	public native void setMessagingSenderId(String messagingSenderId);

	@JsProperty
	public native String getMessagingSenderId();

	@JsProperty
	public native void setAppId(String appId);

	@JsProperty
	public native String getAppId();
}
