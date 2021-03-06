/*
 * Copyright 360buy
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.jd.dd.glowworm.deserializer.normal;

import com.jd.dd.glowworm.deserializer.ObjectDeserializer;
import com.jd.dd.glowworm.deserializer.PBDeserializer;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDeserializer implements ObjectDeserializer {

    public final static AtomicBooleanDeserializer instance = new AtomicBooleanDeserializer();

    @Override
    public <T> T deserialize(PBDeserializer deserializer, Type type, boolean needConfirmExist, Object... extraParams) {
        AtomicBoolean value = null;
        try {
            if (needConfirmExist && deserializer.isObjectExist() || !needConfirmExist) {
                value = deserializer.scanAtomicBool();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (T) value;
    }
}
