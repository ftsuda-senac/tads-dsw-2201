/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplospost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exemplos")
public class ExemplsoBasicosController {

    @GetMapping("/get/{valor}")
    public ModelAndView exemploGet(
            @PathVariable("valor") String valor,
            @RequestParam("senha") String senha,
            @RequestParam("cc") String numeroCartao,
            @RequestParam("codver") String codVerificacao) {

        return new ModelAndView("exemplo-get");
    }
    
    @GetMapping("/abre-form")
    public ModelAndView exemploPostAbreForm() {
        return new ModelAndView("exemplo-post-form");
    }
    
    @PostMapping("/post")
    public ModelAndView exemploPost(
            @RequestParam("senha") String senha,
            @RequestParam("cc") String numeroCartao,
            @RequestParam("codver") String codVerificacao) {
        return new ModelAndView("exemplo-post-resultado");
    }
    
}
