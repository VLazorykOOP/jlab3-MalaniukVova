import java.util.Date;

abstract class Exam {
    protected String subject;
    protected Date date;

    public Exam(String subject, Date date) {
        this.subject = subject;
        this.date = date;
    }

    public abstract void show();
}

class Test extends Exam {
    private int numberOfQuestions;

    public Test(String subject, Date date, int numberOfQuestions) {
        super(subject, date);
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public void show() {
        System.out.printf("Subject: %s, Date: %s, Type: Test, Number of Questions: %d%n",
                subject, date, numberOfQuestions);
    }
}

class ExamType extends Exam {
    private int totalMarks;

    public ExamType(String subject, Date date, int totalMarks) {
        super(subject, date);
        this.totalMarks = totalMarks;
    }

    @Override
    public void show() {
        System.out.printf("Subject: %s, Date: %s, Type: Exam, Total Marks: %d%n",
                subject, date, totalMarks);
    }
}

class FinalExam extends Exam {
    private int totalMarks;

    public FinalExam(String subject, Date date, int totalMarks) {
        super(subject, date);
        this.totalMarks = totalMarks;
    }

    @Override
    public void show() {
        System.out.printf("Subject: %s, Date: %s, Type: Final Exam, Total Marks: %d%n",
                subject, date, totalMarks);
    }
}

class Assessment extends Exam {
    private String assessmentType;

    public Assessment(String subject, Date date, String assessmentType) {
        super(subject, date);
        this.assessmentType = assessmentType;
    }

    @Override
    public void show() {
        System.out.printf("Subject: %s, Date: %s, Type: Assessment, Assessment Type: %s%n",
                subject, date, assessmentType);
    }
}

class task1 {
    public static void main(String[] args) {
        Exam[] exams = {
                new Test("Math", new Date(), 20),
                new ExamType("Science", new Date(), 100),
                new FinalExam("History", new Date(), 100),
                new Assessment("Literature", new Date(), "Project")
        };

        for (Exam exam : exams) {
            exam.show();
        }
    }
}
