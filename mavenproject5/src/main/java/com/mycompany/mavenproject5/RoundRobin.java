/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

/**
 *
 * @author PC
 */
public class RoundRobin {
    static void findWaitingTime(int processes[], int n, int bt[], int wt[], int quantum) {
        int rem_bt[] = new int[n];
        for (int i = 0 ; i < n ; i++)
            rem_bt[i] =  bt[i];
        int t = 0;
        while(true) {
            boolean done = true;
            for (int i = 0 ; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    if (rem_bt[i] > quantum) {
                        t += quantum;
                        rem_bt[i] -= quantum;
                    }
                    else {
                        t = t + rem_bt[i];
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done == true)
                break;
        }
    }
    
    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }
    
    static void findAvgTime(int processes[], int n, int bt[], int quantum) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findWaitingTime(processes, n, bt, wt, quantum);
        findTurnAroundTime(processes, n, bt, wt, tat);
        System.out.println("RR Process\t RR Burst Time\t RR Waiting Time\t RR Turn-Around Time");
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(processes[i] + "\t\t " + bt[i] + "\t\t " + wt[i] + "\t\t " + tat[i]);
        }
        System.out.println("RR  Average waiting time = " + (float)total_wt / (float)n);
        System.out.println("RR  Average turn-around time = " + (float)total_tat / (float)n);
    }
}
