
import pytest
from typing import Optional
from src.edu.python.leetcode.ListNode import ListNode


@pytest.fixture
def head():
    # Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    return head

@pytest.fixture
def n():
    return 1

def test_removeNthFromEnd(head: Optional[ListNode], n: int) -> Optional[ListNode]:
    # Define length of linked list
    sz = 0
    curr = head 
    while curr is not None:
        sz += 1
        curr = curr.next
    
    # Find the node before the node to be removed
    curr = head
    for _ in range(sz - n - 1):
        curr = curr.next

    # Existing 3 cases:
    # 1. If node needs to be remove is head:
    #    1.1 If Linked List is only 1 node, then return None
    #    1.2 If Linked List is more than 1 node, then remove head
    # 2. If node needs to be removed is tail
    # 3. If node needs to be removed is in the middle
    
    if n == sz and sz == 1:
        return None
    elif n == sz and sz > 1:
        head = head.next
        return head

    if n == 1:
        curr.next = None
        return head

    curr.next = curr.next.next
    
    return head