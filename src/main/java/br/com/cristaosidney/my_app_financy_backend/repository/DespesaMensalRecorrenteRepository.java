package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.DespesaMensalRecorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaMensalRecorrenteRepository extends JpaRepository<DespesaMensalRecorrente, Long> {
}
