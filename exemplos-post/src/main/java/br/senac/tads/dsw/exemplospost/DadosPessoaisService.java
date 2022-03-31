/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplospost;

import java.util.List;

public interface DadosPessoaisService {

    List<DadosPessoais> findAll();

    DadosPessoais findById(Integer id);

    void save(DadosPessoais d);
}
