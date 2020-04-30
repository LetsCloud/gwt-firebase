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
package gwt.firebase.messaging.js;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author robi
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FcmMessageJs {

	@JsProperty
	public String collapse_key;

	@JsProperty
	public FcmDataJs data;

	@JsProperty
	public String from;

	@JsProperty
	public FcmNotificationJs notification;

	@JsOverlay
	public final String getCollapse_key() {
		return collapse_key;
	}

	@JsOverlay
	public final FcmDataJs getData() {
		return data;
	}

	@JsOverlay
	public final String getFrom() {
		return from;
	}

	@JsOverlay
	public final FcmNotificationJs getNotification() {
		return notification;
	}

	@Override
	@JsMethod
	public native String toString();
}
