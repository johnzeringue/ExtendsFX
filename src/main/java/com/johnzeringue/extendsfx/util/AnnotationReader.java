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

import com.johnzeringue.extendsfx.annotation.ResourceBundle;
import java.lang.annotation.Annotation;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author John Zeringue
 */
class AnnotationReader {

    private final Class<?> $class;

    AnnotationReader(Class $class) {
        this.$class = $class;
    }

    private <A extends Annotation> A[] getAnnotations(Class<A> annotationType) {
        return $class.getAnnotationsByType(annotationType);
    }

    List<String> getResourceBundleBaseNames() {
        return Stream.of(getAnnotations(ResourceBundle.class))
                .map(ResourceBundle::value)
                .collect(toList());
    }

}
