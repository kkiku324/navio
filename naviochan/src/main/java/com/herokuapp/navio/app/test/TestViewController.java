package com.herokuapp.navio.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herokuapp.navio.entity.WordData;
import com.herokuapp.navio.resource.WordsAndMeanings;

//import com.herokuapp.navio.entity.WordData;

@Controller
@RequestMapping("/test")
public class TestViewController {

	@GetMapping("/")
	public String index() {
		return "test/top";
	}
	
//	@PostMapping("/generate")
//	public String generate(@Validated TestViewForm testViewForm, BindingResult result, Model model) {
//		if (result.hasErrors() || testViewForm.getEndPosition() - testViewForm.getStartPosition() < 50) {
//			model.addAttribute("errorMessage", "1～1900の範囲で入力してください。");
//			
//			return "test/top";
//		}
//		
//		// 出題する問題のデータを取得する
//		List<WordData> wordDataList = TestViewLogic.selectWords(testViewForm.getEndPosition(), testViewForm.getEndPosition());
//
//		model.addAttribute("wordDataList", wordDataList);
//		
//		return "test/paper";
//	}
	
	@PostMapping("/generate")
	public String generate(@Validated TestViewForm testViewForm, BindingResult result, Model model) {
		
		if (result.hasErrors() || testViewForm.getEndPosition() - testViewForm.getStartPosition() < 50) {
			model.addAttribute("errorMessage", "1～1900の範囲で入力してください。");
			
			return "test/top";
		}
		
		List<WordData> wordDataList = new ArrayList<>();  // 問題のデータ
		List<Integer> usedNumbers = new ArrayList<>();  // 出題済みの英単語の番号
		int selectedNumber = 0;  // ランダムで選ばれた英単語の番号
		Random random = new Random();  // 乱数生成用
		
		int startPosition = testViewForm.getStartPosition();
		int endPosition = testViewForm.getEndPosition();
		
		
		// 50回繰り返す
		for (int i = 0; i < 50; i++) {
			// 1問分のデータ
			WordData wordData = new WordData();
			
			// 問題番号を登録する
			wordData.setQuestionNumber(i + 1);
			
			// 出題する英単語の場号を選ぶ
			selectedNumber = random.nextInt(endPosition - startPosition + 1) + startPosition;
			
			// 出題済みの英単語ならやり直し
			while (usedNumbers.contains(selectedNumber)) {
				selectedNumber = random.nextInt(endPosition - startPosition + 1) + startPosition;
			}
			
			// 英単語とその意味を登録する
			wordData.setWord(WordsAndMeanings.words[selectedNumber]);
			wordData.setMeaning(WordsAndMeanings.meanings[selectedNumber]);
			
			// 配列に追加する
			wordDataList.add(wordData);
			
			// 出題済みの番号にする
			usedNumbers.add(selectedNumber);
		}  // end of for statement
		
		
		return "test/paper";
	}
}
