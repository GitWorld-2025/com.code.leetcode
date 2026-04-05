package DesignPatterns.CreationalDesign.Abstract.Factories;

import DesignPatterns.CreationalDesign.Abstract.Products.Button;
import DesignPatterns.CreationalDesign.Abstract.Products.WindosCheckBox;
import DesignPatterns.CreationalDesign.Abstract.Products.WindowsButton;

public class WindowsOSFactory implements GUIFactory {
    @Override
    public WindowsButton createButton() {
        return new WindowsButton();
    }

    @Override
    public WindosCheckBox createCheckBox() {
        return new WindosCheckBox();
    }
}
