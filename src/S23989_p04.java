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

    public static void main(String[] args) {
        BufferedImage img = null;
        File file = null;
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
                int pRight2 = img.getRGB(x+2,y);
                int pTop = img.getRGB(x,y+1);
                int pTop2 = img.getRGB(x, y+2);
                int lowBlack = -16777216;
                int highBlack = -11111111;
                int lowWhite = -11111111;
                int highWhite = -1;

                if ((((p >= lowBlack && p < highBlack) && (pRight <= highWhite && pRight >= lowWhite )) ||
                        ((pRight >= lowBlack && pRight < highBlack) && (p <= highWhite && p >= lowWhite))) ||

                    (((p >= lowBlack && p < highBlack) && (pRight2 <= highWhite && pRight2 >= lowWhite )) ||
                            ((pRight2 >= lowBlack && pRight2 < highBlack) && (p <= highWhite && p >= lowWhite))) ||

                (((p >= lowBlack && p < highBlack) && (pTop <= highWhite && pTop >= lowWhite )) ||
                        ((pTop >= lowBlack && pTop < highBlack) && (p <= highWhite && p >= lowWhite))) ||

                (((p >= lowBlack && p < highBlack) && (pTop2 <= highWhite && pTop2 >= lowWhite )) ||
                        ((pTop2 >= lowBlack && pTop2 < highBlack) && (p <= highWhite && p >= lowWhite))))

                {
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
    }
}
