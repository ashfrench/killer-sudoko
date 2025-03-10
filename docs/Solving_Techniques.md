# [Solving Techniques](https://en.wikipedia.org/wiki/Glossary_of_Sudoku)

![Ash French](./images/favicon/favicon.ico)

[Back to README.md](../README.md)

[Back to Documentation Index](./README.md)

> Below are examples of the technical names of what we will be describing in the domain space of sudoku.
> I will also add useful links below to websites that have helped me understand the techniques better.
> I have made good use of https://sudoku9x9.com/techniques to understand the techniques better.

## Techniques

### [Hidden Single][1]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/HiddenSingle.kt)
> 
> [Test Code is based here](../sudoku-solver/src/test/kotlin/org/ash/french/killer/sudoku/solvers/implementation/HiddenSingleTest.kt)

### [Naked Single][2]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/NakedSingle.kt)

### [Locked Candidates][3]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/LockedCandidates.kt)

### [Naked Pair][4] / [Triplet][13] / [Quad][14]
> [Naked Paid Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/NakedPair.kt)
>
> [Naked Triplet Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/NakedTriplet.kt)
>
> [Naked Quad Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/NakedQuad.kt)

### [Hidden Pair][5] / [Triplet][15] / [Quad][16]
> [Hidden Paid Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/HiddenPair.kt)
>
> [Hidden Triplet Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/HiddenTriplet.kt)
>
> [Hidden Quad Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/HiddenQuad.kt)

### [XY-Wing][6]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/XYWing.kt)

### [XYZ-Wing][7]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/XYZWing.kt)

### [X-Wing][8]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/XWing.kt)

### [Swordfish][9]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/Swordfish.kt)

### [Colouring][10]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/Colouring.kt)

### [Forcing Chain][11]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/ForcingChain.kt)

### [Nishio][12]
> [Code is based here](../sudoku-solver/src/main/kotlin/org/ash/french/killer/sudoku/solvers/implementation/Nishio.kt)

## Killer Sudoku Techniques
### [Fewest Possible Combinations][17]
> Add Code Link

### [The Rule of 45][18]


### No Idea
> Write Stuff

## Useful Links

> * https://sudoku9x9.com/techniques
> * https://masteringsudoku.com/sudoku-solving-techniques/
> * https://www.wikihow.com/Solve-Hard-Sudoku-Puzzles
> * https://www.sudokuonline.io/tips/advanced-sudoku-strategies
> * https://masteringsudoku.com/sudoku-tips-tricks/

[1]: https://sudoku9x9.com/techniques/hiddensingle/
[2]: https://sudoku9x9.com/techniques/nakedsingle/
[3]: https://sudoku9x9.com/techniques/lockedcandidates/
[4]: https://sudoku9x9.com/techniques/nakedpair
[5]: https://sudoku9x9.com/techniques/hiddenpair/   
[6]: https://sudoku9x9.com/techniques/xywing/
[7]: https://sudoku9x9.com/techniques/xyzwing/
[8]: https://sudoku9x9.com/techniques/xwing/
[9]: https://sudoku9x9.com/techniques/swordfish/
[10]: https://sudoku9x9.com/techniques/coloring/
[11]: https://sudoku9x9.com/techniques/forcingchain/
[12]: https://sudoku9x9.com/techniques/nishio/
[13]: https://sudoku9x9.com/techniques/nakedtriplet/
[14]: https://sudoku9x9.com/techniques/nakedquad/
[15]: https://sudoku9x9.com/techniques/hiddentriplet/
[16]: https://sudoku9x9.com/techniques/hiddenquad/
[17]: https://en.wikipedia.org/wiki/Killer_sudoku#Fewest_possible_combinations
[18]:https://en.wikipedia.org/wiki/Killer_sudoku#The_Rule_of_45
