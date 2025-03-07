package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
