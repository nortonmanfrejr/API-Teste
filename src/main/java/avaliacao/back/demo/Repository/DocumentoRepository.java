package avaliacao.back.demo.Repository;

import avaliacao.back.demo.Model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("select d from Documento d where d.beneficiario = :beneficiario")
    public List<Documento> GetAllByBeneficiario(@Param("beneficiario") Long beficiario);
}
