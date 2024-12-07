public class University {
   private Course course= new Course();
    private Teacher teacher= new Teacher();
    private Student student=new Student();
    University(){};

    public University(Course course, Teacher teacher, Student student) {
        this.course = course;
        this.teacher = teacher;
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    void displaySystemStats(){
        System.out.println("Total Number of Students: "+ student.getTotalStudent());
        System.out.println("Total Number of Teacher: "+ teacher.getCountTeacher());
        System.out.println("Total Number of Courses: "+ course.getCourseCount());
    }
}
