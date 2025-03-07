package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.ContaSaldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaSaldoRepository extends JpaRepository<ContaSaldo, Long> {
}
