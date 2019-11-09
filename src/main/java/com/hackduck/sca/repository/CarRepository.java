package com.hackduck.sca.repository;

import com.hackduck.sca.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends PagingAndSortingRepository<Car, UUID> {


    Car findByIdcar(UUID idcar);

}
