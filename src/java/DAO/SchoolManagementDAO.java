package DAO;

import java.util.List;

import schoolmanagementsystem.domain.Student;
import schoolmanagementsystem.domain.Teacher;

public interface SchoolManagementDAO {

    public void registerStudentToEducation(String name, String gender, int age);

    public void registerTeacherToCourse(String name, int age, String gender);

    public void addExistingTeacherToCourse();

    public void registerEducation(String name);

    public void registerCourseToEducation(String name);

    public void addExistingCourseToEducation(int id, int id2);

    public void findStudentById(int id);

    public List<Student> findStudentsByCourse(int id);

    public List<Student> findStudentByName(String name);

    public List<Student> findStudentsByEducation(int id);

    public void findTeacherById(int id);

    public List<Teacher> findTeacherByName(String name);

    public List<Teacher> findTeacherByCourse(int id);

    public List<Teacher> findTeacherByEducation(int id);

    public <T> List<T> showAll(String t);

    public void showStudentInfo();

    public String showTeacherInfo();

    public String showEducationinfo();

    public String showCourseInfo();

    public boolean updateStudentsName(int id, String name);

    public boolean updateStudentEducation(int id, int id2);

    public boolean updateRemoveTeacherCourse();

    public boolean updateTeachersName(int id, String name);

    public boolean removeStudent(int id);

    public boolean removeTeacher(int id);

    public boolean removeCourse();

    public boolean removeEducation();

}
