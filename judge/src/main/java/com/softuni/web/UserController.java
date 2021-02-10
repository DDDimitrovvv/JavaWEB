package com.softuni.web;

import com.softuni.model.binding.UserEntityLoginBindingModel;
import com.softuni.model.binding.UserEntityRegisterBindingModel;
import com.softuni.model.service.UserEntityServiceModel;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userEntityLoginBindingModel")) {
            model.addAttribute("userEntityLoginBindingModel", new UserEntityLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("login")
    public String loginConfirm(@Valid @ModelAttribute UserEntityLoginBindingModel userEntityLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userEntityLoginBindingModel", userEntityLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userEntityLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserEntityServiceModel user = userService.findUserByUsernameAndPassword(userEntityLoginBindingModel.getUsername(),
                userEntityLoginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes.addFlashAttribute("userEntityLoginBindingModel", userEntityLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

//        httpSession.setAttribute("user", user);
        userService.login(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userEntityRegisterBindingModel")) {
            model.addAttribute("userEntityRegisterBindingModel", new UserEntityRegisterBindingModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserEntityRegisterBindingModel userEntityRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !userEntityRegisterBindingModel.getPassword().equals(userEntityRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userEntityRegisterBindingModel", userEntityRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userEntityRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        UserEntityServiceModel userEntityServiceModel = modelMapper.map(userEntityRegisterBindingModel, UserEntityServiceModel.class);

        userService.registerUser(userEntityServiceModel);
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
