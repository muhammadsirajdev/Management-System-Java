package Semester_Project;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private String title;  
    private int credits;
    private Teacher assignedTeacher;  
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private ArrayList<Double> grades = new ArrayList<>();

    public Course(){
        courseId = 0;
        title = null;
        credits = 0;
        assignedTeacher = null;
    }

    public Course(int courseId, String title, int credits, Teacher assignedTeacher) { 
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.assignedTeacher = assignedTeacher;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Teacher getAssignedTeacher() { 
        return assignedTeacher;
    }

    public void setAssignedTeacher(Teacher assignedTeacher) { 
        this.assignedTeacher = assignedTeacher;
    }

    public void addStudent(Student student){
        enrolledStudents.add(student);
        grades.add(0.0); 
        System.out.println("Student "+student.getStudentId()+"  added to " + title);
    }

    public void removeStudent(Student student){
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            enrolledStudents.remove(index);
            grades.remove(index);
            System.out.println("Student "+student.getStudentId()+"  removed from " + title);
        } else {
            System.out.println("Student "+student.getStudentId()+"  is not enrolled in " + title);
        }
    }

    public void setGrade(Student student, double grade) {
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

}
