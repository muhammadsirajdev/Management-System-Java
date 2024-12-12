import java.util.ArrayList;

public class University {
    private Repository<Student> studentRepository;
    private Repository<Teacher> teacherRepository;
    private Repository<Course> courseRepository;
    private Repository<AdministrativeStaff> staffRepository;

    public University() {
        studentRepository = new Repository<>();
        teacherRepository = new Repository<>();
        courseRepository = new Repository<>();
        staffRepository = new Repository<>();
    }

    // Add methods
    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.add(teacher);
    }

    public void addCourse(Course course) {
        courseRepository.add(course);
    }

    public void addStaff(AdministrativeStaff staff) {
        staffRepository.add(staff);
    }

    // Remove methods
    public void removeStudent(Student student) {
        studentRepository.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        teacherRepository.remove(teacher);
    }

    public void removeCourse(Course course) {
        courseRepository.remove(course);
    }

    public void removeStaff(AdministrativeStaff staff) {
        staffRepository.remove(staff);
    }

    // Assign relationships
    public void assignTeacherToCourse(Teacher teacher, Course course) {
        teacher.assignCourse(course);
        course.setAssignedTeacher(teacher);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        student.enrollInCourse(course);
        course.addStudent(student);
    }

    
    public static void displaySystemStats() {
        System.out.println("University System Stats:");
        System.out.println("Total Students: " + Student.getTotalStudent());
        System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
        System.out.println("Total Courses: " + Course.getTotalCourses());
        
    }



    // Search methods

    public ArrayList<Student> searchStudentByName(String name){
        //Returns a list of students with matching names
        ArrayList<Student> students = new ArrayList<>();
        for(Student student : studentRepository.getAll()){
            if(student.getName().contains(name)){
                students.add(student);
            }
        }
        return students; // confirm with teacher whether to return the list or print the students name
    }

    public ArrayList<Course> filterCoursesByCredits(int minCredits){
        
        ArrayList<Course> courses = new ArrayList<>();

        for(Course course : courseRepository.getAll()){
            if(course.getCredits() >= minCredits){
                courses.add(course);
            }
        }
        return courses;
    }

// additional methods, not asked by mam
    public Student findStudentById(int studentId) {
        for (Student student : studentRepository.getAll()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Teacher findTeacherById(int teacherId) {
        for (Teacher teacher : teacherRepository.getAll()) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    public Course findCourseById(int courseId) {
        for (Course course : courseRepository.getAll()) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }



}


