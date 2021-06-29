package com.te.musicPlayer.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@Data
@Entity
@Table(name = "music_info")
@XmlRootElement(name = "music-info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("music_info")
public class MusicPlayerBean implements Serializable {
	
	@Id
	@Column(name = "id")
	private Integer Song_ID ;
	
	@Column
	private String Song_Title;
	
	@Column
	private String Artist_Name;
	
	@Column
	private String Album_Name;
	
	@Column
	private String Song_Location;
	
	@Column
	private String Description;
	

}
