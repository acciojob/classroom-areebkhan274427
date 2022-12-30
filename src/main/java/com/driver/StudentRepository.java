package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb=new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<String, List<String>> pairStudentTeacherDb=new HashMap<>();

    String addStudentToDb(Student student){
        String st=student.getName();
        studentDb.put(st,student);
        return "success";
    }
    String addTeacherToDb(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
        return "success";
    }
    Student getStudentFromDb(String name){
        return studentDb.get(name);

    }
    Teacher getTeacherFromDb(String name){
        return teacherDb.get(name);
    }

    List getStudentsByTeacherNameFromDb(String teacherName){
        List<String> student=new ArrayList<>();
        if(pairStudentTeacherDb.containsKey(teacherName)){

            student=pairStudentTeacherDb.get(teacherName);
        }
        return student;
    }


    String addStudentTeacherPairToDb(String studentName,String teacherName){
        if(studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)){
            if(pairStudentTeacherDb.containsKey(teacherName)){
                pairStudentTeacherDb.get(teacherName).add(studentName);
            }else {
                ArrayList<String> list=new ArrayList<>();
                list.add(studentName);
                pairStudentTeacherDb.put(teacherName,list);
            }

        }
        return "success";

    }


    List getAllStudentFromDb(){
        ArrayList<String> list=new ArrayList<>();
        for(String s:studentDb.keySet()){
            list.add(s);
        }
        return list;
    }
    String deleteTeacherByNameFromDb(String teacherName){
        if(teacherDb.containsKey(teacherName)){

            if(pairStudentTeacherDb.containsKey(teacherName)){
                List<String> student=pairStudentTeacherDb.get(teacherName);
                for(String s:student){
                    student.remove(s);
                }
                pairStudentTeacherDb.remove(teacherName);
            }
            teacherDb.remove(teacherName);
            return "success";
        }
        return null;
    }


    String deleteAllTeachersFromDb(){
        ArrayList<String> list=new ArrayList<>();
        for(String s:pairStudentTeacherDb.keySet()){
            for(String m:pairStudentTeacherDb.get(s)){
                list.add(m);
            }
        }
        for(String l:list){
            studentDb.remove(l);
        }
        return  "success";
    }



}
