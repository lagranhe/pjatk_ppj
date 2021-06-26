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
        File file;
        //change path to your directory
        String path = "/home/mich/Documents/PJATK/PPJ/TestProjects/src/";

        int lowBlack = -16777216;
        int highBlack = -10111114;
        int lowWhite = -10111112;
        int highWhite = -1;
        int green = -10111113;
        int red = 0xFFFF0000;
        Point[] points;

        // change format of image from 8-bit colormap
        try {
            file = new File(path + "grayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                img.setRGB(x, y, p);
            }
        }
        try {
            file = new File(path + "grayFisheye.png");
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        /////////////////////////////////////////////////////////
        // draw in image borders of changing colors from white-like -> black-like and black-like -> white-like
        try {
            file = new File(path + "grayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int y = 2; y < height - 3; y++) {
            for (int x = 2; x < width - 3; x++) {
                int p = img.getRGB(x, y);
                int pRight = img.getRGB(x + 1, y);
                int pTop = img.getRGB(x, y + 1);
                int pTop2 = img.getRGB(x, y + 2);
                int pRight2 = img.getRGB(x + 2, y);
                if ((((p >= lowBlack && p < highBlack) && (pRight <= highWhite && pRight >= lowWhite)) ||
                        ((pRight >= lowBlack && pRight < highBlack) && (p <= highWhite && p >= lowWhite)))

                        || (((p >= lowBlack && p < highBlack) && (pRight2 <= highWhite && pRight2 >= lowWhite)) ||
                        ((pRight2 >= lowBlack && pRight2 < highBlack) && (p <= highWhite && p >= lowWhite)))

                        || (((p >= lowBlack && p < highBlack) && (pTop <= highWhite && pTop >= lowWhite)) ||
                        ((pTop >= lowBlack && pTop < highBlack) && (p <= highWhite && p >= lowWhite)))


                        || (((p >= lowBlack && p < highBlack) && (pTop2 <= highWhite && pTop2 >= lowWhite)) ||
                        ((pTop2 >= lowBlack && pTop2 < highBlack) && (p <= highWhite && p >= lowWhite)))
                ) {
                    img.setRGB(x, y, lowBlack);
                } else {
                    img.setRGB(x, y, highWhite);
                }
            }
        }
        try {
            file = new File(path + "outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        ///////////////////////////////
        // set green colors to points that is nearest of black points concentration for findings nodes
        try {
            file = new File(path + "outGrayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int y = 3; y < height - 3; y++) {
            for (int x = 3; x < width - 3; x++) {

                //int p1 = img.getRGB(x-2,y-2);
                int p2 = img.getRGB(x - 1, y - 2);
                int p3 = img.getRGB(x, y - 2);
                int p4 = img.getRGB(x + 1, y - 2);
                //int p5 = img.getRGB(x+2,y-2);

                int p6 = img.getRGB(x - 2, y - 1);
                int p7 = img.getRGB(x - 1, y - 1);
                int p8 = img.getRGB(x, y - 1);
                int p9 = img.getRGB(x + 1, y - 1);
                int p10 = img.getRGB(x + 2, y - 1);

                int p11 = img.getRGB(x - 2, y);
                int p12 = img.getRGB(x - 1, y);
                int p13 = img.getRGB(x, y);
                int p14 = img.getRGB(x + 1, y);
                int p15 = img.getRGB(x + 2, y);

                int p16 = img.getRGB(x - 2, y + 1);
                int p17 = img.getRGB(x - 1, y + 1);
                int p18 = img.getRGB(x, y + 1);
                int p19 = img.getRGB(x + 1, y + 1);
                //int p20 = img.getRGB(x + 2, y + 1);

                int p21 = img.getRGB(x-2,y+2);
                int p22 = img.getRGB(x - 1, y + 2);
                int p23 = img.getRGB(x, y + 2);
                int p24 = img.getRGB(x + 1, y + 2);
                //int p25 = img.getRGB(x+2,y+2);
                int count = 0;
                //count = (p1 == lowBlack) ? count+1 : count;
                count = (p2 == lowBlack) ? count + 1 : count;
                count = (p3 == lowBlack) ? count + 1 : count;
                count = (p4 == lowBlack) ? count + 1 : count;
                //count = (p5 == lowBlack) ? count+1 : count;
                count = (p6 == lowBlack) ? count + 1 : count;
                count = (p7 == lowBlack) ? count + 1 : count;
                count = (p8 == lowBlack) ? count + 1 : count;
                count = (p9 == lowBlack) ? count + 1 : count;
                count = (p10 == lowBlack) ? count + 1 : count;
                count = (p11 == lowBlack) ? count + 1 : count;
                count = (p12 == lowBlack) ? count + 1 : count;
                count = (p13 == lowBlack) ? count + 1 : count;
                count = (p14 == lowBlack) ? count + 1 : count;
                count = (p15 == lowBlack) ? count + 1 : count;
                count = (p16 == lowBlack) ? count + 1 : count;
                count = (p17 == lowBlack) ? count + 1 : count;
                count = (p18 == lowBlack) ? count + 1 : count;
                count = (p19 == lowBlack) ? count + 1 : count;
                //count = (p20 == lowBlack) ? count + 1 : count;
                count = (p21 == lowBlack) ? count+1 : count;
                count = (p22 == lowBlack) ? count + 1 : count;
                count = (p23 == lowBlack) ? count + 1 : count;
                count = (p24 == lowBlack) ? count + 1 : count;
                //count = (p25 == lowBlack) ? count+1 : count;


                if (count >= 14) {
                    img.setRGB(x, y, green);
                }
            }
        }
        try {
            file = new File(path + "outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        ////////////////////////////////
        // find and draw red points - geometric center of green areas
        try {
            file = new File(path + "outGrayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int y = 10; y < height - 10; y++) {
            for (int x = 20; x < width - 20; x++) {
                int p = img.getRGB(x, y);

                if (p == green) {
                    int count = 0;
                    int sumX = 0;
                    int sumY = 0;
                    for (int i = -10; i < 10; i++) {
                        for (int j = -20; j < 20; j++) {
                            int point = img.getRGB(x + j, y + i);
                            if (point == green || point == red) {
                                sumX += x + j;
                                sumY += y + i;
                                count++;
                            }
                        }
                    }
                    img.setRGB((int) Math.ceil(sumX / count), (int) Math.ceil(sumY / count), red);
                }
            }
        }
        try {
            file = new File(path + "outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        /////////////////////////////////////////
        //change red point to green in places of abnormal congestion of red points
        try {
            file = new File(path + "outGrayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int y = 20; y < height - 30; y++) {
            for (int x = 0; x < width - 25; x++) {
                int p = img.getRGB(x, y);
                int countOfRed = 0;
                if (p == red) {
                    for (int i = -20; i < 30; i++) {
                        for (int j = 0; j < 25; j++) {
                            if (j == 0 && i == 0) continue;
                            int pointInScope = img.getRGB(x + j, y + i);
                            if (pointInScope == red) {
                                img.setRGB(x + j, y + i, lowBlack);
                                countOfRed++;
                            }
                        }
                    }
                    if (countOfRed > 1) {
                        img.setRGB(x, y, lowBlack);
                    }
                }
            }
        }
        try {
            file = new File(path + "outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        /////////////////////////////////////////////////////////////
        //change red point to green in places of abnormal congestion of green points
        //  (that mean not in calibration grid)
        try {
            file = new File(path + "outGrayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int y = 50; y < height - 50; y++) {
            for (int x = 50; x < width - 50; x++) {
                int p = img.getRGB(x, y);
                int countOfGreen = 0;
                if (p == red) {
                    for (int i = -50; i < 50; i++) {
                        for (int j = -50; j < 50; j++) {
                            int pointInScope = img.getRGB(x + j, y + i);
                            if (pointInScope == green) {
                                countOfGreen++;
                            }
                        }
                    }
                    if (countOfGreen > 60) {
                        img.setRGB(x, y, green);
                    }
                }
            }
        }
        try {
            file = new File(path + "outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        ////////////////////////////////////////////////////////////////////
        //creating and populating an array of red points in calibration grid
        try {
            file = new File(path + "outGrayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int countOfCenterPointsInSquare = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (img.getRGB(x, y) == red) {
                    countOfCenterPointsInSquare++;
                }
            }
        }


        points = new Point[countOfCenterPointsInSquare];
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (img.getRGB(x, y) == red) {
                    points[count] = new Point(x, y);
                    count++;
                }
            }
        }
        for (Point p : points) {
            System.out.println(p);
        }
        try {
            file = new File(path + "outGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }

        ///////////////////////////////////////////
        // drawing result image with red points for visualize the solution
        try {
            file = new File(path + "grayFisheye.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                for (Point pointOfRed : points) {
                    if (pointOfRed.x == x && pointOfRed.y == y) {
                        p = red;
                    }
                }
                img.setRGB(x, y, p);
            }
        }
        try {
            file = new File(path + "resultGrayFisheye.png");
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
