package com.dev.springbootmicroservice1realstate.repository;

import com.dev.springbootmicroservice1realstate.model.RealState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealStateRepository extends JpaRepository<RealState, Long> {

}
