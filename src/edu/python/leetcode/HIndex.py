
class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        citations.sort()

        for i,v in enumerate(citations):
            if n - i <= v:
                return n - i
        return 0
    
s = Solution()
h_index = [3, 0, 6, 1, 5]

print(s.hIndex(h_index))