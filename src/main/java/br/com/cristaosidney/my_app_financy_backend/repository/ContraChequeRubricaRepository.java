package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.ContraChequeRubrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContraChequeRubricaRepository extends JpaRepository<ContraChequeRubrica, Long> {
    void deleteByIdAndContraChequeId(Long id, Long contraChequeId);

    Optional<ContraChequeRubrica> findByIdAndContraChequeId(Long id, Long contraChequeId);

    List<ContraChequeRubrica> findAllByContraChequeId(Long contraChequeId);
}
