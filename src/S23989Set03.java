public class S23989Set03 {
    public static void main(String[] args) {
        S23989Set03 s = new S23989Set03();
        s.task02();
    }

    public void task01() {
        byte byteMin = -128;
        byte byteMinBin = 0b11111111111111111111111110000000;
        byte byteMinOct = 037777777600;
        byte byteMinHex = 0xffffff80;
        byte byteMax = 127;
        byte byteMaxBin = 0b1111111;
        byte byteMaxOct = 0177;
        byte byteMaxHex = 0x7f;
        short shortMin = -32768;
        short shortMinBin = 0b11111111111111111000000000000000;
        short shortMinOct = 037777700000;
        short shortMinHex = 0xffff8000;
        short shortMax = 32767;
        short shortMaxBin = 0b111111111111111;
        short shortMaxOct = 077777;
        short shortMaxHex = 0x7fff;
        int intMin = -2147483648;
        int intMinBin = 0b10000000000000000000000000000000;
        int intMinOct = 020000000000;
        int intMinHex = 0x80000000;
        int intMax = 2147483647;
        int intMaxBin = 0b1111111111111111111111111111111;
        int intMaxOct = 017777777777;
        int intMaxHex = 0x7fffffff;
        long longMin = -9223372036854775808L;
        long longMinBin = 0b1000000000000000000000000000000000000000000000000000000000000000L;
        long longMinOct = 01000000000000000000000L;
        long longMinHex = 0x8000000000000000L;
        long longMax = 9223372036854775807L;
        long longMaxBin = 0b111111111111111111111111111111111111111111111111111111111111111L;
        long longMaxOct = 0777777777777777777777L;
        long longMaxHex = 0x7fffffffffffffffL;
        char charMin = 0;
        char charMinBin = 0b0;
        char charMinOct = 00;
        char charMinHex = 0x0;
        char charMax = 65535;
        char charMaxBin = 0b1111111111111111;
        char charMaxOct = 0177777;
        char charMaxHex = 0xffff;
        float floatMin = 1.4E-45F;
        float floatMinHex = 0x0.000002p-126F;
        float floatMax = 3.4028235E38F;
        float floatMaxHex = 0x1.fffffep127F;
        double doubleMin = 4.9E-324;
        double doubleMinHex = 0x0.0000000000001p-1022;
        double doubleMax = 1.7976931348623157E308;
        double doubleMaxHex = 0x1.fffffffffffffp1023;
        boolean booleanMin = false;
        boolean booleanMax = true;
    }

    public void task02() {
        byte byteVar = 100;
        short shortVar = 768;
        int intVar = 47483648;
        long longVar = 36854775808L;
        char charVar = '9';
        float floatVar = 0.132F;
        double doubleVar = 4.123;
        boolean booleanVar = false;
        System.out.println(byteVar == shortVar);
        System.out.println(byteVar == intVar);
        System.out.println(byteVar == longVar);
        System.out.println(byteVar == charVar);
        System.out.println(byteVar == floatVar);
        System.out.println(byteVar == doubleVar);
        System.out.println(shortVar == intVar);
        System.out.println(shortVar == longVar);
        System.out.println(shortVar == charVar);
        System.out.println(shortVar == floatVar);
        System.out.println(shortVar == doubleVar);
        System.out.println(intVar == longVar);
        System.out.println(intVar == charVar);
        System.out.println(intVar == floatVar);
        System.out.println(intVar == doubleVar);
        System.out.println(charVar == floatVar);
        System.out.println(charVar == doubleVar);
        System.out.println(floatVar == doubleVar);
//        System.out.println(byteVar == booleanVar);
//        System.out.println(shortVar == booleanVar);
//        System.out.println(intVar == booleanVar);
//        System.out.println(charVar == booleanVar);
//        System.out.println(floatVar == booleanVar);
//        System.out.println(doubleVar == booleanVar);
    }

    public void task03() {
        int i123 = 10;
        // int 1iasd = 10;
        // int @aer = 10;
        //int static = 10;
        int inull = 10;
    }

    public void task04() {
        int i = 10;
        System.out.println(i);
    }

    public void task05() {
        char charValue = '0';
        char charvalue = 'w';
        /*char charValue1 = 'adad';
        char charvalue1 = 'asdasd';*/
    }

    public void task06() {
        int a = 10;
        double b = 1000;
        a = (int) b;
        b = a;
    }

    public void task07() {
        byte byteVar = 14;
        char charVar = 'a';
        int intVar = 100;
        float floatVar = 100F;
        double doubleVar = 100.0;
//        char charVarSecond = charVar + intVar; char 16 bit < int 32 bit
        char charVarSecond = (char) (charVar + intVar);
        int intVarSecond = intVar + charVar;
//        float floatVarSecond = floatVar + doubleVar; float 32 bit < double 64 bit
        float floatVarSecond = (float) (floatVar + doubleVar);
//         byte byteVarSecond = byteVar + intVar; byte 8 bit < int 32 bit
        byte byteVarSecond = (byte) (byteVar + intVar);
    }
}
