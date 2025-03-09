package com.example.spring_program.Controller;

import com.example.spring_program.Api.ApiResponse;
import com.example.spring_program.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/stu")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    //GET
    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }
    //ADD
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Successfully added student");

    }
    //UPDATE
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student, @PathVariable int index) {
        students.set(index, student);
        return new ApiResponse("Successfully updated student");
    }
    //DELETE
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);

        return new ApiResponse("Successfully deleted student");
    }

    @GetMapping("honors")
    public ArrayList<String> getHonorsStudents() {
        ArrayList<String> honors = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getGPA() >= 4.75 && student.getGPA() <= 5.00) {
                honors.add(student.getName() + " First Honor grade :" + student.getGPA());
            }else if(student.getGPA() > 4.25 && student.getGPA() < 4.75 ){
                honors.add(student.getName() + " Second Honor grade :" + student.getGPA());

            }else honors.add(student.getName() + " grade :" + student.getGPA());
        }
        return honors;
    }
    @GetMapping("/average")
    public ApiResponse getAverage() {
        double gpa = 0;
        for (int i = 0; i < students.size(); i++) {
           gpa += students.get(i).getGPA();
        }
        double average = gpa / students.size();
        return new ApiResponse("The Average is : "+average);

    }

}
