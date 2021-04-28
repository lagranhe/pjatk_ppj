public class S23989Set05 {
    public static void main(String[] args) {
        S23989Set05 s = new S23989Set05();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
        s.task05();
        s.task06();
        s.task07();
    }
    public void task01(){
        System.out.println(123456789);
    }
    public void task02(){
//        int s = 0 ;
//        for ( int i = 1 ; i <= 10 ; i++) {
//            s = s + i ;
//        }
        int s = 0;
        int i = 1;
        while (i != 11) {
            s = s + i;
            i++;
        }
        System.out.println(s);
    }
    public void task03(){
        int i = 10;
        while (i < 10){
            ++i;
        }
        System.out.println(i);
        do {
            ++i;
        } while (i < 10);
        System.out.println(i);
    }
    public void task04(){
        int t = 1;
        for (int n = 0; n < 10; n++){
            for (int i = 0; i < n; i++){
                t = t * 2;
            }
            System.out.print((double) 1/t + " ");
            t = 1;
        }
        System.out.println();
    }
    public void task05(){
        int t = 1;
        int wrt = 10;
        for (int n = 0; n < 10; n++){
            for (int i = 0; i < n; i++){
                t = t * 2;
            }
            System.out.print((double) 1/t * wrt + " ");
            t = 1;
        }
        System.out.println();
    }
    public void task06(){
        for (int i = -1499; i < 1500; i ++){
            if (i % 3 ==0 && i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public void task07(){
        String s = "";
        for (int i = 0; i < 5; i++){
            s = s + "*";
            System.out.println(s);
        }
    }
}
