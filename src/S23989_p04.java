import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class S23989_p04 {

    /*
    Dany jest plik grayFisheye.png zakodowany w formie ASCI
    i przedstawiający prostopadłą siatkę kalibracyjną.
    Napisz program, który odczyta zawarte w pliku informacje i
    przechowa je w tablicy. Następnie znajdzie wszystkie narożniki
    tej siatki kalibracyjnej i poindeksuje je poczynając od indeksu [0 wiersz,0 kolumna].
     */

    public static final int lowBlack = -16777216;
    public static final int highBlack = 10111113;
    public static final int lowWhite = -10111111;
    public static final int highWhite = -1;
    public static final int green = -10111112;

    public static void main(String[] args) {
        BufferedImage img = null;
        File file;

        int lowBlack = -16777216;
        int highBlack = -10111113;
        int lowWhite = -10111111;
        int highWhite = -1;
        int green = -10111112;


        try {
            file = new File("/home/mich/Documents/PJATK/PPJ/TestProjects/src/grayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e ){
            e.printStackTrace();
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] matrix = new int [height][width];
        StringBuilder result = new StringBuilder("");
        for (int y = 2; y < height-3; y++) {
            for (int x = 2; x < width-3; x++) {
                int p = img.getRGB(x,y);
                matrix[y][x] = p;
                int pRight = img.getRGB(x+1,y);
                int pTop = img.getRGB(x,y+1);

                int pTop2 = img.getRGB(x, y+2);
                int pRight2 = img.getRGB(x+2,y);


                if ((((p >= lowBlack && p < highBlack) && (pRight <= highWhite && pRight >= lowWhite )) ||
                        ((pRight >= lowBlack && pRight < highBlack) && (p <= highWhite && p >= lowWhite)))

                        || (((p >= lowBlack && p < highBlack) && (pRight2 <= highWhite && pRight2 >= lowWhite )) ||
                            ((pRight2 >= lowBlack && pRight2 < highBlack) && (p <= highWhite && p >= lowWhite)))

                        || (((p >= lowBlack && p < highBlack) && (pTop <= highWhite && pTop >= lowWhite )) ||
                        ((pTop >= lowBlack && pTop < highBlack) && (p <= highWhite && p >= lowWhite)))


                        || (((p >= lowBlack && p < highBlack) && (pTop2 <= highWhite && pTop2 >= lowWhite )) ||
                        ((pTop2 >= lowBlack && pTop2 < highBlack) && (p <= highWhite && p >= lowWhite)))
                ) {

                    result.append("[").append(x).append(", ").append(y).append("], ");
                    img.setRGB(x, y, lowBlack);
                } else {
                    img.setRGB(x, y, highWhite);
                }
            }
        }

        try
        {
            file = new File("/home/mich/Documents/PJATK/PPJ/TestProjects/src/outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        System.out.println(result);
        System.out.println("============================================================");



            ///////////////////////////////

        try {
            file = new File("/home/mich/Documents/PJATK/PPJ/TestProjects/src/outGrayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e ){
            e.printStackTrace();
        }

        for (int y = 3; y < height-3; y++) {
            for (int x = 3; x < width-3; x++) {

                int p = img.getRGB(x,y);

                int[][] formOfNode = {
                        {img.getRGB(x-2,y-2), img.getRGB(x-1,y-2), img.getRGB(x,y-2), img.getRGB(x+1,y-2), img.getRGB(x+2,y-2)},
                        {img.getRGB(x-2,y-1), img.getRGB(x-1,y-1), img.getRGB(x,y-1), img.getRGB(x+1,y-1), img.getRGB(x+2,y+2)},
                        {img.getRGB(x-2,y), img.getRGB(x-1,y), img.getRGB(x,y), img.getRGB(x+1,y), img.getRGB(x+2,y)},
                        {img.getRGB(x-2,y+1), img.getRGB(x-1,y+1), img.getRGB(x,y+1), img.getRGB(x+1,y+1), img.getRGB(x+2,y+1)},
                        {img.getRGB(x-2,y+2), img.getRGB(x-1,y+2), img.getRGB(x,y+2), img.getRGB(x+1,y+2), img.getRGB(x+2,y+2)}
                };

                if (
                        isFormComparable(formOfNode, form1)
                                || isFormComparable(formOfNode, form2)
                                || isFormComparable(formOfNode, form3)
                                || isFormComparable(formOfNode, form4)
                ) {
                    result.append("[").append(x).append(", ").append(y).append("], ");
                    img.setRGB(x, y, green);
                }
            }
        }
        System.out.println(result);

        try
        {
            file = new File("/home/mich/Documents/PJATK/PPJ/TestProjects/src/outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }



        ////////////////////////////////
    }

    private static boolean isFormComparable (int[][] array1, int [][] array2){
        if ((array1.length != array2.length) || (array1[0].length != array2[0].length)){
            return false;
        }
        int count = 0;
        for (int i = 0; i < array1.length; i++){
            for (int j = 0; j < array1[i].length; j++){
                if (array1[i][j] == array2[i][j] && array1[i][j] == lowBlack){
                    count++;
                }
            }
        }
        return (count >= 8);
    }

    private static int[][] form1 = {
            {highWhite, highWhite, lowBlack, highWhite, highWhite},
            {highWhite, highWhite, lowBlack, highWhite, highWhite},
            {lowBlack, lowBlack, lowBlack, lowBlack, lowBlack},
            {highWhite, highWhite, lowBlack, highWhite, highWhite},
            {highWhite, highWhite, lowBlack, highWhite, highWhite}
    };

    private static int[][] form2 = {
            {lowBlack, highWhite, highWhite, highWhite, lowBlack},
            {highWhite, lowBlack, highWhite, lowBlack, highWhite},
            {highWhite, highWhite, lowBlack, highWhite, highWhite},
            {highWhite, lowBlack, highWhite, lowBlack, highWhite},
            {lowBlack, highWhite, highWhite, highWhite, lowBlack}
    };

    private static int[][] form3 = {
            {highWhite, lowBlack, highWhite, highWhite, highWhite},
            {highWhite, lowBlack, highWhite, lowBlack, lowBlack},
            {highWhite, highWhite, lowBlack, highWhite, highWhite},
            {highWhite, lowBlack, highWhite, lowBlack, highWhite},
            {lowBlack, highWhite, highWhite, lowBlack, highWhite}
    };

    private static int[][] form4 = {
            {highWhite, highWhite, highWhite, lowBlack, highWhite},
            {lowBlack, lowBlack, highWhite, lowBlack, highWhite},
            {highWhite, highWhite, lowBlack, highWhite, highWhite},
            {highWhite, lowBlack, highWhite, lowBlack, lowBlack},
            {highWhite, lowBlack, highWhite, highWhite, highWhite}
    };
}
