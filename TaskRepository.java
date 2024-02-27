package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.entity.Tasks;

public interface TaskRepository extends JpaRepository<Tasks,Integer>
{

	public Tasks findByTitle(String title);

	public List<Tasks> findByCompleted(boolean b);

}
