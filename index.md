---
layout: default
title: Refactoring journey
has_children: true
nav_order: 1
---

<div>
    <link rel="stylesheet" type="text/css" href="css/konami.css">
    <script type="text/javascript" src="js/konami.js"></script>
    <img id="konamiImage" class="konami" src="img/konami.gif"/>
    <script>
    function launchEgg() {
        return new Promise(function (resolve, reject) {
                var konamiImage = document.getElementById("konamiImage");
                konamiImage.style.display = 'inherit';
                var currentPosition = 0;

                var id = setInterval(() => {
                    if (currentPosition == document.body.offsetWidth) {
                        clearInterval(id);
                        konamiImage.style.display = 'none';
                        resolve();
                    } else {
                        currentPosition++;
                        konamiImage.style.left = currentPosition + 'px';
                    }
            }, 10);
        });
    }

    var konami = new Konami(launchEgg);
    konami.load();

    </script>
</div>

# Refactoring journey

* Clone the [repository](https://github.com/ythirion/refactoring-journey)

`Lazy you will be`-> use your IDE
* [Intellij shortcuts](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Eclipse shortcuts](https://www.eclipse.org/getting_started/content/eclipse-ide-keybindings.pdf)

![refactoring-journey](img/refactoring-journey.webp)

## Don't forget the Golden Rule 
Before any changes :
* Check the tests
* Make sure they are all Green

> I strongly advise to use the Split Feature of your IDE to organize your work :  

>![refactoring-journey](img/split-screen.webp)