/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplosspring.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/com-i18n")
public class ComInternacionalizacaoController {

    @GetMapping
    public ModelAndView mostrarTela() {
        return new ModelAndView("i18n/tela-com-i18n").addObject("info", new Info());
    }
}
