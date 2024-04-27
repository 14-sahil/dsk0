# SPPU-BE-IT-DS
#### Requirements
- java 8
```bash
# install java 8 on Ubuntu
sudo apt update 
sudo apt install openjdk-8-jdk -y
# to check if you have multiple version of java and setting default to java 8
sudo update-alternatives --config java
```
![ALT](./assets/java8.png)

- Downlaod java 8 for windows from [Link1](https://builds.openlogic.com/downloadJDK/openlogic-openjdk/8u412-b08/openlogic-openjdk-8u412-b08-windows-x64.msi) or [Link2](https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=416&field_operating_system_target_id=436&field_architecture_target_id=391&field_java_package_target_id=396 
)
<hr>

#### Assignment 1
1. Terminal 1
    ```bash
    # compile all java files
    javac *.java
    # compile implementation file
    rmic ServerImplementation
    # start rmiregistry
    rmiregistry

    ```
2. Terminal 2
    ```bash
    # start the server
    java Server
    ```
3. Terminal 3
    ```bash
    # connect the client
    # for addtion, substraction, division, multiplication
    java Client 10 20
    # for square, square root
    java Client 25
    # for string equal
    java Client abc abc
    # for palindrome
    java Client aba
    ```
<hr>