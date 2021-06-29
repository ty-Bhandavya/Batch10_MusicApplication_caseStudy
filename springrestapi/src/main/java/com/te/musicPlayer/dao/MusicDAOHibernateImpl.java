package com.te.musicPlayer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.musicPlayer.bean.MusicPlayerBean;
import com.te.musicPlayer.custoexpection.MusicException;

@Repository
public class MusicDAOHibernateImpl implements MusicDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public MusicPlayerBean getMusicData(Integer id) {

		EntityManager manager = factory.createEntityManager();
		MusicPlayerBean bean = manager.find(MusicPlayerBean.class, id);
		return bean;
	}

	@Override
	public boolean addMusic(MusicPlayerBean musicPlayerBean) {
		try {

			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(musicPlayerBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateMusic(MusicPlayerBean infoBean) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			MusicPlayerBean orgData = manager.find(MusicPlayerBean.class, infoBean.getSong_ID());

			if (infoBean.getAlbum_Name() != null && infoBean.getAlbum_Name() != "") {
				orgData.setAlbum_Name(infoBean.getAlbum_Name());
			}

			if (infoBean.getArtist_Name() != null && infoBean.getArtist_Name()!="") {
				orgData.setArtist_Name(infoBean.getArtist_Name());
			}

			if (infoBean.getSong_Title() != null && infoBean.getSong_Title() != "") {
				orgData.setSong_Title(infoBean.getSong_Title());
			}

			if (infoBean.getSong_Location() != null && infoBean.getSong_Location() != "") {
				orgData.setSong_Location(infoBean.getSong_Location());
			}

			if (infoBean.getDescription() != null && infoBean.getDescription() != "") {
				orgData.setDescription(infoBean.getDescription());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteMusic(Integer id) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			MusicPlayerBean infoBean = manager.find(MusicPlayerBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new MusicException("The Data is not present");
		}
	}
	@Override
	public List<MusicPlayerBean> getAllMusicDetails() {

		List<MusicPlayerBean> musicPlayerBeans = null;

		try {
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from MusicFiles",MusicPlayerBean.class);

			musicPlayerBeans = query.getResultList();

		} catch (Exception e) {
			musicPlayerBeans = null;
			e.printStackTrace();
		}

		return musicPlayerBeans;
	}

}
