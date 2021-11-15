package ru.job4j.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int count = 0;
        int num = data.get(1) - data.get(0);
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i) + num == data.get(i + 1)) {
                count += data.get(i);
                if (data.get(i).equals(data.get(data.size() - 2))) {
                    count += data.get(data.size() - 1);
                }
            } else {
                return 0;
            }
        }
        return count;
    }
}
