actor-chat
==========

An IRC chat client and server with implemented with Akka remote actors. This demonstrates 
 a few concepts inherent in Scala and a demonstration of the Actor Model using Akka

How to run
===========

This program requires an installation of the Simple Build Tool [SBT](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html), 
which requires that you have at least java 1.6. The build.sbt file has all the requirement definitions and resolvers 

Steps
-----
* Clone the oodp14 repository if you have not done so yet
* Open your terminal and change to the actor-chat directory
* Run 

    `sbt run`

* SBT will download all the required dependencies and provide you with 2 options 

    ` Multiple main classes detected, select one to run:
    
    [1] kaning.actors.ChatClientApplication
    
    [2] kaning.actors.ChatServerApplication
    
    Enter number: `

* Please note that this will not be in the same order
* First run the server so in the example above type in 2 and hit return
* Open another terminal, change your working directory to actor-chat again and run 

    `sbt run`

* This time choose the client application and identify yourself
* In order to join the server type in _/join_ and hit return

Everything else you type into the client console will be displayed in the server console and to any other clients connected to that server