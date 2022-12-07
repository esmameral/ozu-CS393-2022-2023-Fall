package ozu.cs393.homework1.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ozu.cs393.homework1.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
	
	public Set<Song> findSongByAlbumArtistId(int id);
	
	
	public Set<Song> findSongByArtistId(int id);
}
