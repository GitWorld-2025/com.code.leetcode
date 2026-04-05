package DesignPatterns.CreationalDesign.Singleton;

public class SingletonClass {
    private SingletonClass(){}

    private static SingletonClass instanceLazy;
    static SingletonClass getInstanceLazy(){
        /// Simple Single Lazy Initialization
        if(instanceLazy == null) instanceLazy = new SingletonClass();
        return instanceLazy;
    }

    private static SingletonClass instanceEager = new SingletonClass();
    static SingletonClass getInstanceEager(){
        /// Simple Single Lazy Initialization
        return instanceEager;
    }

    private static SingletonClass instanceSynchronizedMethod;
    synchronized static SingletonClass getInstanceSynchronizedMethod(){
        if(instanceSynchronizedMethod == null) instanceSynchronizedMethod  = new SingletonClass();
        return instanceSynchronizedMethod;
    }

    private static SingletonClass instanceSynchronizedBlock;
    synchronized static SingletonClass getInstanceSynchronizedBlock(){
        synchronized(SingletonClass.class){
            if(instanceSynchronizedBlock == null) instanceSynchronizedBlock  = new SingletonClass();
        }
        return instanceSynchronizedBlock;
    }

    private static class BillPughSingleton{
        private static SingletonClass BillPugh_INSTANCE = new SingletonClass();
    }

    public static SingletonClass getBillPughSingleton(){
        return BillPughSingleton.BillPugh_INSTANCE;
    }

    public static enum EnumSingleton{
        EnumINSTANCE;

    }
}
