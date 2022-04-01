package br.senac.tads.dsw.exemplospost;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class DadosPessoais {

    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    private String apelido;

    @Size(max = 1000)
    private String descricao;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ISO-8601
    @PastOrPresent
    @NotNull
    private LocalDate dataNascimento;

    @Email
    private String email;

    private String telefone;

    private String senha;

    private String senhaRepetida;

    @Min(1)
    @Max(99)
    private int numero;

    @Min(0)
    @Max(3)
    @Digits(integer = 1, fraction = 2)
    private BigDecimal altura;

    @Min(0)
    @Max(500)
    @Digits(integer = 3, fraction = 1)
    private BigDecimal peso;

    // -1 - INDEFINIDO
    //  0 - FEMININO
    //  1 - MASCULINO
    //  2 - OUTRO
    private int genero = -1;

    @NotEmpty
    private String[] interesses;

    public long getIdade() {
        if (this.getDataNascimento() != null) {
            return ChronoUnit.YEARS.between(this.getDataNascimento(), LocalDate.now());
        }
        return 0;
    }

    /*
     * IMC = peso / (altura * altura)
     * Magreza, quando o resultado é menor que 18,5 kg/m2;
     * Normal, quando o resultado está entre 18,5 e 24,9 kg/m2;
     * Sobrepeso, quando o resultado está entre 24,9 e 30 kg/m2;
     * Obesidade, quando o resultado é maior que 30 kg/m2.
     */
    public BigDecimal getImc() {
        if (this.getPeso() != null && this.getAltura() != null) {
            BigDecimal basePeso = new BigDecimal(1).multiply(this.getPeso());
            BigDecimal baseAltura = new BigDecimal(1).multiply(this.getAltura()).multiply(this.getAltura());
            return basePeso.divide(baseAltura, RoundingMode.HALF_UP);
        }
        return new BigDecimal(0);
    }

    public String getImcTexto() {
        BigDecimal imc = getImc();
        if (imc.compareTo(new BigDecimal(0)) == 0) {
            return "NÃO CALCULADO";
        } else if (imc.compareTo(new BigDecimal("18.5")) == -1) {
            return "MAGREZA";
        } else if (imc.compareTo(new BigDecimal("24.9")) == -1) {
            return "NORMAL";
        } else if (imc.compareTo(new BigDecimal("30")) == -1) {
            return "SOBREPESO";
        }
        return "OBESIDADE";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaRepetida() {
        return senhaRepetida;
    }

    public void setSenhaRepetida(String senhaRepetida) {
        this.senhaRepetida = senhaRepetida;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String[] getInteresses() {
        return interesses;
    }

    public void setInteresses(String[] interesses) {
        this.interesses = interesses;
    }

}
