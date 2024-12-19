import java.util.Date;

public class Student extends Person{
    private int studentId;
    private String address;
    Course[] enrolledCourses = new Course[5];
    private static int TotalStudent= 0;

    public Student(){
        super();
        studentId = 0;
        address = null;
        TotalStudent++;
    }

    public Student(String name, String email, Date dateOfBirth, int studentId, String address){
        super(name, email, dateOfBirth);
        setStudentId(studentId);
        this.address = address;
        TotalStudent++;

    }

    // getters 

    public static int getTotalStudent(){return TotalStudent;}

    public int getStudentId() {
        return studentId;
    }

    public String getAddress() {
        return address;
    }

    // setters

    public void setStudentId(int studentId) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be less than 0");
        }
        this.studentId = studentId;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void enrollInCourse(Course course){
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] == null) {
                enrolledCourses[i] = course;
                System.out.println("Student "+getStudentId()+" successfully enrolled in " + course.getTitle());
                return;
            }
        }
        System.out.println("You are already enrolled in 5 courses. You cannot enroll in more.");
    }


    public void displayCourses(){
        System.out.println("Student "+ getStudentId()+ " is enrolled in the following courses: \n"  );
        for (Course enrolledCourse : enrolledCourses) {
            if (enrolledCourse != null) {
                System.out.println("Course id: " + enrolledCourse.getCourseId() + " Course name: " + enrolledCourse.getTitle());
            }
        }
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Address: " + getAddress());
        
    }

    @Override
    public String toString() {
        String details = "Student Details:\n";
        details += "ID: " + getStudentId() + "\n";
        details += "Name: " + getName() + "\n";
        details += "Address: " + getAddress() + "\n";
        details += "Enrolled Courses:\n";
        for (Course course : enrolledCourses) {
            if (course != null) {
                details += "- " + course.getTitle() + "\n";
            }
        }
        return details;
    }

}

