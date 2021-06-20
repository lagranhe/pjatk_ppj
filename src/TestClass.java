public class TestClass {
    public class A{
        private B b;
        public A() {
        }

        public B getB() {
            return b;
        }
    }

    public class B{
        public B() {
        }
    }

    public static void main(String[] args) {
        Character a = new Character('1');
        Character b = new Character('1');
        System.out.println(a.equals(b));
    }
}
