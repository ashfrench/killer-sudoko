package org.ash.french.killer.sudoko.solvers

enum class SudokuSolvingUpdateType {
    RULE_OF_ONE,
    RULE_OF_45,
    HIDDEN_SINGLE,
    NAKED_SINGLE,
    LOCKED_CANDIDATES,
    NAKED_PAIR,
    NAKED_TRIPLET,
    NAKED_QUAD,
    HIDDEN_PAIR,
    HIDDEN_TRIPLET,
    HIDDEN_QUAD,
    XY_WING,
    XYZ_WING,
    X_WING,
    SWORDFISH,
    COLOURING,
    FORCING_CHAIN,
    NISHIO,
}