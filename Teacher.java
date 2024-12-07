import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Teacher extends Person implements Reportable {
    private Course[] courses = new Course[5];
    private int teacherId;
    private String Specialization;
    private  static int Countteacher=0;

    Teacher(){};

    public Teacher(String name, String email, Date dateOfBirth, int teacherId, String specialization) {
        super(name, email, dateOfBirth);
        this.teacherId = teacherId;
        Specialization = specialization;
        Countteacher++;
    }

    public Course[] getCourse() {
        return courses;
    }



    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getCountTeacher() {
        return Countteacher;
    }

    public void assignCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {//as i've predefined that a teacher
            //can only have 5 courses at max, so this for loop will add courses
            if (courses[i] == null) {//checks for empty space
                courses[i] = course;
                System.out.println("Teacher " + getName() + " assigned to teach " + course.getTitle());
                return;
            }
        }
        System.out.println("Cannot assign more courses. Maximum limit reached.");
    }
    public void displayCourses() {
        System.out.println("Lists all the courses taught by the teacher "+super.getName());
        if (courses.length!=0){//is lenght of array>0, it means it has course
            for (Course element: courses){
                System.out.println(element.getTitle());
            }
        }else {
            System.out.println("No course has been taught");
        }
    }


    public String displayDetails(){
        String details = "Teacher Details:\n";
        details += "ID: " + teacherId + "\n";
        details += "Name: " + super.getName() + "\n";
        details += "Specialization: " + Specialization + "\n";
        details += "Total Courses: " + courses.length + "\n";
        return details;
    }

    @Override
    public String generateReport(ArrayList<Person> people) {//dk reason for passing
        //the parameter
        String report = "Teacher Report Summary:\n";
        int courseCount = 0;

        for (Course course : courses) {
            if (course != null) {
                courseCount++;
            }
        }

        report += "Teacher ID: " + teacherId + "\n";
        report += "Name: " + getName() + "\n";
        report += "Specialization: " + Specialization + "\n";
        report += "Total Courses Taught: " + courseCount + "\n";

        return report;
    }
}
