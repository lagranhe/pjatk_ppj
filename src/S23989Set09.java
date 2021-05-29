public class S23989Set09 {

    public static void main(String[] args) {
        S23989Set09 s = new S23989Set09();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
        s.task05();
    }

    public void task01(){
        System.out.println("Task01");
        MethodCurrier methodCurrier = new MethodCurrier();
        methodCurrier.setValue(10F);
        methodCurrier.setValue(10);
        methodCurrier.setValue((byte) 10);
        methodCurrier.setValue('c');

       /* 5.1.2. Unary Numeric Promotion
        If the operand is of compile-time type Byte, Short, Character,
        or Integer, it is subjected to unboxing conversion (§5.1.8).
        The result is then promoted to a value of type int by a widening primitive
        conversion (§5.1.2) or an identity conversion (§5.1.1).

        Otherwise, if the operand is of compile-time type Long, Float,
        or Double, it is subjected to unboxing conversion (§5.1.8).

        ------>Otherwise, if the operand is of compile-time type byte, short,
        or char, it is promoted to a value of type int by a widening primitive conversion (§5.1.2).<------

        Otherwise, a unary numeric operand remains as is and is not converted.*/
    }

    public void task02(){
        System.out.println("Task02");
        Number n = new Number();
        n.setValue(10);
        MethodCurrier methodCurrier = new MethodCurrier();
        methodCurrier.setValue(n);
        n.showValue();
    }

    public void task03(){
        System.out.println("Task03");
        Osoba osoba = new Osoba();
        osoba.imie="Jan";
        osoba.nazwisko="Kowalski";
        osoba.rokUrodzenia=1945;
    }

    public void task04(){
        System.out.println("Task04");
        Osoba osoba = new Osoba("Jan", "Kowalski", 1945);
        osoba.show();
    }

    public void task05(){
        System.out.println("Task05");
        Cplx cplx1 = new Cplx(4, 5);
        Cplx cplx2 = new Cplx(1, 2);
        Cplx cplx3 = new Cplx(6, 2);
        cplx1.add(cplx2);
        cplx1.show();
        cplx3.mult(cplx1);
        cplx3.show();
        cplx2.sub(cplx3);
        cplx2.show();
    }

    class MethodCurrier{

        void setValue(int value){
            System.out.println("int przed: " + value);
            value++;
            System.out.println("int po: " + value);
        }
        void setValue(float value){
            System.out.println("float przed: " + value);
            value++;
            System.out.println("float po: " + value);
        }
        void setValue(Number number){
            System.out.println("Number przed: " + number.value);
            number.setValue(number.value + 1);
            System.out.println("Number po: " + number.value);
        }
    }

    class Number{
        int value;

        void setValue(int value){
            this.value = value;
        }

        void showValue(){
            System.out.println(value);
        }
    }

    class Osoba{
        public String imie;
        public String nazwisko;
        public int rokUrodzenia;

        public Osoba() {
        }

        public Osoba(String imie, String nazwisko, int rokUrodzenia) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.rokUrodzenia = rokUrodzenia;
        }

        public void show(){
            System.out.println("Imie, nazwisko, rok urodzenia: " + imie + ", " + nazwisko + ", " + rokUrodzenia);
        }
    }

    class Cplx{
        private double first;
        private double second;

        public Cplx(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public void add(Cplx cplx){
            this.first = this.first + cplx.first;
            this.second = this.second + cplx.second;
        }

        public void sub(Cplx cplx){
            this.first = this.first - cplx.first;
            this.second = this.second - cplx.second;
        }

        public void mult(Cplx cplx){
            this.first = (this.first * cplx.first) - (this.second * cplx.second);
            this.second = (this.second * cplx.first) + (this.first * cplx.second);
        }

        public void inc(){
            this.first = this.first + 1;
        }

        public void show(){
            if (this.second < 0) {
                System.out.println(this.first + " - " + (0 - this.second) + "i");
            } else {
                System.out.println(this.first + " + " + this.second + "i");
            }
        }
    }
}
