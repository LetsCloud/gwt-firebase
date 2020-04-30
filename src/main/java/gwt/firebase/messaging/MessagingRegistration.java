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

import gwt.firebase.HandlerRegistration;
import gwt.firebase.messaging.js.FcmMessageJs;
import gwt.firebase.messaging.js.Messaging;
import gwt.jswrapper.global.promise.Fn;

/**
 * @author robi
 *
 */
public class MessagingRegistration implements HandlerRegistration {
	final Messaging messaging;
	final Fn.Arg<FcmMessageJs> fn;
	Fn.NoArg unsubscribe;

	public MessagingRegistration(Messaging messaging, Fn.Arg<FcmMessageJs> fn) {
		this.messaging = messaging;
		this.fn = fn;
	}

	public Messaging getMessaging() {
		return messaging;
	}

	public Fn.Arg<FcmMessageJs> getFn() {
		return fn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MessagingRegistration on() {
		this.unsubscribe = getMessaging().onMessage(getFn());
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MessagingRegistration off() {
		if (unsubscribe != null) {
			unsubscribe.call();;
		}
		return this;
	}
}