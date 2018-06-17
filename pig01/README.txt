Welcome to the Pig Game - Week 1

Problems encountered:
ComputerPlayer takeTurn() - Without code to check isMyTurn, the Take Turn button wouldn't end turn at the end of 
the maximumRolls.

ComputerPane handle(ActionEvent arg0) - Without code to resetTurnTotal(), the previous turnTotal remained and 
rolling 1 resulted in a reduced total score.


~~~ 2018.06.17 ~~~
Assumptions: maximumRolls for ComputerPlayer is currently unused. Considering that we may implement it later, 
I added a SupressWarning tag to it to prevent a CheckStyle error for the time being. 