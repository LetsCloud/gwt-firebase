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
package gwt.firebase;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import gwt.firebase.messaging.MessagingRegistration;
import gwt.firebase.messaging.js.FcmMessageJs;
import gwt.firebase.messaging.js.Messaging;
import gwt.jswrapper.global.promise.Fn;

/**
 * @author robi
 *
 */
public class FirebaseRegister {

    private final Map<HandlerRegistration, Boolean> handlerRegistrations = Maps.newHashMap();

    public HandlerRegistration addMessaging(Messaging messaging, Fn.Arg<FcmMessageJs> fn, boolean on) {
        return add(new MessagingRegistration(messaging, fn), false, on);
}
    public HandlerRegistration add(HandlerRegistration handlerRegistration, boolean auth, boolean on) {
        handlerRegistrations.put(handlerRegistration, auth);
        if (on) {
            handlerRegistration.on();
        } else {
            handlerRegistration.off();
        }
        return handlerRegistration;
    }

    public void enableFirebaseEvents() {
        Sets.newHashSet(handlerRegistrations.keySet()).forEach(HandlerRegistration::on);
    }

    public void disableFirebaseEvents() {
        Sets.newHashSet(handlerRegistrations.keySet()).forEach(HandlerRegistration::off);
    }

    public void removeRegistration(HandlerRegistration handlerRegistration) {
        if (handlerRegistration != null) {
            handlerRegistration.off();
            handlerRegistrations.remove(handlerRegistration);
        }
    }

    public void removeFirebaseAuthEvents() {
        Set<HandlerRegistration> authHandlerRegistrations = Maps
                .filterValues(handlerRegistrations, auth -> auth).keySet();
        Sets.newHashSet(authHandlerRegistrations).forEach(this::removeRegistration);
    }

    public void removeAllRegistrations() {
        Sets.newHashSet(handlerRegistrations.keySet()).forEach(this::removeRegistration);
    }
}
