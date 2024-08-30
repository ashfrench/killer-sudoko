# Classic Sudoku

[Back to README.md](../README.md)

> Classic sudoku has been around for years and can easily be solved through brute force. The aim of this project is to show and demonstrate how to solve example puzzles. Show techniques and provide solutions.
>
> A simple brute force algorithm will be provided to show how to solve a [well-posed puzzle][1]
>
> Further algorithms will be provided with a [human style UX][6] to help the user learn how to solve the puzzles

## Rules of Sudoku

> In [classic Sudoku](https://en.wikipedia.org/wiki/Sudoku), the objective is to fill a 9 × 9 grid with digits so that each [column](./Terminology.md#column), each [row](./Terminology.md#row), and each of the nine 3 × 3 sub-grids that compose the grid ([nonet](./Terminology.md#nonet)) contains all the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a [well-posed puzzle][1] has a single solution.

### Examples of Sudoku Grids

The below sample grids are taken from https://en.wikipedia.org/wiki/Sudoku

<table>

  <colgroup>
    <col span="1" style="width: 50%;">
  </colgroup>

<thead>
    <tr>
      <th>Example Sudoku Grid</th>
      <th>Example Hard Sudoku Grid</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align: center; vertical-align: middle;"> <img src="../sudoku-solver/src/main/resources/images/sudoko/example-sudoku-grid.png" alt="Example Sudoku Grid" width="250px" height="250px" > </td>
      <td style="text-align: center; vertical-align: middle;"> <img src="../sudoku-solver/src/main/resources/images/sudoko/Sudoku_puzzle_hard_for_brute_force.png" alt="Example Hard Sudoku Grid" width="250px" height="250px"> </td>
    </tr>
  </tbody>

  <colgroup>
    <col span="1" style="width: 50%;">
  </colgroup>

<thead>
    <tr>
      <th>Example Solved Grid Via Brute Force</th>
      <th>Example Solved Grid</th>
    </tr>
  </thead>

<tbody>
    <tr>
      <td style="text-align: center; vertical-align: middle;"> <img src="../sudoku-solver/src/main/resources/images/sudoko/Sudoku_solved_by_bactracking.gif" alt="Example Brute Force Solver" width="250px" height="250px"> </td>
      <td style="text-align: center; vertical-align: middle;"> <img src="../sudoku-solver/src/main/resources/images/sudoko/solved_puzzle.svg" alt="Example Solved Grid" width="250px" height="250px" > </td>
    </tr>
  </tbody>

</table>

[1]: https://en.wikipedia.org/wiki/Well-posed_problem