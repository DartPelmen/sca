package com.hackduck.sca.repository;

import com.hackduck.sca.model.Detector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DetectorRepository extends JpaRepository<Detector, UUID> {

}
