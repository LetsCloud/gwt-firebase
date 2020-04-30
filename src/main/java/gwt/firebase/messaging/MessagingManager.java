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
package gwt.firebase.messaging;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;

import gwt.firebase.js.Firebase;
import gwt.firebase.messaging.js.FcmMessageJs;
import gwt.firebase.messaging.js.Messaging;
import gwt.jswrapper.global.promise.Fn;

/**
 * @author robi
 *
 */
public class MessagingManager implements HasMessagingFeatures {
	private static Logger logger = Logger.getLogger(MessagingManager.class.getName());
/*
	static {
		GwtJsWrapper.injectJs(FirebaseClientBundle.INSTANCE.firebaseAppJs(), true, false);
		GwtJsWrapper.injectJs(FirebaseClientBundle.INSTANCE.firebaseMessagingJs(), true, false);
	}
*/
	private Firebase firebase;
	private Boolean registered;

	Fn.NoArg unsubscribe;

	public MessagingManager() {
		logger.info("MessagingManager()");
		registered = false;
	}

	public Firebase getFirebase() {
		logger.info("MessagingManager.getFirebase()");
		return firebase;
	}

	public void setFirebase(Firebase firebase) {
		logger.info("MessagingManager.setFirebase()");
		this.firebase = firebase;
		registered = true;
	}

	public Boolean isRegistered() {
		logger.info("MessagingManager.isRegistered()=" + registered);
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	@Override
	public Messaging getMessaging() {
		logger.info("MessagingManager.getFirebaseMessaging()");
		if (firebase != null) {
			logger.info("MessagingManager.getFirebaseMessaging()->(firebase != null)");
			return firebase.messaging();
		} else {
			GWT.log("Firebase is not yet registered", new IllegalStateException());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getToken(Fn.Arg<String> callback) {
		logger.info("MessagingManager.getToken()");
		getMessaging().getToken().then((object) -> {
			String token = (String) object;
			logger.info("MessagingManager.getToken()->token=" + token);
			callback.call(token);
		}).katch(error -> {
			logger.info("MessagingManager.getToken().katch()->" + error.toString());
		});
	}

	@Override
	public void useServiceWorker(Object serviceWorker) {
		getMessaging().useServiceWorker(serviceWorker);
	}

	@Override
	public void requestPermission(Fn.NoArg callback) {
		logger.info("MessagingManager.requestPermission()");
		getMessaging().requestPermission().then(() -> {
			callback.call();
		});
	}

	@Override
	public void onTokenRefresh(Fn.Arg<String> callback) {
		logger.info("MessagingManager.onTokenRefresh()");
		getMessaging().onTokenRefresh(() -> {
			getToken(callback);
		});
	}

	@Override
	public void onMessage(Fn.Arg<FcmMessageJs> callback) {
		logger.info("MessagingManager.onMessage()");
		unsubscribe = getMessaging().onMessage(callback);
	}
}
