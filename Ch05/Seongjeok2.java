package Ch05;

import java.util.Arrays;
import java.util.Comparator;

public class Seongjeok2 {

    public static void main(String[] args) {
        int[][] score = {
                { 100, 100, 100},
                { 20, 20, 20},
                { 30, 30, 30},
                { 40, 40, 40},
                { 50, 50, 50}
        };

        // 과목별 총점
        int korTotal = 0, engTotal = 0, mathTotal = 0;

        // 학생들의 평균 저장 배열
        float[] averages = new float[score.length];

        System.out.println(" 번호   국어   영어   수학   총점   평균  순위 ");
        System.out.println("==========================================");

        // 총점 및 평균 계산
        for (int i = 0; i < score.length; i++) {
            int sum = 0; // 개인별 총점
            float avg = 0.0f; // 개인별 평균

            korTotal += score[i][0];
            engTotal += score[i][1];
            mathTotal += score[i][2];

            System.out.printf(" %3d", i + 1);

            for (int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
                System.out.printf(" %5d", score[i][j]);
            }

            avg = sum / (float) score[i].length;
            averages[i] = avg; // 평균을 averages 배열에 저장

            System.out.printf(" %5d  %5.1f", sum, avg);
            System.out.println();
        }

        // 평균을 기준으로 순위를 계산하기 위한 배열 생성
        Integer[] ranks = new Integer[score.length];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = i; // 학생 번호 저장
        }

        // 학생들의 평균을 기준으로 내림차순 정렬
        Arrays.sort(ranks, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Float.compare(averages[i2], averages[i1]); // 평균 내림차순
            }
        });

        // 출력: 순위 추가
        System.out.println("==========================================");
        for (int i = 0; i < score.length; i++) {
            int rank = 1;
            // 해당 학생의 순위 구하기
            for (int j = 0; j < ranks.length; j++) {
                if (ranks[j] == i) {
                    rank = j + 1;
                    break;
                }
            }

            System.out.printf(" %3d", i + 1);
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf(" %5d", score[i][j]);
            }

            int sum = 0;
            float avg = 0.0f;
            for (int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
            }
            avg = sum / (float) score[i].length;
            
            System.out.printf(" %5d  %5.1f  %3d\n", sum, avg, rank);
        }

        // 과목별 총점 출력
        System.out.println("==========================================");
        System.out.printf("총점:   %3d  %4d  %4d\n", korTotal, engTotal, mathTotal);
    }
}
