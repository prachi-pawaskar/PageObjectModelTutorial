# PageObjectModelTutorial

The project demonstrates use of Page Object Model automation framework. The framework implements one test case for showcase purpose.

## Getting Started

These instructions will help you get started.

### Prerequisites

1. Java
2. Maven
3. Browser driver [Project have a driver embedded, but may need upgrade base on the time of execution]

## Tests

Uses [Zero banking site](http://zero.webappsecurity.com/index.html) for scenarios.

### Test scenarios

1. Login to the portal successfully and verify landing page.

### How to execute test

1. Through IDE: right click on "Tests"

## About Page Object Model framework

Each page have an associated class created for it. Each class with UI elements and methods associated with the page.
Classes have UI elements declared as "By" object:
```
By signinButton = By.id("signin_button");
```
Which is used in methods as:
```
driver.findElement(signinButton).click();
```