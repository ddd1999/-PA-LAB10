# -PA-LAB10
Repository for the 10th laboratory

For this laboratory we had to create an implementation of **Gomoku (Five in a row)** that allows remote players to start or join games. The application had to contain two parts: the server and the client.

The **ServerApplication** project contains the classes **GameServer** and **ClientThread**.
- The class **GameServer**: The server receives requests/commands from clients and it executes them.
- The class **ClientThread**: If the server receives the command **stop** it will stop and will return to the client the respons **"Server stopped"**, otherwise it return: **"Server received the request ... "**

The **ClientApplication** project contains the class **GameClient**.
-The class **GameClient**: The client stops when it reads from the keyboard the string "exit".
