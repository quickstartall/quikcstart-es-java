package com.raquibul.quickstartall.es;

import java.io.IOException;
import java.util.Date;

import com.raquibul.quickstartall.es.model.Music;
import com.raquibul.quickstartall.es.service.MusicService;
import com.raquibul.quickstartall.es.service.MusicServiceImpl;

public class MusicApp {
	private static MusicService musicService = null;

	public static void main(String[] args) throws IOException {
		System.out.println("Calling sweet API...");
		musicService = new MusicServiceImpl();

		// saveSomeMusics();

		/*
		 * Music music1 = new Music(); music1.setYear(new Date());
		 * music1.setDocumentId("1"); music1.setLyrics(
		 * "Chu kar mera mann ko tune kiya isara.."); music1.setName(
		 * "Bollywood Track 1");
		 * 
		 * System.out.println();
		 * 
		 * if (musicService.isMusicExist(music1)) {
		 * musicService.updateMusic(music1); }
		 */

		insertSomeMusics();

		//Test the create operation. Print music with id=1
		printMusic("1");

		// Now update the music with id =1
		Music music1 = new Music();
		music1.setYear(new Date());
		music1.setDocumentId("1");
		music1.setLyrics("Updated Bollywood song..");
		music1.setName("Bollywood Track 1 updated");

		musicService.updateMusic(music1);
		// Now, print to verify that it's really updated. (update id=1)
		printMusic("1");

		//print music with Id=4
		printMusic("4");
		// Delete the music with id=4
		if (musicService.deleteMusicById("4")) {
			System.out.println("Music with Id[4] deleted successfully. It's gone to heaven now.");
		} else {
			System.out.println("Could not delete music with id[4]. Have a good day!");
		}
		
		//Now, check that music with id[4] is really deleted
		printMusic("4");
		
		System.out.println("Done!");
	}

	private static void insertSomeMusics() {
		// Save music 1
		Music music1 = new Music();
		music1.setYear(new Date());
		music1.setDocumentId("1");
		music1.setLyrics("Chhu kar mera mann ko tune kiya isara..");
		music1.setName("Bollywood Track 1");
		createMusic(music1);

		// Save music 2
		Music music2 = new Music();
		music2.setYear(new Date());
		music2.setDocumentId("2");
		music2.setLyrics("Zindagi ka safar hai yeh kaisa safar..");
		music2.setName("Bollywood Track 2");
		createMusic(music2);

		// Save music 3
		Music music3 = new Music();
		music3.setYear(new Date());
		music3.setDocumentId("3");
		music3.setLyrics("Tell me babe that you love me..");
		music3.setName("Hollywood Track 3");
		createMusic(music3);

		// Save music 3
		Music music4 = new Music();
		music4.setYear(new Date());
		music4.setDocumentId("4");
		music4.setLyrics("Cause I'm leaving on a jet plane...");
		music4.setName("Hollywood Track 4");
		createMusic(music4);
	}

	private static void createMusic(Music music) {
		try {
			musicService.createMusic(music);
			System.out.println("Following Music created successfully. Enjoy your day!");
			System.out.println(music.toString());
		} catch (IOException e) {
			System.out.println("Something went wrong. I'm sorry but I could not help you. Thanks!");
			e.printStackTrace();
		}
	}

	private static void printMusic(String id) throws IOException {
		Music music = musicService.findMusicById(id);

		if (music != null) {
			System.out.println("Hurray, following music found, Enjoy your day!");
			System.out.println("******************************************************************");
			System.out.println(music.toString());
			System.out.println("******************************************************************");
		} else {
			System.out.println("No  music with the ID[" + id + "] found, enjoy your day");
		}
	}
}
