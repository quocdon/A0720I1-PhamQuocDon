package controllers;

import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.StudentService;
import services.StudentServiceImpl;

@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/")
    public ModelAndView getStudentList(){
        return new ModelAndView("list", "students", studentService.getAllStudent());
    }

    @GetMapping("/create")
    public String getFormCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String saveStudent(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Created");
        studentService.saveStudent(new Student(id, name));
        return "redirect:/";
    }
}
