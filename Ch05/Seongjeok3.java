package Ch05;

public class Seongjeok3 {

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
