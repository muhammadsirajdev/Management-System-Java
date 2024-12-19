import java.util.ArrayList;
import java.util.Collections;

public class Course {
    private int courseId;
    private String title;
    private int credits;
    private Teacher assignedTeacher;
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private ArrayList<Double> grades = new ArrayList<>();
    private static int totalCourses = 0;

    public Course(){
        courseId = 0;
        title = null;
        credits = 0;
        assignedTeacher = null;
        totalCourses++;
    }

    public Course(int courseId, String title, int credits, Teacher assignedTeacher) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.assignedTeacher = assignedTeacher;
        totalCourses++;
    }

    // getters
    public static int getTotalCourses(){return totalCourses;}

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    // setters 
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }


    public void addStudent(Student student){
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        enrolledStudents.add(student);
        grades.add(0.0);
        System.out.println("Student "+student.getStudentId()+" added to " + title);
    }

    public void removeStudent(Student student){
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            enrolledStudents.remove(index);
            grades.remove(index);
            System.out.println("Student "+student.getStudentId()+" removed from " + title);
        } else {
            System.out.println("Student "+student.getStudentId()+" is not enrolled in " + title);
        }
    }

    public void setGrade(Student student, double grade) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            grades.set(index, grade);
        } else {
            System.out.println("Student " + student.getStudentId() + " is not enrolled in " + title);
        }
    }

    public double getGrade(Student student) {
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            return grades.get(index);
        } else {
            System.out.println("Student " + student.getStudentId() + " is not enrolled in " + title);
            return 0.0;
        }
    }

    public void calculateAverageGrade() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled in " + title);
            return;
        }

        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        double average = total / grades.size();
        System.out.println("Average grade for " + title + " is " + average);
    }

    public double calculateMedianGrade(){

        int size = grades.size();
        boolean isEven = size % 2 == 0;
        ArrayList<Double> sortedGrades = new ArrayList<>(grades);
        Collections.sort(sortedGrades);

        if (isEven) {
            return (sortedGrades.get(size / 2 - 1) + sortedGrades.get(size / 2)) / 2.0;
        } else {
            return sortedGrades.get(size / 2);
        }
    }
}

