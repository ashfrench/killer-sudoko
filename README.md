# Killer Sudoku Solver


[![Ash at Stack Overflow](https://stackoverflow.com/users/flair/6894338.png?theme=dark)](https://stackoverflow.com/users/6894338/ash)

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ash-french-tamil/)
[![HackerRank](https://img.shields.io/badge/-Hackerrank-2EC866?style=for-the-badge&logo=HackerRank&logoColor=white)](https://www.hackerrank.com/profile/ash_french1)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@ash.french1)
[![Substack](https://img.shields.io/badge/Substack-%23006f5c.svg?style=for-the-badge&logo=substack&logoColor=FF6719)](https://substack.com/@ashfrench1)
[![Patreon](https://img.shields.io/badge/Patreon-F96854?style=for-the-badge&logo=patreon&logoColor=white)](https://patreon.com/AshFrench)

[![Kotlin CI with Gradle](https://github.com/ashfrench/killer-sudoko/actions/workflows/gradle.yml/badge.svg)](https://github.com/ashfrench/killer-sudoko/actions/workflows/gradle.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ashfrench_killer-sudoko&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=ashfrench_killer-sudoko)

> This is a rewrite in kotlin of my Computer Science dissertation project. I Studied `Computer Science with a Year in Industry (2006-2010)` with [IBM][1] `(2008-2009)` at [Manchester University][2]. I achieved a 1st class honours for this project and was in the top 10 of the year.
>
> The goals of this project is to be able to take any Killer Sudoku Grid and then be able to solve them from said grid.
>
> I should be able to demonstrate solving by [brute force][3], but also be able to solve using [human techniques][4].
>
> The human provided techniques should also be able to graphically display or verbally describe how to solve said Sudoku Grid
> 
> I will be using https://sudoku.com/ as a source of data to test my algorithms

## [Classic Sudoku](docs/Classic_Sudoku.md)

> Classic sudoku has been around for years and can easily be solved through brute force. The aim of this project is to show and demonstrate how to solve example puzzles. Show techniques and provide solutions.
>
> A simple brute force algorithm will be provided to show how to solve a [well-posed puzzle][15]
>
> Further algorithms will be provided with a [human style UX](#solving-techniques) to help the user learn how to solve the puzzles

![Example Sudoku Grid](./sudoku-solver/src/main/resources/images/sudoko/example-sudoku-grid.png)

## [Killer Sudoku Grid](docs/Killer_Sudoku.md)

> The objective is to fill the grid with numbers from 1 to 9 in a way that the following conditions are met:
>
> * Each [row](docs/Terminology.md#Row), [column](docs/Terminology.md#Column), and [nonet](docs/Terminology.md#Nonet) contains each number exactly once.
> * The sum of all numbers in a [cage](docs/Terminology.md#Cage) must match the small number printed in its corner.
> * No number appears more than once in a [cage](docs/Terminology.md#Cage). (This is the standard rule for killer sudokus, and implies that no [cage](docs/Terminology.md#Cage) can include more than 9 [cells](docs/Terminology.md#Cell).

![Example Killer Sudoku Grid](./sudoku-solver/src/main/resources/images/killer-sudoko/Killersudoku_bw_with_bg.png)

## Solving Techniques

## Code Location

## Tooling
[![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)][6]
[![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)][7]
[![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)][12]
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)][8]
[![JUnit 5](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)][14]
[![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)][13]
[![SonarQube](https://img.shields.io/badge/SonarQube-black?style=for-the-badge&logo=sonarqube&logoColor=4E9BCD)][5]

* [Kotlin][6] 
* [Gradle][7] 
* [JVM][8]
* [Compose Multi Platform][9]
* [JUnit 5 Extension Model][10]

## How to Build

`./gradlew build`

## References

[Project Kanban Board][11]

## [Security](SECURITY.md)

## Miscellaneous

[![License: GPLv3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

[1]: https://www.ibm.com
[2]: https://www.cs.manchester.ac.uk/
[3]: https://en.wikipedia.org/wiki/Brute-force_search
[4]: https://en.wikipedia.org/wiki/Killer_sudoku#Solving_strategies
[5]: https://sonarcloud.io/summary/overall?id=ashfrench_killer-sudoko
[6]: https://kotlinlang.org/
[7]: https://gradle.org/
[8]: https://www.oracle.com/java/technologies/downloads/
[9]: https://www.jetbrains.com/lp/compose-multiplatform/
[10]: https://junit.org/junit5/docs/current/user-guide/#extensions
[11]: https://github.com/users/ashfrench/projects/1/views/1
[12]: https://html.com/html5/
[13]: https://www.markdownguide.org/cheat-sheet/
[14]: https://junit.org/junit5/docs/current/user-guide/
[15]: https://en.wikipedia.org/wiki/Well-posed_problem