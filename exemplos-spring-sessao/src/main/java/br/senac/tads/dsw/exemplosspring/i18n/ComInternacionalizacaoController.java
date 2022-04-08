/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplosspring.i18n;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/com-i18n")
public class ComInternacionalizacaoController {

    @GetMapping
    public ModelAndView mostrarTela() {
        return new ModelAndView("i18n/tela-com-i18n").addObject("info", new Info());
    }
    
    @PostMapping
    public ModelAndView salvar(@ModelAttribute("info") @Valid Info info, BindingResult bindingResult,
            RedirectAttributes redirAttr) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("i18n/tela-com-i18n");
        }
        return new ModelAndView("redirect:/com-i18n");
    }
}
