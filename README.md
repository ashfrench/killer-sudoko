# Killer Sudoku Solver


[![Ash at Stack Overflow](https://stackoverflow.com/users/flair/6894338.png?theme=dark)](https://stackoverflow.com/users/6894338/ash)

[![Build Workflow Status](https://github.com/ashfrench/killer-sudoko/actions/workflows/ci.yml/badge.svg)](https://github.com/ashfrench/killer-sudoko/actions/workflows/ci.yml)
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

## [Killer Sudoku Grid](docs/Killer_Sudoku.md)

## Solving Techniques

## Code Location

[Sonar Cloud][5]

## Tooling
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

* [Kotlin][6] 
* [Gradle][7] 
* [JVM][8]
* [Compose Multi Platform][9]
* [JUnit 5 Extension Model][10]

## How to Build

`./gradlew build`

## References

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