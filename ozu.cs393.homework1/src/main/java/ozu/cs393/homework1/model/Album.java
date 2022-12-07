package ozu.cs393.homework1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Album {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "ARTIST_ID")
	private Artist artist;
	
	@OneToMany(mappedBy = "album",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Song> songs=new ArrayList<>();
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Album(String name) {
		super();
		this.name = name;
	}
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
