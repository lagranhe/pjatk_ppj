public class S23989_p02 {

    public static void main(String[] args) {
        int[] intArray =
                new int[] {rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()
                        , rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()
                        , rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()
                        , rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()};

        char[] charArray =
                new char[] {rChar(), rChar(), rChar(), rChar(), rChar(), rChar(), rChar(), rChar()};
        float[] floatArray =
                new float[] {rFloat(), rFloat(), rFloat(), rFloat(), rFloat(), rFloat(), rFloat(), rFloat()};

        for (int i = 0; i < 100; i++){
            double[] doubleArray =
                    new double[] {rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble()
                            , rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble()
                            , rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble(), rDouble()
            };
            printDoubleArray(doubleArray);
            sortDoubleRadix(doubleArray);
            printDoubleArray(doubleArray);
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

    private static void heapifyInt(int[] array, int n, int i){
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
        int countPositive = 0;
        int countZeroes = 0;
        for (int i : numbers){
            if (i > 0) countPositive++;
            if (i == 0) countZeroes++;
        }
        int countNegative = numbers.length - countPositive;
        int[] positArray = new int[countPositive];
        int[] negatArray = new int[countNegative];
        int count = 0;
        for (int i : numbers){
            if (i > 0){
                positArray[count] = i;
                count++;
            }
        }
        count = 0;
        for (int i : numbers){
            if (i < 0){
                negatArray[count] = 0 - i;
                count++;
            }
        }
        int[][] positiveBucket = new int[11][positArray.length+1];
        if (positArray.length > 0){
            for (int i = 0; i < 11; i ++){
                positiveBucket[i][0] = 1;
            }
            for (int i = 0; i < positArray.length; i ++){
                int numberOfBucket = (positArray[i] / 10) + 1;
                int emptyBucket = positiveBucket[numberOfBucket][0];
                positiveBucket[numberOfBucket][emptyBucket] = positArray[i];
                positiveBucket[numberOfBucket][0]++;
            }
            for (int i = 0; i < 11; i++){
                positiveBucket[i][0] = 0;
                sortIntInsertion(positiveBucket[i]);
            }
        }

        int[][] negativeBucket = new int[11][negatArray.length+1];
        if (negatArray.length > 0){
            for (int i = 0; i < 11; i ++){
                negativeBucket[i][0] = 1;
            }
            for (int i = 0; i < negatArray.length; i ++){
                int numberOfBucket = (negatArray[i] / 10) + 1;
                int emptyBucket = negativeBucket[numberOfBucket][0];
                negativeBucket[numberOfBucket][emptyBucket] = negatArray[i];
                negativeBucket[numberOfBucket][0]++;
            }

            for (int i = 0; i < 11; i ++){
                for (int k = 0; k < negatArray.length+1; k ++){
                    negativeBucket[i][k] = - negativeBucket[i][k];
                }
            }

            for (int i = 0; i < 11; i++){
                negativeBucket[i][0] = 0;
                sortIntInsertion(negativeBucket[i]);
            }

        }

        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length;){
            for (int countBucket = 10; countBucket > 0; countBucket--){
                for (int k = 0; k < negativeBucket[countBucket].length; k ++){
                    if (negativeBucket[countBucket][k] != 0){
                        result[i] = negativeBucket[countBucket][k];
                        i++;
                    }
                }
            }
            for (int countZero = 0; countZero < countZeroes; countZero++){
                result[i] = 0;
                i++;
            }
            for (int countBucket = 0; countBucket < 11; countBucket++){
                for (int k = 0; k < positiveBucket[countBucket].length; k ++){
                    if (positiveBucket[countBucket][k] != 0){
                        result[i] = positiveBucket[countBucket][k];
                        i++;
                    }
                }
            }
        }
        for (int i = 0; i < numbers.length; i ++){
            numbers[i] = result[i];
        }
    }


    public static void sortIntRadix(int[] numbers){
        int max = getMaxInt(numbers);
        if (max < 0){
            max = - max;
        }
        int countPositive = 0;
        for (int i : numbers){
            if (i >= 0) countPositive++;
        }
        int countNegative = numbers.length - countPositive;
        int[] positArray = new int[countPositive];
        int[] negatArray = new int[countNegative];
        int count = 0;
        for (int i : numbers){
            if (i >= 0){
                positArray[count] = i;
                count++;
            }
        }
        count = 0;
        for (int i : numbers){
            if (i < 0){
                negatArray[count] = 0 - i;
                count++;
            }
        }

        if (positArray.length != 0){
            for (int place = 1; max / place > 0; place *= 10) {
                countingSortInt(positArray, positArray.length, place);
            }
        }

        if (negatArray.length != 0){
            for (int place = 1; max / place > 0; place *= 10) {
                countingSortInt(negatArray, negatArray.length, place);
            }
            for(int i=0; i<negatArray.length/2; i++){
                int temp = negatArray[i];
                negatArray[i] = negatArray[negatArray.length -i -1];
                negatArray[negatArray.length -i -1] = temp;
            }
        }

        int countNeg=0;
        int countPos=0;
        for (int i = 0; i < numbers.length; i++){
            if (countNeg <= negatArray.length-1){
                numbers[i] = - negatArray[countNeg];
                countNeg++;
            } else {
                numbers[i] = positArray[countPos];
                countPos++;
            }
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

    private static int getMaxInt(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }



    //sort double
    public static void sortDoubleInsertion(double[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            double key = numbers[i];
            int k = i - 1;
            while (k >= 0 && numbers[k] > key) {
                numbers[k + 1] = numbers[k];
                k = k - 1;
            }
            numbers[k + 1] = key;
        }
    }

    public static void sortDoubleSelection(double[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            int minElementIndex = i;
            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[minElementIndex] > numbers[k]) {
                    minElementIndex = k;
                }
            }

            if (minElementIndex != i) {
                double temp = numbers[i];
                numbers[i] = numbers[minElementIndex];
                numbers[minElementIndex] = temp;
            }
        }
    }

    public static void sortDoubleMerge(double[] numbers){
        mergeSortForDouble(numbers, numbers.length);
    }

    public static void mergeSortForDouble(double[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        double[] k = new double[mid];
        double[] r = new double[n - mid];

        for (int i = 0; i < mid; i++) {
            k[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSortForDouble(k, mid);
        mergeSortForDouble(r, n - mid);

        mergeDouble(array, k, r, mid, n - mid);
    }

    public static void mergeDouble(double[] array, double[] l, double[] r, int left, int right) {
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

    public static void sortDoubleHeapsort(double[] numbers){
        int n = numbers.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapifyDouble(numbers, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            double temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            heapifyDouble(numbers, i, 0);
        }
    }

    private static void heapifyDouble(double[] array, int n, int i) {
        int largestNumber = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largestNumber]) {
            largestNumber = l;
        }

        if (r < n && array[r] > array[largestNumber]) {
            largestNumber = r;
        }

        if (largestNumber != i) {
            double temp = array[i];
            array[i] = array[largestNumber];
            array[largestNumber] = temp;
            heapifyDouble(array, n, largestNumber);
        }
    }

    public static void sortDoubleQuicksort(double[] numbers){
        quickSortDouble(numbers, 0, numbers.length-1);
    }

    private static void quickSortDouble(double[] array, int begin, int end) {
        if (begin < end) {
            int partIndex = partDouble(array, begin, end);

            quickSortDouble(array, begin, partIndex-1);
            quickSortDouble(array, partIndex+1, end);
        }
    }

    private static int partDouble(double[] array, int begin, int end) {
        double pivot = array[end];
        int i = (begin-1);
        for (int k = begin; k < end; k++) {
            if (array[k] <= pivot) {
                i++;

                double temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        double temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i+1;
    }

    public static void sortDoubleBubble(double[] numbers){
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void sortDoubleBucket(double[] numbers){
        int countPositive = 0;
        int countZeroes = 0;
        for (double i : numbers){
            if (i > 0) countPositive++;
            if (i == 0) countZeroes++;
        }
        int countNegative = numbers.length - countPositive;
        double[] positArray = new double[countPositive];
        double[] negatArray = new double[countNegative];
        int count = 0;
        for (double i : numbers){
            if (i > 0){
                positArray[count] = i;
                count++;
            }
        }
        count = 0;
        for (double i : numbers){
            if (i < 0){
                negatArray[count] = 0 - i;
                count++;
            }
        }
        double[][] positiveBucket = new double[11][positArray.length+1];
        if (positArray.length > 0){
            for (int i = 0; i < 11; i ++){
                positiveBucket[i][0] = 1;
            }
            for (int i = 0; i < positArray.length; i ++){
                int numberOfBucket = (int) (positArray[i] * 10) + 1;
                double emptyBucket = positiveBucket[numberOfBucket][0];
                positiveBucket[numberOfBucket][(int) emptyBucket] = positArray[i];
                positiveBucket[numberOfBucket][0]++;
            }
            for (int i = 0; i < 11; i++){
                positiveBucket[i][0] = 0;
                sortDoubleInsertion(positiveBucket[i]);
            }
        }

        double[][] negativeBucket = new double[11][negatArray.length+1];
        if (negatArray.length > 0){
            for (int i = 0; i < 11; i ++){
                negativeBucket[i][0] = 1;
            }
            for (int i = 0; i < negatArray.length; i ++){
                int numberOfBucket = (int) (negatArray[i] * 10) + 1;
                double emptyBucket = negativeBucket[numberOfBucket][0];
                negativeBucket[numberOfBucket][(int) emptyBucket] = negatArray[i];
                negativeBucket[numberOfBucket][0]++;
            }

            for (int i = 0; i < 11; i ++){
                for (int k = 0; k < negatArray.length+1; k ++){
                    negativeBucket[i][k] = - negativeBucket[i][k];
                }
            }

            for (int i = 0; i < 11; i++){
                negativeBucket[i][0] = 0;
                sortDoubleInsertion(negativeBucket[i]);
            }

        }

        double[] result = new double[numbers.length];
        for (int i = 0; i < result.length;){
            for (int countBucket = 10; countBucket > 0; countBucket--){
                for (int k = 0; k < negativeBucket[countBucket].length; k ++){
                    if (negativeBucket[countBucket][k] != 0){
                        result[i] = negativeBucket[countBucket][k];
                        i++;
                    }
                }
            }
            for (int countZero = 0; countZero < countZeroes; countZero++){
                result[i] = 0;
                i++;
            }
            for (int countBucket = 0; countBucket < 11; countBucket++){
                for (int k = 0; k < positiveBucket[countBucket].length; k ++){
                    if (positiveBucket[countBucket][k] != 0){
                        result[i] = positiveBucket[countBucket][k];
                        i++;
                    }
                }
            }
        }
        for (int i = 0; i < numbers.length; i ++){
            numbers[i] = result[i];
        }
    }

    public static void sortDoubleRadix(double[] numbers){
        double max = getMaxDouble(numbers);
        if (max < 0){
            max = - max;
        }
        int countPositive = 0;
        for (double i : numbers){
            if (i >= 0) countPositive++;
        }
        int countNegative = numbers.length - countPositive;
        double[] positArray = new double[countPositive];
        double[] negatArray = new double[countNegative];
        int count = 0;
        for (double i : numbers){
            if (i >= 0){
                positArray[count] = i;
                count++;
            }
        }
        count = 0;
        for (double i : numbers){
            if (i < 0){
                negatArray[count] = 0 - i;
                count++;
            }
        }

        if (positArray.length != 0){
            for (int place = 1; max / place > 0; place *= 10) {
                countingSortDouble(positArray, positArray.length, place);
            }
        }

        if (negatArray.length != 0){
            for (int place = 1; max / place > 0; place *= 10) {
                countingSortDouble(negatArray, negatArray.length, place);
            }
            for(int i=0; i<negatArray.length/2; i++){
                double temp = negatArray[i];
                negatArray[i] = negatArray[negatArray.length - i - 1];
                negatArray[negatArray.length -i -1] = temp;
            }
        }

        int countNeg=0;
        int countPos=0;
        for (int i = 0; i < numbers.length; i++){
            if (countNeg <= negatArray.length-1){
                numbers[i] = - negatArray[countNeg];
                countNeg++;
            } else {
                numbers[i] = positArray[countPos];
                countPos++;
            }
        }
    }

    private static void countingSortDouble(double[] array, int size, int place) {
        double[] output = new double[size + 1];
        double max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        double[] count = new double[(int) (max * 100 + 1)];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }
        int approximation = 1000000000;
        for (int i = 0; i < size; i++) {
            count[(int) ((array[i] * approximation / place) % 10)]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            output[(int) (count[(int) ((array[i] * approximation / place) % 10)] - 1)] = array[i];
            count[(int) ((array[i] * approximation / place) % 10)]--;
        }
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    private static double getMaxDouble(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
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
        if (Math.random() > 0.5){
            return (int) (Math.random() * 100);
        } else {
            return (int) (-Math.random() * 100);
        }
    }

    private static double rDouble(){
        if (Math.random() > 0.5){
            return Math.random();
        } else {
            return -Math.random();
        }
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
