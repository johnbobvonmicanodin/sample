package org.cnam.sample.repository;

import org.cnam.sample.model.FactureModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.UUID;

public interface FactureRepository extends JpaRepository<FactureModel, Long> {

    //@Query("SELECT f FROM Facture f WHERE f.id_client = ?1")
    //ArrayList<FactureModel> findByIdClient(UUID id_client);

}
