package DesignPatterns.CreationalDesign.Abstract.Factories;

import DesignPatterns.CreationalDesign.Abstract.Products.MacOSCHeckBox;
import DesignPatterns.CreationalDesign.Abstract.Products.MacOsButton;

public class MacOSFactory implements GUIFactory {
    @Override
    public MacOsButton createButton() {
        return new MacOsButton();
    }

    @Override
    public MacOSCHeckBox createCheckBox() {
        return new MacOSCHeckBox();
    }
}
