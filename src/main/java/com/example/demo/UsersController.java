package com.example.demo;

import com.example.demo.dto.MembersForm;
import com.example.demo.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    MembersRepository membersRepository;

    @GetMapping("login_form")
    public String login_form(Model model){
        model.addAttribute("MembersForm",new MembersForm());
        return "login_form";
    }
}
