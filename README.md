# Killer-Sudoku

This is a rewrite in koltin of my Computer Science disertation project. I Studied `Computer Science with a Year in Industry` at `Manchester Univestity`. I achieved a 1st class honours for this project and was in the top 10 of the year.

The goals of this project is to be able to take any Killer Sudoku Grid and then be able to solve them from said grid.

## Classic Sudoku
Classic sudoku has been around for years and can easily be solved through brute force. The aim of this project is to show and demonstrate how to solve example puzzles. Show techniques and provide solutions.

## Rules of Sudoku
In classic Sudoku, the objective is to fill a 9 × 9 grid with digits so that each column, each row, and each of the nine 3 × 3 subgrids that compose the grid (nonet) contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a [well-posed puzzle][1] has a single solution.

### Examples of Sudoku Grids

## Killer Sudoku Grid

### Rules of Sudoku

### Examples of Killer Sudoku Grids

#### Example Killer Sudoku Grids

#### Terminology

##### Cell

      A single square that contains one number in the grid

##### Row

      A horizontal line of 9 cells

##### Column

      A vertical line of 9 cells

##### Nonet

      A 3×3 grid of cells, as outlined by the bolder lines in the diagram above; also called a box

#####  Cage

      The grouping of cells denoted by a dotted line or by individual colours.

##### House 

      Any nonrepeating set of 9 cells: can be used as a general term for "row, column, or nonet" (or, in Killer X variants, "long diagonal")

## Solving Techniques

## Code Location

## Tooling
* [Kotlin][2]
* [Gradle][3]
* [JVM][4]

## How to Build

`./gradlew build`

#### References
[Well Posed Problem][1]


[1]: https://en.wikipedia.org/wiki/Well-posed_problem
[2]: https://kotlinlang.org/
[3]: https://gradle.org/
[4]: https://www.oracle.com/java/technologies/downloads/