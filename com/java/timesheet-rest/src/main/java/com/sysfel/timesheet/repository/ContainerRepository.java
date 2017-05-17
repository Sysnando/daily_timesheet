package com.sysfel.timesheet.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.sysfel.timesheet.model.Container;

public interface ContainerRepository extends Repository<Container, Long>{

	List<Container> findAll();
}
