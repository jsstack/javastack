package com.jsstack.javastack.worker;

import com.jsstack.javastack.constant.Global;
import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Image;
import com.jsstack.javastack.model.Puzzle;

public class ParsePuzzleWorker implements IWorker {

	private IDao dao = new Dao();

	@Override
	public String getQueue() {
		return Global.PuzzlesResource.PARSE_PUZZLE_MQ;
	}

	@Override
	public void process(String msg) {
		int puzzleId = Integer.parseInt(msg);
		Puzzle p = dao.findById(Puzzle.class, puzzleId);
		Image img = dao.findById(Image.class, p.getImageId());
	}

}
