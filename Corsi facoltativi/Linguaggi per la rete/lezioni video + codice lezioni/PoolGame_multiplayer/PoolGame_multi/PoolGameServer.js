var http = require('http');
var url = require('url');

var server = new http.Server(); // Crea un server HTTP
var io = require('socket.io')( server );



server.on("close", function() {
    console.log("Server chiuso");
});

server.on("connect", function() {
    console.log("Nuova connessione");
});


io.on('connection', function(socket) {
    console.log("socket.io  client connected");

    socket.on('pole_update', function(obj) {
        io.emit( 'pole_update', obj );
    });
    socket.on('ball_fired', function(obj) {
        console.log("White ball fired");
        io.emit( 'ball_fired', obj );
    });
});

io.on('disconnect', function(){
    console.log('socket.io client disconnected');
});


server.listen(8080); 
