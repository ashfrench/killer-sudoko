# Killer-Sudoku

This is a rewrite in kotlin of my Computer Science disertation project. I Studied `Computer Science with a Year in Industry` with [IBM](https://www.ibm.com) at `Manchester Univestity`. I achieved a 1st class honours for this project and was in the top 10 of the year.

The goals of this project is to be able to take any Killer Sudoku Grid and then be able to solve them from said grid.

I should be able to demonstrate solving by [brute force][5], but also be able to solve using human techniques.

## Classic Sudoku
Classic sudoku has been around for years and can easily be solved through brute force. The aim of this project is to show and demonstrate how to solve example puzzles. Show techniques and provide solutions.

A simple brute force algorithm will be provided to show how to solve a [well-posed puzzle][1]

## Rules of Sudoku
In [classic Sudoku](#Classic-Sudoko), the objective is to fill a 9 × 9 grid with digits so that each [column](#Column), each [row](#Row), and each of the nine 3 × 3 subgrids that compose the grid ([nonet](#Nonet)) contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a [well-posed puzzle][1] has a single solution.

### Examples of Sudoku Grids

## Killer Sudoku Grid

### Rules of Killer Sudoku

### Examples of Killer Sudoku Grids

### [Terminology](https://en.wikipedia.org/wiki/Glossary_of_Sudoku)

Below are examples of the technical names of what we will be describing in the domain space of sudoku.

#### Cell

      A single square that contains one number in the grid

#### Row

      A horizontal line of 9 cells

#### Column

      A vertical line of 9 cells

#### Nonet

      A 3×3 grid of cells, as outlined by the bolder lines in the diagram above; also called a box

####  Cage

      The grouping of cells denoted by a dotted line or by individual colours.

#### House 

      Any nonrepeating set of 9 cells: can be used as a general term for "row, column, or nonet" (or, in Killer X variants, "long diagonal")

### Solving Techniques

### Code Location

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
[5]: https://en.wikipedia.org/wiki/Brute-force_search