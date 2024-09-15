package org.ash.french.killer.sudoku.domain

interface SudokuGridInterface : CellValueFinder, CellValueSetter, ColumnFinder, RowFinder, NonetFinder
