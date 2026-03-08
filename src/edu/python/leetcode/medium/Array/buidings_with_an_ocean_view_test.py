
from ast import List
import pytest

@pytest.fixture
def heights() -> List[int]:
    return [4, 2, 3, 1]

def test_findBuildings(heights: List[int]) -> List[int]:
    # Use the Stack
    # Step 1: Keep the last buiding height in the stack (because this building always view the see)
    n = len(heights)
    stack = []
    stack.append(n - 1)

    # Start j from building at location n - 2 to 0
    # Pop the location of build on top of stack, like i
    # If height of building i <  height of building j -> building i and j are able to view the ocean
    #    - Keep the location of build i - 1 and i in stack
    # else: Only building i is able to view the ocean
    #.   - Keep the location of build i in stack
    for i in range(n - 2, -1, -1):
        j = stack.pop()
        if heights[i] > heights[j]:
            stack.append(j)
            stack.append(i)
        else:
            stack.append(j)

    ans = []
    while len(stack) != 0:
        i = stack.pop()
        ans.append(i)

    return ans

