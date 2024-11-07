package Ch05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Seongjeok4 {

    public static void main(String[] args) {
        // 주어진 파일 경로
        String filePath = "D:\\kmw_data\\ecl_java_data\\java_js\\src\\Ch05\\scores.txt"; // Windows 경로

        // 학생 수를 미리 알 수 없으므로, 먼저 데이터를 읽고 학생 수를 파악한 후 배열 크기를 결정합니다.
        int[][] score = readScoresFromFile(filePath);

        if (score == null) {
            System.out.println("데이터를 읽을 수 없습니다.");
            return;
        }

        // 과목별 총점
        int korTotal = 0, engTotal = 0, mathTotal = 0;

        // 학생들의 총점, 평균, 순위를 저장하는 배열
        Student[] students = new Student[score.length];

        // 총점 및 평균 계산
        for (int i = 0; i < score.length; i++) {
            int sum = 0; // 개인별 총점
            float avg = 0.0f; // 개인별 평균

            korTotal += score[i][0];
            engTotal += score[i][1];
            mathTotal += score[i][2];

            // 학생 객체 생성
            for (int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
            }
            avg = sum / (float) score[i].length;

            students[i] = new Student(i + 1, sum, avg); // 학생 객체 생성 및 저장
        }

        // 버블 정렬을 이용해 학생들의 평균을 기준으로 내림차순 정렬
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].avg < students[j + 1].avg) {
                    // 평균이 작은 학생과 큰 학생을 교환
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        // 순위 부여
        for (int i = 0; i < students.length; i++) {
            students[i].rank = i + 1; // 순위는 1부터 시작
        }

        // 출력
        System.out.println(" 번호   국어   영어   수학   총점   평균  순위 ");
        System.out.println("==========================================");

        for (int i = 0; i < students.length; i++) {
            // 학생 번호에 맞춰서 점수를 출력
            int studentIndex = students[i].number - 1;
            System.out.printf(" %3d", students[i].number);
            for (int j = 0; j < score[studentIndex].length; j++) {
                System.out.printf(" %5d", score[studentIndex][j]);
            }
            System.out.printf(" %5d  %5.1f  %3d\n", students[i].sum, students[i].avg, students[i].rank);
        }

        // 과목별 총점 출력
        System.out.println("==========================================");
        System.out.printf("총점:   %3d  %4d  %4d\n", korTotal, engTotal, mathTotal);
    }

    // 파일에서 성적 데이터를 읽어오는 메서드
    public static int[][] readScoresFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowCount = 0;

            // 첫 번째로 파일의 행 수를 세기 위해 반복
            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            // 배열 크기 설정
            int[][] score = new int[rowCount][3];

            // 두 번째로 파일을 다시 읽어 데이터를 배열에 저장
            br.close();  // 첫 번째 리소스를 닫고 다시 파일을 열어야 하므로

            BufferedReader br2 = new BufferedReader(new FileReader(filePath));  // 두 번째 BufferedReader 생성
            int i = 0;
            while ((line = br2.readLine()) != null) {
                String[] tokens = line.split("\\s+"); // 공백을 기준으로 분리
                for (int j = 0; j < tokens.length; j++) {
                    score[i][j] = Integer.parseInt(tokens[j]);
                }
                i++;
            }

            br2.close(); // 두 번째 리소스를 닫음
            return score;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 학생 정보를 저장하는 Student 클래스
    static class Student {
        int number;  // 학생 번호
        int sum;     // 학생의 총점
        float avg;   // 학생의 평균
        int rank;    // 학생의 순위

        // 생성자
        public Student(int number, int sum, float avg) {
            this.number = number;
            this.sum = sum;
            this.avg = avg;
        }
    }
}
