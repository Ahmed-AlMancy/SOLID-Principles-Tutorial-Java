`Explanation`: It States That Subtypes must be Substututable for their base class.
---
### Liskov Substitution Principle (LSP) Violation and Fix

#### LSP Violation
The original code violates LSP because `Square` overrides the behavior of `Rectangle` incorrectly:
```java
class Rectangle {
    protected int width, height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = this.height = width;
    }
  
    @Override
    public void setHeight(int height) {
        this.width = this.height = height;
    }
}
```
`Square` modifies the behavior of Rectangle by enforcing equal `width` and `height`.
This breaks LSP because a `Square` cannot be substituted where a `Rectangle` is expected without changing behavior.
-----
## The Fix: 
```
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}
```
Now, `Rectangle` and `Square` are separate implementations.
LSP is maintained: Both classes adhere to the `Shape interface` without `modifying behavior`.
-----
