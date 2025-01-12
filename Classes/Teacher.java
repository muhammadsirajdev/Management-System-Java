import java.util.ArrayList;
import java.util.Date;


public class Teacher extends Person  {
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

    public Course[] getCourses(){
        return assignedCourses;
    }

    // setters 

    // setTotalTeachers
    public static void setTotalTeachers(int totalTeachers){
        if (totalTeachers < 0) {
            throw new IllegalArgumentException("Total Teachers cannot be less than 0");
        }
        Teacher.totalTeachers = totalTeachers;
    }
    
    public void setTeacherId(int teacherId) {
        if (teacherId < 0) {
            throw new IllegalArgumentException("Teacher ID cannot be less than 0");
        }
        this.teacherId = teacherId;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty");
        }
        this.specialization = specialization;
    }


                         // METHODS ASKED BY MAM

    public void assignCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        for (int i = 0; i < assignedCourses.length; i++) {
            if (assignedCourses[i] == null) {
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
        details += "Total Courses: " + getAssignedCourseCount() + "\n";
        return details;
    }

    // @Override
    public String generateReport(ArrayList<Person> people) {
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


                // ADDITIONAL METHODS FOR BETTER GUI EXPERIENCE (NOT ASKED BY MAM)

    public int getAssignedCourseCount() {
        int count = 0;
        for (int i = 0; i < assignedCourses.length; i++) {
            if (assignedCourses[i] != null) {
                count++;
            }
        }
        return count;
    }


    public String getCourseDetails() {
        if(getAssignedCourseCount() == 0){
            return "No course has been assigned to the teacher";
        }
        
        String details = "All the courses taught by the teacher "+ super.getName()+ " are:\n";
        for (Course assignedCourse : assignedCourses) {
            if (assignedCourse != null) {
                details += "\nCourse id: " + assignedCourse.getCourseId() + " Course name: " + assignedCourse.getTitle();
            }
        }
        return details;
    }


    // removeCourse method
    public void removeCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        for (int i = 0; i < assignedCourses.length; i++) {
            if (assignedCourses[i] != null && assignedCourses[i].getCourseId() == course.getCourseId()) {
                assignedCourses[i] = null;
                System.out.println("Teacher " + getName() + " successfully removed from " + course.getTitle());
                return;
            }
        }
        System.out.println("Course not found in the teacher's assigned courses.");
    }

    //decrementTotalTeachers
    public static void decrementTotalTeachers(){
        totalTeachers--;
    }
}
