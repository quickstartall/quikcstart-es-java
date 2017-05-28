package com.raquibul.quickstartall.es.service;

import java.io.IOException;

import com.raquibul.quickstartall.es.dao.MusicDao;
import com.raquibul.quickstartall.es.dao.MusicDaoImpl;
import com.raquibul.quickstartall.es.model.Music;

public class MusicServiceImpl implements MusicService {
	private final MusicDao musicDao = new MusicDaoImpl();;
	
	public boolean isMusicExist(Music music) {
		return musicDao.isMusicExist(music);
	}
	
	public void createMusic(Music music) throws IOException {
		musicDao.createMusic(music);
	}
	
	public Music findMusicById(String id) throws IOException {
		return musicDao.findMusicById(id);
	}

	public void updateMusic(Music music) throws IOException {
		musicDao.updateMusic(music);
	}

	public boolean deleteMusicById(String id) {
		return musicDao.deleteMusicById(id);
	}
	
}
