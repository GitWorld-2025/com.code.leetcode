package DesignPatterns.CreationalDesign.Abstract.Factories;

import DesignPatterns.CreationalDesign.Abstract.Products.Button;
import DesignPatterns.CreationalDesign.Abstract.Products.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
