package com.jsstack.javastack.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.constant.Global;
import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Puzzle;
import com.jsstack.javastack.mq.MQ;

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
	public Puzzle addPuzzle(Puzzle p) {
		System.out.println("create puzzle with imageId=" + p.getImageId());
		Puzzle puzzle = new Puzzle();
		puzzle.setImageId(p.getImageId());
		puzzle.setDateCreated(new Date().getTime());

		int id = dao.insert(puzzle);

		puzzle.setId(id);

		MQ.push(Global.PuzzlesResource.PARSE_PUZZLE_MQ, String.valueOf(id));
		
		return puzzle;
	}

	@Path("{id}")
	public PuzzleResource getPuzzle(@PathParam("id") int puzzleId) {
		System.out.println("=============================" + puzzleId);
		return new PuzzleResource(puzzleId);
	}
	
	@Path("{id}/pieces")
	public PiecesResource getPieces(@PathParam("id") int puzzleId) {
		System.out.println("=============================" + puzzleId);
		return new PiecesResource(puzzleId);
	}
}
