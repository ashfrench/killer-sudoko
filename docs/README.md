# Documentation Index

![Ash French](./images/favicon/favicon.ico)

[Back to README.md](../README.md)

This is the documentation index. It contains a list of all the documentation pages.

* [Terminology](./Terminology.md)
* [Classic Sudoku](./Classic_Sudoku.md)
* [Killer Sudoku Grid](./Killer_Sudoku.md)
* [Solving Techniques](./Solving_Techniques.md)

## Code

The way you can listen to any updates for a grid will return any CellUpdates which all have a unique ID, so you can
check which have been processed already.

```kotlin
@Serializable
sealed class CellUpdate : UpdateID
```

[0]: https://ashfrench.co.uk/