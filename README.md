ExtendsFX
=========
[![Build Status](https://travis-ci.org/johnzeringue/ExtendsFX.svg?branch=master)](https://travis-ci.org/johnzeringue/ExtendsFX)

ExtendsFX is designed to be a lightweight alternative to other JavaFX frameworks
such as [afterburner.fx][].

Usage
-----

In the simplist case, just extend the appropriate `Custom*` class and write a
corresponding FXML file. ExtendsFX will automatically load your class and FXML
by convention.

my/package/JustAButton.java:

``` java
public class JustAButton extends CustomStackPane {

    @FXML
    private void sayHello() {
        System.out.println("Hello world!");
    }

}
```

my/package/JustAButton.fxml:

``` xml
<fx:root xmlns:fx="http://javafx.com/fxml/1"
         type="my.package.JustAButton">

    <Button text="Press me!" onAction="#sayHello"/>

</fx:root>
```

In more complex cases, you're able to access constructor parameters and specify
any number of resource bundles for inclusion.

my/package/StillJustAButton.java:

``` java
@ResourceBundle("any.package.MyResources")
public class StillJustAButton extends CustomStackPane<StillJustAButton> {

    private String message;

    public StillJustAButton(String message) {
        super(self -> {
            self.message = message;
        });
    }

    @FXML
    private void initialize() {
        System.out.printf("My message is \"%s\".\n", message);
    }

    @FXML
    private void sayMessage() {
        System.out.println(message);
    }

}
```

my/package/StillJustAButton.fxml:

``` xml
<fx:root xmlns:fx="http://javafx.com/fxml/1"
         type="my.package.StillJustAButton">

    <Button text="%someResource" onAction="#sayMessage"/>

</fx:root>
```

Getting ExtendsFX
-----------------

ExtendsFX is distributed through [JitPack.io][]. Instructions for including
ExtendsFX in a Gradle or Maven project can be found there.

[afterburner.fx]: https://github.com/AdamBien/afterburner.fx
[JitPack.io]: https://jitpack.io/#johnzeringue/ExtendsFX
