package com.sysfel.timesheet.repository;

import org.springframework.data.repository.Repository;

import com.sysfel.timesheet.model.Laborer;

public interface LaborerRepository extends Repository<Laborer, Long>{
	Laborer save(Laborer laborer);
	Laborer findByName(String name);
	Laborer findById(Long id);
}
