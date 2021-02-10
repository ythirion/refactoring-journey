---
layout: default
title: Simplifying Method Calls
parent: Refactoring journey
nav_order: 5
---

![refactoring-journey](../img/5-simplifying-method-calls.webp)

<details open markdown="block">
  <summary>
    Table of contents
  </summary>
  {: .text-delta }
1. TOC
{:toc}
</details>

## Rename method
### Code Smells
{: .no_toc}
* The name of a method does not explain what the method does

### Technique
{: .no_toc}
* Use the "Rename" functionality of your IDE
* It will fix each calls for you

### Practice
{: .no_toc}
* Open `Employee` in `simplifying.method.calls` package
* Rename every method with a "shitty" name

### Shortcuts
{: .no_toc}
Rename : `can be used to rename anything`

| IntelliJ | Eclipse |
|---|---|
| Shift+F6 | Alt+Shift+R |
| ⇧+F6 | ⌥+⌘+R |

### Benefits
{: .no_toc}
* Improved code readability

### Drawbacks
{: .no_toc}
* N/A

## Remove Dead Parameter
### Code Smells
{: .no_toc}
* A parameter isn’t used in the body of a method
* Every parameter in a method call forces the programmer reading it to figure out what information is in this parameter
* Additional parameters are extra code that has to be run

### Technique
{: .no_toc}
* Use the "Rename" functionality of your IDE
* It will fix each calls for you

### Practice
{: .no_toc}
* Open `Lottery` in `simplifying.method.calls` package
* Remove safely every Dead parameter

### Shortcuts
{: .no_toc}
* Use `Safe Delete` feature in your IDE

| IntelliJ |
|---|
| Alt+Delete |
| ⌘+Delete |

### Benefits
{: .no_toc}
* A method contains only the parameters that it truly requires
* More understandable code

### Drawbacks
{: .no_toc}
* N/A

## Separate Query from Modifier
### Code Smells
{: .no_toc}
* Method that returns a value but also changes the internal state of an object
* Have an `and` in your method names

Always remind this sentence : `asking a question should not change the answer`  
To know more read about [Command-query separation](https://en.wikipedia.org/wiki/Command%E2%80%93query_separation)

### Technique
{: .no_toc}
* Split the method into two separate methods
* As you would expect :
    * One of them should return the value 
    * The other one modifies the object
    
### Practice
{: .no_toc}
* Open `Client` in `simplifying.method.calls` package
* Apply the technique explained

### Shortcuts
{: .no_toc}
Extract method :

| IntelliJ | Eclipse |
|---|---|
| Ctrl+Alt+M | Alt+Shift+M |
| ⌘+⌥+M | ⌥+⌘+M |

### Benefits
{: .no_toc}
* Avoid side effects in your programs

### Drawbacks
{: .no_toc}
* N/A

## Introduce Parameter Object
### Code Smells
{: .no_toc}
* Methods contain a repeating group of parameters

### Technique
{: .no_toc}
* Replace these parameters with an object
* Create a new immutable class representing the group of parameters
* In all method calls, pass the object created from old method parameters to this parameter
    
### Practice
{: .no_toc}
* Open `AccountingService` in `simplifying.method.calls` package
* Apply the technique explained

### Shortcuts
{: .no_toc}
?

### Benefits
{: .no_toc}
* Instead of a lot of parameters
    * You see a single object with a comprehensible name

### Drawbacks
{: .no_toc}
* N/A

> BONUS : Add a minimumAmount parameter to each find method and change the code accordingly

## Use Factory or Factory Methods
### Code Smells
{: .no_toc}
* Complex constructor that does something more than just setting parameter values in object fields

### Technique
{: .no_toc}
* Create a factory method and use it to replace constructor calls.

### Practice
{: .no_toc}
* Open `AccountingService` in `simplifying.method.calls` package
* Apply the technique explained

### Shortcuts
{: .no_toc}
?

### Benefits
{: .no_toc}
* Instead of a lot of parameters
    * You see a single object with a comprehensible name

### Drawbacks
{: .no_toc}
* N/A

> BONUS : Add a minimumAmount parameter to each find method and change the code accordingly