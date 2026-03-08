from typing import List

import pytest

@pytest.fixture
def nums():
    return [5, 7, 7, 8, 8, 10]

@pytest.fixture
def target():
    return 8

# Complexity: O(nlogn)
def test_searchRange(nums: List[int], target: int) -> List[int]:
    
    left, right = 0, len(nums) - 1
    
    while left <= right:
        median = left + (right - left) // 2
        
        if nums[median] < target:
            left = median + 1
        elif nums[median] > target:
            right = median - 1
        else:
            # Find the first and last position
            first = last = median
            while first > 0 and nums[first - 1] == target:
                first -= 1
            while last < len(nums) - 1 and nums[last + 1] == target:
                last += 1
            return [first, last]
        
    return [-1, -1]