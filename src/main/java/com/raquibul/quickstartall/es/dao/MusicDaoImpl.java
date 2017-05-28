package com.raquibul.quickstartall.es.dao;

import java.io.IOException;

import com.raquibul.quickstartall.es.client.ESJestClient;
import com.raquibul.quickstartall.es.model.Music;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;

public class MusicDaoImpl implements MusicDao {
	public void createMusic(Music music) throws IOException {
		Index index = new Index.Builder(music).index("music").type("songs").build();
		JestClient client = ESJestClient.getMusicClient();
		client.execute(index);
	}

	public Music findMusicById(String id) throws IOException {
		Get get = new Get.Builder("music", id).type("songs").build();
		JestClient client = ESJestClient.getMusicClient();
		JestResult result = client.execute(get);

		return result.getSourceAsObject(Music.class);
	}

	public boolean isMusicExist(Music music) {
		//There is some bug in the following code. Hence the shortcode method
		/*SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("id", music.getDocumentId()));
		Count count = new Count.Builder().query(searchSourceBuilder.toString())
				// multiple index or types can be added.
				.addIndex("music").addType("songs").build();

		JestClient client = ESJestClient.getMusicClient();
		CountResult result = client.execute(count);

		return result.isSucceeded() && result.getSourceAsString().equals("1");*/
		
		try {
			if (findMusicById(music.getDocumentId()) != null) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("There was some error finding music.");
			e.printStackTrace();
		}
		
		return false;
	}

	public void updateMusic(Music music) throws IOException {
		//There was some problem with the update query below. Looks like API isseu. Hence the work around
		/*JestClient client = ESJestClient.getMusicClient();
		client.execute(new Update.Builder(music).index("music").type("songs").id(music.getDocumentId()).build());*/
		
		Index index = new Index.Builder(music).index("music").type("songs").id(music.getDocumentId()).build();
		JestClient client = ESJestClient.getMusicClient();
		client.execute(index);
	}

	public boolean deleteMusicById(String id) {
		JestClient client = ESJestClient.getMusicClient();
		try {
			DocumentResult documentResult = client.execute(new Delete.Builder(id)
			        .index("music")
			        .type("songs")
			        .build());
			return documentResult.isSucceeded();
		} catch (IOException e) {
			System.out.println("There was some issue deleting the document with id[" + id + "]");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
