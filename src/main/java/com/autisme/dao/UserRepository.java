package com.autisme.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.autisme.modal.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	void deleteUserById(Long id);

    Optional<User> findUserById(Long id);  
    
  
    @Query(value = "SELECT * FROM utilisateur u  where u.notif = 1", nativeQuery = true)  
    List<User> findAllNotifier();
     
    @Query(value = "select * FROM utilisateur u  where u.active=0 ", nativeQuery = true)  
    List<User> findAllNotV();
     
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE utilisateur u set adress =:adress  where u.id = :id", nativeQuery = true)  
    int updateProfile(@Param(value = "id") long id, @Param(value = "adress") String adress);
     
  
  /*  @Transactional
    @Modifying
    @Query(value = "UPDATE utilisateur u set prenom =:prenom and adress =:adress and tele =:tele   where u.id = :id", nativeQuery = true)  
    int updateProfile(@Param(value = "id") long id,  @Param(value = "prenom") String prenom,@Param(value = "adress") String adress,@Param(value = "tele") String tele);
   */ 
  
    @Transactional
    @Modifying
    @Query(value = "update utilisateur u set u.notif = 1 where u.id = :id",nativeQuery = true)
    int onActiveUserNotif(@Param(value = "id") long id);
    
   
    @Transactional
    @Modifying
    @Query(value = "update utilisateur u set u.active = 1 where u.id = :id",nativeQuery = true)
    int onActiveUserAccount(@Param(value = "id") long id);
}