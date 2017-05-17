package com.sysfel.timesheet.service;

import com.sysfel.timesheet.model.Laborer;

public interface LaborerService {
	Laborer save(Laborer laborer);
	Laborer findByName(String name);
	Laborer findById(Long id);
}
