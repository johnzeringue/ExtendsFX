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
package com.johnzeringue.extendsfx.annotation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John Zeringue
 */
@ResourceBundle("Resources")
@ResourceBundle("MoreResources")
public class ResourceBundleTest {

    @Test
    public void testResourceBundleAvailableAtRuntime() {
        ResourceBundle[] resourceBundles
                = getClass().getAnnotationsByType(ResourceBundle.class);

        assertEquals("Resources", resourceBundles[0].value());
        assertEquals("MoreResources", resourceBundles[1].value());
    }

}
