public interface A {

    int a =10;
    void m1();

    static void m2() {
        System.out.println("Am2");
    }

    default void m3() {
        System.out.println("Am3");
    }
}
