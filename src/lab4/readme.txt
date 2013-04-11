Lab #2 Instructions
======================================================
Design a portable file access system that can work
with any project that needs file access. Try not to make
any of your file access code dependent on other classes
in a project (e.g., your Garage project).

A well-designed file access system will have a high-level service class
that delegates to reader and/or writer objects based on abstraction (the
Strategy Pattern).

Test your code by adding a main method to the service class.

*eliminate the need to write file access code
1. file service, no matter how complex it is, needs to be accessible from 1 class
2. none of the code behind it can be changed
3. any values need to be passed in - not hardcoded
                                                    
                      FileService                     
                     /           \                  
                FileReader    FileWriter
                   /                 \     
           TextFileReader        TextFileWriter                                
                                                     
                                                      
