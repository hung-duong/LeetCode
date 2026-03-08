

import pytest

@pytest.fixture
def n():
    return 4

# n = 1 -> 1
# n = 2 -> 11
# n = 3 -> 21
# n = 4 -> 1211
# n = 5 -> 111221
# n = 6 -> 312211

# Solution 1: Recursive
# * Running Time: O(2^n) => Because each time, the string grow fast and can
# be 2 * length of preivous
#    Eg. si = 1234 -> si+1 = 11121314
# * Space: O(n x 2 ^ n)
#.  Cause n is the stack of depth and 2^n is because of string growing fast
def helper(s: str) -> str:
    ans = ''
    count = 0
    last_num = ''
    for i in range(0, len(s)):
        last_num = s[i]
        if i == 0 or s[i] == s[i-1]:
            count += 1
        else:
            ans += str(count) + s[i - 1]
            count = 1
            
    ans += str(count) + last_num
    return ans

def test_countAndSay_01(n: int) -> str:
    if n == 1:
        return '1'

    prev = test_countAndSay_01(n - 1)
    ans = helper(prev)

    return ans


# Solution 1: Interative
# * Running Time: O(2^n) => Because we have n terms and each term can
# * Space: O(2^n) maybe double every term
def test_countAndSay_02(n: int) -> str:
    if n == 1:
        return '1'

    ans = '1'
    for term in range(2, n + 1):
        # For each term, determine the result from previous string
        res = ''
        count = 0
        last_num = ''
        for i in range(0, len(ans)):
            last_num = ans[i]
            if i == 0 or ans[i] == ans[i-1]:
                count += 1
            else:
                res += str(count) + ans[i-1]
                count = 1   # Reset count for num at i
                
        ans = res + str(count) + last_num

    return ans

