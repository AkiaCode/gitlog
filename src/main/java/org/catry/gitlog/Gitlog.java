package org.catry.gitlog;

import java.io.IOException;
import java.util.List;

/**
 * @package Gitlog.java
 * @author Catry
 * @version 1.0
 */

public class Gitlog {
    /**
     * Just main function
     * @param arg
     */
    public static void main(String arg[]) throws IOException {
        // Found get workspace
        String workspace = Config.getConfig("workspace");
        // Found Repos With Git folder
        List<String> repos = Git.FindReposWithGitFolder(workspace);
        // Found Branch name of repo
        String branchName = Git.FindRepoCurrentBranchName(workspace, repos.get(1));
        // Found logs of repo
        List<String[]> logs = Git.FindRepoLogs(workspace, repos.get(1));

        System.out.println("Current branch name: " + branchName);

        for (String[] log: logs) {
            if (log.length == 1) {
                System.out.println(log[0]);
                break;
            }

            gitLogs.setLog(log[0], log[1], log[2], log[3], new Integer(log[4]), log[5], log[6], log[7]);
            System.out.println("\nPrevHash: " + gitLogs.getPrevHash() + "\nHash: " + gitLogs.getHash() + "\nName: " + gitLogs.getName() + "\nEmail: " + gitLogs.getEmail() + "\nTime: " + gitLogs.getTime() + "\nTimeZone: " + gitLogs.getTimeZone() + "\nAction: " + gitLogs.getAction() + "\nMessage: " + gitLogs.getMessage());
        }
    }
}
