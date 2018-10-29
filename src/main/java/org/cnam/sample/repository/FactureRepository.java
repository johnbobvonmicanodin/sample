package org.cnam.sample.repository;

import org.cnam.sample.model.FactureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<FactureModel, Long> {

}
