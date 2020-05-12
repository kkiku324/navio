package com.herokuapp.navio.app.test;

import com.herokuapp.navio.entity.WordData;
import com.herokuapp.navio.resource.WordsAndMeanings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * �e�X�g�Ɋւ��鏈�����s�����f���N���X
 */
public class TestLogic {
	public static List<WordData> selectWords(int startPosition, int endPosition) {
		List<WordData> wordDataList = new ArrayList<>();  // �e�X�g����p�P��̃��X�g
		List<Integer> usedNumbers = new ArrayList<>();  // �o��ς݂̉p�P��̔ԍ�
		int selectedNumber = 0;  // �����_���őI�΂ꂽ���ԍ�
		Random random = new Random();  // �p�P��������_���őI�Ԃ��߂̗��������C���X�^���X
		
		// 50�̒P���I�яo��
		for (int i = 0; i < 50; i++) {
			// 1�╪�̂̉p�P��̃f�[�^
			WordData wordData = new WordData();
			
			// ���ԍ���o�^����
			wordData.setQuestionNumber(i + 1);
			
			while (true) {
				// �o�肷��p�P��̔ԍ���I��
				selectedNumber = random.nextInt(endPosition - startPosition + 1) + startPosition;
				
				// �o��ς݂̉p�P��̔ԍ��Ȃ猈�߂Ȃ���
				if (usedNumbers.contains(selectedNumber)) {
					continue;
				}
				else {
					// ���֐i��
					break;
				}
			}
			
			// �I�񂾔ԍ��̒P��ƈӖ����擾����
			wordData.setWord(WordsAndMeanings.words[selectedNumber]);
			wordData.setMeaning(WordsAndMeanings.meanings[selectedNumber]);
			
			// ���X�g�ɒǉ�����
			wordDataList.add(wordData);
			
			// �ԍ����o��ς݂ɂ���
			usedNumbers.add(selectedNumber);
		}  // end of for statement
		
		return wordDataList;
	}
}
