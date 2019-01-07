package org.cnam.sample.repository;

import org.cnam.sample.model.FactureModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FactureRepository extends JpaRepository<FactureModel, Long> {

    List<FactureModel> findByIdClient(UUID idClient);

}
