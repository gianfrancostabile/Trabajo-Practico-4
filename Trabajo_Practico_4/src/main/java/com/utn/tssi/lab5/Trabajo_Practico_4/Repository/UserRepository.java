package com.utn.tssi.lab5.Trabajo_Practico_4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utn.tssi.lab5.Trabajo_Practico_4.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	
    @Query(	value = "SELECT * FROM users u WHERE u.date = :date",
    		nativeQuery = true,
    		name = "findByDate")
    List<User> findByDate(@Param("date")String date);

    
    @Query(	value = "SELECT u.browser_Name, date, COUNT(*) FROM users u WHERE date = :date GROUP BY u.browser_Name, u.date ORDER BY COUNT(*) DESC LIMIT 1",
    		nativeQuery = true,
    		name = "findByBrowser")
    List<?> findByBrowser(@Param("date")String date);

    
    @Query(	value = "SELECT u.os_Name, u.date, COUNT(*) FROM users u WHERE u.date = :date GROUP BY u.os_Name, u.date ORDER BY COUNT(*) DESC LIMIT 1",
    		nativeQuery = true,
    		name = "findByOS")
    List<?> findByOS(@Param("date")String date);

    
    @Query(	value = "SELECT u.browser_Name, u.os_Name, u.date, COUNT(*) FROM users u WHERE u.date = :date GROUP BY u.browser_Name, u.os_Name, u.date ORDER BY COUNT(*) DESC LIMIT 1",
    		nativeQuery = true,
    		name = "findByBrowserOS")
    List<?> findByBrowserOS(@Param("date")String date);
}
