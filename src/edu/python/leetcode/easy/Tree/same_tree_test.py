
import pytest

@pytest.fixture
def p():
    # Create a binary tree: 1
    #                       / \
    #                      2   3
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    return root

@pytest.fixture
def q():
    # Create a binary tree: 1
    #                       / \
    #                      2   3
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    return root 

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Solution: Inorder Traversal + Recursion
def test_is_same_tree(p, q):
    if not p and not q:
        return True

    if not p or not q:
        return False

    if p.val != q.val:
        return False

    return test_is_same_tree(p.left, q.left) and test_is_same_tree(p.right, q.right)

from queue import Queue

# Solution: Inorder Traversal + Iteration
def test_is_same_tree_iterative(p, q):
    queue1 = Queue()
    queue2 = Queue()

    queue1.put(p)
    queue2.put(q)

    while not queue1.empty() and not queue2.empty():
        p = queue1.get()
        q = queue2.get()

        if not p and not q:
            continue

        if not p or not q:
            return False

        if p.val != q.val:
            return False

        queue1.put(p.left)
        queue1.put(p.right)
        queue2.put(q.left)
        queue2.put(q.right)

    return True