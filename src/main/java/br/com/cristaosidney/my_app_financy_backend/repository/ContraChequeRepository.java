package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.ContraCheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContraChequeRepository extends JpaRepository<ContraCheque, Long> {
}
