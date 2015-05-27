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

import com.johnzeringue.extendsfx.CustomComponent;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author John Zeringue
 * @param <T>
 */
public class CustomComponentInitializer<T extends Parent & CustomComponent> {

    private final T customComponent;

    private final FXMLLoader fxmlLoader;
    private final ResourceBundleBuilder resourceBundleBuilder;

    public CustomComponentInitializer(T customComponent) {
        this.customComponent = customComponent;
        fxmlLoader = new FXMLLoader(fxmlURL());

        resourceBundleBuilder
                = new ResourceBundleBuilder(customComponent.getClass());
    }

    private String fxmlResourceName() {
        return customComponent.getClass().getSimpleName() + ".fxml";
    }

    private URL fxmlURL() {
        return customComponent.getClass().getResource(fxmlResourceName());
    }

    private void configureFXMLLoader() {
        fxmlLoader.setRoot(customComponent);
        fxmlLoader.setController(customComponent);
        fxmlLoader.setResources(resourceBundleBuilder.build());
    }

    private void loadFXML() {
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        configureFXMLLoader();
        loadFXML();
    }

}
