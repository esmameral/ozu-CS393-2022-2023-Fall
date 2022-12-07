package ozu.cs393.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ozu.cs393.homework1.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
