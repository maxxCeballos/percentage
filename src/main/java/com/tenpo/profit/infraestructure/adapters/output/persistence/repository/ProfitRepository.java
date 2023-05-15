package com.tenpo.profit.infraestructure.adapters.output.persistence.repository;

import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitRepository extends PagingAndSortingRepository<ProfitE, String> {

    ProfitE save(ProfitE profit);

    Iterable<ProfitE> findAll();
}
