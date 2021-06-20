import java.util.Collections;

public class S23989Set11 {
    public static void main(String[] args) throws Exception {
        S23989Set11 s = new S23989Set11();
        //s.task01();
        //s.task02();
        s.task03();
    }

    public void task01() throws Alarm {
        DetektorDymu detektorDymu = new DetektorDymu();
        detektorDymu.sprawdz();
    }

    public void task02() throws Exception {
        CiagnikSiodlowy ciagnikSiodlowy = new CiagnikSiodlowy("czerwony", 2, 30);
        ciagnikSiodlowy.rozpocznijJazde();
    }
    public void task03() throws Exception {
        int length = (int) (Math.random() * 10);
        int[][] tab = new int[length][length];

        for (int i = 0; i < length; i ++){
            for (int k = 0; k < length; k ++){
                tab[i][k] = (int) (Math.random() * 5);
            }
        }

//        for (int i = 0; i < length; i ++){
//            for (int k = 0; k < length; k ++){
//                System.out.print(tab[i][k] + " ");
//            }
//            System.out.println();
//        }

        String msgErr = "";
        boolean first = true;
        for (int i = 0; i < length; i ++){
            for (int k = 0; k < length; k ++){
                if (i != k && tab[i][k] != 0){
                    if (first){
                        msgErr += "[" + i + ", " + k + "]";
                        first = false;
                    } else {
                        msgErr += ", [" + i + ", " + k + "]";
                    }
                }
            }
        }
        if (!first){
            throw new Exception("Tablica nie spelnia wymagan , bledy na pozycjach " + msgErr);
        }
    }


    public class Alarm extends Exception{
        public Alarm(String alarm) {
            super(alarm);
        }
    }

    public class DetektorDymu{
        boolean isSmoke = true;
        public void sprawdz() throws Alarm {
            if (this.isSmoke){
                throw new Alarm("Wykryto dym");
            }
        }
    }

    public class Pojadz{
        String color;

        public Pojadz(String color) {
            this.color = color;
        }
    }

    public class PojazdKolowy extends Pojadz{
        private int iloscOsi;

        public PojazdKolowy(String color, int iloscOsi) {
            super(color);
            this.iloscOsi = iloscOsi;
        }
    }

    public class CiagnikSiodlowy extends PojazdKolowy{
        int masa;

        public CiagnikSiodlowy(String color, int iloscOsi, int masa) {
            super(color, iloscOsi);
            this.masa = masa;
        }

        public void rozpocznijJazde() throws Exception {
            double nacisk = masa/super.iloscOsi;
            if (nacisk > 11) {
                throw new Exception("Jazda niebezpieczna, odmowa uruchomienia silnika");
            }
        }
    }

}
