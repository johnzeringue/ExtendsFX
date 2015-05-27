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
package com.johnzeringue.extendsfx.layout;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author John Zeringue
 */
public class CustomVBoxTest extends ApplicationTest {

    private VBox customVBox;

    @Override
    public void start(Stage stage) throws Exception {
        customVBox = new TestCustomVBox();

        Scene scene = new Scene(customVBox);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testChildIsVisible() {
        verifyThat("#child", isVisible());
    }

    @Test
    public void testChildHasText() {
        verifyThat("#child", hasText("Hello world!"));
    }

}
