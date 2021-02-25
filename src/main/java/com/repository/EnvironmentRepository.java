/**
 * 
 */
package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Environment;
import com.model.Role;

/**
 * @author Sunil
 *
 * EnvironmentDAO.java Feb 21, 2021 8:53:37 PM
 */
@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long>  {


}
