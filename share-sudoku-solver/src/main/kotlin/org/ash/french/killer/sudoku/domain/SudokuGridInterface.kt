package org.ash.french.killer.sudoku.domain

sealed interface SudokuGridInterface :
    CellValueFinder,
    CellValueSetter,
    ColumnFinder,
    RowFinder,
    NonetFinder

interface KillerSudokuGridInterface :
    SudokuGridInterface,
    CageFinder
