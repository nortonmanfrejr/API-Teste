package avaliacao.back.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Documento {

    @Id
    @GeneratedValue
    private Long Id;

    private String TipoDocumento;
    private String Descricao;
    private Date DataInclusao;
    private Date DataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario")
    private Beneficiario beneficiario;

    //------------------------------------------------------------------------
}
