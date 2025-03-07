package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensalContaSaldo;
import br.com.cristaosidney.my_app_financy_backend.model.ResultadoMensalContaSaldoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoMensalContaSaldoRepository extends JpaRepository<ResultadoMensalContaSaldo, ResultadoMensalContaSaldoId> {
}
