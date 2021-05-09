package com.razan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.demo.compositekey.ModuleDiscontinueKey;
import com.razan.demo.entity.ModuleDiscontinue;

public interface ModuleDiscontinueRepository extends JpaRepository<ModuleDiscontinue, ModuleDiscontinueKey> {

}
