import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // School details
        System.out.println("Enter your School Name: ");
        String schoolName = input.nextLine();

        System.out.println("Enter your Teacher's name: ");
        String teacherName = input.nextLine();

        System.out.println("Enter your Grade: ");
        int grade = input.nextInt();

        System.out.println("Enter the Year: ");
        int year = input.nextInt();

        // Student Records
        System.out.println("Enter the number of students you want to record: ");
        int numberOfStudents = input.nextInt();
        input.nextLine(); // clear buffer

        // Arrays
        String[] studentsName = new String[numberOfStudents];
        double[] englishMarks = new double[numberOfStudents];
        double[] mathMarks = new double[numberOfStudents];
        double[] historyMarks = new double[numberOfStudents];
        double[] geographyMarks = new double[numberOfStudents];
        double[] scienceMarks = new double[numberOfStudents];
        double[] programmingMarks = new double[numberOfStudents];
        double[] totalMarks = new double[numberOfStudents];
        char[] rank = new char[numberOfStudents];

        int index = 0;

        while (index < numberOfStudents) {
            System.out.println("Details for student " + (index + 1));
            System.out.println("Enter Student's " + (index + 1) + " name: ");
            studentsName[index] = input.nextLine();

            System.out.println("Enter English Marks: ");
            englishMarks[index] = input.nextDouble();

            System.out.println("Enter Math Marks: ");
            mathMarks[index] = input.nextDouble();

            System.out.println("Enter History Marks: ");
            historyMarks[index] = input.nextDouble();

            System.out.println("Enter Geography Marks: ");
            geographyMarks[index] = input.nextDouble();

            System.out.println("Enter Science Marks: ");
            scienceMarks[index] = input.nextDouble();

            System.out.println("Enter Programming Marks: ");
            programmingMarks[index] = input.nextDouble();
            input.nextLine(); // clear newline

            // Total Marks
            totalMarks[index] = englishMarks[index] + mathMarks[index] + historyMarks[index]
                    + geographyMarks[index] + scienceMarks[index] + programmingMarks[index];

            // Ranking (classic if-else)
            if (totalMarks[index] >= 540) {
                rank[index] = 'A';
            } else if (totalMarks[index] >= 480) {
                rank[index] = 'B';
            } else if (totalMarks[index] >= 420) {
                rank[index] = 'C';
            } else if (totalMarks[index] >= 360) {
                rank[index] = 'D';
            } else {
                rank[index] = 'F';
            }

            index++;
        }

        // Totals
        double totalEnglishMarks = 0, totalMathMarks = 0, totalHistoryMarks = 0,
                totalGeographyMarks = 0, totalScienceMarks = 0,
                totalProgrammingMarks = 0, cumulativeTotalMarks = 0;

        // Rank counts
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (index = 0; index < numberOfStudents; index++) {
            totalEnglishMarks += englishMarks[index];
            totalMathMarks += mathMarks[index];
            totalHistoryMarks += historyMarks[index];
            totalGeographyMarks += geographyMarks[index];
            totalScienceMarks += scienceMarks[index];
            totalProgrammingMarks += programmingMarks[index];
            cumulativeTotalMarks += totalMarks[index];

            // Classic switch statement
            switch (rank[index]) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                default:
                    countF++;
                    break;
            }
        }

        // Averages
        double averageEnglish = totalEnglishMarks / numberOfStudents;
        double averageMath = totalMathMarks / numberOfStudents;
        double averageHistory = totalHistoryMarks / numberOfStudents;
        double averageGeography = totalGeographyMarks / numberOfStudents;
        double averageScience = totalScienceMarks / numberOfStudents;
        double averageProgramming = totalProgrammingMarks / numberOfStudents;
        double averageTotalMarks = cumulativeTotalMarks / numberOfStudents;

        // Header printing
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%70s%n", "School Name : " + schoolName);
        System.out.printf("%68s%n", "Teacher : " + teacherName);
        System.out.printf("%66s%n", "Grade : " + grade);
        System.out.printf("%64s%n", "Year : " + year);
        System.out.println("==================================================================================================================================");

        // Table Header - tighter grouping (English/Math, History/Geography)
        System.out.printf("%-25s %-10s %-10s %-10s %-10s %-10s %-14s %-10s %-6s%n",
                "Student Name", "English", "Math", "History", "Geography",
                "Science", "Programming", "Total", "Rank");
        System.out.println("==================================================================================================================================");

        // Print rows
        for (index = 0; index < numberOfStudents; index++) {
            System.out.printf("%-25s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-14.2f %-10.2f %-6s%n",
                    studentsName[index],
                    englishMarks[index], mathMarks[index], historyMarks[index],
                    geographyMarks[index], scienceMarks[index], programmingMarks[index],
                    totalMarks[index], rank[index]);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        // Totals row
        System.out.printf("%-25s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-14.2f %-10.2f%n",
                " ",
                totalEnglishMarks, totalMathMarks, totalHistoryMarks,
                totalGeographyMarks, totalScienceMarks,
                totalProgrammingMarks, cumulativeTotalMarks);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        // Averages row
        System.out.printf("%-25s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-14.2f %-10.2f%n",
                " ",
                averageEnglish, averageMath, averageHistory,
                averageGeography, averageScience,
                averageProgramming, averageTotalMarks);

        System.out.println("==================================================================================================================================");

        // Rank summary
        System.out.printf("%30sRanks: A's=%6d  B's=%6d  C's=%6d  D's=%6d  F's=%6d%n",
                "", countA, countB, countC, countD, countF);
        System.out.println("==================================================================================================================================");
  }
}
