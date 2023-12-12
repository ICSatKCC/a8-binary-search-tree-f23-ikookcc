[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/IuEJnHYo)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13040861)
# Assignment 8 - FishBox Binary Search Tree

 * 50 points
 * Pull Request for code review due Tues November 28th at class time.
 * Final version due Tues 12/12 at **2:15 pm.** (day/time of final exam).
  
----
## Overview

For this assignment, you will practice/learn:
* Creating and using binary search trees.
* Use binary tree traversals.
* Practice your skills in creating and communicating several classes.
----
We are going to make a modified Binary Search Tree (BST) that keeps counts of how many of each type of I'a you have. This isn't a detailed database of each specific fish added, just a listing of each kind of fish you have and their count.

 * Fish types not added or completely removed so none are left should not be present in the FishBox/BST
 * Fish types in the Fishbox/BST should be ordered by Hawaiian name, alphabetically.
 
You should write and submit the five new class files described below: 
 * FishBox.java (Driver)
 * IaTree.java
 * IaNode.java
 * IaTreeException.java
 * IaNodeException.java


## Details: 

In this assignment, you must write code for a **modified** Binary Search Tree (BST) called `IaTree.java` to function as a database of your `I_a` fish objects from Assignment 5 and/or Assignment 6. Your `IaTree` should be based on the `BinarySearchTree` example code from class.

 - Your `IaTree` will formed of special node objects that you must write. `IaNodes` must each contain **two** data items:
   1. An `I_a`.
   2. An `int` `fishCount` of how many times that `I_a` type has been encountered. 
      - **This is the big modification that you must do to the BST for the assignment.** Repeat `I_a` of the same type must be able to be added to the tree, but only the first one of a type will add a new IaNode. Adding a fish of a type that is already in the tree should instead increase the fishcount in that fish type's IaNode.
 
 - The `IaTree` must be ordered by the `I_a` type **name** datafield (*don't use the compareTo method we have made for I'a in Assignment 5, use the String.compareTo method with just the name!*) 
    - The `I_a` name String will be the BST key.

 - The process is:  An `I_a` object is put into an `IaNode` then the `IaNode` is added to the `IaTree` object.
 - ![IaTree](https://user-images.githubusercontent.com/279775/159372257-004928ba-1992-43d8-b508-e6d22b76ff2d.png)

----
**Use the example code in Laulima --> Resources --> Session 25 - BinarySearchTree as a template**
* BinaryNode.java
* BinarySearchTree.java
* TreeException.java

**Except** in this assignment, you're not going to make a generic BST, it should be tailored specifically to I_a objects (see below).

**I strongly suggest you use the jGRASP debugger and view your tree by name to see the structure of it as nodes are added and removed. The remove method is especially hard to debug without being able to see what the tree is doing.**

--- 
Required classes for this assignment:
---
* FishBox.java, a driver class
* IaTree.java, implementing all the binary search tree functionality
* IaNode.java, the special nodes held by your IaTree.
* IaTreeException.java,  a RuntimeException thrown by IaTree get and remove methods if requested I'a is not in the tree.
* IaNodeException.java, a RuntimeException thrown by IaNode decreaseCount method if the fishCount becomes less than 1.

 - If you create any other classes for this assignment, you must submit them as well. 

 - Include all of the I_a java files from previous assignments that are needed to run your program in this repository.
---
### FishBox.java - 10 points

For this assignment, write a driver program using a menu with these options:

1. Add a Fish  (for adding to the tree) (3 pt)
  * Add a new fish type to the IaTree
  * OR increase the fishCount of an I_a already in the tree.
  * You can re-use your sub-menu from Assignment 4 to choose Ia
  
2. Release a Fish (for removing from the tree) (3 pt)
  * Lower the quantity of an I_a type in the IaTree.
  * Make sure you can't release fish you don't have! fishCount quantity in a node cannot become negative.
  * Remove I_a type's IaNode from the tree if all are released (fishCount is 0).
  * You can re-use your sub-menu from Assignment 4 to choose Ia
  
3. Print FishBox (print the tree in sorted order) (3 pt)
  - Print all the I_a in the FishBox ordered by name (*inorder traversal*) and how many of each have been seen.
  - This should only print the fish name and the count, don't use the toString method because it will be ugly and hard to read.

0. Quit


Style and Comments (2 pt)

-----
### Suggestions for the rest

The class methods described below are what are needed to pass the provided JUnit tests for IaNode and IaTree. Some of the functionality is left up to you, such as the remove method helper methods and the FishBox driver.

Do not forget that you need to validate everything, thus you will need to write exceptions for IaNode and IaTree classes. 
These may be included in the class files like some of our example code has done, or in their own files.

#### Comments are very important
Since you are in charge of your overall code design, it is VERY important that you add explicit comments 
to your code. This can add or take away points from your grade. 

### IaNode.java - 10 points

Style and Comments (2 pt)

#### constructor (3 pt)
`public IaNode( I_a fish, int fishCount, IaNode lChild,  IaNode rChild)`
 * I_a should be a non-null object.
 * fishCount should be >= 1.
 * lChild and rChild are IaNodes. They may or not be null depending on your implementation.

#### Get methods (3 pt)
`public I_a getIa( )`
 * This method will return an I_a object from inside a given node (the species representative/first one added)
 
`public String getKey( )`
 * This method will return the I_a name String of the I_a in a given node. This is the key for the IaTree.
 
`public int getCount( )`
 * This method will return the fishCount from inside a given node
  
`public IaNode getLChild( )`
 * This method will return the left child of a given node

`public IaNode getRChild( )`
 * This method will return the right child of a given node

#### Set methods (3pt)
`public void increaseCount( )`
 * This method will increment the fishCount in a node
 
 `public void decreaseCount( )`
 * This method will decrement fishCount in a given node
 * Should throw an exception if it becomes < 1
 
`public void setLChild( IaNode newLChild)`
 * This method will set newLNode as the left child of a node

`public void setRChild( IaNode newRChild)`
 * This method will set newRNode as the right child of a node

`public void setFish( I_a newFish)`
**Note:** We want control changing the species of I_a in a node that is already in the tree. This can break the Binary Search Tree rules causing your data structure to work incorrectly. Your IaTree object should only use this as part of its remove method (if needed, there are other ways to do this without this method).

---

### IaTree.java - 25 points

Style and Comments (2 pt)

#### Constructor: (5 pt)
`public IaTree( )`
 * Empty IaTree constructor.

#### Adding Fish: (5 pt)
`public void add( I_a fish )`
 * This method should call the private recursive add method with root (below)
 
`private IaNode add(IaNode node, I_a fish )`
 * Recursive add method
 * Should make a new node and put I_a fish in it with fishCount = 1 if not already in the tree
 * Should increment fishCount if fish's type is already is in the tree
 
#### Getting Fish in Tree by name: (3 pt)
`public I_a get(I_a searchKey){`
 * Public wrapper method that calls recursive method with root
 
`private I_a get(IaNode node, I_a searchKey){`
 * Private recursive get method
 * Returns I_a object with name.equals(searchKey.getName())
 * Should throw an exception if no I_a with name.equals(searchKey.getName()) is in the tree
 
 #### Removing Fish: (7 pt)
***Hint:*** Do this part last, it is hardest because you have to reorder the tree

`public void remove(I_a fish)`
 * Wrapper method that calls recursive remove method with root
 
`private IaNode remove(IaNode node,  I_a fish)`
 * decrements fishCount
 * Removes fish's node from the tree if fishCount < 1
 * Throws exception if fish not in the tree
 
#### IaTree Print method: (3 pt)
`public void print()`
 * Overloaded wrapper method in order to access private data field `root` to send to recursive method.
 
`private void print(IaNode root){`
 * private recursive method that prints the IaTree **inorder** 
 * It should only print the fish name (the Key) and the fishCount from a node, one per line. Like this form: `Moi-li'i Count: 1` . Don't use the `I_a.toString()` method because output will be too hard to read.
 
 Use the below example to print the IaTree tree in preorder, **THIS IS NOT THE REQUIRED PRINT METHOD! You must modify the order to make the print method:**

```java
public void preorderIaTree() {
  this.preorderIaTree(root);
}
```
 * Overloaded wrapper method in order to access private data field `root` to send to recursive method.
 
```java	
private void preorderIaTree(IaNode root){
      if(root != null){
       System.out.println("  " + root.getKey() + "\nCount: "+root.getCount( ) );
           preorderIaTree(root.getLChild());
           preorderIaTree(root.getRChild());
      }
}
```
 * The recursive method takes the root as a parameter and will print tree in **preorder traversal**. 
 * It is good for debugging purposes.
 * You may copy and paste this into your IaTree class.
 
---
