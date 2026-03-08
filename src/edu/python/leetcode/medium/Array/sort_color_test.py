
from typing import List
import pytest

@pytest.fixture
def nums() -> List[int]:
    return [2, 0, 2, 1, 1, 0]

def test_sortColors(nums: List[int]) -> None:
    count_red = 0
    count_white = 0
    count_blue = 0

    for num in nums:
        if num == 0:
            count_red += 1

        if num == 1:
            count_white += 1

        if num == 2:
            count_blue += 1

    for i in range(len(nums)):
        if count_red > 0:
            nums[i] = 0
            count_red -= 1
        elif count_white > 0:
            nums[i] = 1
            count_white -= 1
        else:
            nums[i] = 2