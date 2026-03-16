package NewMethodForScanner;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Adi", 101);
        int[] marks = {85, 90, 78};
        ReportCard reportCard = new ReportCard(marks);
        GradeCalculator gradeCalculator = new DefaultGradeCalculator();
        ReportRepository repository = new DatabaseReportRepository();
        ReportPrinter printer = new ReportPrinter();
        repository.save(student, reportCard);
        printer.printReport(student, reportCard, gradeCalculator);
    }
}
// SRP: only student data
class Student {
    private String name;
    private int rollNo;
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public int getRollNo() {
        return rollNo;
    }
}
// SRP: marks & calculation
class ReportCard {
    private int[] marks;
    public ReportCard(int[] marks) {
        this.marks = marks;
    }
    public int calculateTotal() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum;
    }
    public double calculatePercentage() {
        return calculateTotal() / (double) marks.length;
    }
}
// OCP + DIP
interface GradeCalculator {
    char calculateGrade(double percentage);
}
class DefaultGradeCalculator implements GradeCalculator {
    @Override
    public char calculateGrade(double percentage) {
        if (percentage >= 90) return 'A';
        if (percentage >= 75) return 'B';
        if (percentage >= 60) return 'C';
        return 'D';
    }
}
// DIP
interface ReportRepository {
    void save(Student student, ReportCard reportCard);
}
class DatabaseReportRepository implements ReportRepository {
    @Override
    public void save(Student student, ReportCard reportCard) {
        System.out.println("Report saved for: " + student.getName());
    }
}
// SRP
class ReportPrinter {
    public void printReport(
            Student student,
            ReportCard reportCard,
            GradeCalculator gradeCalculator) {

        System.out.println("----- REPORT CARD -----");
        System.out.println("Name      : " + student.getName());
        System.out.println("Roll No   : " + student.getRollNo());
        System.out.println("Percentage: " + reportCard.calculatePercentage());
        System.out.println("Grade     : " +
                gradeCalculator.calculateGrade(reportCard.calculatePercentage()));
    }
}
