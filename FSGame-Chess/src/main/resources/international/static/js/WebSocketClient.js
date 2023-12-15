const socket = new WebSocket("ws://localhost:80/websocket")

socket.addEventListener("open", (event) => {
    console.log('WebSocket opened');
    socket.send('Hello, Server!');
});

socket.addEventListener("close", (event) => {
    console.log('WebSocket closed:', event.code, event.reason);
});

socket.addEventListener("message", (event) => {
    console.log('Message from server:', event.data);
});