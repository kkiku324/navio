package com.herokuapp.navio.app.test;

import com.herokuapp.navio.entity.WordData;
import com.herokuapp.navio.resource.WordsAndMeanings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * テストに関する処理を行うモデルクラス
 */
public class TestLogic {
	public static List<WordData> selectWords(int startPosition, int endPosition) {
		List<WordData> wordDataList = new ArrayList<>();  // テストする英単語のリスト
		List<Integer> usedNumbers = new ArrayList<>();  // 出題済みの英単語の番号
		int selectedNumber = 0;  // ランダムで選ばれた問題番号
		Random random = new Random();  // 英単語をランダムで選ぶための乱数生成インスタンス
		
		// 50個の単語を選び出す
		for (int i = 0; i < 50; i++) {
			// 1問分のの英単語のデータ
			WordData wordData = new WordData();
			
			// 問題番号を登録する
			wordData.setQuestionNumber(i + 1);
			
			while (true) {
				// 出題する英単語の番号を選ぶ
				selectedNumber = random.nextInt(endPosition - startPosition + 1) + startPosition;
				
				// 出題済みの英単語の番号なら決めなおし
				if (usedNumbers.contains(selectedNumber)) {
					continue;
				}
				else {
					// 次へ進む
					break;
				}
			}
			
			// 選んだ番号の単語と意味を取得する
			wordData.setWord(WordsAndMeanings.words[selectedNumber]);
			wordData.setMeaning(WordsAndMeanings.meanings[selectedNumber]);
			
			// リストに追加する
			wordDataList.add(wordData);
			
			// 番号を出題済みにする
			usedNumbers.add(selectedNumber);
		}  // end of for statement
		
		return wordDataList;
	}
}
