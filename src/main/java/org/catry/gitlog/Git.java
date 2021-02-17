package org.catry.gitlog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @package Git.java
 * @author Catry
 * @version 1.0
 */

public class Git {

    private static int Error = 0; //NOTE: not error: 0, error: -1

    /**
     * Found repos(subfolders of workspace) with .git folder
     * @param workspace
     * @return List<String>
     */
    public static List<String> FindReposWithGitFolder (String workspace) {
        List<String> FoundFolders = new ArrayList<>();
        List<String> Repos = new ArrayList<>();
        File Folders = new File(workspace);

        for (File folder : Folders.listFiles()) {
            if (!folder.isFile()) {
                FoundFolders.add(folder.getName());
            }
        }

        for (String folder: FoundFolders) {
            File CheckGitFolder = new File(workspace + "/" + folder);
            for (String Check : CheckGitFolder.list()) {
                if (Check.equals(".git")) {
                    Repos.add(folder);
                }
            }
        }

        return Repos;
    }

    /**
     * Found Current branch name of repo (.git/refs/heads, Filename)
     * @param workspace, repos, repoName
     * @return String
     */
    public static String FindRepoCurrentBranchName (String workspace, String repoName) {
        File BranchName = new File(workspace + "/" + repoName + "/.git/refs/heads");
        if (BranchName.list().length == 0) {
            Error = -1;
            return "Not found Current branch";
        }
        return BranchName.list()[0];
    }

    /**
     * Found git log of repo (Current branch) (.git/logs/HEAD)
     * @param workspace, repoName
     * @return List<String[]>
     */
    public static List<String[]> FindRepoLogs (String workspace, String repoName) throws IOException {
        File LogFolder = new File(workspace + "/" + repoName + "/.git/logs");
        File LogFile = new File(workspace + "/" + repoName + "/.git/logs/HEAD");
        List<String[]> map = new ArrayList<>();

        if (!LogFolder.exists() && !LogFile.exists()) {
            if (Error == -1) {
                map.add(new String[] { "Your current branch '" + FindRepoCurrentBranchName(workspace, repoName) + "' does not have any commits yet" });
            } else {
                map.add(new String[] { FindRepoCurrentBranchName(workspace, repoName) });
            }
            return map;
        }

        Path path = Paths.get(String.valueOf(LogFile));
        Stream<String> lines = Files.lines(path);
        List<String> logs = new ArrayList<>();

        for (Object line: lines.toArray()) { logs.add(line.toString()); }
        lines.close();

        for (String log: logs) {
            gitLogs.setLog(log.split(" ")[0],
                    log.split(" ")[1],
                    log.split(" ")[2],
                    log.split(" ")[3],
                    new Integer(log.split(" ")[4]),
                    log.substring(123, 128),
                    log.substring(129).split(":")[0],
                    log.split(": ")[1].trim());

            String[] GitLog = {
                    gitLogs.getPrevHash(),
                    gitLogs.getHash(),
                    gitLogs.getName(),
                    gitLogs.getEmail(),
                    String.valueOf(gitLogs.getTime()),
                    gitLogs.getTimeZone(),
                    gitLogs.getAction(),
                    gitLogs.getMessage()
            };

            map.add(GitLog);
        }

        return map;
    }
}
