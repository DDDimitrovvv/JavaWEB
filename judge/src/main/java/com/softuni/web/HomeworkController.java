package com.softuni.web;

import com.softuni.model.binding.HomeworkEntityAddBindingModel;
import com.softuni.service.ExerciseService;
import com.softuni.service.HomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;

    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
    }


    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("homeworkEntityAddBindingModel")) {
            model.addAttribute("homeworkEntityAddBindingModel", new HomeworkEntityAddBindingModel());
            model.addAttribute("isLate", false);
        }
        model.addAttribute("exNames", exerciseService.findAllExNames());
        return "homework-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid HomeworkEntityAddBindingModel homeworkEntityAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeworkEntityAddBindingModel", homeworkEntityAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userEntityRegisterBindingModel", bindingResult);
            return "redirect:add";
        }

        boolean isLate = exerciseService.checkIsLate(homeworkEntityAddBindingModel.getExercise());

        if (isLate) {
            redirectAttributes.addFlashAttribute("homeworkEntityAddBindingModel", homeworkEntityAddBindingModel);
            redirectAttributes.addFlashAttribute("isLate", true);
        }

        homeworkService
                .addHomework(homeworkEntityAddBindingModel.getExercise(),
                        homeworkEntityAddBindingModel.getGitAddress());


        return "redirect:/";

    }
}
