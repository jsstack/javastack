package com.jsstack.javastack.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Puzzle;

public class PuzzleResource {

	private IDao dao = new Dao();
	private int puzzleId;

	public PuzzleResource(int puzzleId) {
		this.puzzleId = puzzleId;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Puzzle getPuzzle() {
		System.out.println("get puzzle with puzzleId=" + puzzleId);
		return dao.findById(Puzzle.class, puzzleId);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Puzzle updatePuzzle() {
		throw new UnsupportedOperationException();
	}

	@DELETE
	public void deletePuzzle() {
		System.out.println("delete puzzle with puzzleId=" + puzzleId);
		if (dao.delete(Puzzle.class, puzzleId) <= 0) {
			throw new NotFoundException("No such Puzzle.");
		}
	}
}
