# ImmutableQueue

This repository contains implementation of an immutable queue in Java.

# Files in this repository

### src/
  - **module-info.java**: Information for Eclipse to include Junit 5 in build path of the project

### src/com/github/genuinelucifer/queue/
  - **Queue.Java**: The interface to be implemented in the queue
  - **ImmutableQueue.java**: The implementation of the immutable queue

### src/com/github/genuinelucifer/queue/usage/
  - **CheckImmutableQueue.java**: A java program that imports and uses the implemented ImmutableQueue

### src/com/github/genuinelucifer/queue/tests/
  - **ImmutableQueueTests.java**: Junit 5 tests for the created library

# Importing the project in Eclipse

- Clone this repo
- Open eclipse and go to File -> "Open Projects from File System"
- Locate the directory of this repository and click Finish
- Project should be properly loaded in eclipse.

**Note:** This project and tests were run/built with Eclipse version 4.10 and Java SDK (OpenJDK) v11

