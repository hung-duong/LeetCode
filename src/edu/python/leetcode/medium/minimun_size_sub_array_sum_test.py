
# https://leetcode.com/problems/minimum-size-subarray-sum/

from typing import List

import pytest

@pytest.fixture
def target():
    return 7

@pytest.fixture
def nums():
    return [2, 3, 1, 2, 4, 3]

def test_minSubArrayLen(target: int, nums: List[int]) -> int:
    if not nums:
        return 0
    
    n = len(nums)
    min_len = float('inf')
    curr_sum = 0
    left = 0
    
    for right in range(n): 
        curr_sum += nums[right]
        
        while curr_sum >= target:
            min_len = min(min_len, right - left + 1)
            left += 1
            curr_sum -= nums[left - 1]

    return min_len if min_len != float('inf') else 0
