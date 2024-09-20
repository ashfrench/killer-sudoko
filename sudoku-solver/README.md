# Sudoku Solver API

# Documentation Index
[Back to README.md](../README.md)

# To Build
```shell
..\gradlew clean build 
```

# How to use

Below is the Builder function that can be called to create a grid

[Source](./src/main/kotlin/org/ash/french/killer/sudoku/builders/SudokuBuilders.kt)
```kotlin
fun sudokuGrid(init: SudokuGrid.() -> Unit): SudokuGridBuilder {
    val sudokuGrid = SudokuGrid()
    sudokuGrid.init()
    return SudokuGridBuilder(sudokuGrid)
}

fun SudokuGrid.cellValue(init: SudokuCellValueBuilder.() -> Unit) {
    val cellValueBuilder = SudokuCellValueBuilder(this)
    cellValueBuilder.init()

    val cellUpdate = cellValueBuilder.build()
    this.cellValue(cellUpdate.cell, cellUpdate.value)
}
```

Below is an example grid with a [Hidden Single](../docs/Solving_Techniques.md#hidden-single1) where `Cell(x=2, y=5, value=2)`
```kotlin
sudokuGrid {
    cellValue {
        x = 1
        y = 5
        value = 1
    }

    cellValue {
        x = 3
        y = 5
        value = 3
    }

    cellValue {
        x = 6
        y = 4
        value = 2
    }

    cellValue {
        x = 8
        y = 6
        value = 2
    }
}.build()
```