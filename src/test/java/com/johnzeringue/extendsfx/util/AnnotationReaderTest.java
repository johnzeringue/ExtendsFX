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
import static java.util.Arrays.asList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author John Zeringue
 */
public class AnnotationReaderTest {

    private static final List<String> EXPECTED_BASE_NAMES = asList(
            "Resources", "MoreResources"
    );

    AnnotationReader annotationReader;

    @Before
    public void setUpAnnotationReader() {
        annotationReader = new AnnotationReader(AnnotatedObject.class);
    }

    @Test
    public void testGetResourceBundleBaseNames() {
        assertEquals(EXPECTED_BASE_NAMES,
                annotationReader.getResourceBundleBaseNames());
    }

    @ResourceBundle("Resources")
    @ResourceBundle("MoreResources")
    static class AnnotatedObject {

    }

}
