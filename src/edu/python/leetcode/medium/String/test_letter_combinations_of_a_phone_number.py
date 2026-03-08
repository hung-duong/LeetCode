
from typing import List
import pytest

@pytest.fixture
def digits():
    return "23"

hashMaps = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "pqrs",
    "8": "tuv",
    "9": "wxyz"
}

# Solution 1: Using DFS
# Time complexity: O(4ᴺ × N)
def test_letterCombinations_01(digits: str) -> List[str]:
    ans = []
    if not digits:
        return ans

    backtracking(0, "", digits, ans)
    return ans

def backtracking(index: int, path: str, digits: str, ans: List[str]):
    # If the path have same length as digits, we have a complete combination
    if len(path) == len(digits):
        ans.append(path)
        return
    
    # Get the letters that the current digit maps to and loop through them
    possible_letters = hashMaps[digits[index]]
    for letter in possible_letters:
        # Add the letter to current path
        path += letter

        # Call the backtrack for next possible
        backtracking(index + 1, path, digits, ans)

        # Remove the letter before moving to the next
        path = path[:-1]
        
        
# Solution 2: Using BFS
# Σ (number of combinations at level i) × (cost to build each new string)
# = Σ (4ⁱ × (i+1)) for i = 0 to N-1
# => Time complexity ≈ O(4ᴺ × N) and space O(4ᴺ x N)
def test_letterCombinations_02(digits: str) -> List[str]:

    if not digits:
        return []

    maps = [
        "",     # 0
        "",     # 1
        "abc",  # 2
        "def",  # 3
        "ghi",  # 4
        "jkl",  # 5
        "mno",  # 6
        "pqrs", # 7
        "tuv",  # 8
        "wxyz"  # 9
    ]

    queue = [""]
    for digit in digits:
        letters = maps[int(digit)]
        new_queue = []
        for comb in queue:
            for letter in letters:
                new_queue.append(comb + letter)

        queue = new_queue

    return queue
