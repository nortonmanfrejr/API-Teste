package avaliacao.back.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Beneficiario {

    @Id
    @GeneratedValue
    private Long Id;

    private String Nome;
    private String Telefone;
    private Date DataNascimento;
    private Date DataInclusao;
    private Date DataAtualizacao;

    //------------------------------------------------------------------------

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> Documentos;
    //------------------------------------------------------------------------

    public Beneficiario(){
    }

    //------------------------------------------------------------------------

    public static class Builder{

    }
}


