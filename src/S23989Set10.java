public class S23989Set10 {
    public static void main(String[] args) {
        S23989Set10 s = new S23989Set10();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
        s.task05();
    }

    public void task01(){
        Kwadrat kwadrat = new Kwadrat(10);
        kwadrat.show();
    }

    public void task02(){
        Walec walec = new Walec(12, 4);
        walec.show();
    }

    public void task03(){
        new Prostokat(2, 5).show();
        new Prostopadloscian(4, 5, 2).show();
        new Trojkat(4).show();
        new Ostroslup(4, 2).show();
        new Graniastoslup(2, 4).show();
    }

    public void task04(){
        System.out.println(new Drzewo(true, 12, "jakiś przekrój"));
    }

    public void task05(){
        System.out.println(new DrzewoIglaste(true, 12, "jakiś", 1323, 12.4214));
        System.out.println(new DrzewoLisciaste(false, 12, "jakiś", 123));
        System.out.println(new DrzewoOwocowe(false, 11, "jakiś", 121, "Wiśnia"));
    }

    public class Kwadrat{
        private int bok;

        public Kwadrat(int bok) {
            this.bok = bok;
        }

        public void show(){
            System.out.println("Powierzchnia kwadratu: " + bok*bok);
            System.out.println("Objętość sześcianu: " + bok*bok*bok);
        }
    }

    public class Walec{
        private int promien;
        private int wysokosc;

        public Walec(int promien, int wysokosc) {
            this.promien = promien;
            this.wysokosc = wysokosc;
        }

        public void show(){
            System.out.println("Powierzchnia podstawy: " + promien*promien*Math.PI);
            System.out.println("Objętość walca: " + promien*promien*Math.PI*wysokosc);
        }
    }


    public class Prostokat{
        private int wysokosc;
        private int szerokosc;

        public Prostokat(int wysokosc, int szerokosc) {
            this.wysokosc = wysokosc;
            this.szerokosc = szerokosc;
        }

        public void show(){
            System.out.println("Pole powierzchni prostokąta: " + wysokosc*szerokosc);
        }
    }

    public class Prostopadloscian extends Prostokat{
        private int dlugosc;

        public Prostopadloscian(int wysokosc, int szerokosc, int dlugosc) {
            super(wysokosc, szerokosc);
            this.dlugosc = dlugosc;
        }

        public Prostopadloscian(int dlugosc, Prostokat prostokat) {
            super(prostokat.wysokosc, prostokat.szerokosc);
            this.dlugosc = dlugosc;

        }

        @Override
        public void show(){
            System.out.println("Pole powierzchni prostopadłościana: "
                    + (super.wysokosc*super.szerokosc*2 + super.wysokosc*dlugosc*4));
        }
    }

    public class Trojkat{
        private int bok;

        public Trojkat(int bok) {
            this.bok = bok;
        }

        public void show(){
            double square = Math.sqrt(3)*bok*bok/4;
            System.out.println("Powierzchnia trójkąta równobocznego: " + square);
        }
    }

    public class Ostroslup extends Trojkat{
        private int strona;

        public Ostroslup(int bok, int strona) {
            super(bok);
            this.strona = strona;
        }

        public Ostroslup(int strona, Trojkat trojkat) {
            super(trojkat.bok);
            this.strona = strona;
        }

        @Override
        public void show(){
            double square = Math.sqrt(3)*super.bok*super.bok * 3/4 + Math.sqrt(3)*strona*strona/4;
            System.out.println("Powierzchnia ostrosłupa: " + square);
        }

    }

    public class Graniastoslup extends Trojkat{
        private int dlugosc;

        public Graniastoslup(int bok, int dlugosc) {
            super(bok);
            this.dlugosc = dlugosc;
        }

        public Graniastoslup(int dlugosc, Trojkat trojkat) {
            super(trojkat.bok);
            this.dlugosc = dlugosc;
        }

        @Override
        public void show(){
            double square = Math.sqrt(3)*super.bok*super.bok*2/4 + dlugosc*super.bok*3;
            System.out.println("Powierzchnia graniastosłupa: " + square);
        }
    }

    public class Drzewo{
        protected boolean wiecznieZielone;
        protected int wysokosc;
        protected String przekrojDrzewa;

        public Drzewo(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa) {
            this.wiecznieZielone = wiecznieZielone;
            this.wysokosc = wysokosc;
            this.przekrojDrzewa = przekrojDrzewa;
        }

        @Override
        public String toString() {
            return "Drzewo{" +
                    "wiecznieZielone=" + wiecznieZielone +
                    ", wysokosc=" + wysokosc +
                    ", przekrojDrzewa='" + przekrojDrzewa + '\'' +
                    '}';
        }
    }

    public class DrzewoIglaste extends Drzewo{
        private int iloscIgiel;
        private double dlugoscSzyjki;

        public DrzewoIglaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int iloscIgiel, double dlugoscSzyjki) {
            super(wiecznieZielone, wysokosc, przekrojDrzewa);
            this.iloscIgiel = iloscIgiel;
            this.dlugoscSzyjki = dlugoscSzyjki;
        }

        @Override
        public String toString() {
            return "DrzewoIglaste{" +
                    "wiecznieZielone=" + super.wiecznieZielone +
                    ", wysokosc=" + super.wysokosc +
                    ", przekrojDrzewa='" + super.przekrojDrzewa + '\'' +
                    ", iloscIgiel=" + iloscIgiel +
                    ", dlugoscSzyjki=" + dlugoscSzyjki +
                    '}';
        }
    }

    public class DrzewoLisciaste extends Drzewo{
        private int ksztaltLiscia;

        public DrzewoLisciaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int ksztaltLiscia) {
            super(wiecznieZielone, wysokosc, przekrojDrzewa);
            this.ksztaltLiscia = ksztaltLiscia;
        }

        @Override
        public String toString() {
            return "DrzewoLisciaste{" +
                    "wiecznieZielone=" + wiecznieZielone +
                    ", wysokosc=" + wysokosc +
                    ", przekrojDrzewa='" + przekrojDrzewa + '\'' +
                    ", ksztaltLiscia=" + ksztaltLiscia +
                    '}';
        }
    }

    public class DrzewoOwocowe extends DrzewoLisciaste{
        private String nazwaOwoca;

        public DrzewoOwocowe(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int ksztaltLiscia, String nazwaOwoca) {
            super(wiecznieZielone, wysokosc, przekrojDrzewa, ksztaltLiscia);
            this.nazwaOwoca = nazwaOwoca;
        }

        @Override
        public String toString() {
            return "DrzewoOwocowe{" +
                    "wiecznieZielone=" + wiecznieZielone +
                    ", wysokosc=" + wysokosc +
                    ", przekrojDrzewa='" + przekrojDrzewa + '\'' +
                    ", ksztaltLiscia=" + super.ksztaltLiscia +
                    ", nazwaOwoca='" + nazwaOwoca + '\'' +
                    '}';
        }
    }
}
