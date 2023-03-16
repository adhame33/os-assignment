/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

/**
 *
 * @author PC
 */
public class SJF {
    static void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
        int rt[] = new int[n];
        for (int i = 0 ; i < n ; i++)
            rt[i] =  bt[i];
        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;
        while (complete != n) {
            for (int j = 0 ; j < n; j++) {
                if ((rt[j] <= minm) && (rt[j] > 0)) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }
            if (check == false) {
                t++;
                continue;
            }
            rt[shortest]--;;
            minm = rt[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;
            if (rt[shortest] == 0) {
                complete++;
                check = false;
                finish_time = t + 1;
                wt[shortest] = finish_time - bt[shortest];
                if (wt[shortest] < 0)
                    wt[shortest] = 0;
            }
            t++;
        }
    }
    
    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }
    
    static void findAvgTimeS(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        findWaitingTime(processes, n, bt, wt);
        findTurnAroundTime(processes, n, bt, wt, tat);
        int total_wt = 0, total_tat = 0;
        System.out.println("SJF Process\t SJF Burst Time\t SJF Waiting Time\t SJF Turn-Around Time");
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(processes[i] + "\t\t " + bt[i] + "\t\t " + wt[i] + "\t\t " + tat[i]);
        }
        System.out.println("SJF Average waiting time = " + (float)total_wt / (float)n);
        System.out.println("SJF Average turn-around time = " + (float)total_tat / (float)n);
    }
}
