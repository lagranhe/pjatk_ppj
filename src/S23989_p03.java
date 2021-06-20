import java.io.*;

public class S23989_p03 {

    public static void main(String[] args) {
        S23989_p03 s = new S23989_p03();
        //change path to your directory
        String path = "/home/mich/Documents/PJATK/PPJ/TestProjects/src/";

        String inputFile1 = path + "dane01.txt";
        String inputFile2 = path + "dane02.txt";
        String outputFileSortSka = path + "sortSka.txt";
        String outputFileSortName = path + "sortName.txt";
        String outputFileSortSkaBin = path + "sortSka.bin";

        Student[] arrayOfStudents = s.getArrayOfStudentsFromTwoFiles(inputFile1, inputFile2);

        s.sortBubbleOfStudentArrayBySka(arrayOfStudents);
        s.outputStudentArrayToTextFile(outputFileSortSka, arrayOfStudents);
        s.outputStudentArrayToBinaryFile(outputFileSortSkaBin, arrayOfStudents);

        s.sortBubbleOfStudentArrayByName(arrayOfStudents);
        s.outputStudentArrayToTextFile(outputFileSortName, arrayOfStudents);

        Student[] arrayOfStudentsFromBinary = s.inputStudentArrayFromBinaryFile(outputFileSortSkaBin);
        for (Student stud : arrayOfStudentsFromBinary){
            System.out.println(stud);
        }
    }

    private Student[] getArrayOfStudentsFromTwoFiles (String pathToFile1, String pathToFile2){
        Student[] arrayOfStudents = new Student[0];
        int countOfStudents = getCountOfStudentsFromFile(pathToFile1) +
                getCountOfStudentsFromFile(pathToFile2);
        try {
            BufferedReader readerFirstFile = new BufferedReader(new FileReader(pathToFile1));
            BufferedReader readerSecondFile = new BufferedReader(new FileReader(pathToFile2));
            arrayOfStudents = new Student[countOfStudents];
            countOfStudents = 0;
            while (readerFirstFile.ready()){
                String personString = readerFirstFile.readLine();
                String[] personData = personString.split(" ");
                String index = personData[0];
                String firstName = personData[1].split("(?=\\p{Upper})")[0];
                String secondName = personData[1].split("(?=\\p{Upper})")[1];
                int yearOfBirth = Integer.parseInt(personData[2]);
                arrayOfStudents[countOfStudents] = new Student(firstName, secondName, yearOfBirth, index);
                countOfStudents++;
            }

            while (readerSecondFile.ready()){
                String personString = readerSecondFile.readLine();
                String[] personData = personString.split(" ");
                String index = personData[0];
                String firstName = personData[1].split("(?=\\p{Upper})")[0];
                String secondName = personData[1].split("(?=\\p{Upper})")[1];
                int yearOfBirth = Integer.parseInt(personData[2]);
                arrayOfStudents[countOfStudents] = new Student(firstName, secondName, yearOfBirth, index);
                countOfStudents++;
            }
            readerFirstFile.close();
            readerSecondFile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return arrayOfStudents;
    }

    private void outputStudentArrayToTextFile(String pathToFile, Student[] studentArray){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile));
            for (Student student : studentArray){
                String outputString = student.getIndex() + " "
                        + student.getFirstName()
                        + student.getSecondName() + " "
                        + student.getYearOfBirth() + "\n";
                writer.write(outputString);
            }
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void outputStudentArrayToBinaryFile(String pathToFile, Student[] studentArray){
        try{
            FileOutputStream writer = new FileOutputStream(pathToFile);
            for (Student student : studentArray){
                String outputString = student.getFirstName()
                        + student.getIndex().substring(1)
                        + student.getSecondName()
                        + (student.getYearOfBirth()-1900);

                byte[] data = outputString.getBytes();
                for (byte b : data){
                    writer.write(b);
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private Student[] inputStudentArrayFromBinaryFile(String pathToFile){
        Student[] resultArray = new Student[getCountOfStudentsFromBinaryFile(pathToFile)];
        StringBuilder s = new StringBuilder("");
        try {
            FileInputStream inputStream = new FileInputStream(pathToFile);
            int i;
            while ((i=inputStream.read()) != -1){
                s.append((char) i);
            }
            inputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        String[] lines = s.toString().split("(?=\\p{Upper})");
        int count = 0;
        for (int i = 0; i < resultArray.length * 2; i += 2){
            String firstName = lines[i].replaceAll("\\d", "");
            String index = "s" + lines[i].replaceAll("[^\\d.]", "");
            String secondName = lines[i+1].replaceAll("\\d", "");
            int yearOfBirth = Integer.parseInt(lines[i+1].replaceAll("[^\\d.]", "")) + 1900;
            resultArray[count] = new Student(firstName, secondName, yearOfBirth, index);
            count++;
        }
        return resultArray;
    }

    private int getCountOfStudentsFromFile(String file){
        int countOfPerson = 0;
        try {
            BufferedReader readerFirstFile = new BufferedReader(new FileReader(file));
            while (readerFirstFile.ready()) {
                countOfPerson++;
                readerFirstFile.readLine();
            }
            readerFirstFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOfPerson;
    }
    private int getCountOfStudentsFromBinaryFile(String file){
        StringBuilder s = new StringBuilder("");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int i;
            while ((i=inputStream.read()) != -1){
                s.append((char) i);
            }
            inputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        String[] lines = s.toString().split("(?=\\p{Upper})");
        return lines.length / 2;
    }

    public void sortBubbleOfStudentArrayBySka(Student[] students) {
        String[] arrayOfSka = new String[students.length];
        for (int i = 0; i < arrayOfSka.length; i++){
            arrayOfSka[i] = students[i].getIndex();
        }
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (isFirstGreaterThanSecond(arrayOfSka[j],arrayOfSka[j + 1])) {
                    String tempName = arrayOfSka[j];
                    arrayOfSka[j] = arrayOfSka[j + 1];
                    arrayOfSka[j + 1] = tempName;

                    Student tempStudents = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tempStudents;

                }
            }
        }
    }

    public void sortBubbleOfStudentArrayByName(Student[] students) {
        String[] arrayOfSka = new String[students.length];
        for (int i = 0; i < arrayOfSka.length; i++){
            arrayOfSka[i] = students[i].getFirstName();
        }
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (isFirstGreaterThanSecond(arrayOfSka[j],arrayOfSka[j + 1])) {
                    String tempName = arrayOfSka[j];
                    arrayOfSka[j] = arrayOfSka[j + 1];
                    arrayOfSka[j + 1] = tempName;

                    Student tempStudents = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tempStudents;

                }
            }
        }
    }

    public boolean isFirstGreaterThanSecond(String firstString, String secondString){
        char[] firstChars = firstString.toCharArray();
        char[] secondChars = secondString.toCharArray();
        int min = Math.min(firstChars.length, secondChars.length);
        for (int i = 0; i < min; i++){
            if (firstChars[i] > secondChars[i]){
                return true;
            } else if (firstChars[i] < secondChars[i]){
                return false;
            } else {
            }
        }
        if (firstChars.length == min){
            return true;
        } else {
            return false;
        }
    }


    private class Person {
        private String firstName;
        private String secondName;
        private int yearOfBirth;

        public Person(String firstName, String secondName, int yearOfBirth) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.yearOfBirth = yearOfBirth;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public int getYearOfBirth() {
            return yearOfBirth;
        }
    }

    private class Student extends Person {

        private String index;

        public Student(String firstName, String secondName, int yearOfBirth, String index) {
            super(firstName, secondName, yearOfBirth);
            this.index = index;
        }

        public String getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "index='" + index + '\'' +
                    ", firstName='" + super.firstName + '\'' +
                    ", secondName='" + super.secondName + '\'' +
                    ", yearOfBirth=" + super.yearOfBirth +
                    '}';
        }
    }
}
