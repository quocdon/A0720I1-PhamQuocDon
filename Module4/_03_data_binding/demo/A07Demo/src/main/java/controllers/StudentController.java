package controllers;

import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.StudentService;
import services.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/")
    public ModelAndView getStudentList(){
        return new ModelAndView("list", "students", studentService.getAllStudent());
    }

    @GetMapping("/create")
    public String getFormCreate(Model model){
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("C#");
        subjects.add("PHP");
        subjects.add("Python");
        model.addAttribute("subjects", subjects);
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Created");
        studentService.saveStudent(student);
        return "redirect:/";
    }
}
