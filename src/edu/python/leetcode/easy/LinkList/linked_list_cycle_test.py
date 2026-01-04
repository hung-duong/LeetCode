import pytest
from typing import Optional
from src.edu.python.leetcode.ListNode import ListNode

@pytest.fixture
def head():
    # Create a linked list: 3 -> 2 -> 0 -> -4
    head = ListNode(3)
    second = ListNode(2)
    third = ListNode(0)
    fourth = ListNode(-4)
    head.next = second
    second.next = third
    third.next = fourth
    fourth.next = second  # Create a cycle
    return head

@pytest.fixture
def no_cycle_list():
    # Create a linked list: 1 -> 2 -> 3 -> 4
    head = ListNode(1)
    second = ListNode(2)
    third = ListNode(3)
    fourth = ListNode(4)
    head.next = second
    second.next = third
    third.next = fourth
    return head

def test_hasCycle_1(head: Optional[ListNode]) -> bool:
    # Keep track visited node
    visited = set()
    curr = head
    while curr:
        if curr in visited:
            return True
        visited.add(curr)
        curr = curr.next

    return False

# Not use more space
def test_hasCycle_2(head: Optional[ListNode]) -> bool:
    slow = head
    fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        
        if slow == fast:
            return True
        
    return False