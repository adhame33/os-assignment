/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject5;

import static com.mycompany.mavenproject5.RoundRobin.findAvgTime;
import static com.mycompany.mavenproject5.SJF.findAvgTimeS;

/**
 *
 * @author PC
 */
public class Mavenproject5 {

    public static void main(String[] args) {
   int processes[] = {1, 2, 3};
        int n = processes.length;
        int burst_time[] = {10, 5, 8};
        int quantum = 2;
        findAvgTime(processes, n, burst_time, quantum);
        findAvgTimeS(processes, n, burst_time);
    }
}
