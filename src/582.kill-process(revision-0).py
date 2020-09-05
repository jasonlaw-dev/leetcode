#
# @lc app=leetcode id=582 lang=python3
#
# [582] Kill Process
#

# @lc code=start
class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        graph = {}
        for i in range(len(pid)):
            if ppid[i] not in graph:
                graph[ppid[i]] = []
            graph[ppid[i]].append(pid[i])
        toKill = [kill]
        res = []
        while toKill:
            kill = toKill.pop()
            res.append(kill)
            if kill in graph:
                toKill.extend(graph[kill])
        return res
# @lc code=end

