# Definition for a binary tree node.
import pytest
from typing import Optional

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
@pytest.fixture
def root() -> Optional[TreeNode]:
    # Create a sample BST
    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(7)
    return root

@pytest.fixture
def low() -> int:
    return 2

@pytest.fixture
def high() -> int:
    return 5

from queue import Queue

def test_range_sum_BST_01(root: Optional[TreeNode], low: int, high: int) -> int:
    # Use Inorder Traversal to find the range sum by using a queue to store the nodes
    curr = root
    queue = Queue()
    queue.put(curr)
    range_sum = 0
    while not queue.empty():
        curr = queue.get()
        
        if low <= curr.val <= high:
            range_sum += curr.val
            
        if curr.left:
            queue.put(curr.left)

        if curr.right:
            queue.put(curr.right)
    
    return range_sum


def test_range_sum_BST_01_improved(root: Optional[TreeNode], low: int, high: int) -> int:
    # Use Inorder Traversal to find the range sum by using a queue to store the nodes
    # We store only the nodes that are within the range [low, high]
    curr = root
    queue = Queue()
    queue.put(curr)
    range_sum = 0   
    while not queue.empty():
        curr = queue.get()
        
        if low <= curr.val <= high:
            range_sum += curr.val
            
        if curr.left and curr.val > low:
            queue.put(curr.left)

        if curr.right and curr.val < high:
            queue.put(curr.right)
    
    return range_sum

def test_range_sum_BST_02(root: Optional[TreeNode], low: int, high: int) -> int:
    if not root:
        return 0
    
    # if current node have value is less than low, so we dont need to visite the left node
    if root.val < low:
        return test_range_sum_BST_02(root.right, low, high)

    # if current node have value is greater than high, so we dont need to visite the right node
    if root.val > high:
        return test_range_sum_BST_02(root.left, low, high)

    # current node is in range [low, high]
    return root.val + test_range_sum_BST_02(root.left, low, high) + test_range_sum_BST_02(root.right, low, high)