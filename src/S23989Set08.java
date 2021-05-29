public class S23989Set08 {

    public static void main(String[] args) {
        S23989Set08 s = new S23989Set08();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
        s.task05();
    }

    public void task01 (){
        show(123456);
    }

    public void task02 (){
        modifyValue(4);
    }

    public void task03 (){
        char[] array = {'A', 'l', 'a', ' ', 'm', 'a' , ' ', 'k', 'o', 't', 'a'};
        getCharQuantity(array);
    }

    public void task04 (){
        int[] firstArray = {1, 2, 4, 5, 72, 12};
        int[] secondArray = {5, 2, 6, 7, 24, 66, 22, 11};
        int number = -1;
        int[] result = getOperationOnArrays(firstArray, secondArray, number);
        for (int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void task05 (){
        createSquare(10, 'x');
    }

    public void show (int number){
        System.out.println(number);
    }

    public void modifyValue (int number){
        int methodNumber = number;
        System.out.println(methodNumber);
        methodNumber *= 5;
        System.out.println(methodNumber);
    }

    public int[] getOperationOnArrays(int[] firstArray, int[] secondArray, int number){
        int minLength = Math.min(firstArray.length, secondArray.length);
        int maxLength = Math.max(firstArray.length, secondArray.length);
        int[] maxArray = (firstArray.length > secondArray.length) ? firstArray : secondArray;
        int[] result;
        if (number < 0) {
            result = new int[minLength];
            for (int i = 0; i < minLength; i ++){
                result[i] = firstArray[i] + secondArray[i];
            }
            return result;
        } else if (number > 0) {
            result = new int[maxLength - minLength];
            for (int i = 0; i < result.length; i ++){
                result[i] = maxArray[minLength+i];
            }
            return result;
        } else if (firstArray.length == secondArray.length) {
            return new int[0];
        }
        return new int[0];
    }

    public void getCharQuantity(char[] array){
        int count = 0;
        String s = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (!s.contains(Character.toString(array[i]))) {
                System.out.println(array[i] + " " + count);
                s += array[i];
                count = 0;
            }
        }
    }

    public void createSquare (int side, char firstChar){
        char x = 'x';
        char o = 'o';
        boolean firstIteration = true;
        for (int i = 0; i < side; i ++) {
            for (int j = 0; j < side; j ++) {
                if (!firstIteration){
                    if (firstChar == x) {
                        firstChar = o;
                    } else {
                        firstChar = x;
                    }
                }
                firstIteration = false;
                System.out.print(firstChar + " ");
            }
            System.out.println();
        }
    }
}
