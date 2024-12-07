import java.util.Date;

public class Student extends Person{
    private int studentId;
    private String address;
    Course[] enrolledCourses = new Course[5];
    private static int TotalStudent=0;

    public Student(){
        super();
        studentId = 0;
        address = null;
        TotalStudent++;
    }

    public Student(String name, String email, Date dateOfBirth, int studentId, String address){
        super(name, email, dateOfBirth);
        setStudentId(studentId);
        setAddress(address);
    }
    public int getTotalStudent(){return TotalStudent;}

    public void setStudentId(int studentId) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be less than 0");
        }
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
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
        for(int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] != null) {
                System.out.println("Course id: "+ enrolledCourses[i].getCourseId()+" Course name: "+ enrolledCourses[i].getTitle());
            }
        }
    }
    public String displayDetails() {
        String details = "Student Details:\n";
        details += "ID: " + studentId + "\n";
        details += "Name: " + getName() + "\n";
        details += "Address: " + address + "\n";
        details += "Enrolled Courses:\n";
        for (Course course : enrolledCourses) {
            if (course != null) {
                details += "- " + course.getTitle() + "\n";
            }
        }
        return details;
    }

}

