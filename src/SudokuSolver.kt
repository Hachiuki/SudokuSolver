val sudokuBoard = arrayOf(
    intArrayOf(5,3,0,0,7,0,0,0,0),
    intArrayOf(6,0,0,1,9,5,0,0,0),
    intArrayOf(0,9,8,0,0,0,0,6,0),
    intArrayOf(8,0,0,0,6,0,0,0,3),
    intArrayOf(4,0,0,8,0,3,0,0,1),
    intArrayOf(7,0,0,0,2,0,0,0,6),
    intArrayOf(0,6,0,0,0,0,2,8,0),
    intArrayOf(0,0,0,4,1,9,0,0,5),
    intArrayOf(0,0,0,0,8,0,0,7,9)
)

class SudokuSolver(val boardToSolve: Array<IntArray>){
    fun boardSizeValid(): Boolean{
        if (boardToSolve.size != 9) return false
        for(row in boardToSolve) if(row.size != 9) return false
        return true
    }

    fun usedInRow(board: Array<IntArray>, row: Int, value: Int): Boolean{
        for (col in 0 until 9) if(board[row][col] == value) return true
        return false
    }

    fun usedInCol(board: Array<IntArray>, col: Int, value: Int): Boolean{
        for(row in 0 until 9) if(board[row][col] == value) return true
        return false
    }

    fun usedInBox(board: Array<IntArray>, row: Int, col: Int, value: Int): Boolean{
        val rowBox = row/3; val colBox = col/3
        for (x in 0..2){
            for (y in 0..2){
                if (board[rowBox * 3 + x][colBox * 3 + y] == value) return true
            }
        }
        return false
    }

    fun validSolution(board: Array<IntArray>, row: Int, col: Int, value: Int){

    }
    fun solveSudoku(): Array<IntArray> {
        var solution = boardToSolve
        if(!boardSizeValid()) println("$this : Illegal board size!"); return solution

    }
}
