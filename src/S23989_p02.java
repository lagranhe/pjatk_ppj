import org.omg.CORBA.CharSeqHelper;

public class S23989_p02 {

    public static void main(String[] args) {

        double[] doubleArray =
                new double[] {rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble()};
        char[] charArray =
                new char[] {rChar(), rChar(), rChar(), rChar(), rChar(), rChar(), rChar(), rChar()};
        float[] floatArray =
                new float[] {rFloat(), rFloat(), rFloat(), rFloat(), rFloat(), rFloat(), rFloat(), rFloat()};

        for (int i = 0; i < 10; i++){
            int[] intArray =
                    new int[] {rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()};
            printIntArray(intArray);
            sortIntRadix(intArray);
            printIntArray(intArray);
            System.out.println("========================");
        }


    }

    //sort int
    public static void sortIntInsertion(int[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int k = i - 1;
            while (k >= 0 && numbers[k] > key) {
                numbers[k + 1] = numbers[k];
                k = k - 1;
            }
            numbers[k + 1] = key;
        }
    }

    public static void sortIntSelection(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            int minElementIndex = i;
            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[minElementIndex] > numbers[k]) {
                    minElementIndex = k;
                }
            }

            if (minElementIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minElementIndex];
                numbers[minElementIndex] = temp;
            }
        }
    }


    public static void sortIntMerge(int[] numbers){
        mergeSortForInt(numbers, numbers.length);
    }

    public static void mergeSortForInt(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] k = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            k[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSortForInt(k, mid);
        mergeSortForInt(r, n - mid);

        mergeInt(array, k, r, mid, n - mid);
    }

    public static void mergeInt(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            }
            else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }


    public static void sortIntHeapsort(int[] numbers){
        int n = numbers.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapifyInt(numbers, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            heapifyInt(numbers, i, 0);
        }
    }

    private static void heapifyInt(int[] array, int n, int i)
    {
        int largestNumber = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largestNumber]){
            largestNumber = l;
        }

        if (r < n && array[r] > array[largestNumber]){
            largestNumber = r;
        }

        if (largestNumber != i) {
            int temp = array[i];
            array[i] = array[largestNumber];
            array[largestNumber] = temp;
            heapifyInt(array, n, largestNumber);
        }
    }

    public static void sortIntQuicksort(int[] numbers){
        quickSortInt(numbers, 0, numbers.length-1);
    }

    private static void quickSortInt(int[] array, int begin, int end) {
        if (begin < end) {
            int partIndex = partInt(array, begin, end);

            quickSortInt(array, begin, partIndex-1);
            quickSortInt(array, partIndex+1, end);
        }
    }

    private static int partInt(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin-1);
        for (int k = begin; k < end; k++) {
            if (array[k] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i+1;
    }

    public static void sortIntBubble(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void sortIntBucket(int[] numbers){
        int[] bucket = new int[getMaxInt(numbers, numbers.length) + 1];
        int[] sorted_array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            bucket[numbers[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++){
            for (int k = 0; k < bucket[i]; k++){
                sorted_array[outPos++] = i;
            }
        }
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = sorted_array[i];
        }
    }


    public static void sortIntRadix(int[] numbers){
        int max = getMaxInt(numbers, numbers.length);
        for (int place = 1; max / place > 0; place *= 10) {
            countingSortInt(numbers, numbers.length, place);
        }
    }

    private static void countingSortInt(int[] array, int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }
        for (int i = 0; i < size; i++) {
            count[(array[i] / place) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    private static int getMaxInt(int[] array, int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }



    //sort double
    public static void sortDoubleInsertion(double[] numbers){
    }

    public static void sortDoubleSelection(double[] numbers){

    }

    public static void sortDoubleMerge(double[] numbers){

    }

    public static void sortDoubleHeapsort(double[] numbers){

    }

    public static void sortDoubleQuicksort(double[] numbers){

    }

    public static void sortDoubleBubble(double[] numbers){

    }

    public static void sortDoubleBucket(double[] numbers){

    }

    public static void sortDoubleRadix(double[] numbers){

    }


    //sort char - short
    public static void sortCharInsertion(char[] numbers){
    }

    public static void sortCharSelection(char[] numbers){

    }

    public static void sortCharMerge(char[] numbers){

    }

    public static void sortCharHeapsort(char[] numbers){

    }

    public static void sortCharQuicksort(char[] numbers){

    }

    public static void sortCharBubble(char[] numbers){

    }

    public static void sortCharBucket(char[] numbers){

    }

    public static void sortCharRadix(char[] numbers){

    }


    //sort float
    public static void sortFloatInsertion(float[] numbers){
    }

    public static void sortFloatSelection(float[] numbers){

    }

    public static void sortFloatMerge(float[] numbers){

    }

    public static void sortFloatHeapsort(float[] numbers){

    }

    public static void sortFloatQuicksort(float[] numbers){

    }

    public static void sortFloatBubble(float[] numbers){

    }

    public static void sortFloatBucket(float[] numbers){

    }

    public static void sortFloatRadix(float[] numbers){

    }




    private static int rInt(){
        return (int) (-Math.random() * 100);
    }

    private static double rDouble(){
        return Math.random();
    }

    private static char rChar(){
        int i = (int) ((Math.random() * (57 - 48)) + 48);
        return (char) i;
    }

    private static float rFloat(){
        return (float) Math.random();
    }





    private static void printIntArray(int[] numbers){
        for (int s : numbers){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(double[] numbers){
        for (double s : numbers){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printCharArray(char[] numbers){
        for (char s : numbers){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printFloatArray(float[] numbers){
        for (float s : numbers){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
