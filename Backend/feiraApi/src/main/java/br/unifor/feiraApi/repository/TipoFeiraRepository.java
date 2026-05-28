package br.unifor.feiraApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifor.feiraApi.domain.TipoFeira;

@Repository
public interface TipoFeiraRepository extends JpaRepository<TipoFeira, Long> {

}
