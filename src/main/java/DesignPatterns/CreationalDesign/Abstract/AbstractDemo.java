package DesignPatterns.CreationalDesign.Abstract;

import DesignPatterns.CreationalDesign.Abstract.Factories.MacOSFactory;
import DesignPatterns.CreationalDesign.Abstract.Factories.WindowsOSFactory;

public class AbstractDemo {
    public static void main(String... args){
        ApplicationFactory wiondows = new ApplicationFactory(new WindowsOSFactory());
        ApplicationFactory macOS = new ApplicationFactory(new MacOSFactory());
        wiondows.renderUI();
        macOS.renderUI();
    }
}
