package org.cnam.sample.repository;

import org.cnam.sample.model.LibelleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibelleRepository extends JpaRepository<LibelleModel, Long> {
}
