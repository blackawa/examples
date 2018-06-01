/*eslint-env node*/
const express = require('express');
const path = require('path');
const app = express();
const port = process.env.PORT || 3000;
const server = require('http').createServer(app);

app.use(express.static(path.join(__dirname, 'public')));
app.get('*', function (req, res) {
  res.sendFile(path.join(__dirname, 'public', 'index.html'))
});

server.listen(port, function() {
  console.log('Start server: port=' + port)
});
