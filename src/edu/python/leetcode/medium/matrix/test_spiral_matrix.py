
from typing import List
import pytest

@pytest.fixture
def matrix() -> List[List[int]]:
    return [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]

# Simulate Spiral movement
def test_spiralOrder_01(matrix: List[List[int]]) -> List[int]:
    # Simulate the movement of spiral
    up = left = 0
    down = len(matrix) - 1
    right = len(matrix[0]) - 1

    ans = []
    while True:
        # Move to right
        row = up
        for column in range(left, right + 1):
            ans.append(matrix[row][column])

        up += 1
        if up > down:
            break

        # Move downward
        column = right
        for row in range(up, down + 1):
            ans.append(matrix[row][column])

        right -= 1
        if right < left:
            break

        # Move to left
        row = down
        for column in range(right, left - 1, -1):
            ans.append(matrix[row][column])

        down -= 1
        if up > down:
            break

        # Move upward
        column = left
        for row in range(down, up - 1, -1):
            ans.append(matrix[row][column])

        left += 1
        if right < left:
            break
    
    return ans
    
