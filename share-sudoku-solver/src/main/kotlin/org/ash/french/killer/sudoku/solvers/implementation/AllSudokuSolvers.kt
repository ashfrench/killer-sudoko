package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface

private val allSudokuSolvers: List<SudokuGridCellUpdate> =
    listOf(
        Colouring,
        ForcingChain,
        HiddenSingle,
        HiddenPair,
        HiddenTriplet,
        HiddenQuad,
        LockedCandidates,
        NakedSingle,
        NakedPair,
        NakedTriplet,
        NakedQuad,
        Nishio,
        Swordfish,
        XWing,
        XYWing,
        XYZWing,
    )

class AllSudokuSolvers(
    private val solvers: List<SudokuGridCellUpdate> = allSudokuSolvers
) : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGridInterface) = solvers.flatMap { it.getCellUpdates(grid) }
}
