from typing import List
import pytest

@pytest.fixture
def nums() -> List[int]:
    return [0, 0]

def test_moveZeroes(nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    left = 0 # Pointer to the first zero
    right = 0 # Pointer to the first non-zero
    n = len(nums)

    # Move the left and right pointers
    while left < n and right < n:

        # Find the next zero
        while left < n and nums[left] != 0:
            left += 1

        # Find the next non-zero after the left pointer
        if right < left:
            right = left + 1
            
        while right < n and nums[right] == 0:
            right += 1

        # Swap the found zero with the found non-zero
        if left < n and right < n and left < right:
            nums[left], nums[right] = nums[right], nums[left]
            