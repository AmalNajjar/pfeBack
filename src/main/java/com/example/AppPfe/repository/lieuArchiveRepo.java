package com.example.AppPfe.repository;


import com.example.AppPfe.Models.lieuArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface lieuArchiveRepo extends JpaRepository<lieuArchive,Long> {
   @Query("select a from lieuArchive a where a.Lieu=?1")
    lieuArchive findByLieu(String Lieu);
}
