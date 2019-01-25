package com.ph.security.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author panha
 *
 * @param <T>
 */
@NoRepositoryBean
public interface PhRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T>{

}
