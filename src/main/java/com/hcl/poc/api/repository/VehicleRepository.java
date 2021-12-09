package com.hcl.poc.api.repository;

import com.hcl.poc.api.model.Vehicle;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface VehicleRepository extends CassandraRepository<Vehicle, UUID> {
}
