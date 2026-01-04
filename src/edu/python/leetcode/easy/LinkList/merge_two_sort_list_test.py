
import pytest
from src.edu.python.leetcode.ListNode import ListNode

@pytest.fixture
def list1():
    # Create linked list 1 -> 2 -> 4
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(4)
    return head

@pytest.fixture
def list2():
    # Create linked list 1 -> 3 -> 4
    head = ListNode(1)
    head.next = ListNode(3)
    head.next.next = ListNode(4)
    return head

def test_mergeTwoLists_1(list1: ListNode, list2: ListNode):
    # Purpose: merge list2 into list1 as long as the list1 is sorted

    # If either list is empty, return the other list
    if list1 is None:
        return list2
    
    if list2 is None:
        return list1
    
    if list1.val <= list2.val:
        pointer1 = head = list1
        pointer2 = list2
    else:
        pointer1 = head = list2
        pointer2 = list1

    while pointer1 is not None and pointer2 is not None:
        if pointer1.val <= pointer2.val:
            if pointer1.next is not None:
                if pointer1.next.val > pointer2.val:
                    # Insert current pointer2 between pointer1 and pointer1.next and move pointer2 to next
                    curr = pointer2
                    pointer2 = pointer2.next
                    
                    curr.next = pointer1.next
                    pointer1.next = curr
                    pointer1 = pointer1.next
                    
                else:
                    # Move to the next node in pointer1
                    pointer1 = pointer1.next
            else:
                # If pointer1 has reached the end, append pointer2
                pointer1.next = pointer2
                break
        else:
            pointer1 = pointer1.next

    return head

# Use: Recursive
def test_mergeTwoLists_2(list1: ListNode, list2: ListNode):
    # Use: Recursive
    
    if list1 is None:
        return list2
    
    if list2 is None:
        return list1

    if list1.val <= list2.val:
       list1.next = test_mergeTwoLists_2(list1.next, list2)
       return list1
    else:
       list2.next = test_mergeTwoLists_2(list1, list2.next)
       return list2
