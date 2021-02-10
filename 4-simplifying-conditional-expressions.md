![refactoring-journey](img/4-simplifying-conditional-expressions.webp)

## Consolidate Conditional Expression
### Code Smells
* Multiple conditionals that lead to the same result or action

### Technique
* Consolidate the conditionals in a single expression by using AND and OR As a general rule when consolidating
* Perform Extract Method on the operator conditions and give the method a name that reflects the expression’s purpose

### Practice
* Open `AuthorizationService` in `simplifying.conditional.expressions` package
* Simplify if else

`Before touching this kind of code always check the Code Coverage`
* Let's cover the missing branch
* Only then simplify if else

### Benefits
* Eliminates duplicate control flow code
    * More readable code  
* By consolidating all operators
    * Isolate the complex expression in a method with a name that explains the conditional’s purpose

### Drawbacks
* N/A

### BONUS : what do you think about the tests ?  
* Would you favor mocks over instantiating concrete objects ?

## Consolidate Duplicate Conditional Fragments
### Code Smells
* Identical code in all branches of a conditional

### Technique
* Move the code outside of the conditional :
    * If the duplicated code is `at the beginning` of the conditional branches
        * Move the code to a place before the conditional
    * If the code is `at the end` of the branches
        * Place it after the conditional
    * If the duplicate code is `randomly located`  inside the branches
        * First try to move the code to the beginning or end of the branch
        * Depending on whether it changes the result of the subsequent code
* If appropriate, and the duplicate code is longer than one line, try using Extract Method.

### Practice
* Open `PriceCalculator` in `simplifying.conditional.expressions` package
* Remove duplicate code by using your IDE

### Shortcuts
* Put your cursor on the if line and use this shortcut (`Show intention actions and quick-fixes`)

| IntelliJ |
|---|
| Alt+Enter |
| ⌥+↩ |

### Benefits
* Code deduplication

### Drawbacks
* N/A

## Decompose Conditional
### Code Smells
* Complex conditional 
    * `if...else`
    * `switch`
* The longer a piece of code is the harder it is to understand.

### Technique
* Decompose the complicated parts of the conditional into separated methods :
    * The condition : then and else
    * Use your `Extract Method` feature
* Repeat the process for each block

### Practice
* Open `RoomPriceCalculator` in `simplifying.conditional.expressions` package
* Decompose conditional by extracting methods

### Shortcuts
Extract method :

| IntelliJ | Eclipse |
|---|---|
| Ctrl+Alt+M | Alt+Shift+M |
| ⌘+⌥+M | ⌥+⌘+M |

### Benefits
* More maintainable / understandable code

### Drawbacks
* N/A

## Replace Conditional with Polymorphism
### Code Smells
* Conditional which performs various actions depending on object type or properties

### Technique
* Create subclasses matching the branches of the conditional
* Create a shared method and move code from the corresponding branch of the conditional to it
* Then replace the conditional with the relevant method calls

### Practice
* Open `Calculator` in `simplifying.conditional.expressions` package
* Extract behaviors into class hierarchies

### Shortcuts
Replace Method with Method Object by using `Refactor | Replace Method with Method Object` menu in IntelliJ

![Replace Method with Method Object](img/extract-method-object.webp)

### Benefits
* If you need to add a new execution variant
    * All you need to do is add a new subclass without touching the existing code (Open/Closed Principle)
* Adheres to the Tell-Don’t-Ask principle :
    * Instead of asking an object about its state and then performing actions based on this
    * Much easier to simply tell the object what it needs to do and let it decide for itself how to do that

### Drawbacks
* N/A