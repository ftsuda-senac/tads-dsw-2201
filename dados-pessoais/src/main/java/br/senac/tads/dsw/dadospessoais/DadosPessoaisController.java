/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DadosPessoaisController {
    
    @GetMapping("/{apelido}")
    public ModelAndView mostrarTela(@PathVariable("apelido") String apelido) {
        Dados dados = new Dados();
        dados.setNome("Seu Madruga");
        dados.setDtNascimento("1970-10-20");
        dados.setEmail("madruga@teste.com.br");
        dados.setTelefone("(11) 99876-1122");
        dados.setLinkedinUrl("https://linkedin.com/madruga");
        dados.setGithubUrl("https://github.com/madruga");
        
        ModelAndView mv = new ModelAndView("dados-pessoais");
        mv.addObject("dados", dados);
        return mv;
    }
    
    @GetMapping("/{apelido}/js")
    public ModelAndView mostrarTelaJs(@PathVariable("apelido") String apelido) {
        ModelAndView mv = new ModelAndView("dados-pessoais-js");
        return mv;
    }
    
    @GetMapping("/dados")
    @ResponseBody
    public Dados obterDadosJson() {
        Dados dados = new Dados();
        dados.setNome("Dona Florinda");
        dados.setDtNascimento("1970-04-10");
        dados.setEmail("florinda@teste.com.br");
        dados.setTelefone("(11) 99123-3344");
        dados.setLinkedinUrl("https://linkedin.com/florinda");
        dados.setGithubUrl("https://github.com/florinda");
        return dados;
    }
    
}
