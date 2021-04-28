import java.math.BigInteger;

public class S23989_p01 {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {


        for (int system = 2; system < 17; system ++){
            for (int count = 0; count < 5 ; count++){
                char[] first = new char[]{ r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r()};
                char[] second = new char[]{r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r(), r(), r(), r(), r(), r(),
                        r(), r(), r()};
                calc(first, second, '+', system);
                testCalc(first, second, '+', system);
            }
        }
    }

    public static void calc(char[] number1, char[] number2, char operator, int system){
        String decimalResultAfterOperation =
                getStringDecimalNumberAfterOperationWithNumbers(number1, number2, operator);
        String result = getNumberInNumeralSystemFromDecimal(decimalResultAfterOperation, system);
        System.out.println("Result of an operation on number:");
        System.out.println(getStringFromCharArray(number1));
        System.out.println(operator);
        System.out.println(getStringFromCharArray(number2));
        System.out.println("Decimal result is :");
        System.out.println(ANSI_RED + decimalResultAfterOperation + ANSI_RESET);
        System.out.println("in numeral system: " + system + " is ---->");
        System.out.println(ANSI_GREEN + result + ANSI_RESET);
    }

    private static int add(int i, int j) {
        int uncommonBitsFromBoth = i ^ j;
        int commonBitsFromBoth = i & j;
        if (commonBitsFromBoth == 0)
            return uncommonBitsFromBoth;
        return add (
                uncommonBitsFromBoth,
                commonBitsFromBoth << 1
        );
    }

    private static int subtract(int i, int j) {
        while (j != 0) {
            int borrow = (~i) & j;
            i = i ^ j;
            j = borrow << 1;
        }
        return i;
    }

    private static int[] charArrayToIntegerArray (char[] number){
        StringBuilder stringNumber1 = new StringBuilder();
        for (char c : number) {
            stringNumber1.append(c);
        }
        String[] stringArray = new String[number.length/8+1];
        for (int count = number.length/8+1; count > 0; count--){
            String result = stringNumber1.substring(Math.max(stringNumber1.length() - 8, 0));
            stringArray[count-1] = result;
            stringNumber1.delete(Math.max((stringNumber1.length() - 8), 0), stringNumber1.length());
        }
        int[] result = new int [stringArray.length];
        for (int i = 0; i < result.length; i ++){
            result[i] = Integer.parseInt(stringArray[i]);
        }
        return result;
    }

    private static boolean isNumberRankMoreThenEight (int number){
        return number >= 100000000;
    }

    private static boolean isNumberLessThenZero (int number){
        return number < 0;
    }

    private static boolean isFirstArrayOfNumberHigherOrEqualThenSecond(int[] first, int[] second){
        if (first.length > second.length){
            return true;
        } else if (first.length == second.length){
            int count = 0;
            while(count!=first.length-1){
                if (first[count] > second[count]){
                    return true;
                } else if (first[count] < second[count]){
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    private static String getStringDecimalNumberAfterOperationWithNumbers(char[] number1,
                                                                          char[] number2,
                                                                          char operator){
        System.out.println("============================================");
        System.out.println("CALC METHOD");
        int[] integerNumbersFirst = charArrayToIntegerArray(number1);
        int[] integerNumbersSecond = charArrayToIntegerArray(number2);
        int firstCount = integerNumbersFirst.length;
        int secondCount = integerNumbersSecond.length;
        String[] resultOfOperationAddOrSubtract = new String[Math.max(firstCount, secondCount) + 1];
        int resultCount = resultOfOperationAddOrSubtract.length;
        int firstInteger = integerNumbersFirst[firstCount - 1];
        int secondInteger = integerNumbersSecond[secondCount - 1];
        printIntArray("First array", integerNumbersFirst);
        printIntArray("Second array", integerNumbersSecond);
        boolean isFirstBiggerThenOne = true;
        if (operator == '+') {
            while(resultCount > 0) {
                resultOfOperationAddOrSubtract[resultCount - 1] = String.valueOf(add(firstInteger, secondInteger));
                --firstCount;
                firstInteger = firstCount - 1 >= 0 ? integerNumbersFirst[firstCount - 1] : 0;
                --secondCount;
                secondInteger = secondCount - 1 >= 0 ? integerNumbersSecond[secondCount - 1] : 0;
                --resultCount;
            }
        } else if (operator == '-') {
            for(isFirstBiggerThenOne = isFirstArrayOfNumberHigherOrEqualThenSecond(integerNumbersFirst, integerNumbersSecond); resultCount > 0; --resultCount) {
                if (isFirstBiggerThenOne) {
                    resultOfOperationAddOrSubtract[resultCount - 1] = String.valueOf(subtract(firstInteger, secondInteger));
                } else {
                    resultOfOperationAddOrSubtract[resultCount - 1] = String.valueOf(subtract(secondInteger, firstInteger));
                }

                --firstCount;
                firstInteger = firstCount - 1 >= 0 ? integerNumbersFirst[firstCount - 1] : 0;
                --secondCount;
                secondInteger = secondCount - 1 >= 0 ? integerNumbersSecond[secondCount - 1] : 0;
            }
        }

        printStringArray("Result array        ", resultOfOperationAddOrSubtract);

        for(int i = resultOfOperationAddOrSubtract.length - 1; i > 0; --i) {
            if (isNumberRankMoreThenEight(Integer.parseInt(resultOfOperationAddOrSubtract[i]))) {
                resultOfOperationAddOrSubtract[i - 1] = String.valueOf(Integer.parseInt(resultOfOperationAddOrSubtract[i - 1]) + 1);
                resultOfOperationAddOrSubtract[i] = String.valueOf(Integer.parseInt(resultOfOperationAddOrSubtract[i]) - 100000000);
            } else if (isNumberLessThenZero(Integer.parseInt(resultOfOperationAddOrSubtract[i]))) {
                resultOfOperationAddOrSubtract[i] += 100000000;
                resultOfOperationAddOrSubtract[i - 1] = String.valueOf(Integer.parseInt(resultOfOperationAddOrSubtract[i - 1]) - 1);
            }
        }

        printStringArray("Correct result array", resultOfOperationAddOrSubtract);
        String resultOfCalculationDecimal = "";
        if (!isFirstBiggerThenOne) {
            resultOfCalculationDecimal = "-" + resultOfOperationAddOrSubtract[0];
        }

        for(int s = 1; s < resultOfOperationAddOrSubtract.length; ++s) {
            String resultWithoutZeroes = resultOfOperationAddOrSubtract[s];
            int difference = 8 - resultWithoutZeroes.length();

            for(int i = 0; i < difference; ++i) {
                resultOfCalculationDecimal = resultOfCalculationDecimal + "0";
            }

            resultOfCalculationDecimal = resultOfCalculationDecimal + resultWithoutZeroes;
        }

        return resultOfCalculationDecimal;
    }

    public static String getNumberInNumeralSystemFromDecimal(String decimalNumber, int system){
        boolean negativeNumberFlag = false;
        if (decimalNumber.contains("-")){
            negativeNumberFlag = true;
            decimalNumber = decimalNumber.substring(1);
        }
        while(true){
            if (decimalNumber.startsWith("0") && decimalNumber.length()!=0){
                decimalNumber = decimalNumber.substring(1);
            } else {
                break;
            }
        }

        StringBuilder binaryNumer = new StringBuilder("");
        int remainder = 0;
        String resultString = decimalNumber;
        int count = 0;
        while (true){
            char[] decimalNumbers = resultString.toCharArray();
            resultString = "";
            for (int i = 0; i < decimalNumbers.length; i ++){
                int number = Integer.parseInt(Character.toString(decimalNumbers[i]));
                int resultOfDivision = (number+remainder*10)/system;
                resultString += resultOfDivision;
                remainder = (number+remainder*10)%system;
            }
            count++;
            if (resultString.contains(".")){
                resultString = resultString.substring(resultString.length()-2);
            }
            while (resultString.startsWith("0")){
                resultString=resultString.substring(1);
            }
            String appendResult = "";
            if (remainder <= 9){
                appendResult = Integer.toString(remainder);
            } else {
                char secondPart = (char) (remainder+87);
                appendResult = Character.toString(secondPart);
            }
            binaryNumer.append(appendResult);
            remainder = 0;
            if (resultString.equals("")) break;
        }
        if (negativeNumberFlag){
            binaryNumer.append("-");
        }
        binaryNumer.reverse();
        return binaryNumer.toString();
    }


    private static String getStringFromCharArray(char[] chars){
        StringBuilder s = new StringBuilder();
        for (char i : chars){
            s.append(i);
        }
        return s.toString();
    }

    private static void printIntArray(String text, int[] intArray){
        System.out.print(text + " ");
        for (int i : intArray){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printStringArray(String text, String[] intArray){
        System.out.print(text + " ");
        for (String i : intArray){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //TESTING BIGINTEGER
    public static void testCalc(char[] number1, char[] number2, char operator, int system){
        BigInteger firstBigInteger = new BigInteger(getStringFromCharArray(number1));
        BigInteger secondBigInteger = new BigInteger(getStringFromCharArray(number2));
        BigInteger operationResult = new BigInteger("0");
        if (operator == '-'){
            operationResult = firstBigInteger.subtract(secondBigInteger);
        } else if (operator == '+'){
            operationResult = firstBigInteger.add(secondBigInteger);
        }
        String result = operationResult.toString(system);
        System.out.println("BigInteger decimal is :");
        System.out.println(ANSI_RED + operationResult.toString(10) + ANSI_RESET);
        System.out.println("biginteger result: " + system + " is ---->");
        System.out.println(ANSI_GREEN + result + ANSI_RESET);
        System.out.println("======================================================================");
    }

    private static char r(){
        int i = (int) ((Math.random() * (57 - 48)) + 48);
        return (char) i;
    }
}
