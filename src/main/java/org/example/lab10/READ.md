# Networking
Create an implementation of Gomoku (Five in a row) that allows remote players to start or join games. The application will contain two parts (create a project for each one):

The server is responsible with the game management and mediating the players.
The client will communicate with the server, sending it commands such as:
create or join a game,
submit a move, etc.
The main specifications of the application are:

## Compulsory (1p)

Create the project ServerApplication. This will contain (at least) the classes: GameServer and ClientThread.
Create the class GameServer. An instance of this class will create a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.
Create the class ClientThread. An instance of this class will be responsible with communicating with a client Socket. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
Create the project ClientApplication. This will contain (at least) the class: GameClient.
Create the class GameClient. An instance of this class will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".

## Optional (2p)

Implement functionalities of the game, using the classes Game, Board, Player, etc.
The clients will send to the server commands such as: create game, join game, submit move, etc.
The server is responsible with the game management and mediating the players.
The games will be played under time control (blitz) with each player having the same amount of time at the beginning of the game. If a player's time runs out, the game is lost.

### Implementation

I created 2 separeted projects for Client and Server. In Server I made the classes: GameServer, ClientThread, Board, Player and Game. In Client project I only have GameClient.

GameServer is responsibe with the server, it has methods like createGame() and joinGame().

ClientThread makes the communication between Server and Client, it has only one function (run) which takes care of any commands from client like create game, join game, make move, exit etc.

Board, Game and Player are game related classes.

GameServer reads the input from player and sends it to the server.