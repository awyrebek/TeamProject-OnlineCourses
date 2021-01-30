package com.app.course.online.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userProductMapRepository")
public interface UserProductMapRepository  extends JpaRepository<UserProductMap, Integer>
{
	public UserProductMap findById(Long id);
}
