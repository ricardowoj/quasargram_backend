package com.quasagram.springbootv2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "caption")
	private String caption;
	
	@Column(name = "date")
	private Long date;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "photo")
	private String photo;
	
	public Post() {
		
	}

	public Post(String caption, Long date, String location, String photo) {
		this.caption = caption;
		this.date = date;
		this.location = location;
		this.photo = photo;
	}

	public long getId() {
		return id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Posts [id=" + id + ", caption=" + caption + ", date=" + date + ", location=" + location + ", photo="
				+ photo + "]";
	}

	
}
