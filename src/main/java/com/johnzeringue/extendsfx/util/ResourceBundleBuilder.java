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

import static com.johnzeringue.extendsfx.util.ResourceBundleUtils.getParent;
import static com.johnzeringue.extendsfx.util.ResourceBundleUtils.setParent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import static java.util.ResourceBundle.getBundle;

/**
 *
 * @author John Zeringue
 */
class ResourceBundleBuilder {

    private final static Map<Class, ResourceBundle> CACHE = new HashMap<>();

    private final Class $class;

    private AnnotationReader annotationReader;
    private List<String> baseNames;
    private ResourceBundle resourceBundle;
    private ResourceBundle oldestAncestor;

    ResourceBundleBuilder(Class $class) {
        this.$class = $class;
    }

    private void findOldestAncestor() {
        while (getParent(oldestAncestor) != null) {
            oldestAncestor = getParent(oldestAncestor);
        }
    }

    private void buildFromBaseNames() {
        int last = baseNames.size() - 1;
        resourceBundle = getBundle(baseNames.get(last)); // the base bundle

        oldestAncestor = resourceBundle;
        for (int i = last - 1; i >= 0; i--) {
            findOldestAncestor();
            setParent(oldestAncestor, getBundle(baseNames.get(i)));
        }
    }

    private ResourceBundle buildUncached(Class $class) {
        annotationReader = new AnnotationReader($class);
        baseNames = annotationReader.getResourceBundleBaseNames();

        if (baseNames.isEmpty()) {
            resourceBundle = null;
        } else {
            buildFromBaseNames();
        }

        return resourceBundle;
    }

    ResourceBundle build() {
        return CACHE.computeIfAbsent($class, this::buildUncached);
    }

}
