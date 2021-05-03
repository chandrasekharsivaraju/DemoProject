package com.example.demoproject2.resource;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoproject2.model.DemoEntity;

public interface DemoRepository extends JpaRepository<DemoEntity, Long>{

}
