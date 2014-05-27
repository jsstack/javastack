package com.jsstack.javastack.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Piece;

public class PiecesResource {
	private IDao dao = new Dao();
	private int puzzleId;

	public PiecesResource(int puzzleId) {
		this.puzzleId = puzzleId;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Piece> getPieces() {
		return dao.findAll(Piece.class, "puzzleId=" + puzzleId);
	}

}
