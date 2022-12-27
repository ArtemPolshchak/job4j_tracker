package ru.job4j.map;

import java.util.*;

/**
 * @author artem.polschak@gmail.com on 27.12.2022.
 * @project job4j_tracker
 * The class gets statistics on passports.
 */
public class AnalyzeByMap {

    /**
     * method calculate the overall average score.
     * @param pupils list with students
     * @return overall average score
     */
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double score = 0D;
        for (Pupil p : pupils) {
            List<Subject> subjects = p.subjects();
            count += p.subjects().size();
            for (Subject s : subjects) {
                score += s.score();
            }
        }
        return score / count;
    }

    /**
     * the method calculates the average score for each student.
     * @param pupils list with students
     * @return List with name and average score for each student
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupil = new ArrayList<>();
        for (Pupil p : pupils) {
            int count = 0;
            double score = 0D;
            List<Subject> subjects = p.subjects();
            for (Subject s : subjects) {
                count++;
                score += s.score();
            }
            pupil.add(new Label(p.name(), score / count));
        }
        return pupil;
    }

    /**
     * the method calculates the average score for each subject.
     * @param pupils list with students
     * @return List with name of subject and average score for each subject.
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();

        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                int score = map.getOrDefault(s.name(), 0);
                map.put(s.name(), score + s.score());
            }
        }

        for (Map.Entry<String, Integer> result : map.entrySet()) {
            double tmp = (double) result.getValue() / pupils.size();
            subjects.add(new Label(result.getKey(), tmp));
        }
        return subjects;
    }

    /**
     * the method finding student with the highest total score in all subjects
     * @param pupils list with students
     * @return the best student
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            int count = 0;
            for (Subject s : p.subjects()) {
                count += s.score();
            }
            result.add(new Label(p.name(), count));
        }
        result.sort(Comparator.naturalOrder());

        return result.get(result.size() - 1);
    }

    /**
     * the method finding the highest scoring subject for all students
     * @param pupils list with students
     * @return the best subject
     */
    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();

        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                int score = map.getOrDefault(s.name(), 0);
                map.put(s.name(), score + s.score());
            }
        }

        for (Map.Entry<String, Integer> result : map.entrySet()) {
            subjects.add(new Label(result.getKey(), result.getValue()));
        }

        subjects.sort(Comparator.naturalOrder());
        return subjects.get(subjects.size() - 1);
    }
}
