public class S23989Set02 {
    public static void main(String[] args) {
        S23989Set02 s = new S23989Set02();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
    }

    public void task01 () {
        int i = 165;
        System.out.println(0b10100101);
        System.out.println(0245);
        System.out.println(0xa5);
    }

    public void task02 () {
        int i = 14 >> 0;
        System.out.println(i);
        i = i << 2;
        System.out.println(i);
        i = i >> 4;
        System.out.println(i);
    }

    public void task03 () {
        int number = 223374036;
        System.out.println(number & 0b11111);
        System.out.println(number >> 7 & 0b1);
        System.out.println((number >> 24 & 0b11111111) + " " +
                (number << 8 >> 24 & 0b11111111) + " " +
                (number << 16 >> 24 & 0b11111111) + " " +
                (number << 24 >> 24 & 0b11111111));
        System.out.println(number << 8 >> 16);
    }

    public void task04 () {
        int a1 = 0x6D , a2 = 13 , a = a1 & a2 ,
                b1 = 0xA , b2 = 15 , b = b1 | b2 ,
                c1 = 11 << 2 , c2 = 6 , c = c1 ^ c2 ;
        System.out.println(a + " " + b + " " + c);
    }
}
