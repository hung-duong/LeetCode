

import heapq
from typing import List
import typing


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Solution: Using Min heap
# Using Min heap
# Complextiy: O(Nlogk) with N is number of list list, K is number 
def mergeKLists(lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    heap = []

    for ls in lists:
        node = ls
        while node:
            heapq.heappush(heap, node.val)
            node = node.next

    root = ListNode()
    node = root
    next = node
    while heap:
        val = heapq.heappop(heap)
        next = ListNode(val, None)
        node.next = next 
        node = next

    return root.next