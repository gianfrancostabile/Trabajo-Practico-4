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
	
    @Query(	value = "SELECT * FROM users u WHERE u.date = ?1",
    		nativeQuery = true,
    		name = "findByDate")
    List<User> findByDate(String date);

    
    @Query(	value = "SELECT u.browserName, u.date, COUNT(u) FROM users u WHERE u.date = ?1 GROUP BY u.browserName, u.date ORDER BY COUNT(u) DESC LIMIT 1",
    		nativeQuery = true,
    		name = "findByBrowser")
    List<?> findByBrowser(String date);

    
    @Query(	value = "SELECT u.osName, u.date, COUNT(u) FROM users u WHERE u.date = ?1 GROUP BY u.osName, u.date ORDER BY COUNT(u) DESC LIMIT 1",
    		nativeQuery = true,
    		name = "findByOS")
    List<?> findByOS(String date);

    
    @Query(	value = "SELECT u.browserName, u.osName, u.date, COUNT(u) FROM users u WHERE u.date = ?1 GROUP BY u.browserName, u.osName, u.date ORDER BY COUNT(u) DESC LIMIT 1",
    		nativeQuery = true,
    		name = "findByBrowserOS")
    List<?> findByBrowserOS(String date);
}
