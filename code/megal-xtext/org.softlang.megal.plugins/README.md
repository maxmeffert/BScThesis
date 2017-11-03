# org.softlang.megal.plugins

A collection of *static/dynamic program analysis* and *reasoner* plugins for MegaL.

## Contents
- [Project Outline](#project-outline)
- [Package Outline](#package-outline)
- [MegaL Style Guide](#megal-coding-guide)

## Project Outline
The Project's directory is structured as follows:

- ```/src``` The source files for plugins
- ```/input``` A collection of mixed input sources
- ```/input-lib``` Dependencies for input sources
- ```/lib``` Dependencies for plugins
- ```/megal``` Java source files for plugins
- ```/output``` Folder for results
- ```/ucls``` Folder for ObjectAid diagrams
- ```/SETUP.md``` Instructions how to set up an eclipse environment

## Package Outline
The Java-Packages in ```/src``` are structured as follows:

- ```org.softlang.megal.plugins``` The top package only contains an eclipse ```Activator``` class and a ```Main``` class for local executions.
- ```org.softlang.megal.plugins.api``` The package for plugin base classes aka the API.
- ```org.softlang.megal.plugins.api.antlr``` The package for plugin base classes that are backed by ANTLR. 
- ```org.softlang.megal.plugins.api.fragmentation``` ...
- ```org.softlang.megal.plugins.prelude``` The package for plugin implementations which are directly declared in MegaL's Prelude.
- ```org.softlang.megal.plugins.util``` The package for global utility classes.
- ```org.softlang.megal.plugins.impl.<name>``` Packages with this naming scheme contain plugin implementations for the specific language or technology ```<name>```.
  They may contain the following sub-packages: 
  - ```org.softlang.megal.plugins.impl.<name>.antlr``` A package for ANTLR grammar files and corresponding generated code.
  - ```org.softlang.megal.plugins.impl.<name>.test``` A package for JUnit test classes.
  
 ## MegaL Coding Guide
 TBD.