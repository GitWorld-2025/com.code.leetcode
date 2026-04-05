package DesignPatterns.CreationalDesign.Abstract.Products;

public class MacOSCHeckBox implements CheckBox{
    @Override
    public void render() {
        System.out.println("MacOS CheckBox Rendered");
    }
}
