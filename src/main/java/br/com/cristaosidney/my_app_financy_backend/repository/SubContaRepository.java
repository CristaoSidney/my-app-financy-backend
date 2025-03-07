package br.com.cristaosidney.my_app_financy_backend.repository;

import br.com.cristaosidney.my_app_financy_backend.model.SubConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubContaRepository extends JpaRepository<SubConta, Long> {
}
