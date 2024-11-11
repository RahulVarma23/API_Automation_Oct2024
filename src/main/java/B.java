public class B implements A {



    @Override
    public void m1() {

    }


    public static void main(String[] args) {
        A.m2();
        B b = new B();
        b.m3();


    }
}
