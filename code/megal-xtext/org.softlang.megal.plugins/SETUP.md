# How to setup eclipse

1. Download eclipse for DSL developers
2. Import following projects into your workspace:
  - ```org.softlang.megal```
  - ```org.softlang.megal.language```
  - ```org.softlang.megal.language.ui```
  - ```org.softlang.megal.plugins```
  - ```org.softlang.megal.sourcesupport```
3. Create folders ```src-gen``` (if missing) in:
  - ```org.softlang.megal.language```
  - ```org.softlang.megal.language.ui```
4. Execute ```org.softlang.megal/transformation/GenerateModel.mwe2 > Run As > MWE2 Workflow```
5. Execute ```org.softlang.megal.language/src/org.softlang.megal.language/GenerateMegal.mwe2 > Run As > MWE2 Workflow```

Done.