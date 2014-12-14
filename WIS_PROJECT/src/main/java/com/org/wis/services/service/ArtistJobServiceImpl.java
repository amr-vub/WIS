package com.org.wis.services.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.ArtistJobManager;
import com.org.wis.data.dao.BookerJobManager;
import com.org.wis.data.dao.IArtistJobManager;
import com.org.wis.data.dao.IBookerJobManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Ranking;
import com.org.wis.data.domain.User;


@Service
public class ArtistJobServiceImpl implements ArtistJobService {

	@Autowired
	IArtistJobManager artJobM;

	@Transactional(readOnly = true)
	public ArtistJob getArtistJobById(int artistJobID) {
		ArtistJob aj =  artJobM.getArtistJobById(artistJobID);
		return aj;
	}

	@Transactional
	public void saveArtistJob(ArtistJob artistJob) {
		
		
		artJobM.saveArtistJob(artistJob);
		
	}

	@Transactional
	public void updateArtistJob(ArtistJob updatedAJ) {
		ArtistJob dbAJ = artJobM.getArtistJobById(updatedAJ.getArtistJobID());
		System.out.println("ARTISTJOB ID." + updatedAJ.getArtistJobID());
		dbAJ.setAliase(updatedAJ.getAliase());
		dbAJ.setArtFrom(updatedAJ.getArtFrom());
		dbAJ.setDescription(updatedAJ.getDescription());
		dbAJ.setPersonalWebSite(updatedAJ.getPersonalWebSite());
		dbAJ.setSondCloudLink(updatedAJ.getSondCloudLink());
		
		artJobM.updateArtistJob(dbAJ);
		
	}

	@Transactional
	public void deleteArtistJob(int artistJobID) {
		ArtistJob aj = artJobM.getArtistJobById(artistJobID);
		if(aj != null){
			artJobM.deleteArtistJob(aj);
		}
	}

	@Transactional(readOnly = true)
	public List<ArtistJob> getArtistByAlias(String alias, int nbrResults) {
		return artJobM.getArtistByAlias(alias, nbrResults);
	}

	@Transactional
	public void addRanking(int artistJobID, int rankValue, int uid) {
		
		ArtistJob aj = artJobM.getArtistJobById(artistJobID);
		Ranking r = new Ranking();
		r.setRankValue(rankValue);
		r.setRankArtistJob(aj);
		List<Ranking> rankings =aj.getRankings();
		rankings.add(r);
		int sum=0;
		for(Ranking ranking : rankings){
			sum += ranking.getRankValue();
		}
		System.out.println("sum" + sum + "size" +rankings.size());
		aj.setRankingValue(sum/rankings.size());
		artJobM.updateArtistJob(aj);
	}
	
	@Transactional
	public int getRanking(int artistJobID){
		return artJobM.getArtistJobById(artistJobID).getRankingValue();
	}	
	
}
