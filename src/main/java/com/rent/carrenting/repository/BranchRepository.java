package com.rent.carrenting.repository;

import com.rent.carrenting.models.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Integer> {

    Branch findBranchesByName(String name);
}
