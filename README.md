## Project Introduction

[中文README](app/asset/zh-cn.md)

This is a practice calculator project written using Jetpack Compose and Kotlin, provided for reference only.

## Demo

![演示效果](https://github.com/Akiyama-sama/Calculator-Kotlin/blob/480562edefd444ab77d2a0d5fd79c32bde337822/app/asset/show.gif?raw=true)

## Limitations

- The calculation logic involves first taking the input expression and then calculating it directly using a JavaScript engine. This can lead to precision issues because computers only store approximations of decimal numbers (e.g., 1.3). However, the current precision is acceptable for a simple practice project.
- When the expression or result exceeds a single line, Compose causes the multi-line numbers to get squished together. This is currently being handled temporarily by using an ellipsis (...).