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
package com.johnzeringue.extendsfx.control;

import com.johnzeringue.extendsfx.CustomComponent;
import com.johnzeringue.extendsfx.util.CustomComponentInitializer;
import java.util.function.Consumer;
import javafx.scene.control.DialogPane;

/**
 *
 * @author John Zeringue
 * @param <T>
 */
public abstract class CustomDialogPane<T extends CustomDialogPane>
        extends DialogPane implements CustomComponent {

    public CustomDialogPane() {
        new CustomComponentInitializer(this).initialize();
    }

    public CustomDialogPane(Consumer<T> preload) {
        preload.accept((T) this);
        new CustomComponentInitializer(this).initialize();
    }

}
