![refactoring-journey](img/2-moving-features.png)

## Extract Class
### Code Smells
* A class is doing the work of several

### Technique
* Create a new class
* Place the fields / methods responsible for the related functionality in it

### Practice
* Open `Player` in `moving.features` package
* Extract "*attributes*" into a new class 

### Shortcuts
* Right Click in the file
* Refactor | Extract Delegate
![refactoring-journey](img/extract-delegate.png)
* Then configure the extraction
* More info [here](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html#extract_delegate)

### Benefits
* Maintain adherence to the Single Responsibility Principle

### Drawbacks
* Could create a lot of Inline Class