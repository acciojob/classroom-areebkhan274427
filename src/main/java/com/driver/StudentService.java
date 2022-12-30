package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudentService(Student student){
        String result=studentRepository.addStudentToDb(student);
        return result;
    }

    public String addTeacherService(Teacher teacher){
        String result=studentRepository.addTeacherToDb(teacher);
        return result;
    }

    public String addStudentTeacherPairService(String studentName,String teacherName){
        String result=studentRepository.addStudentTeacherPairToDb(studentName,teacherName);
        return result;
    }

    public Student getStudentByNameService(String name){
        Student student=studentRepository.getStudentFromDb(name);
        return student;
    }

    public Teacher getTeacherByNameService(String name){
        Teacher teacher=studentRepository.getTeacherFromDb(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherNameService(String name){
        return studentRepository.getStudentsByTeacherNameFromDb(name);
    }

    public List<String> getAllStudentService(){
        return studentRepository.getAllStudentFromDb();
    }

    public String deleteTeacherByNameService(String name){
        return studentRepository.deleteTeacherByNameFromDb(name);
    }

    public String deleteAllTeachersService(){
        return studentRepository.deleteAllTeachersFromDb();
    }

}
