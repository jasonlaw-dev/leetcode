#
# @lc app=leetcode id=763 lang=python3
#
# [763] Partition Labels
#

# @lc code=start
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        count = [0] * 26
        visited = [False] * 26
        res = []
        open = 0
        for c in S:
            count[ord(c) - ord('a')] += 1
        i = 0
        for j in range(0, len(S)):
            c = ord(S[j]) - ord('a')
            if not visited[c]:
                visited[c] = True
                open += 1
            count[c] -= 1
            if count[c] == 0:
                open -= 1
            if open == 0:
                res.append(j - i + 1)
                i = j + 1
        return res
# @lc code=end

