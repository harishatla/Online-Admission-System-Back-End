package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmission.entity.CourseEntity;


@Repository
public interface CourseJpaDao extends JpaRepository<CourseEntity, Integer>{

}
