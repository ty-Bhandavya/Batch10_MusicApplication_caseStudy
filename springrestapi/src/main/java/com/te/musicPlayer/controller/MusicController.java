package com.te.musicPlayer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.musicPlayer.bean.MusicPlayerBean;
import com.te.musicPlayer.bean.MusicResponse;
import com.te.musicPlayer.service.MusicService;

@RestController
public class MusicController {

	@Autowired
	private MusicService service;

	@GetMapping(path = "/getMusic", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicResponse getMusicData(int id) {

		MusicResponse response = new MusicResponse();
		MusicPlayerBean infoBean = service.getMusicData(id);

		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure , Data Not found");
		}

		return response;
	}

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicResponse getAllMusicDetails() {
		MusicResponse response = new MusicResponse();
		List<MusicPlayerBean> infoBeans = service.getAllMusicDetails();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setMusicInfos(infoBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public MusicResponse addMusicData(@RequestBody MusicPlayerBean infoBean) {
		MusicResponse response = new MusicResponse();

		if (service.addMusic(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public MusicResponse updateEmpData(@RequestBody MusicPlayerBean infoBean) {
		MusicResponse response = new MusicResponse();

		if (service.updateMusic(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} 

	
	@DeleteMapping(path = "/delete/{Song_ID}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public MusicResponse deleteEmpData(@PathVariable(name = "Song_ID")int id ) {
		MusicResponse response = new MusicResponse();

		if (service.deleteMusic(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}

}
