package com.te.musicPlayer.service;

import java.util.List;

import com.te.musicPlayer.bean.MusicPlayerBean;

public interface MusicService {
	
	public MusicPlayerBean getMusicData(Integer id);

	public boolean addMusic(MusicPlayerBean MusicBean);

	public boolean updateMusic(MusicPlayerBean infoBean);

	public boolean deleteMusic(Integer id);

	public List<MusicPlayerBean> getAllMusicDetails();
}
