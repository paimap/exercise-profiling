package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
//        List<Student> students = studentRepository.findAll();
//        List<StudentCourse> studentCourses = new ArrayList<>();
//        for (Student student : students) {
//            List<StudentCourse> studentCoursesByStudent = studentCourseRepository.findByStudentId(student.getId());
//            for (StudentCourse studentCourseByStudent : studentCoursesByStudent) {
//                StudentCourse studentCourse = new StudentCourse();
//                studentCourse.setStudent(student);
//                studentCourse.setCourse(studentCourseByStudent.getCourse());
//                studentCourses.add(studentCourse);
//            }
//        }
        return studentCourseRepository.findAll();
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findAll()
                .stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.getName()).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}

