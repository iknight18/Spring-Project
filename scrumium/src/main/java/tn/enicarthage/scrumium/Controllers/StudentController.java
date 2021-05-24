package tn.enicarthage.scrumium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.scrumium.Domain.Student;
import tn.enicarthage.scrumium.Services.StudentService;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path= "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);

    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable Long studentId,
            @RequestBody(required = false) Student student
    ){
    studentService.updateStudent(studentId,student);
    }

}
