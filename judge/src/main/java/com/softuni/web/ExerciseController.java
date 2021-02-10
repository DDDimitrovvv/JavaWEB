package com.softuni.web;

import com.softuni.model.binding.ExerciseEntityAddBindingModel;
import com.softuni.model.service.ExerciseEntityServiceModel;
import com.softuni.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {


    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("exerciseEntityAddBindingModel")) {
            model.addAttribute("exerciseEntityAddBindingModel", new ExerciseEntityAddBindingModel());
        }
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ExerciseEntityAddBindingModel exerciseEntityAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseEntityAddBindingModel", exerciseEntityAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exerciseEntityAddBindingModel", bindingResult);
            return "redirect:add";
        }


        exerciseService.addExercise(modelMapper
                .map(exerciseEntityAddBindingModel, ExerciseEntityServiceModel.class));

        return "redirect:/";

    }
}
