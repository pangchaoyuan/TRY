public class duotai {
    public static void main(String[] args) {
        A a2 = new B();
        A b = new B();
        System.out.println(a2.show(b));
    }
}

class A{
    public String show(A obj){
        return("A and A");
    }
}

class B extends A{
    public String show(B obj){
        return("B and B");
    }
    public String show(A obj){
        return("B and A");
    }
}

class C extends B{;}

class D extends B{;}


