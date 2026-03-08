class Solution:

    # Solution 1: -> NOT SUCCEED YET 
    # Cannot satisfify for case ['a', 'a'] and word = 'aa'
    # def is_adjacent(self, i: int, j: int, prev_letter: str, adjacent: List[List[str]]) -> bool:

    #     rows = len(adjacent)
    #     columns = len(adjacent[0])

    #     is_adj = False
    #     if i > 0 and adjacent[i - 1][j] == prev_letter:
    #         if adjacent[i][j] != '':
    #             is_adj = False
    #         else:
    #             is_adj = True

    #     if i < rows - 1 and adjacent[i + 1][j] == prev_letter:
    #         if is_adj or adjacent[i][j] != '':
    #             is_adj = False
    #         else: 
    #             is_adj = True

    #     if j > 0 and adjacent[i][j - 1] == prev_letter:
    #         if is_adj or adjacent[i][j] != '':
    #             is_adj = False
    #         else: 
    #             is_adj = True

    #     if j < columns - 1 and adjacent[i][j + 1] == prev_letter:
    #         if is_adj or adjacent[i][j] != '':
    #             is_adj = False
    #         else: 
    #             is_adj = True

    #     return is_adj

    # def exist(self, board: List[List[str]], word: str) -> bool:
        
    #     # For each letter in the string
    #     #   find in board any position that have same letter that its location is adjacent to previous leter.
    #     #       If there is not any letter satisfied the condition -> return false
    #     # return true -> mean that we go through the each letter and alway find the exising letter satistisfy the condition
    #     # What is the condition for checking adjacent?
    #     #   1. adjacents of a letter should contain previous visited letter in word
    #     #   2. Current location of letter should not visit yet


    #     rows = len(board)
    #     columns = len(board[0])

    #     if len(word) > rows * columns:
    #         return False

    #     adjacent = []
    #     for row in range(0, rows):
    #         arr = []
    #         for col in range(0, columns):
    #             arr.append('')
    #         adjacent.append(arr)

    #     visited_first_letter = False
    #     prev_letter = ''
    #     for letter in word:
    #         found = False
    #         for row in range(0, rows):
    #             for col in range(0, columns):
    #                 if board[row][col] == letter and (self.is_adjacent(row, col, prev_letter, adjacent) or not visited_first_letter):
    #                     adjacent[row][col] = letter
    #                     found = True

    #         visited_first_letter = True
    #         prev_letter = letter

    #         if not found:
    #             return False
        
    #     return True

    # Solution 2: Backtracking 
    # running time is O(m*n*4^k) (k is length of word)
    def exist_path(self, i: int, j: int, board: List[List[str]], pos: int, word: str) -> bool:
        # If pos is equal to len of word, mean found the path
        if pos == len(word):
            return True

        # If current location (i, j) is over the boundary of board matrix -> return False
        # Else, check the current letter in word and the current location (i,j) is equal -> Not: return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or word[pos] != board[i][j]:
            return False

        # Store the current letter and mark as visited by update to empty
        letter = board[i][j]
        board[i][j] = ''

        # Continue and find adjacent in matrix board for next letter in word
        result = self.exist_path(i - 1, j, board, pos + 1, word) or  \
                    self.exist_path(i + 1, j, board, pos + 1, word) or \
                    self.exist_path(i, j - 1, board, pos + 1, word) or \
                    self.exist_path(i, j + 1, board, pos + 1, word)

        # Restore back to letter
        board[i][j] = letter

        return result

    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        columns = len(board[0])

        if len(word) > rows * columns:
            return False

        for row in range(0, rows):
            for col in range(0, columns):
                if self.exist_path(row, col, board, 0, word):
                    return True
        
        return False