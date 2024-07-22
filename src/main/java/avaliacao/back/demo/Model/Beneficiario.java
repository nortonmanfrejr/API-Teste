package avaliacao.back.demo.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Beneficiario {

    @Id
    @GeneratedValue
    private Long Id;

    private String Nome;
    private String Telefone;
    private LocalDate DataNascimento;
    private LocalDate DataInclusao;
    private LocalDate DataAtualizacao;

    //------------------------------------------------------------------------

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> Documentos;
    //------------------------------------------------------------------------

    public Beneficiario(){
    }

    //------------------------------------------------------------------------

    //region GET/SET

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public LocalDate getDataInclusao() {
        return DataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        DataInclusao = dataInclusao;
    }

    public LocalDate getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        DataAtualizacao = dataAtualizacao;
    }

    public List<Documento> getDocumentos() {
        return Documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        Documentos = documentos;
    }


    //endregion GET/SET
    //------------------------------------------------------------------------

    public static class Builder{

    }
}


