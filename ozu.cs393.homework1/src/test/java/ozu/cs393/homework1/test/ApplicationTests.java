package ozu.cs393.homework1.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ozu.cs393.homework1.model.Album;
import ozu.cs393.homework1.model.Artist;
import ozu.cs393.homework1.model.Playlist;
import ozu.cs393.homework1.model.Song;
import ozu.cs393.homework1.service.PlaylistService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	PlaylistService service;
	

	@Test
	@Order(1)
	void testSaveAndSongs() {
		Album album=new Album("Sözüm Meclisten Dışarı");
		Song song1=new Song("Gulpembe",312);
		Song song2=new Song("Dönence",351);
		Song song3=new Song("Hal Hal",215);

		
		song1.setAlbum(album);
		song2.setAlbum(album);
		song3.setAlbum(album);
		album.getSongs().add(song1);
		album.getSongs().add(song2);
		album.getSongs().add(song3);
		service.saveAlbum(album);
		
	}
	@Test
	public void testAddSongToAlbum() {
		Song song=new Song("Ali Yazar Veli Bozar",226);
		service.addSongToAlbum(119,song);
	}
	
	@Test
	public void testAddArtist() {
		Artist artist=new Artist("Barış Manço");
		service.saveArtist(artist);
	}
	
	@Test
	public void testAssignArtistToAlbum() {
		service.assignArtistToAlbum(5, 1);
	}
	
	@Test
	public void testDeleteSong() {
		service.deleteSong(107);
	}
	
	@Test
	public void testDeleteAlbum() {
		service.deleteAlbum(107);
	}
	
	@Test
	public void testCreatePlayList() {
		String name="denemeddd";
		List<Song> songs=service.getAllSongs();
		Playlist pl2=service.findPlaylistById(202);
		List<Playlist> plList=new ArrayList<>();
		plList.add(pl2);	
		service.createPlayList(name,songs,plList);
	}
	
	@Test
	public void testFindSongsWithArtistId() {
			
		Set<Song> songs=service.findSongsWithArtistId(5);
		for (Song song : songs) {
			System.out.println(song.getId()+" "+song.getName());
		}
	}
	

}
