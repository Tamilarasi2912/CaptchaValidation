package com.tamil.RecaptchaValidation.Controller;

import com.tamil.RecaptchaValidation.Model.StudentEntity;
import com.tamil.RecaptchaValidation.Repository.StudentRepository;
import com.tamil.RecaptchaValidation.Service.RecaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class RecaptchaController {
    @Autowired
    private RecaptchaService validator;

    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/register")
    public String showRegister(Model model)
    {
        model.addAttribute("student", new StudentEntity());
        return "StudentRegister";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student")
                                   StudentEntity student,

                               @RequestParam(name="g-recaptcha-response")
                               String captcha, Model model)
    {
        if(validator.validateCaptcha(captcha))
        {
            studentRepository.save(student);
            model.addAttribute("student", new StudentEntity());
            model.addAttribute("message", "Student added!!");
        }
        else {
            model.addAttribute("message", "Please Verify Captcha");
        }
        return "StudentRegister";
    }

    @GetMapping("/all")
    public String getAllStudents(Model model)
    {
        model.addAttribute("list", studentRepository.findAll());
        return "StudentData";

    }
}
