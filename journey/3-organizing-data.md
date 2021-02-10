---
layout: default
title: Organizing Data
parent: Refactoring journey
nav_order: 3
---

![refactoring-journey](../img/3-organizing-data.webp)

<details open markdown="block">
  <summary>
    Table of contents
  </summary>
  {: .text-delta }
1. TOC
{:toc}
</details>

## Replace Magic Stuff with Constants
### Code Smells
{: .no_toc}
* Code uses `numbers` that have a certain meaning to it
* Code uses `strings` that have a certain meaning to it

Make it harder to understand the program and refactor the code

### Technique
{: .no_toc}
* Extract the magic stuff by using your IDE feature
  * Makes its name self-evident

### Practice
{: .no_toc}
* Open `Wizard` in `organizing.data` package
* Extract magic stuff

### Shortcuts
{: .no_toc}
Extract Constant :

| IntelliJ |
|---|
| Ctrl+Alt+C |
| ⌘+⌥+C |

### Benefits
{: .no_toc}
* Symbolic constant can serve as live documentation of the meaning of its value
* Reduce duplicate use of a number in the code

### Drawbacks
{: .no_toc}
* N/A

## Encapsulate fields
### Code Smells
{: .no_toc}
* From public to private fields
* Ideally expose just behaviors (methods / functions)

One of the pillars of object-oriented programming is Encapsulation : the ability to conceal object data.

### Technique
{: .no_toc}
* Extract the magic stuff by using your IDE feature
  * Makes its name self-evident

### Practice
{: .no_toc}
* Open `Wizard` in `organizing.data` package
* Extract magic stuff

### Shortcuts
{: .no_toc}
* Right Click in the file
* Refactor | Encapsulate Fields  

![extract class](../img/encapsulateFields.webp)
* Then configure the encapsulation
* More info [here](https://www.jetbrains.com/help/idea/encapsulate-fields.html)

### Benefits
{: .no_toc}
* Preserve the state of your object
    * No side effect from the outside
* Much easier for you to maintain and develop this component

### Drawbacks
{: .no_toc}
* N/A