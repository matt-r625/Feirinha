package br.unifor.feiraApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifor.feiraApi.domain.Feira;

@Repository
public interface FeiraRepository extends JpaRepository<Feira, Long> {

}
