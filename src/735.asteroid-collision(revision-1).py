#
# @lc app=leetcode id=735 lang=python3
#
# [735] Asteroid Collision
#

# @lc code=start
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for num in asteroids:
            if num > 0:
                stack.append(num)
            else:
                while stack and stack[-1] > 0 and stack[-1] < -num:
                    stack.pop()
                if not stack or stack[-1] < 0:
                    stack.append(num)
                elif stack[-1] == -num:
                    stack.pop()
        return stack
        
# @lc code=end

