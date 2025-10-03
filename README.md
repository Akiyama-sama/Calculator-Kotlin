## 项目简介(Project Introduction)

这是一个用Jetpack Compose 和 kotlin写的一个练手计算器项目，仅供参考
This is a practice calculator project written using Jetpack Compose and Kotlin, provided for reference only.

## 项目演示(Demo)

![演示效果](https://github.com/Akiyama-sama/Calculator-Kotlin/blob/480562edefd444ab77d2a0d5fd79c32bde337822/app/asset/show.gif?raw=true)

## 局限性(Limitations)

- 计算逻辑是先输入运算表达式，然后直接利用JavaScript引擎来计算，因此计算过程当中会出现精度问题，问题原因是计算机在表达小数，例如1.3的时候，只能表达其近似值。但只是作为一个练手项目来说，计算精度已经足够了
- 在表达式或者结果超过一行时，compose会让多行数字挤压在一起，这里先用省略号暂时替代一下

- The calculation logic involves first taking the input expression and then calculating it directly using a JavaScript engine. This can lead to precision issues because computers only store approximations of decimal numbers (e.g., 1.3). However, the current precision is acceptable for a simple practice project.
- When the expression or result exceeds a single line, Compose causes the multi-line numbers to get squished together. This is currently being handled temporarily by using an ellipsis (...).