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
		// 入力が不正または、テスト範囲が50未満の場合は戻る
		if (result.hasErrors() || testForm.getEndPosition() - testForm.getStartPosition() < 50) {
			model.addAttribute("errorMessage", "注意：1～1900の範囲で入力してください。");
			
			return "test/top";
		}
		
		// 出題するデータを取得する
		List<WordData> wordDataList = TestLogic.selectWords(testForm.getEndPosition(), testForm.getEndPosition());
		
		model.addAttribute("wordDataList", wordDataList);
		
		return "test/paper";
	}
}
