package ozu.cs393.homework1.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozu.cs393.homework1.model.Album;
import ozu.cs393.homework1.model.Artist;
import ozu.cs393.homework1.model.Playlist;
import ozu.cs393.homework1.model.Song;
import ozu.cs393.homework1.repository.AlbumRepository;
import ozu.cs393.homework1.repository.ArtistRepository;
import ozu.cs393.homework1.repository.PlaylistRepository;
import ozu.cs393.homework1.repository.SongRepository;

@Service
public class PlaylistService {
	@Autowired
	SongRepository songRepository;
	
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	PlaylistRepository playlistRepository;
	
	public void saveArtist(Artist artist) {
		artistRepository.save(artist);
	}
	
	public void saveAlbum(Album album) {
		albumRepository.save(album);
	}
		
	public void saveSong(Song song) {
		songRepository.save(song);
	}
	


	@Transactional
	public void addSongToAlbum(int albumId, Song song) {
		Album album= albumRepository.findById(albumId).get();
		album.getSongs().add(song);
		song.setAlbum(album);
		albumRepository.save(album);
	}

	@Transactional
	public void assignArtistToAlbum(int artistId , int albumId) {
		Album album= albumRepository.findById(albumId).get();
		Artist artist=artistRepository.findById(artistId).get();
		album.setArtist(artist);
		artist.getAlbums().add(album);
		albumRepository.save(album);
		
	}

	@Transactional
	public void deleteAlbum(int albumId) {
		Album album= albumRepository.findById(albumId).get();
		for (Song song : album.getSongs()) {
			song.setAlbum(null);
			songRepository.save(song);
		}
		albumRepository.deleteById(albumId);
	}
	
	public void deleteSong(int songId) {	
		songRepository.deleteById(songId);
	}
	
	public List<Song> getAllSongs() {	
		return songRepository.findAll();
	}
	
	public void createPlayList(String name, List<Song> songs, List<Playlist> playLists) {
		Playlist pl=new Playlist(name,songs, playLists);
		
		playlistRepository.save(pl);
	}
	
	public Playlist findPlaylistById(int id) {
		return playlistRepository.findById(id).get();
	}
	
	public Set<Song> findSongsWithArtistId(int id) {
		Set<Song> list1=songRepository.findSongByAlbumArtistId(id);
		Set<Song> list2=songRepository.findSongByArtistId(id);
	
		list1.addAll(list2);
		return list1;
	}

}
