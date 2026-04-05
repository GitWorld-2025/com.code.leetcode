package DesignPatterns.CreationalDesign.Abstract.Products;

public class WindosCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Windows CheckBox Rendered");
    }
}
