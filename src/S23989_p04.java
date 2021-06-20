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
        for (int y = 2; y < height-1; y++) {
            for (int x = 2; x < width-1; x++) {
                int p = img.getRGB(x,y);
                matrix[y][x] = p;
                int pRight = img.getRGB(x+1,y);
                int pLeft = img.getRGB(x-1,y);
                int pTop = img.getRGB(x,y+1);
                int pDown = img.getRGB(x, y-1);
                int lowBlack = -16777216;
                int highBlack = -14111111;
                int lowWhite = -10000;
                int highWhite = -1;

                if ((((p >= lowBlack && p < highBlack) && (pRight <= highWhite && pRight >= lowWhite )) ||
                        ((pRight >= lowBlack && pRight < highBlack) && (p <= highWhite && p >= lowWhite))) ||

                    (((p >= lowBlack && p < highBlack) && (pLeft <= highWhite && pLeft >= lowWhite )) ||
                            ((pLeft >= lowBlack && pLeft < highBlack) && (p <= highWhite && p >= lowWhite))) ||

                (((p >= lowBlack && p < highBlack) && (pTop <= highWhite && pTop >= lowWhite )) ||
                        ((pTop >= lowBlack && pTop < highBlack) && (p <= highWhite && p >= lowWhite))) ||

                (((p >= lowBlack && p < highBlack) && (pDown <= highWhite && pDown >= lowWhite )) ||
                        ((pDown >= lowBlack && pDown < highBlack) && (p <= highWhite && p >= lowWhite))))

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
