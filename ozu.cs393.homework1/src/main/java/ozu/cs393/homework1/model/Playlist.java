package ozu.cs393.homework1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Playlist {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany()
	@JoinColumn(name = "SONG_ID")
	private List<Song> songs=new ArrayList<>();
	
	@ManyToMany()
	@JoinTable(name = "REL_PLAYLIST", 
	joinColumns = @JoinColumn(name = "PARENT_PL_ID", 
	referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "CHILD_PL_ID", 
	referencedColumnName = "ID"))
	private List<Playlist> playlists=new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlayLists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	public Playlist() {
		super();
		
	}
	public Playlist(String name,List<Song> songs, List<Playlist> playlists) {
		super();
		this.name=name;
		this.songs = songs;
		this.playlists = playlists;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
