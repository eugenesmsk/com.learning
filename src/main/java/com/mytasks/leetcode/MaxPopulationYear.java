package com.mytasks.leetcode;


//Accepted


public class MaxPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int counter;
        int year = 1950;
        int maxYear = 0;
        int maxCount = 0;
        int count = 0;
        if(logs.length == 1) {return logs[0][0];}
        else {
            while (year <= 2050) {
                for(int[] i: logs) {
                    if(i[0] <= year && year < i[1]) {
                        count++;
                    }
                }
                if(count > maxCount) {
                    maxCount = count;
                    maxYear = year;
                }
                else if(count == maxCount) {
                    if(year < maxYear) {
                        maxYear = year;
                    }
                }
                count = 0;
                year++;
            }
        }
        return maxYear;
    }
}

class Test {
    public static void main(String[] args) {
        MaxPopulationYear year = new MaxPopulationYear();
        int[][] logs = {
                        {1950,1961},
                        {1960,1971},
                        {1970,1981}
                        };

        System.out.println(year.maximumPopulation(logs));
    }
}