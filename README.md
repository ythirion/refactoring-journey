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
