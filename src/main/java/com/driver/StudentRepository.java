package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();
    HashMap<String, Teacher> teacherDb = new HashMap<>();
    HashMap<String, List<String>> pairStudentTeacherDb = new HashMap<>();

    public void addStudentToDb(Student student) {
        String st = student.getName();
        studentDb.put(st, student);
    }

    public void addTeacherToDb(Teacher teacher) {
        teacherDb.put(teacher.getName(), teacher);
    }

    public Student getStudentFromDb(String name) {
        return studentDb.get(name);
    }

    public Teacher getTeacherFromDb(String name) {
        return teacherDb.get(name);
    }

    public List<String> getStudentsByTeacherNameFromDb(String teacherName) {
        List<String> student = new ArrayList<>();
        if (pairStudentTeacherDb.containsKey(teacherName)) {

            student = pairStudentTeacherDb.get(teacherName);
        }
        return student;
    }


    public void addStudentTeacherPairToDb(String studentName, String teacherName) {
        if (studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)) {
            if (pairStudentTeacherDb.containsKey(teacherName)) {
                pairStudentTeacherDb.get(teacherName).add(studentName);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(studentName);
                pairStudentTeacherDb.put(teacherName, list);
            }

        }
    }


    public List<String> getAllStudentFromDb() {
        List<String> list = new ArrayList<>();
        for (String s : studentDb.keySet()) {
            list.add(s);
        }
        return list;
    }

    public void deleteTeacherByNameFromDb(String teacherName) {
        if(teacherDb.containsKey(teacherName)){

            if(pairStudentTeacherDb.containsKey(teacherName)){
                List<String> student=pairStudentTeacherDb.get(teacherName);
                for(String s:student){
                    student.remove(s);
                }
                pairStudentTeacherDb.remove(teacherName);
            }
            teacherDb.remove(teacherName);

        }



//        List<String> student = pairStudentTeacherDb.get(teacherName);
//        for (String s : student) {
//            if (studentDb.containsKey(student)) {
//                studentDb.remove(student);
//            }
//        }
//        pairStudentTeacherDb.remove(teacherName);

    }


    public void deleteAllTeachersFromDb() {
        ArrayList<String> list=new ArrayList<>();
        for(String s:pairStudentTeacherDb.keySet()){
            for(String m:pairStudentTeacherDb.get(s)){
                list.add(m);
            }
        }
        for(String l:list){
            studentDb.remove(l);
        }
        pairStudentTeacherDb = new HashMap<>();


//        for (String t : pairStudentTeacherDb.keySet()) {
//            List<String> student = pairStudentTeacherDb.get(t);
//            for (String s : student) {
//                if (studentDb.containsKey(s)) {
//                    studentDb.remove(s);
//                }
//            }
//        }
//        pairStudentTeacherDb.clear();
//


    }

}


