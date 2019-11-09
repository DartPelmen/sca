package com.hackduck.sca.repository;

import com.hackduck.sca.model.Detector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface DetectorRepository extends PagingAndSortingRepository<Detector, UUID> {
        Detector findByIddetector(UUID iddetector);

}
