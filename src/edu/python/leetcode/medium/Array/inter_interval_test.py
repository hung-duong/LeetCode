

from ast import List
import pytest
    

@pytest.fixture
def intervals() -> List[List[int]]:
    return [[1, 3], [6, 9]]

@pytest.fixture
def newInterval() -> List[int]:
    return [2, 5]

# Solution 1: Use Stack
# O(n) and O(n) of memory
def test_insert_01(intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
    ans = []
    ans.append(newInterval)

    for interval in intervals:
        start = interval[0]
        end = interval[1]

        newInterval = ans.pop()
        if start > newInterval[1]:
            ans.append(newInterval)
            ans.append(interval)
        elif end < newInterval[0]: 
            ans.append(interval)
            ans.append(newInterval)
        else:
            new_start = min(start, newInterval[0])
            end_start = max(end, newInterval[1])
            ans.append([new_start, end_start])

    return ans

