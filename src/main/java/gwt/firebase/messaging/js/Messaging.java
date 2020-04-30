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

import gwt.jswrapper.global.promise.Fn;
import gwt.jswrapper.global.promise.Promise;
import jsinterop.annotations.JsType;

/**
 * firebase.messaging.Messaging
 * 
 * The Firebase Messaging service interface. Do not call this constructor
 * directly. Instead, use firebase.messaging().
 * 
 * @author robi
 *
 */
@JsType(isNative = true, namespace = "firebase.messaging", name = "Messaging")
public class Messaging {

	/**
	 * deleteToken
	 * 
	 * To forcibly stop a registration token from being used, delete it by calling
	 * this method.
	 * 
	 * @param token string The token to delete.
	 * @return Promise<Boolean> The promise resolves when the token has been
	 *         successfully deleted.
	 */
	public native Promise<Boolean, String> deleteToken(String token);

	/**
	 * getToken
	 * 
	 * Subscribes the user to push notifications and returns an FCM registration
	 * token that can be used to send push messages to the user.
	 * 
	 * If notification permission isn't already granted, this method asks the user
	 * for permission. The returned promise rejects if the user does not allow the
	 * app to show notifications.
	 * 
	 * @return Promise<String> The promise resolves with the FCM token string.
	 */
	public native Promise<String, String> getToken();

	/**
	 * onMessage
	 * 
	 * When a push message is received and the user is currently on a page for your
	 * origin, the message is passed to the page and an onMessage() event is
	 * dispatched with the payload of the push message.
	 * 
	 * NOTE: These events are dispatched when you have called
	 * setBackgroundMessageHandler() in your service worker.
	 * 
	 * @param nextOrObserver (non-null function(non-null Object) or non-null Object)
	 *                       This function, or observer object with next defined, is
	 *                       called when a message is received and the user is
	 *                       currently viewing your page.
	 * @return function() To stop listening for messages execute this returned
	 *         function.
	 */
	public native Fn.NoArg onMessage(Fn.Arg<FcmMessageJs> nextOrObserver);

	/**
	 * onTokenRefresh
	 * 
	 * You should listen for token refreshes so your web app knows when FCM has
	 * invalidated your existing token and you need to call getToken() to get a new
	 * token.
	 * 
	 * @param nextOrObserver (non-null function(non-null Object) or non-null Object)
	 *                       This function, or observer object with next defined, is
	 *                       called when a token refresh has occurred.
	 * @return function() To stop listening for token refresh events execute this
	 *         returned function.
	 */
	public native Fn.NoArg onTokenRefresh(Fn.NoArg nextOrObserver);

	/**
	 * requestPermission
	 * 
	 * Notification permissions are required to send a user push messages. Calling
	 * this method displays the permission dialog to the user and resolves if the
	 * permission is granted.
	 * 
	 * @return firebase.Promise The promise resolves if permission is granted.
	 *         Otherwise, the promise is rejected with an error.
	 */
	public native Promise<Void, Error> requestPermission();

	/**
	 * setBackgroundMessageHandler
	 * 
	 * FCM directs push messages to your web page's onMessage() callback if the user
	 * currently has it open. Otherwise, it calls your callback passed into
	 * setBackgroundMessageHandler().
	 * 
	 * Your callback should return a promise that, once resolved, has shown a
	 * notification.
	 * 
	 * @param callback
	 */
	public native void setBackgroundMessageHandler(Fn.NoArg callback);

	/**
	 * usePublicVapidKey
	 * 
	 * To set your own server application key, you can specify here the public key
	 * you set up from the Firebase Console under the Settings options.
	 * 
	 * @param publicKey A URL safe base64 encoded server application key. Value must
	 *                  not be null.
	 */
	public native void usePublicVapidKey(String publicKey);

	/**
	 * useServiceWorker
	 * 
	 * To use your own service worker for receiving push messages, you can pass in
	 * your service worker registration in this method.
	 * 
	 * @param registration The service worker registration you wish to use for push
	 *                     messaging.
	 * 
	 *                     Value must not be null.
	 */
	public native void useServiceWorker(Object registration);

}
