package com.it.wecodeyou.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.board.model.BoardVO;
import com.it.wecodeyou.board.service.IBoardService;

@RestController
@RequestMapping(value="/board")
public class BoardController {
	private ModelAndView mv = new ModelAndView();
	
	@Autowired
	private IBoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView selectBoard() {
		mv.addObject("boardList", boardService.list());
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView registerBoard() {
		mv.setViewName("board/boardRegister");
		return mv;
	}
	@PostMapping("/register")
	public ModelAndView registerBoard(BoardVO bvo, Model model) {
		boardService.insert(bvo);
		
		return mv;
	}
}
