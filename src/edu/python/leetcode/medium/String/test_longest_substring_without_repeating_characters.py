
import pytest

@pytest.fixture
def s():
    return "abcabcbb"

# Using Sliding window with set data structure in Python
# A set in Python is an unordered collection of unique and immutable elements, implemented using a hash table. 
def test_lengthOfLongestSubstring(s: str) -> int:
    char_set = set()
    left = 0 # Left pointer for the sliding window
    max_length = 0
    
    for right in range(len(s)):
        # Remove all the characters from the left until we remove the duplicate
        while s[right] in char_set:
            char_set.remove(s[left])
            left += 1
            
        # Add the current character to the set
        char_set.add(s[right])

        # Update the maximum length found
        max_length = max(max_length, right - left + 1)
        
    return max_length