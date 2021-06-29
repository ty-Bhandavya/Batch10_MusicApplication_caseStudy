package com.te.musicPlayer.dao;

import java.util.List;

import com.te.musicPlayer.bean.MusicPlayerBean;


public interface MusicDAO {

	public MusicPlayerBean getMusicData(Integer id);
	
	public boolean addMusic(MusicPlayerBean MusicBean);
	
	public boolean updateMusic(MusicPlayerBean infoBean);
	
	public boolean deleteMusic(Integer id);
	
	public List<MusicPlayerBean> getAllMusicDetails();
}
