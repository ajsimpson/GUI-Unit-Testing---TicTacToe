cd acceptance
javac -cp .;..\build\classes\main TicTacToeGUIKeywords.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.8.7.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..