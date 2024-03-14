class Solution:
    # https://leetcode.com/problems/longest-substring-without-repeating-characters/
    # Array - Sliding Window - 2 pointers
    def MinimumSizeSubarraySum(self, target: int, nums: List[int]) -> int:
        sum = 0
        min_len = math.inf
        left = 0
        for right in range(len(nums)):
            sum += nums[right]

            while sum >= target:
                min_len = min(min_len, right - left + 1)
                sum -= nums[left]
                left += 1
        
        return min_len if min_len != math.inf else 0