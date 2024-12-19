import java.util.ArrayList;
import java.util.Date;


public class Teacher extends Person implements Reportable {
    private int teacherId;
    private String specialization;
    private Course[] assignedCourses = new Course[5];
    private  static int totalTeachers = 0;

    Teacher(){
        super();
        teacherId = 0;
        specialization = null;
        totalTeachers++;
    };

    public Teacher(String name, String email, Date dateOfBirth, int teacherId, String specialization) {
        super(name, email, dateOfBirth);
        this.teacherId = teacherId;
        this.specialization = specialization;
        totalTeachers++;
    }

    // Getters
    public static int getTotalTeachers() {
        return totalTeachers;
    }

    public Course[] getAssignedCourse() {
        return assignedCourses;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getSpecialization() {
        return specialization;
    }


    // setters 

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }



    public void assignCourse(Course course) {
        for (int i = 0; i < assignedCourses.length ; i++ ) {//as i've predefined that a teacher
            //can only have 5 courses at max, so this for loop will add courses
            if (assignedCourses[i] == null) {//checks for empty space
                assignedCourses[i] = course;
                System.out.println("Teacher " + getName() + " assigned to teach " + course.getTitle());
                return;
            }
        }
        System.out.println("Cannot assign more courses. Maximum limit reached.");
    }


    public void displayCourses() {
        System.out.println("All the courses taught by the teacher "+ super.getName()+ " are:");
        if (assignedCourses.length != 0){ //is length of array > 0, it means it has course
            for (Course element: assignedCourses){
                System.out.println( " Course ID: "+element.getCourseId()+" Course Title: "+element.getTitle());
            }
        }else {
            System.out.println("No course has been taught");
        }
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Specialization: " + specialization);
        
    }


    @Override
    public String toString(){
        String details = "Teacher Details:\n";
        details += "ID: " + teacherId + "\n";
        details += "Name: " + getName() + "\n";
        details += "Specialization: " + specialization + "\n";
        details += "Total Courses: " + assignedCourses.length + "\n";
        return details;
    }

    @Override
    public String generateReport(ArrayList<Person> people) {//dk reason for passing
        //the parameter
        String report = "Teacher Report Summary:\n";
        int courseCount = 0;

        for (Course course : assignedCourses) {
            if (course != null) {
                courseCount++;
            }
        }

        report += "Teacher ID: " + teacherId + "\n";
        report += "Name: " + getName() + "\n";
        report += "Specialization: " + specialization + "\n";
        report += "Total Courses Taught: " + courseCount + "\n";

        return report;
    }
}
