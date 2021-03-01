/**
 * 
 */
package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Application;

/**
 * @author Sunil
 *
 * ApplicationRepository.java Feb 21, 2021 11:47:09 PM
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

	@Transactional
	@Modifying
	@Query(value="select * from applications where env_ref=:envRefNo",nativeQuery=true)
	public List<Application> getApplicationListByEnvironmentRefNo(@Param("envRefNo")Long envRefNo);
}
