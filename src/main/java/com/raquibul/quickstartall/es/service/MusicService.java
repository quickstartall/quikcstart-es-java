package com.raquibul.quickstartall.es.service;

import java.io.IOException;

import com.raquibul.quickstartall.es.model.Music;

public interface MusicService {
	public boolean isMusicExist(Music music);
	public void createMusic(Music music) throws IOException;
	public void updateMusic(Music music) throws IOException;
	public Music findMusicById(String id) throws IOException;
	public boolean deleteMusicById(String id);
}
