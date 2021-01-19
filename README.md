# Refactoring journey
* Clone the repository

`Lazy you will be`-> use your IDE
* [Intellij shortcuts](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Eclipse shortcuts](https://www.eclipse.org/getting_started/content/eclipse-ide-keybindings.pdf)

![refactoring-journey](refactoring-journey.png)

## Composing methods
### Extract Method
* Extract the new method by using your IDE feature
    * Makes its purpose self-evident
* Be careful with the needed variables before extracting otherwise you will have to move them by yourself

#### Practice 1
* Open `Order` in `composing.methods` package
* Extract methods to improve readability / reduce complexity

#### Practice 2
* Open `AmountCalculator` in `composing.methods` package
* Extract methods to remove code duplication
* `The power of your IDE you will use`

#### Shortcuts :
| IntelliJ | Eclipse |
|---|---|
| Ctrl+Alt+M | Alt+Shift+M |
| ⌘+⌥+M | ⌥+⌘+M |

Before any changes :
* Check the tests
* Make sure they are all Green

### Extract variable
`Place the result of the expression or its parts in separate variables that are self-explanatory.`

#### Practice
* Open `Food` in `composing.methods` package
* Extract variables from the `isEdible` method

#### Shortcuts :
| IntelliJ | Eclipse |
|---|---|
| Ctrl+Alt+V | Alt+Shift+L |
| ⌘+⌥+V | ⌥+⌘+L |

### Inline Temp
* Replace the references to the variable with the expression itself

#### Practice 1
* Open `OrderHelper` in `composing.methods` package
* Replace the price reference with the expression itself

#### Practice 2
* Refactor the `deserveDiscountBasedOnCustomer` by using previous learnings

`Faker library (or alternatives) can really help you save a lot of time when needing data for your tests.` 

### Remove Assignments to Parameters
* Use a local variable instead of a parameter.

#### Practice 1
* Open `OrderHelper` in `composing.methods` package  
* Reflect on the method, which concept does it break ?
* Add a new test for the `calculateNewStock` method

#### Practice 2
* Refactor the `calculateNewStock` into a Pure Function