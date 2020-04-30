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

import gwt.firebase.messaging.js.Messaging;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * firebase.app.App
 * 
 * A Firebase App holds the initialization information for a collection of
 * services. Do not call this constructor directly. Instead, use
 * firebase.initializeApp() to create an app.
 * 
 * @author robi
 *
 */
@JsType(isNative = true, namespace = "firebase.app", name = "App")
public class Firebase {

	/**
	 * Mivel a firebase névtérben található initializeApp metódus a firebase.app
	 * névtérben található App osztályt adja vissza, ésszerű azt a firebase.app.App
	 * osztályt leképező osztályban leképezni.
	 * 
	 * @param config non-null Object
	 * @return Firebase azaz firebase.app.App
	 */
	@JsMethod(namespace = "firebase")
	public static native Firebase initializeApp(Config config);

	/**
	 * A firebase.app.App osztály name tulajdonsága.
	 * 
	 * The (read-only) name for this app. The default app's name is "[DEFAULT]".
	 * 
	 * @return string
	 */
	@JsProperty
	public native String getName();

	/**
	 * A firebase.app.App osztály messaging metódusa.
	 * 
	 * Gets the Messaging service for the current app.
	 * 
	 * @return non-null firebase.messaging.Messaging
	 */
	public native Messaging messaging();
}
