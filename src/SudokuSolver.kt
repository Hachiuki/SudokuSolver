class SudokuSolver(val boardToSolve: Array<IntArray>){
    var solution = boardToSolve.copyOf()

    fun usedInRow(row: Int, value: Int): Boolean{
        for (col in 0 until 9) if(solution[row][col] == value) return true
        return false
    }

    fun usedInCol(col: Int, value: Int): Boolean{
        for(row in 0 until 9) if(solution[row][col] == value) return true
        return false
    }

    fun usedInBox(row: Int, col: Int, value: Int): Boolean{
        val rowBox = row/3; val colBox = col/3
        for (x in 0..2){
            for (y in 0..2){
                if (solution[rowBox * 3 + x][colBox * 3 + y] == value) return true
            }
        }
        return false
    }

    fun validValue(row: Int, col: Int, value: Int) = if(usedInRow(row, value) or usedInCol(col, value) or usedInBox(row, col, value)) false else true

    fun solveSudoku(row: Int = 0, col: Int = 0): Boolean{
        if (row > 8) return true
        if (col > 8) return solveSudoku(row+1, 0)
        if (solution[row][col] != 0) return solveSudoku(row, col+1)
        for (value in 1..9){
            if(validValue(row,col,value)){
                solution[row][col] = value
                if (solveSudoku(row,col+1)) return true
                solution[row][col] = 0
            }
        }
        return false
    }

    fun printQuestion(){
        for (row in boardToSolve){
            for (grid in row){
                print("$grid ")
            }
            println()
        }
    }

    fun printSolution(){
        for (row in solution){
            for (grid in row){
                print("$grid ")
            }
            println()
        }
    }
}

fun main() {
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

    val solver = SudokuSolver(sudokuBoard)
    if(solver.solveSudoku()) solver.printSolution()
    else println("couldn't find a solution.")
}
