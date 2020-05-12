package com.herokuapp.navio.app.test;

import com.herokuapp.navio.entity.WordData;

import com.herokuapp.navio.resource.WordsAndMeanings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * テストに関する処理を行うモデルクラス
 */
public class TestViewLogic {
	public static List<WordData> selectWords(int startPosition, int endPosition) {
		List<WordData> wordDataList = new ArrayList<>();  // 問題のデータ
		List<Integer> usedNumbers = new ArrayList<>();  // 出題済みの英単語の番号
		int selectedNumber = 0;  // ランダムで選ばれた英単語の番号
		Random random = new Random();  // 乱数生成用
		
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
		
		return wordDataList;
	}
}
