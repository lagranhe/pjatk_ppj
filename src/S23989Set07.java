import java.util.*;

public class S23989Set07 {

    public static void main(String[] args) {
        S23989Set07 s = new S23989Set07();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
    }

    public void task01(){
        separateTask("Task01");
        int[] arrayFirst = {1, 2, 4, 6, 2, 1};
        int[] arraySecond = {0, 2, 4, 6, 2, 1};
        int[] arrayThird = {1, 2, 1, 10, 2, 1};
        int[][] arrayForth = {arrayFirst, arraySecond, arrayThird};
        printArray(arrayForth);
    }
    public void task02(){
        separateTask("Task02");
        int[][] array = {
                {1, 2, 9, 4, 5, 6, 7, 8},
                {0, 1, 3, 4, 5, 3, 1, 8},
                {7, 5, 7, 4, 5, 6, 2, 8},
                {5, 2, 5, 4, 5, 6, 7, 8},
                {8, 4, 4, 4, 2, 5, 5, 8},
                {2, 9, 1, 4, 5, 6, 6, 8},
                {9, 0, 2, 4, 5, 3, 8, 8},
                {6, 0, 3, 4, 5, 6, 7, 8},
        };
        int[] diagonalArray = new int[16];
        int step = 0;
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++){
                if (j == i || i + j == 7){
                    diagonalArray[step] = array[i][j];
                    step++;
                }
            }
        }
        String result = "";
        for (int i = 0; i < 16; i ++){
            int count = 0;
            int number = diagonalArray[i];
            String numberString = Integer.toString(number);
            for (int j = i; j < 16; j ++){
                if (number == diagonalArray[j] && !result.contains(numberString)){
                    count++;
                    if (count == 3){
                        result += numberString + " ";
                        break;
                    }
                }
            }
        }
        System.out.println("Na przekątnych tablicy przynajmniej trzy razy występują liczby: " + result);
    }

    public void task03() {
        separateTask("Task03");
        char[][] tab = {
                {'S', 'a', 'm', 's', 'u', 'n', 'g'},
                {'N', 'o', 'k', 'i', 'a'},
                {'A', 'p', 'p', 'l', 'e'},
                {'B', 'l', 'a', 'c', 'k', 'B', 'e', 'r', 'r', 'y'},
                {'A', 'l', 'c', 'a', 't', 'e', 'l'},
                {'S', 'o', 'n', 'y'},
                {'J', 'o', 'l', 'l', 'a'}
        };
        System.out.println("Następne tablicy spełnia co najmniej trzy warunki:");
        for (char[] i : tab){
            if (sumOfStatements(i) >= 3) {
                printCharArray(i);
            }
        }

    }
    public void task04(){
        separateTask("Task04");
        int[][] array = {
                {1, 2, 9, 4, 5, 6, 7, 8, 5, 9},
                {0, 1, 3, 4, 5, 3, 1, 8, 6, 7},
                {7, 5, 7, 4, 5, 6, 2, 8, 5, 4},
                {5, 2, 5, 4, 5, 6, 7, 8, 1, 3},
                {8, 4, 4, 4, 2, 5, 5, 8, 0, 8},
                {2, 9, 1, 4, 5, 6, 6, 8, 5, 4},
                {9, 0, 2, 4, 5, 3, 8, 8, 7, 6},
                {6, 0, 3, 4, 5, 6, 7, 8, 1, 9},
        };
        for (int i = 0; i < array.length; i++){
            sort(array[i]);
        }
        System.out.println("Posortowana dwuwymiarowa tablica: ");
        printArray(array);
    }

    private void sort (int[] array){
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    private void printArray (int[][] array){
        for (int[] i : array){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();;
        }
    }

    private void printCharArray (char[] array){
        for (char i : array){
            System.out.print(i + " ");

        }
        System.out.println();
    }


    private void separateTask(String task) {
        System.out.println("==========================================");
        System.out.println(task);
    }

    private int isContainSameCharCaseInsensitive(char[] array){
        for (int i = 0; i < array.length; i ++){
            String firstString = Character.toString(array[i]).toLowerCase();
            for (int j = i + 1; j < array.length; j ++){
                String secondString = Character.toString(array[j]).toLowerCase();
                if (firstString.equals(secondString)){
                    return 1;
                }
            }
        }
        return 0;
    }

    private int isCharSumHigherThan225(char[] array){
        int count = 0;
        for (int i = 0; i < array.length; i ++){
            count += array[i];
        }
        return (count > 255) ? 1 : 0;
    }

    private int isContainCharI(char[] array){
        for (int i = 0; i < array.length; i ++){
            if (array[i] == 'i') return 1;
        }
        return 0;
    }

    private int isContainSameCharCaseSensitive(char[] array){
        for (int i = 0; i < array.length; i ++){
            char firstChar = array[i];
            for (int j = i + 1; j < array.length; j ++){
                if (array[j] == firstChar){
                    return 1;
                }
            }
        }
        return 0;
    }

    private int sumOfStatements(char[] array){
        return isContainSameCharCaseInsensitive(array) + isCharSumHigherThan225(array)
                + isContainCharI(array) + isContainSameCharCaseSensitive(array);
    }
}
