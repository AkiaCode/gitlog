package org.catry.gitlog;

import java.io.IOException;
import java.util.List;

import org.catry.gitlog.git.Git;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class rest {

	private static String workspace() throws IOException { return Config.getConfig("workspace"); };
	
	//API: /api/repos
	@GetMapping("/repos")
	List<String> repos() throws IOException {
		return Git.FindReposWithGitFolder(workspace());
	}
	
	//API: /api/branch?repo={repoName}
	@RequestMapping("/branch")
	String branch(@RequestParam(value="repo", required=true) String repoName) throws IOException {
		List<String> repos = Git.FindReposWithGitFolder(workspace());
		if (repoName.isEmpty() || !repos.contains(repoName)) { return null ; }
		
		return Git.FindRepoCurrentBranchName(workspace(), repoName);
	}
	
	//API: /api/logs?repo={repoName}
	@RequestMapping("/logs")
	List<String[]> logs(@RequestParam(value="repo", required=true) String repoName) throws IOException {
		List<String> repos = Git.FindReposWithGitFolder(workspace());
		if (repoName.isEmpty() || !repos.contains(repoName)) { return null ; }
		
		return Git.FindRepoLogs(workspace(), repoName);
	}
}
