package DesignPatterns.CreationalDesign.Singleton;

public class SingletonDesign {
    public static void main(String... args){
        LazySingletonCall();
        EagerSingletonCall();
        BillPughSingleton();
        EnumSingleton();
    }
    static void LazySingletonCall(){
        SingletonClass s1 = SingletonClass.getInstanceLazy();
        SingletonClass s2 = SingletonClass.getInstanceLazy();
        System.out.println(s1);
        System.out.println(s2);
    }

    static void EagerSingletonCall(){
        SingletonClass s1 = SingletonClass.getInstanceEager();
        SingletonClass s2 = SingletonClass.getInstanceEager();
        System.out.println(s1);
        System.out.println(s2);
    }

    static void BillPughSingleton(){
        SingletonClass s1 = SingletonClass.getBillPughSingleton();
        SingletonClass s2 = SingletonClass.getBillPughSingleton();
        System.out.println(s1);
        System.out.println(s2);
    }

    static void EnumSingleton(){
        SingletonClass.EnumSingleton e1 = SingletonClass.EnumSingleton.EnumINSTANCE;
        SingletonClass.EnumSingleton e2 = SingletonClass.EnumSingleton.EnumINSTANCE;
        System.out.println(e1);
        System.out.println(e2);
    }
}
