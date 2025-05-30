# Simple Java Client-Server Test

This project contains a basic Java client-server implementation using sockets.

## How to Run
r
1. **Start the Server First**

   Run the `Server.java` file first. This opens a server socket and waits for a client connection.

2. **Start the Client**

   After the server is running, run the `Client.java` file. If the server isn't started first, you will encounter a connection error.

## Purpose

This setup was created just to test my **first Git commit using git commands**.  
The code itself is simple, experimental, and mostly just a **stupid test for Git**.

## Notes

- Messages from the client are sent to the server.
- Typing `goodbye` in the client will trigger shutdown, if the server replies with `goodbye`.
- The communication stops when both sides agree on termination.

> Yes, it's basic. Yes, it's silly. But Git is working now 😄
