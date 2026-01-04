
from math import ceil
import pytest

@pytest.fixture
def s():
    return "PAYPALISHIRING"

@pytest.fixture
def numRows():
    return 4

def test_convert(s: str, numRows: int) -> str:
    if numRows == 1:
        return s
    
    # Simulate ZigZag movement
    n = len(s)

    # Separate the maxtrix to each section which will include 2 * numRows - 2 characters
    # Each section, we will have 2*numRows - 2 characters
    # P   A   H   N       -> 3 sections:
    # A P L S I I G       -> Section 1: PAYP     Section 2: ALIS
    # Y   I   R           -> Section 3: HING     Section 4: NG
    sections = ceil(n / (2 * numRows - 2))
    numCols = sections * (numRows - 1)
    
    # Init matrix
    matrix = []
    for _ in range(numRows):
        matrix.append([''] * numCols)

    # Move a long the zigzag path and fill the matrix
    curr_row = curr_column = index_str = 0
    while index_str < n:
        # Iterate from top to down
        while curr_row < numRows and index_str < n:
            matrix[curr_row][curr_column] = s[index_str]
            index_str += 1
            curr_row += 1

        # Iterate diagonally
        curr_row -= 2
        curr_column += 1
        while curr_row > 0 and curr_column < numCols and index_str < n:
            matrix[curr_row][curr_column] = s[index_str]
            index_str += 1
            curr_row -= 1
            curr_column += 1

    # Read the matrix in zigzag order
    result = []
    for row in range(numRows):
        for col in range(numCols):
            if matrix[row][col] != '':
                result.append(matrix[row][col])

    # Print the result in matrix form
    print("ZigZag Matrix:\n")
    for row in matrix:
        print(' '.join(row))

    return ''.join(result)


# Do no use more memory
def test_convert_improved(s: str, numRows: int) -> str:
    if numRows == 1:
        return s
    
    # Create an array of StringBuilder for each row
    rows = [''] * min(numRows, len(s))
    curr_row = 0
    going_down = False

    for char in s:
        rows[curr_row] += char
        # Change direction if we are at the first or last row
        if curr_row == 0 or curr_row == numRows - 1:
            going_down = not going_down
        curr_row += 1 if going_down else -1

    # Combine all rows to get the final string
    return ''.join(rows)