public class S23989_p02 {

    public static void main(String[] args) {

        int[] intArray =
                new int[] {rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()
                        , rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()
                        , rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()
                        , rInt(), rInt(), rInt(), rInt(), rInt(), rInt(), rInt()};

        long timeFirstSortInt = System.nanoTime();
        for (int i = 0; i < 100; i++){
            int[] arrayInsertion = copyIntArray(intArray);
            sortIntInsertion(arrayInsertion);
            int[] arraySelection = copyIntArray(intArray);
            sortIntSelection(arraySelection);
            int[] arrayMerge = copyIntArray(intArray);
            sortIntMerge(arrayMerge);
            int[] arrayHeapsort = copyIntArray(intArray);
            sortIntHeapsort(arrayHeapsort);
            int[] arrayQuicksort = copyIntArray(intArray);
            sortIntQuicksort(arrayQuicksort);
            int[] arrayBubble = copyIntArray(intArray);
            sortIntBubble(arrayBubble);
            int[] arrayBucket = copyIntArray(intArray);
            sortIntBucket(arrayBucket);
            int[] arrayRadix = copyIntArray(intArray);
            sortIntRadix(arrayRadix);
        }
        long timeSecondSortInt = System.nanoTime();
        System.out.println("Sort table of integers: " + (timeSecondSortInt-timeFirstSortInt)/100);


        double[] doubleArray = copyDoubleArrayFromInt(intArray);
        long timeFirstSortDouble = System.nanoTime();
        for (int i = 0; i < 100; i++){
            double[] arrayInsertion = copyDoubleArray(doubleArray);
            sortDoubleInsertion(arrayInsertion);
            double[] arraySelection = copyDoubleArray(doubleArray);
            sortDoubleSelection(arraySelection);
            double[] arrayMerge = copyDoubleArray(doubleArray);
            sortDoubleMerge(arrayMerge);
            double[] arrayHeapsort = copyDoubleArray(doubleArray);
            sortDoubleHeapsort(arrayHeapsort);
            double[] arrayQuicksort = copyDoubleArray(doubleArray);
            sortDoubleQuicksort(arrayQuicksort);
            double[] arrayBubble = copyDoubleArray(doubleArray);
            sortDoubleBubble(arrayBubble);
            double[] arrayBucket = copyDoubleArray(doubleArray);
            sortDoubleBucket(arrayBucket);
            double[] arrayRadix = copyDoubleArray(doubleArray);
            sortDoubleRadix(arrayRadix);
        }
        long timeSecondSortDouble = System.nanoTime();
        System.out.println("Sort table of doubles: " + (timeSecondSortDouble-timeFirstSortDouble)/100);


        char[] charArray = copyCharArrayFromInt(intArray);
        long timeFirstSortChar = System.nanoTime();
        for (int i = 0; i < 100; i++){
            char[] arrayInsertion = copyCharArray(charArray);
            sortCharInsertion(arrayInsertion);
            char[] arraySelection = copyCharArray(charArray);
            sortCharSelection(arraySelection);
            char[] arrayMerge = copyCharArray(charArray);
            sortCharMerge(arrayMerge);
            char[] arrayHeapsort = copyCharArray(charArray);
            sortCharHeapsort(arrayHeapsort);
            char[] arrayQuicksort = copyCharArray(charArray);
            sortCharQuicksort(arrayQuicksort);
            char[] arrayBubble = copyCharArray(charArray);
            sortCharBubble(arrayBubble);
            char[] arrayBucket = copyCharArray(charArray);
            sortCharBucket(arrayBucket);
            char[] arrayRadix = copyCharArray(charArray);
            sortCharRadix(arrayRadix);
        }
        long timeSecondSortChar = System.nanoTime();
        System.out.println("Sort table of chars: " + (timeSecondSortChar-timeFirstSortChar)/100);


        float[] floatArray = copyFloatArrayFromInt(intArray);
        long timeFirstSortFloat = System.nanoTime();
        for (int i = 0; i < 100; i++){
            float[] arrayInsertion = copyFloatArray(floatArray);
            sortFloatInsertion(arrayInsertion);
            float[] arraySelection = copyFloatArray(floatArray);
            sortFloatSelection(arraySelection);
            float[] arrayMerge = copyFloatArray(floatArray);
            sortFloatMerge(arrayMerge);
            float[] arrayHeapsort = copyFloatArray(floatArray);
            sortFloatHeapsort(arrayHeapsort);
            float[] arrayQuicksort = copyFloatArray(floatArray);
            sortFloatQuicksort(arrayQuicksort);
            float[] arrayBubble = copyFloatArray(floatArray);
            sortFloatBubble(arrayBubble);
            float[] arrayBucket = copyFloatArray(floatArray);
            sortFloatBucket(arrayBucket);
            float[] arrayRadix = copyFloatArray(floatArray);
            sortFloatRadix(arrayRadix);

        }
        long timeSecondSortFloat = System.nanoTime();
        System.out.println("Sort table of float: " + (timeSecondSortFloat-timeFirstSortFloat)/100);
    }

    //---------------------------------->sort int<-----------------------------------------
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
        int base = array[end];
        int i = (begin-1);
        for (int k = begin; k < end; k++) {
            if (array[k] <= base) {
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
        int maxValue = getMaxInt(numbers);
        int minValue = getMinInt(numbers);
        int cap = 1;
        maxValue = Math.max(maxValue, -minValue);
        while (maxValue > 10){
            maxValue = maxValue / 10;
            cap = cap * 10;
        }

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
                int numberOfBucket = (positArray[i] / cap) + 1;
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
                int numberOfBucket = (negatArray[i] / cap) + 1;
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

    private static int getMinInt(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }



    //---------------------------------->sort double<-----------------------------------------
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
        double base = array[end];
        int i = (begin-1);
        for (int k = begin; k < end; k++) {
            if (array[k] <= base) {
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
        double maxValue = getMaxDouble(numbers);
        double minValue = getMinDouble(numbers);
        int cap = 1;
        maxValue = Math.max(maxValue, -minValue);
        while (maxValue > 10){
            maxValue = maxValue / 10;
            cap = cap * 10;
        }

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
                int numberOfBucket = (int) (positArray[i] / cap) + 1;
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
                int numberOfBucket = (int) (negatArray[i] / cap) + 1;
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
        int approximation = 1000000;
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

    private static double getMinDouble(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }


    //---------------------------------->sort char<-----------------------------------------
    public static void sortCharInsertion(char[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int k = i - 1;
            while (k >= 0 && numbers[k] > key) {
                numbers[k + 1] = numbers[k];
                k = k - 1;
            }
            numbers[k + 1] = (char) key;
        }
    }

    public static void sortCharSelection(char[] numbers){
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
                numbers[minElementIndex] = (char) temp;
            }
        }
    }

    public static void sortCharMerge(char[] numbers){
        mergeSortForChar(numbers, numbers.length);
    }

    public static void mergeSortForChar(char[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        char[] k = new char[mid];
        char[] r = new char[n - mid];

        for (int i = 0; i < mid; i++) {
            k[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSortForChar(k, mid);
        mergeSortForChar(r, n - mid);

        mergeChar(array, k, r, mid, n - mid);
    }

    public static void mergeChar(char[] array, char[] l, char[] r, int left, int right) {
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

    public static void sortCharHeapsort(char[] numbers){
        int n = numbers.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapifyChar(numbers, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            char temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            heapifyChar(numbers, i, 0);
        }
    }

    private static void heapifyChar(char[] array, int n, int i){
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
            char temp = array[i];
            array[i] = array[largestNumber];
            array[largestNumber] = temp;
            heapifyChar(array, n, largestNumber);
        }
    }

    public static void sortCharQuicksort(char[] numbers){
        quickSortChar(numbers, 0, numbers.length-1);
    }

    private static void quickSortChar(char[] array, int begin, int end) {
        if (begin < end) {
            int partIndex = partChar(array, begin, end);

            quickSortChar(array, begin, partIndex-1);
            quickSortChar(array, partIndex+1, end);
        }
    }

    private static int partChar(char[] array, int begin, int end) {
        int base = array[end];
        int i = (begin-1);
        for (int k = begin; k < end; k++) {
            if (array[k] <= base) {
                i++;

                char temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        char temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i+1;
    }

    public static void sortCharBubble(char[] numbers){
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    char temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void sortCharBucket(char[] numbers){
        int countPositive = 0;
        int countZeroes = 0;
        int maxValue = getMaxChar(numbers);
        int minValue = getMinChar(numbers);
        int cap = 1;
        maxValue = Math.max(maxValue, -minValue);
        while (maxValue > 10){
            maxValue = maxValue / 10;
            cap = cap * 10;
        }

        for (int i : numbers){
            if (i > 0) countPositive++;
            if (i == 0) countZeroes++;
        }
        int[] positArray = new int[countPositive];
        int count = 0;
        for (int i : numbers){
            if (i > 0){
                positArray[count] = i;
                count++;
            }
        }
        int[][] positiveBucket = new int[11][positArray.length+1];
        if (positArray.length > 0){
            for (int i = 0; i < 11; i ++){
                positiveBucket[i][0] = 1;
            }
            for (int i = 0; i < positArray.length; i ++){
                int numberOfBucket = (positArray[i] / cap) + 1;
                int emptyBucket = positiveBucket[numberOfBucket][0];
                positiveBucket[numberOfBucket][emptyBucket] = positArray[i];
                positiveBucket[numberOfBucket][0]++;
            }
            for (int i = 0; i < 11; i++){
                positiveBucket[i][0] = 0;
                sortIntInsertion(positiveBucket[i]);
            }
        }

        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length;){
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
            numbers[i] = (char) result[i];
        }
    }



    public static void sortCharRadix(char[] numbers){
        int max = getMaxChar(numbers);
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
                numbers[i] = (char) - negatArray[countNeg];
                countNeg++;
            } else {
                numbers[i] = (char) positArray[countPos];
                countPos++;
            }
        }
    }

    private static void countingSortChar(char[] array, int size, int place) {
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
            array[i] = (char) output[i];
        }
    }


    private static char getMaxChar(char[] array) {
        char max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static char getMinChar(char[] array) {
        char min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //---------------------------------->sort float<-----------------------------------------
    public static void sortFloatInsertion(float[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            float key = numbers[i];
            int k = i - 1;
            while (k >= 0 && numbers[k] > key) {
                numbers[k + 1] = numbers[k];
                k = k - 1;
            }
            numbers[k + 1] = key;
        }
    }

    public static void sortFloatSelection(float[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            int minElementIndex = i;
            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[minElementIndex] > numbers[k]) {
                    minElementIndex = k;
                }
            }

            if (minElementIndex != i) {
                float temp = numbers[i];
                numbers[i] = numbers[minElementIndex];
                numbers[minElementIndex] = temp;
            }
        }
    }

    public static void sortFloatMerge(float[] numbers){
        mergeSortForFloat(numbers, numbers.length);
    }

    public static void mergeSortForFloat(float[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        float[] k = new float[mid];
        float[] r = new float[n - mid];

        for (int i = 0; i < mid; i++) {
            k[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSortForFloat(k, mid);
        mergeSortForFloat(r, n - mid);

        mergeFloat(array, k, r, mid, n - mid);
    }

    public static void mergeFloat(float[] array, float[] l, float[] r, int left, int right) {
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

    public static void sortFloatHeapsort(float[] numbers){
        int n = numbers.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapifyFloat(numbers, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            float temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            heapifyFloat(numbers, i, 0);
        }
    }

    private static void heapifyFloat(float[] array, int n, int i) {
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
            float temp = array[i];
            array[i] = array[largestNumber];
            array[largestNumber] = temp;
            heapifyFloat(array, n, largestNumber);
        }
    }

    public static void sortFloatQuicksort(float[] numbers){
        quickSortFloat(numbers, 0, numbers.length-1);
    }

    private static void quickSortFloat(float[] array, int begin, int end) {
        if (begin < end) {
            int partIndex = partFloat(array, begin, end);

            quickSortFloat(array, begin, partIndex-1);
            quickSortFloat(array, partIndex+1, end);
        }
    }

    private static int partFloat(float[] array, int begin, int end) {
        float base = array[end];
        int i = (begin-1);
        for (int k = begin; k < end; k++) {
            if (array[k] <= base) {
                i++;

                float temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        float temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i+1;
    }

    public static void sortFloatBubble(float[] numbers){
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    float temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void sortFloatBucket(float[] numbers){
        float maxValue = getMaxFloat(numbers);
        float minValue = getMinFloat(numbers);
        int cap = 1;
        maxValue = Math.max(maxValue, -minValue);
        while (maxValue > 10){
            maxValue = maxValue / 10;
            cap = cap * 10;
        }

        int countPositive = 0;
        int countZeroes = 0;
        for (float i : numbers){
            if (i > 0) countPositive++;
            if (i == 0) countZeroes++;
        }
        int countNegative = numbers.length - countPositive;
        float[] positArray = new float[countPositive];
        float[] negatArray = new float[countNegative];
        int count = 0;
        for (float i : numbers){
            if (i > 0){
                positArray[count] = i;
                count++;
            }
        }
        count = 0;
        for (float i : numbers){
            if (i < 0){
                negatArray[count] = 0 - i;
                count++;
            }
        }
        float[][] positiveBucket = new float[11][positArray.length+1];
        if (positArray.length > 0){
            for (int i = 0; i < 11; i ++){
                positiveBucket[i][0] = 1;
            }
            for (int i = 0; i < positArray.length; i ++){
                int numberOfBucket = (int) (positArray[i] / cap) + 1;
                float emptyBucket = positiveBucket[numberOfBucket][0];
                positiveBucket[numberOfBucket][(int) emptyBucket] = positArray[i];
                positiveBucket[numberOfBucket][0]++;
            }
            for (int i = 0; i < 11; i++){
                positiveBucket[i][0] = 0;
                sortFloatInsertion(positiveBucket[i]);
            }
        }

        float[][] negativeBucket = new float[11][negatArray.length+1];
        if (negatArray.length > 0){
            for (int i = 0; i < 11; i ++){
                negativeBucket[i][0] = 1;
            }
            for (int i = 0; i < negatArray.length; i ++){
                int numberOfBucket = (int) (negatArray[i] / cap) + 1;
                float emptyBucket = negativeBucket[numberOfBucket][0];
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
                sortFloatInsertion(negativeBucket[i]);
            }

        }

        float[] result = new float[numbers.length];
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

    public static void sortFloatRadix(float[] numbers){
        float max = getMaxFloat(numbers);
        if (max < 0){
            max = - max;
        }
        int countPositive = 0;
        for (float i : numbers){
            if (i >= 0) countPositive++;
        }
        int countNegative = numbers.length - countPositive;
        float[] positArray = new float[countPositive];
        float[] negatArray = new float[countNegative];
        int count = 0;
        for (float i : numbers){
            if (i >= 0){
                positArray[count] = i;
                count++;
            }
        }
        count = 0;
        for (float i : numbers){
            if (i < 0){
                negatArray[count] = 0 - i;
                count++;
            }
        }

        if (positArray.length != 0){
            for (int place = 1; max / place > 0; place *= 10) {
                countingSortFloat(positArray, positArray.length, place);
            }
        }

        if (negatArray.length != 0){
            for (int place = 1; max / place > 0; place *= 10) {
                countingSortFloat(negatArray, negatArray.length, place);
            }
            for(int i=0; i<negatArray.length/2; i++){
                float temp = negatArray[i];
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

    private static void countingSortFloat(float[] array, int size, int place) {
        float[] output = new float[size + 1];
        double max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        float[] count = new float[(int) (max * 100 + 1)];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }
        int approximation = 100000;
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

    private static float getMaxFloat(float[] array) {
        float max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static float getMinFloat(float[] array) {
        float min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }


    //-------------------------------------->for tests<----------------------------------------
    private static int rInt(){
        if (Math.random() > 0.5){
            return (int) (Math.random() * 1000);
        } else {
            return (int) (-Math.random() * 1000);
        }
    }

    private static double rDouble(){
        if (Math.random() > 0.5){
            return Math.random() * 1000;
        } else {
            return -Math.random() * 1000;
        }
    }

    private static char rChar(){
        int i = (int) ((Math.random() * (126 - 33)) + 33) * 10;
        return (char) i;
    }

    private static float rFloat(){
        if (Math.random() > 0.5){
            return (float) Math.random();
        } else {
            return (float) - Math.random();
        }
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

    private static int[] copyIntArray(int[] array){
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }

    private static double[] copyDoubleArray(double[] array){
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }

    private static char[] copyCharArray(char[] array){
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }

    private static float[] copyFloatArray(float[] array){
        float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }


    private static double[] copyDoubleArrayFromInt(int[] array){
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }

    private static char[] copyCharArrayFromInt(int[] array){
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = (char) array[i];
        }
        return result;
    }

    private static float[] copyFloatArrayFromInt(int[] array){
        float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }
}
