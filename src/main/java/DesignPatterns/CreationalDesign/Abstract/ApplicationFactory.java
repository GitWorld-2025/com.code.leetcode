package DesignPatterns.CreationalDesign.Abstract;

import DesignPatterns.CreationalDesign.Abstract.Factories.GUIFactory;
import DesignPatterns.CreationalDesign.Abstract.Products.Button;
import DesignPatterns.CreationalDesign.Abstract.Products.CheckBox;

public class ApplicationFactory {
    private Button button;
    private CheckBox checkBox;

    ApplicationFactory(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    void renderUI(){
        button.render();
        checkBox.render();
    }
}
