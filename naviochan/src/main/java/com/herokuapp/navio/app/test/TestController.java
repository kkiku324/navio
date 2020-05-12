package com.herokuapp.navio.app.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herokuapp.navio.entity.WordData;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping("/")
	public String index() {
		return "test/top";
	}
	
	@PostMapping("/generate")
	public String generate(@Validated TestForm testForm, BindingResult result, Model model) {
		// ���͂��s���܂��́A�e�X�g�͈͂�50�����̏ꍇ�͖߂�
		if (result.hasErrors() || testForm.getEndPosition() - testForm.getStartPosition() < 50) {
			model.addAttribute("errorMessage", "���ӁF1�`1900�͈̔͂œ��͂��Ă��������B");
			
			return "test/top";
		}
		
		// �o�肷��f�[�^���擾����
		List<WordData> wordDataList = TestLogic.selectWords(testForm.getEndPosition(), testForm.getEndPosition());
		
		model.addAttribute("wordDataList", wordDataList);
		
		return "test/paper";
	}
}
