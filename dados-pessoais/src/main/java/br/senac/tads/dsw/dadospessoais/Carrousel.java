/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ftsuda
 */
@Controller
@RequestMapping("/carrossel")
public class Carrousel {
    
    @GetMapping
    public ModelAndView mostrarTela() {
        List<Produto> produtos = new ArrayList<>();
        Produto p1 = new Produto();
        p1.setNome("Produto 1");
        p1.setImagens(Arrays.asList("avatar01.jpg", "avatar02.jpg", "avatar03.jpg"));
        produtos.add(p1);
        
        Produto p2 = new Produto();
        p2.setNome("Produto 2");
        p2.setImagens(Arrays.asList("avatar04.jpg", "avatar05.jpg", "avatar06.jpg"));
        produtos.add(p2);
        
        ModelAndView mv = new ModelAndView("carrousel");
        mv.addObject("produtos", produtos);
        return mv;
    }
    
}
