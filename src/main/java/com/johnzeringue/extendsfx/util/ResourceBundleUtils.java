/*
 * Copyright 2015 John Zeringue.
 *
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
 */
package com.johnzeringue.extendsfx.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Zeringue
 */
class ResourceBundleUtils {

    private static final Logger LOGGER
            = Logger.getLogger(ResourceBundleUtils.class.getName());

    private static final Field PARENT_FIELD;

    static {
        try {
            PARENT_FIELD = ResourceBundle.class.getDeclaredField("parent");
            PARENT_FIELD.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static final Method SET_PARENT_METHOD;

    static {
        try {
            SET_PARENT_METHOD = ResourceBundle.class
                    .getDeclaredMethod("setParent", ResourceBundle.class);

            SET_PARENT_METHOD.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    static ResourceBundle getParent(ResourceBundle child) {
        ResourceBundle parent = null;

        try {
            parent = (ResourceBundle) PARENT_FIELD.get(child);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return parent;
    }

    static void setParent(ResourceBundle child, ResourceBundle parent) {
        try {
            SET_PARENT_METHOD.invoke(child, parent);
        } catch (IllegalAccessException | IllegalArgumentException |
                InvocationTargetException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

}
