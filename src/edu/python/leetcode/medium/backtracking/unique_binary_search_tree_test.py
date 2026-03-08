

from functools import cache
import pytest

@pytest.fixture
def n():
    return 5


# Solution 1: Brute force (naive)
# complextiy: O(2^n)
def test_numTrees_1(n: int) -> int:
    if n <= 1:
        return 1

    ans = 0
    for i in range(1, n + 1):
        ans += test_numTrees_1(i - 1) * test_numTrees_1(n - i)

    return ans

# Solution 2: Dynamic Programming (Bottom-Up)
#                                                                          numTrees(4)
#                   numTrees()*numTrees(3)          numTrees(2) * numTrees(1)        numTrees(1)* numTrees(2)        numTrees(3)*numTrees(0)
# numTrees(0)*numTrees(2)  numTrees(1)*numTrees(1)  numTrees(2)*numTrees(0)        
# numTrees(0)*numTrees(1)   numTrees(1)*numTrees(0)

# decorator (from Python’s functools module) is a memoization tool that automatically stores the results of function calls so that if the same inputs occur again, the function doesn’t recompute — it returns the cached result instantly.
# Complextity: reduce from O(2^n) to O()
@cache
def test_numTrees_2(n: int) -> int:
    if n <= 1:
        return 1

    ans = 0
    for i in range(1, n + 1):
        ans += test_numTrees_2(i - 1) * test_numTrees_2(n - i)

    return ans

# Solution 3: Dynamic Programming (Top-Down)
def test_numTrees_3(n: int) -> int:
    dp = [0] * (n + 1)
    dp[0], dp[1] = 1, 1

    for i in range(2, n + 1):
        for j in range(1, i + 1):
            dp[i] += dp[j - 1] * dp[i - j]

    return dp[n]