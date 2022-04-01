/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplospost;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("dados-pessoais/lista");
        // mv.addObject("lista", new ArrayList<DadosPessoais>());
        return mv;
    }

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

    @PostMapping("/salvar-com-post-redirect-get")
    public ModelAndView receberDadosComPostRedirectGet(
            @ModelAttribute("dados") DadosPessoais d,
            RedirectAttributes redirAttr) {
        redirAttr.addFlashAttribute("dados", d);
        return new ModelAndView("redirect:/dados-pessoais/mostrar-resultado-pos-redirect");
    }

    @GetMapping("/mostrar-resultado-pos-redirect")
    public ModelAndView mostrarResultadoPosRedirect(@ModelAttribute("dados") DadosPessoais d) {
        return new ModelAndView("dados-pessoais/resultado");
    }

    @GetMapping("/form-validacao")
    public ModelAndView mostrarFormValidacao() {
        ModelAndView mv = new ModelAndView("dados-pessoais/form-validacao");
        mv.addObject("dados", new DadosPessoais());
        return mv;
    }
    
    @PostMapping("/salvar-com-post-redirect-get-validacao")
    public ModelAndView receberDadosComPostRedirectGetValidacao(
            @ModelAttribute("dados") @Valid DadosPessoais d,
            BindingResult bindingResult,
            RedirectAttributes redirAttr) {
        if (bindingResult.hasErrors()) {
            // Teve erros, reapresentar formulário para correção
            return new ModelAndView("dados-pessoais/form-validacao");
        }
        redirAttr.addFlashAttribute("dados", d);
        return new ModelAndView("redirect:/dados-pessoais/mostrar-resultado-pos-redirect");
    }

}
