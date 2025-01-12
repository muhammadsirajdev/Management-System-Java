import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        return students; 
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

    public void filterTeacherByCourseName(int id){

        for(Teacher teacher: teacherRepository.getAll()){
            for(Course course: teacher.getAssignedCourse()){
                if(course!= null && course.getCourseId() == id){
                    System.out.println("The course with "+id + "is taught by the "+teacher.getName());
                }
            }
        }
    }

    // Save data to file
    public void saveData(String filename) {
        if (filename == null || filename.isEmpty()) {
            System.err.println("Invalid filename.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studentRepository.getAll());
            oos.writeObject(teacherRepository.getAll());
            oos.writeObject(courseRepository.getAll());
            oos.writeObject(staffRepository.getAll());
            oos.writeObject(Student.getTotalStudent());
            oos.writeObject(Teacher.getTotalTeachers());
            oos.writeObject(Course.getTotalCourses());
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    public void loadData(String filename) {
        if (filename == null || filename.isEmpty()) {
            System.err.println("Invalid filename.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studentRepository.setAll((ArrayList<Student>) ois.readObject());
            teacherRepository.setAll((ArrayList<Teacher>) ois.readObject());
            courseRepository.setAll((ArrayList<Course>) ois.readObject());
            staffRepository.setAll((ArrayList<AdministrativeStaff>) ois.readObject());
            Student.setTotalStudent((int) ois.readObject());
            Teacher.setTotalTeachers((int) ois.readObject());
            Course.setTotalCourses((int) ois.readObject());
            System.out.println("Data loaded successfully from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

                             // Add methods
    public void addStudent(Student student) {
        if (student == null) {
            System.err.println("Invalid student input.");
            return;
        }
        studentRepository.add(student);
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null) {
            System.err.println("Invalid teacher input.");
            return;
        }
        teacherRepository.add(teacher);
    }

    public void addCourse(Course course) {
        if (course == null) {
            System.err.println("Invalid course input.");
            return;
        }
        Teacher assignedTeacher = course.getAssignedTeacher();
        if (assignedTeacher != null) {
            if (assignedTeacher.getAssignedCourseCount() >= 5) {
                System.err.println("Teacher " + assignedTeacher.getName() + " already has the maximum number of assigned courses.");
                return;
            }
        }
        assignedTeacher.assignCourse(course);
        courseRepository.add(course);
    }

    public void addStaff(AdministrativeStaff staff) {
        if (staff == null) {
            System.err.println("Invalid staff input.");
            return;
        }
        staffRepository.add(staff);
    }

                                 // Remove methods
    public void removeStudent(Student student) {
        if (student == null) {
            System.err.println("Invalid student input.");
            return;
        }
        studentRepository.remove(student);
        Student.decrementTotalStudent();
    }

    public void removeTeacher(Teacher teacher) {
        if (teacher == null) {
            System.err.println("Invalid teacher input.");
            return;
        }
        teacherRepository.remove(teacher);
        Teacher.decrementTotalTeachers();
    }

    public void removeCourse(Course course) {
        if (course == null) {
            System.err.println("Invalid course input.");
            return;
        }
        Teacher assignedTeacher = course.getAssignedTeacher();
        if (assignedTeacher != null) {
            assignedTeacher.removeCourse(course);
        }

        courseRepository.remove(course);
        Course.decrementTotalCourses();
    }

    public void removeStaff(AdministrativeStaff staff) {
        if (staff == null) {
            System.err.println("Invalid staff input.");
            return;
        }
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

    
    public void addGrade(Student student, Course course, double grade) {
        if (student == null || course == null) {
            System.err.println("Invalid student or course input.");
            return;
        }
        if (grade < 0 || grade > 100) {
            System.err.println("Invalid grade input. Grade must be between 0 and 100.");
            return;
        }
        if (!isCourseAssignedToStudent(course.getCourseId())) {
            System.err.println("Student " + student.getName() + " is not enrolled in course " + course.getTitle());
            return;
        }
        course.setGrade(student, grade);
        System.out.println("Grade added successfully for student " + student.getName() + " in course " + course.getTitle());
    }



                        // ADDITIONAL METHODS (FOR BETTER GUI WORKING)

                        
    public void removeStudentFromCourse(Student student, Course course) {

        student.removeCourse(course);
        course.removeStudent(student);

    }

    // FIND METHODS
    public Student findStudentById(int studentId) {
        for (Student student : studentRepository.getAll()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public AdministrativeStaff findStaffById(int staffId) {
        for (AdministrativeStaff staff : staffRepository.getAll()) {
            if (staff.getStaffId() == staffId) {
                return staff;
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
    
    // EXIST METHODS
    public boolean studentExists(int studentId) {
        return findStudentById(studentId) != null;
    }

    public boolean staffExists(int staffId) {
        return findStaffById(staffId) != null;
    }

    public boolean teacherExists(int teacherId) {
        return findTeacherById(teacherId) != null;
    }

    public boolean courseExists(int courseId) {
        return findCourseById(courseId) != null;
    }

    // IS ASSIGNED METHODS
    public boolean isCourseAssignedToTeacher(int teacherId, int courseId) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null) {
            for (Course course : teacher.getCourses()) {
                if (course != null && course.getCourseId() == courseId) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCourseAssignedToStudent(int studentId, int courseId) {
        Student student = findStudentById(studentId);
        if (student != null && student.getCourses() != null) {
            for (Course course : student.getCourses()) {
                if (course != null && course.getCourseId() == courseId) {
                    return true;
                }
            }
        }
        return false;
    }

    // isCourseAssignedToStudent(CourseId) 
    public boolean isCourseAssignedToStudent(int courseId) {
        for (Student student : studentRepository.getAll()) {
            for (Course course : student.getCourses()) {
                if (course != null && course.getCourseId() == courseId) {
                    return true;
                }
            }
        }
        return false;
    }
    
         

    // GETTERS 
    public AdministrativeStaff getAdministrativeStaff() {

        // return the administrative staff instance

        return new AdministrativeStaff();
    }

    // getStudents
    public List<Student> getStudents() {
        return studentRepository.getAll();
    }

    // getCourses
    public List<Course> getCourses() {
        return courseRepository.getAll();
    }

    public String getSystemStats() {
        return "System Statistics:\n" +
                "Total Students: " + Student.getTotalStudent() + "\n" +
                "Total Teachers: " + Teacher.getTotalTeachers() + "\n" +
                "Total Courses: " + Course.getTotalCourses() + "\n" ;
    }

    

}



