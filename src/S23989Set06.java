public class S23989Set06 {
    public static void main(String[] args) {
        S23989Set06 s = new S23989Set06();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
        s.task05();
        s.task06();
        s.task07();
        s.task08();
    }

    public void task01(){
        int[] array;
    }

    public void task02(){
        int[] array = new int [10];
        for (int i = 0; i < array.length; i ++){
            array[i] =(int) (Math.random() + 0.5);
        }
    }

    public void task03(){
        int[] array = new int [10];
        for (int i = 0; i < array.length; i ++){
            array[i] =(int) (Math.random() + 0.5);
        }

        int countOfOne = 0;
        int countOfZero = 0;
        for (int i = 0; i < array.length; i ++){
            if (array[i] == 0) {
                countOfZero++;
            } else {
                countOfOne++;
            }
        }
        System.out.println("Ilość jedynek: " + countOfOne);
        System.out.println("Ilość zer: " + countOfZero);
    }

    public void task04(){
        double[] array = new double[10];
        System.out.print("Liczby w tablicy: ");
        for (int i = 0; i < array.length; i ++){
            array[i] = Math.random() * 10000;
            System.out.print(" " + array[i]);
        }
        System.out.println();
        System.out.print("Liczby o parzystym indeksie: ");
        for (int i = 0; i < array.length; i ++){
            if (i % 2 == 0){
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
        System.out.print("Liczby przekonwertowane na int wartości nieparzyste: ");
        for (int i = 0; i < array.length; i ++){
            if ((int) array[i] % 2 != 0){
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }

    public void task05(){
        System.out.println("Nic się nie skompiluje ponieważ tablica nie została zainicjalizowana");
    }

    public void task06(){
        System.out.println("0");
        System.out.println("111");
        System.out.println("222");
        System.out.println("0");
        System.out.println("111");
        System.out.println("0");
    }

    public void task07(){
        String [ ] slowa = {
                "Ala " , " kota " , "ma" , "ma" , "a" , " kot " , " Ale "
        };
        System.out.println(slowa[0] + slowa[2] + slowa[1] + slowa[4] + slowa[5] + slowa[3] + slowa[6]);
    }

    public void task08(){
        // A - 65; Z - 90;
        char[] array = new char [20];
        System.out.print("Oryginalna tablica: ");
        for (int i = 0; i < array.length; i ++){
            array[i] = (char) ((Math.random() * (90 - 65)) + 65);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Lustrzane odbicie tablicy: ");
        char[] mirrorArray = new char[array.length];
        int j = mirrorArray.length - 1;
        for (int i = 0; i < mirrorArray.length; i ++){
            mirrorArray[i] =array[j];
            j--;
            System.out.print(mirrorArray[i] + " ");
        }
    }
}
