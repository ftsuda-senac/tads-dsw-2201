/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplospost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {
    
    @GetMapping("/form")
    public ModelAndView mostrarForm() {
        // Em "/templates" - subpasta "dados-pessoais" e arquivo "form.html"
        return new ModelAndView("dados-pessoais/form");
    }
    
    // OBS: Para o @ModelAttribute funcionar:
    // Classe deve seguir regra do POJO (atributos private, get/set e construtor padrão)
    @PostMapping("/salvar")
    public ModelAndView receberDados(@ModelAttribute("dados") DadosPessoais d) {
        return new ModelAndView("dados-pessoais/resultado");
    }
    
}
