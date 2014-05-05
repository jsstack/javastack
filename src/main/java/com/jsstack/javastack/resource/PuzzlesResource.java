package com.jsstack.javastack.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Puzzle;

@Path("puzzles")
public class PuzzlesResource {
	private IDao dao = new Dao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Puzzle> getPuzzles() {
		System.out.println("get all puzzles");
		return dao.findAll(Puzzle.class);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Puzzle addPuzzle(@FormParam("imageId") int imageId) {
		System.out.println("create puzzle with imageId=" + imageId);
		Puzzle puzzle = new Puzzle();
		puzzle.setImageId(imageId);
		puzzle.setDateCreated(new Date().getTime());

		int id = dao.insert(puzzle);

		puzzle.setId(id);

		return puzzle;
	}

	@Path("puzzleId")
	public PuzzleResource getPuzzle(@FormParam("puzzleId") int puzzleId) {
		System.out.println("get puzzle with puzzleId=" + puzzleId);
		return new PuzzleResource(puzzleId);
	}
}
